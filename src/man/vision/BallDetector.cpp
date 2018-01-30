
#include "BallDetector.h"

#include <algorithm>
#include <iostream>


using std::to_string;

namespace man {
namespace vision {

BallDetector::BallDetector(FieldHomography* homography_,
                           Field* field_, bool topCamera_):
    homography(homography_),
    field(field_),
    topCamera(topCamera_)
{

}

BallDetector::~BallDetector() { }

void BallDetector::setDebugImage(DebugImage * di) {
    debugDraw =  *di;
}

void BallDetector::processDarkSpots(SpotList & darkSpots, intPairVector & blackSpots,
                        intPairVector & badBlackSpots, spotVector & actualBlackSpots)
{
    for (auto i = darkSpots.begin(); i != darkSpots.end(); i++) {
        // convert back to raw coordinates
        int midX = (*i).ix() + width / 2;
        int midY = -(*i).iy() + height / 2;
		if (midX < width - 5 && midX > 5 && midY > 5 && midY < height - 5) {
			(*i).rawX = midX;
			(*i).rawY = midY;
			getColor(midX, midY);
			// if the middle of the spot is white or green, ignore it
			if (!(isWhite() || isGreen()) &&
				(!topCamera || midY > field->horizonAt(midX))) {
				if (filterBlackSpots((*i))) {
					blackSpots.push_back(std::make_pair(midX, midY));
					actualBlackSpots.push_back((*i));
					(*i).spotType = SpotType::DARK_CANDIDATE;
				} else {
					(*i).spotType = SpotType::DARK_REJECT;
					badBlackSpots.push_back(std::make_pair(midX, midY));
				}
				if (debugBall) {
					debugBlackSpots.push_back((*i));
				}
			}
		}
    }
}

bool BallDetector::processWhiteSpots(SpotList & whiteSpots,
									 intPairVector & blackSpots,
									 intPairVector & badBlackSpots,
									 spotVector & actualWhiteSpots,
									 double cameraHeight, bool & foundBall)
{
    for (auto i = whiteSpots.begin(); i != whiteSpots.end(); i++) {
        int midX = (*i).ix() + width / 2;
        int midY = -(*i).iy() + height / 2;
        (*i).rawX = midX;
        (*i).rawY = midY;
		/*imagePoint p = imagePoint(midX - width /2, -midY + height / 2);
		std::cout << "Spots " << (*i).innerDiam << " " << (2 * projectedBallRadius(p)) << std::endl;
		debugDraw.drawBox(midX, midX + 2 * projectedBallRadius(p), midY + 2 * projectedBallRadius(p), midY, RED);
		p = imagePoint( - width /2, -midY + height / 2);
		debugDraw.drawBox(midX, midX + 2 * projectedBallRadius(p),
		midY + 2 * projectedBallRadius(p), midY, RED);*/
        if (filterWhiteSpot((*i), blackSpots, badBlackSpots)) {
            actualWhiteSpots.push_back((*i));
                if(debugBall) {
                    std::cout<<"filterWhiteSpot returned true\n";
                    debugDraw.drawPoint((*i).ix() + width / 2,
										-(*i).iy() + height / 2, RED);
                }
            makeBall((*i), cameraHeight, 0.75, foundBall, false);
#ifdef OFFLINE
            foundBall = true;
#else
            return true;
#endif
            (*i).spotType = SpotType::WHITE_CANDIDATE;
        } else if (!topCamera || midY > field->horizonAt(midX)) {
            (*i).spotType = SpotType::WHITE_REJECT;
        }
        if (debugBall && (!topCamera || midY > field->horizonAt(midX))) {
            debugWhiteSpots.push_back((*i));
        }
    }
    return foundBall;
}

bool BallDetector::processBlobs(Connectivity & blobber, intPairVector & blackSpots,
                                bool & foundBall, intPairVector & badBlackSpots,
                                spotVector & actualWhiteSpots, double cameraHeight,
                                int bottomQuarter)
{
    for (auto i = blobber.blobs.begin(); i!=blobber.blobs.end(); i++) {
        int diam = (*i).firstPrincipalLength();
        int diam2 = (*i).secondPrincipalLength();
		int cx = (*i).centerX();
		int cy = (*i).centerY();
		int bx = cx - width / 2;
		int by = -(cy + bottomQuarter) + height / 2;
		imagePoint p = imagePoint(bx, by);
		int radius = projectedBallRadius(p);
		int fudge = radius / 4;
		bool goodSize = radius <= diam + fudge && diam < 2 * radius + fudge;
		if (topCamera && diam2 >= 10 && diam < 2 * radius + fudge) {
			goodSize = true;
		}
		// The black spots sometimes depress the size of the first principle axis
		// so on big blobs that are relatively circular let them have another chance
		if (!topCamera && !goodSize) {
			goodSize = diam > 8 && diam < 2 * radius + fudge && diam < 30;
		}
		if (!topCamera && goodSize && diam > 25) {
			goodSize = false;
		}
		/*if (topCamera && cy + bottomQuarter + diam > height - 5 && diam < radius && diam * 2 > radius) {
			goodSize = true;
			diam2 = diam;
			}*/
		if (!goodSize && debugBall) {
			std::cout << "Bad size on blob " << radius << " " <<
				diam << " " << diam2 << " " << cx << " " <<
				(cy+bottomQuarter) << std::endl;
		}
		if (goodSize && debugBall) {
			std::cout << "Good size on blob " << radius << " " <<
				diam << " " << diam2 << " " << cx << " " <<
				(cy+bottomQuarter) << std::endl;
		}
        if (goodSize && diam2 >= radius / 2 && cy - diam > 0 &&
			cx - diam > 0 && cx + diam < width &&
			(diam2 > diam * 0.6 || ((*i).centerY() + diam2 < height - 2) && diam2 > diam * 0.5)) {
            // convert this blob to a Spot
            //int cx = (*i).centerX();
            //int cy = (*i).centerY();
            Spot s;
            s.x = (cx - width / 2) * 2;
            s.y = (cy + bottomQuarter - height / 2) * 2;
            s.rawX = cx;
            s.rawY = cy + bottomQuarter;
            s.innerDiam = (*i).firstPrincipalLength() * 2;
            if (filterWhiteBlob(s, blackSpots, badBlackSpots)) {
                s.spotType = WHITE_BLOB;
                actualWhiteSpots.push_back(s);
                makeBall(s, cameraHeight, 0.75, foundBall, false);
#ifdef OFFLINE
                foundBall = true;
#else
                return true;
#endif
            } else {
                s.spotType = SpotType::WHITE_BLOB_BAD;
            }
            if (debugBall) {
                debugWhiteSpots.push_back(s);
            }
        }
    }
    return foundBall;
}

/* This function takes in a spot generated by the spot filter
   system running on the y image and determines if the
   spot could reasonably be interpreted at one of the black
   hexagons on a ball. The spot filter makes certain kinds of
   predictible errors - e.g. seeing spots next to lines, goal
   posts and the like. True spots ought to be surrounded by white
   on more than one side.
*/
bool BallDetector::filterBlackSpots(Spot currentSpot)
{
    int WHITE_JUMP = 40;
    int MIN_CENTER_Y = 110;
	if (topCamera) {
		MIN_CENTER_Y = 130;
	}
	// Some ideas: spots on the ball should have white in at least two directions
    int buff = 0;
    int leftX = currentSpot.xLo() + width / 2 - buff;
    int rightX = currentSpot.xHi() + width / 2 + buff;
    int topY = currentSpot.yLo() + height / 2 - buff;
    int bottomY = currentSpot.yHi() + height / 2 + buff;
	int scan = currentSpot.innerDiam / 2;
    if (scan < 4) {
        scan = 4;
    }
    int midY = *(yImage.pixelAddr(currentSpot.ix() + width / 2,
                                  -currentSpot.iy() + height / 2)) / 4;
	if (topCamera && topY < height / 3) {
		//return false;
	}
    // spots in robots are often actually bright, just surrounded by brighter
    if (midY > MIN_CENTER_Y) {
		if (debugBall) {
			std::cout << "Rejecting black for being too light " << leftX <<
				" " << midY << std::endl;
		}
        return false;
    } else if (midY > MIN_CENTER_Y - 10) {
		// do a bit of extra checking
		int midX = currentSpot.ix() + width / 2;
		midY = -currentSpot.iy() + height / 2;
		for (int i = midX - 1; i < midX + 2; i++) {
			for (int j = midY - 1; j < midY + 2; j++) {
				if (*(yImage.pixelAddr(i, j)) / 4 > MIN_CENTER_Y) {
					if (debugBall) {
						std::cout << "Rejecting black for being too light " << leftX <<
							" " << midY << std::endl;
					}
					return false;
				}
			}
		}
	}
    int currentY = 0;
    int whites = 0;
	int NEEDED = 2;
	if (!topCamera) {
		NEEDED = 3;
	}
	// scan out from each edge to see if there is a significant
    // jump in Y in at least two directions
	for (int i = leftX; i > leftX - scan; i--) {
        currentY = *(yImage.pixelAddr(i, -currentSpot.iy() + height / 2)) / 4;
        if (abs(currentY - midY) > WHITE_JUMP) {
			whites++;
			i = i - scan;
		}
	}
	for (int i = rightX; i < rightX + scan; i++) {
        currentY = *(yImage.pixelAddr(i, -currentSpot.iy() + height / 2)) / 4;
        if (abs(currentY - midY) > WHITE_JUMP) {
			whites++;
			i = i + scan;
		}
	}
	for (int i = topY; i > topY - scan && whites < NEEDED; i--) {
        currentY = *(yImage.pixelAddr(currentSpot.ix() + width / 2, i)) / 4;
        if (abs(currentY - midY) > WHITE_JUMP) {
			whites++;
			i = i - scan;
		}
	}
	for (int i = bottomY; i < bottomY + scan && whites < NEEDED; i++) {
        currentY = *(yImage.pixelAddr(currentSpot.ix() + width / 2, i)) / 4;
        if (abs(currentY - midY) > WHITE_JUMP) {
			whites++;
			i = i + scan;
		}
	}
    if (whites >= NEEDED) {
        if (debugBall) {
            debugDraw.drawPoint(currentSpot.ix() + width / 2, -currentSpot.iy() + height / 2, BLUE);
            std::cout << "Black blob " << (currentSpot.ix() + width / 2) << " " <<
                (-currentSpot.iy() + width / 2) << " " << currentSpot.filterOutput <<
				" " << currentSpot.green << std::endl;
        }
		return true;
    } else {
        if (debugBall) {
            std::cout << "Filtered " << scan << " " << whites << std::endl;
            //debugDraw.drawPoint(currentSpot.x, currentSpot.y, RED);
        }
        return false;
    }
}

//this expects coordinates in Bill's coordinate system;
int BallDetector::projectedBallRadius(imagePoint p) {
    double dwx1, dwy1, dwx2, dwy2 = 0.0;
    homography->fieldVector((double)p.first, (double)p.second, 1.0, 0.0, dwx1, dwy1);

    double pixel_width = sqrt(dwx1*dwx1 + dwy1*dwy1);
    double rw = std::round((BALL_RADIUS/pixel_width) + 0.5);

    return rw;
}

imagePoint BallDetector::findPointsCentroid(intPairVector & v) {
    double x_sum = 0.0, y_sum = 0, cx = 0, cy = 0;
    int n = v.size();
    if(n != 0) {
        for(int i=0; i < v.size(); i++) {
            x_sum += v[i].first;
            y_sum += v[i].second;
        }
        cx = x_sum/n;
        cy = y_sum/n;
    }
    return std::make_pair((int)cx, (int)cy);
}

bool BallDetector::pointsEquidistantFromCentroid(intPairVector & v,
												 int projectedBallRadius) {
    imagePoint c = findPointsCentroid(v);
    int wrongDistanceCounter = 0;
    if(v.size() > 0) {
        for(int i = 0; i < v.size(); i++) {
            double distance = sqrt((v[i].first - c.first)*(v[i].first - c.first) +
                        (v[i].second - c.second)*(v[i].second - c.second));
            if(-3 > distance - projectedBallRadius > 3) { //these should be constants.
                wrongDistanceCounter++;                   //thoughts on what the thresholds should be?
            }
            if(wrongDistanceCounter > v.size() / 4) { //this can be some threshold
                return false;
            }
        }
        if(wrongDistanceCounter < v.size() / 4) { //so can this
            return true;
        }
    }
    return false;
}

void BallDetector::initializeSpotterSettings(SpotDetector &s, bool darkSpot,
                                            float innerDiam, float altInnerDiam,
                                            bool topCamera, int filterThreshold,
                                            int greenThreshold, float filterGain)
{
    s.darkSpot(darkSpot);
    s.innerDiamCm(innerDiam);

    if(!topCamera) {
        s.innerDiamCm(altInnerDiam);
    }

    s.filterThreshold(filterThreshold);
    s.greenThreshold(greenThreshold);
    s.filterGain(filterGain);

}

int BallDetector::getAzimuthColumnRestrictions(double az) {
    float percentOfImage;

    if(az >= 0) {
        percentOfImage = 0.8994*az*az - 0.0036*az - 0.5767;
    } else {
        percentOfImage = 0.8994*az*az + 0.0036*az - 0.5767;
    }

    int val = percentOfImage * width;
    if(val <= 0) { return 0; }
    if(val >= width-1) { return width-1; }
    if(az > 0) { return -1*(width - val); }
    else { return val; }
}

int BallDetector::getAzimuthRowRestrictions(double az) {
    float percentOfImage;
    //percentOfImage = -0.356*az*az - 0.025*az + 1.044; //lower
    //percentOfImage = -0.396*az*az - 0.015*az + 1.144; //upper
    //percentOfImage = -0.376*az*az - 0.015*az + 1.084;   //average
    percentOfImage = -0.376*az*az - 0.015*az + 1.104; //little higher than average

    int val = percentOfImage * height;
    if(val <= 0) { return 0; }
    if(val >= height-1) { return height-1; }
    return val;
}

void BallDetector::adjustWindow(int & startCol, int & endCol, int & endRow) {
    int c = getAzimuthColumnRestrictions(homography->azimuth());
    if(c < 0) {
        endCol = -c;
    } else {
        startCol = c;
    }
    if(startCol <= 0) { startCol = 0; }
    if(endCol >= width-1) { endCol = width-1; }

    int r = getAzimuthRowRestrictions(homography->azimuth());
    if(r < 0) {
        endRow = 0;
    } else {
        endRow = r;
    }
    if(endRow > height-1) {endRow = height-1; }

    bool extendedBottom = false;

    if(startCol-BOT_RESTRICTION_BUF >= 0 && endRow+BOT_RESTRICTION_BUF <= height-1) {
        getColor(startCol, endRow);
        if(isGreen()) {
            startCol -= BOT_RESTRICTION_BUF;
            endRow   += BOT_RESTRICTION_BUF;
            extendedBottom = true;
        }
    }
    if(endCol+BOT_RESTRICTION_BUF <= width-1 && endRow+BOT_RESTRICTION_BUF <= height-1) {
        getColor(endCol, endRow);
        if(isGreen()) {
            endCol += BOT_RESTRICTION_BUF;
            endRow += BOT_RESTRICTION_BUF;
            extendedBottom = true;
        }
    }
    if(startCol-TOP_RESTRICTION_BUF >= 0) {
        getColor(startCol, 0);
        if(isGreen()) {
            if(extendedBottom) {
                startCol -= TOP_RESTRICTION_BUF/2;
            } else {
                startCol -= TOP_RESTRICTION_BUF;
            }
        }
    }
    if(endCol+TOP_RESTRICTION_BUF <= width-1) {
        getColor(startCol, 0);
        if(isGreen()) {
            if(extendedBottom) {
                endCol += TOP_RESTRICTION_BUF/2;
            } else {
                endCol += TOP_RESTRICTION_BUF;
            }
        }
    }
}

/* Checks if two black blobs are close enough to be potentially
   part of the same ball.
*/

bool BallDetector::blobsAreClose(std::pair<int,int> p, std::pair<int,int> q)
{

    double cx = (p.first + q.first) / 2;
    double cy = (p.second + q.second) / 2;

    getColor(cx, cy);
    if(isGreen()) {
        return false;
    }

    double bcx = 0, bcy = 0;
    imageToBillCoordinates(cx, cy, bcx, bcy);

    int upper = projectedBallRadius(std::make_pair(bcx, bcy)) * 2.25;
    int lower = (upper >> 1) >> 1; //divide by 4
    int xdiff = abs(p.first - q.first);
    int ydiff = abs(p.second - q.second);

    int dist = sqrt(pow(xdiff,2) + pow(ydiff,2));

    if(dist >= lower && dist <= upper) {
        return true; //blobs are close
    } else {
        return false; //blobs are either too far or too close
    }
}

bool BallDetector::edgeSanityCheck(int x, int y, int radius) {
	int diam = radius * radius * 1.5;

    AngleBinsIterator<Edge> abi(*edgeList);
    for (Edge* e = *abi; e; e = *++abi){
        // If we are part of a hough line, we are not a ball edge
        if (e->memberOf()) { continue; }

        int ex = e->x() + width/2;
        int ey = height/2 - e->y();
        int ang = e->angle();
        // binary angles, so 128 = pi radians
        if ( ang > 128) {
			if ((ex - x) * (ex - x) + (ey - y) * (ey - y) < diam) {
				return true;
			}
		}
	}
	if (debugBall) {
		std::cout << "Did not find top edge in two spotted ball" << std::endl;
	}
	return false;
}


/* Sometimes our balls are not tidy blobs (e.g. they are up against a
   post or a robot). So we need other methods of finding them. This
   is one such method. It looks at our filtered list of black blobs
   and tries to find groups of them that are near each other. If there
   are enough of them then it is strong evidence of a ball.

   @TODO: This method has become so ugly. Needs clean up.
*/
bool BallDetector::findCorrelatedBlackSpots
(intPairVector & blackSpots, spotVector & actualBlobs,
 double cameraHeight, bool & foundBall)
{
    // loop through the filtered blobs and see if any are close together
    int correlations[blackSpots.size()];
    int correlatedTo[blackSpots.size()][blackSpots.size()];
    bool foundThree = false;
    // loop through filtered black blobs
    for (int i = 0; i < blackSpots.size()-1; i++) {
        std::pair<int,int> p = blackSpots[i];
        // initialize the correlations for this blob
        correlations[i] = 0;
        for (int k = 0; k < blackSpots.size(); k++) {
            correlatedTo[i][k] = 0;
        }
        // we're going to check against all other black blobs
        for (int j = i+1; j < blackSpots.size(); j++) {
            std::pair<int,int> q = blackSpots[j];
            if (blobsAreClose(p, q)) {
                correlations[i] += 1;
                correlatedTo[i][j] = 1;
                // Four close black blobs is good evidence for a ball
                if (correlations[i] > 2) {
                    // grab this blob from our vector
                    foundThree = true;
                    std::vector<Spot> correlatedSpots;
                    // find our correlated blobs and merge them in
                    for (int k = 0; k < blackSpots.size(); k++) {
                        if (correlatedTo[i][k] == 1) {
                            correlatedSpots.push_back(actualBlobs[k]);
                            correlatedTo[k][i] = 0;
                            correlations[k] -= 1;
                        }
                    }
                    correlatedSpots.push_back(actualBlobs[i]);
                    double xsum = 0.0, ysum = 0.0, ballSpotX, ballSpotY;

                    for(int s = 0; s < correlatedSpots.size(); s++) {
                        xsum += correlatedSpots[s].ix();
                        ysum += correlatedSpots[s].iy();
                    }

                    ballSpotX = xsum/correlatedSpots.size();
                    ballSpotY = ysum/correlatedSpots.size();

					if (debugBall) {
						std::cout<<"Correlated Spots Size: "<<
							correlatedSpots.size() << " " << ballSpotX <<
							" " << ballSpotY << std::endl;
					}

                    double ix = 0, iy = 0;
                    billToImageCoordinates(ballSpotX, ballSpotY, ix, iy);

                    if (debugBall) { debugDraw.drawPoint(ix,iy,MAROON); }
                    
                    if(greenAroundBallFromCentroid(std::make_pair(ix, iy))) {
                        Spot ballSpot;

                        ballSpot.x = ballSpotX * 2;
                        ballSpot.y = ballSpotY * -2;
					    ballSpot.rawX = ix;
					    ballSpot.rawY = iy;
					    ballSpot.innerDiam = 5;
					    
                        makeBall(ballSpot, cameraHeight, 0.8, foundBall, true);
#ifdef OFFLINE
                        foundBall = true;
#else
                        return true;
#endif
                    }
                }
            } else {
                break;
            }
        }
    }
    // If the best case didn't work out, look for 3 black blobs together
    for (int c = 0; c < blackSpots.size(); c++) {
        if ((correlations[c] > 1 || (correlations[c] == 1))
             && !foundThree) {
            std::vector<Spot> correlatedSpots;
            double ballSpotX, ballSpotY = 0;
            for (int k = 0; k < blackSpots.size(); k++) {
                if(correlatedTo[c][k] == 1) {
                    correlatedSpots.push_back(actualBlobs[k]);
                    correlatedTo[k][c] = 0;
                    correlations[k] -= 1;
                }
            }
            correlatedSpots.push_back(actualBlobs[c]);

			if (debugBall) {
				std::cout<<"Correlated Spots Size: "<<correlatedSpots.size()<<std::endl;
			}

            if(correlatedSpots.size() == 2) { //lets check the distance here
                Spot s1 = correlatedSpots[0];
                Spot s2 = correlatedSpots[1];

                ballSpotX = ((s1.ix()+s2.ix())/2);
                ballSpotY = ((s1.iy()+s2.iy())/2);
                int r = projectedBallRadius(std::make_pair(ballSpotX, ballSpotY));

                double distance, upper, lower;
                upper = r * 2.5;
                lower = (r >> 1) >> 1;

                distance = sqrt(pow((s2.ix() - s1.ix()),2) + pow((s2.iy() - s1.iy()),2));

				if (debugBall) {
					std::cout<<"[BALL INFO] Distance Between Spots: "<<distance<<std::endl;
				}

                if(distance >= lower && distance <= upper && r > 6) {
    				if (debugBall) { std::cout<<"[BALL INFO] Distance OK"<<std::endl; }
                    double ix = 0, iy = 0;
                    billToImageCoordinates(ballSpotX, ballSpotY, ix, iy);
                    if (debugBall) { debugDraw.drawPoint(ix,iy,BLUE); }

                    if(greenAroundBallFromCentroid(std::make_pair(ix, iy))) {
                        Spot ballSpot;
                        ballSpot.x = ballSpotX * 2;
                        ballSpot.y = ballSpotY * -2;
    					ballSpot.rawX = ix;
    					ballSpot.rawY = iy;
    					ballSpot.innerDiam = r * 2;

                        makeBall(ballSpot, cameraHeight, 0.6, foundBall, true);
                        //checkGradientAroundSpot(r);
                        if(checkBallHasNoGreenAndSomeWhite(r)) {
#ifdef OFFLINE
                            foundBall = true;
#else
                            return true;
#endif
                        } else {
#ifdef OFFLINE
                            candidates.pop_back();
#endif
                        }
                    }
                }
            } else if(correlatedSpots.size() == 3) {
                Spot s1 = correlatedSpots[0];
                Spot s2 = correlatedSpots[1];
                Spot s3 = correlatedSpots[2];

                ballSpotX = (s1.ix()+s2.ix()+s3.ix())/3;
                ballSpotY = (s2.iy()+s2.iy()+s3.iy())/3;
                int r = projectedBallRadius(std::make_pair(ballSpotX, ballSpotY));

                //equation below derives the maximum area a triangle could have, inscribed
                //in a circle with radius r obtained above. Derivation was done using
                //Heron's Formula and some trig. 1.73205 ~= sqrt(3)
                //Max. Area = ((1.73205)^3 * radius^2) / 4
                int upper = std::round((pow(1.73205, 3) * pow(r, 2)) + 0.5); //numerator
                upper = (upper >> 1) >> 1; //divide by 4
                int lower = (upper >> 1) >> 1;

                double area = abs((s1.ix()*(s2.iy()-s3.iy()) + 
                                   s2.ix()*(s3.iy()-s1.iy()) + 
                                   s3.ix()*(s1.iy()-s2.iy())) / 2);

                if(debugBall) { std::cout<<"[BALL INFO] Area Between Spots: "<<area<<std::endl; }

                if(area >= lower && area <= upper) {
                    if (debugBall) { std::cout<<"[BALL INFO] Area OK"<<std::endl; }

                    ballSpotX = (s1.ix()+s2.ix()+s3.ix())/3;
                    ballSpotY = (s2.iy()+s2.iy()+s3.iy())/3;
                    double ix = 0, iy = 0;
                    billToImageCoordinates(ballSpotX, ballSpotY, ix, iy);
                    if(debugBall) { debugDraw.drawPoint(ix,iy,BLACK); }

                    if(greenAroundBallFromCentroid(std::make_pair(ix, iy))) {
                        Spot ballSpot;
                        ballSpot.x = ballSpotX * 2; // in half pixels
                        ballSpot.y = ballSpotY * -2;
        				ballSpot.rawX = ix;
        				ballSpot.rawY = iy;
        				ballSpot.innerDiam = 5;

                        makeBall(ballSpot, cameraHeight, 0.6, foundBall, true);
                        //checkGradientAroundSpot(r);
                        if(checkBallHasNoGreenAndSomeWhite(r)) {
#ifdef OFFLINE
                            foundBall = true;
#else
                            return true;
#endif
                        } else {
#ifdef OFFLINE
                            candidates.pop_back();
#endif
                        }
                    }
                }
            }
        }
    }
    return foundBall;
}


/* This function is called when one of our detectors has found a
   ball. For now it creates a ball from the spot used to find it.
   Also, it might set this as the "best" ball based on confidence
   ratings. Since we process balls in terms of highest confidence
   methods first, in practice (on the robot) this won't matter as
   we will stop looking as soon as we find one. But for debugging it
   is helpful to find all of the possible balls that vision could
   detect in every image.
*/
void BallDetector::makeBall(Spot spot, double cameraHeight, double conf,
                            bool foundBall, bool isBlack)
{
    double x_rel, y_rel;
    int r = projectedBallRadius(std::make_pair(spot.ix(), spot.iy()));
    bool belowHoriz = homography->fieldCoords(spot.ix(), spot.iy()-r, x_rel, y_rel);

    Ball b(spot, x_rel, -1 * y_rel, cameraHeight, height,
           width, topCamera, spot.ix() + width / 2, -spot.iy() + height / 2, conf);
    _best = b;
#ifdef OFFLINE
	candidates.push_back(b);
#endif
}


/* The next two are very similar, but the first one assumes that the
   "spot" actually comes from the blob detector.
 */
bool BallDetector::filterWhiteBlob(Spot spot, intPairVector & blackSpots,
								   intPairVector & badBlack)
{
    // convert back to raw coordinates
    int leftX = spot.ix() + width / 2 - spot.innerDiam / 4;
    int rightX = spot.ix() + width / 2 + spot.innerDiam / 4;
    int topY = -spot.iy() + height / 2 - spot.innerDiam / 4;
    int bottomY = -spot.iy() + height / 2 + spot.innerDiam / 4;
    int midX = spot.ix() + width / 2;
    int midY = -spot.iy() + height / 2;

    // count up how many black spots are inside
    int spots = 0;
    for (int j = 0; j < blackSpots.size(); j++) {
        std::pair<int,int> blackspot = blackSpots[j];
        if (blackspot.first > spot.xLo() + width / 2 &&
            blackspot.first < spot.xHi() + width / 2 &&
            blackspot.second > spot.yLo() + height / 2 &&
            blackspot.second < spot.yHi() + height / 2) {
            spots++;
        }
    }
    // for now, if there are no black spots then it is too dangerous
    if (spots < 1) {
		if (!topCamera || !whiteNoBlack(spot)) {
			return false;
		}
    }
	if (spots == 1) {
		if ((spot.innerDiam < 25 || !topCamera) &&!checkGradientInSpot(spot)) {
			return false;
		}
	}

    // count up how many bad black spots are inside
    /*int badspots = 0;
    for (int j = 0; j < badBlack.size(); j++) {
        std::pair<int,int> blackspot = badBlack[j];
        if (blackspot.first > spot.xLo() + width / 2 &&
            blackspot.first < spot.xHi() + width / 2 &&
            blackspot.second > spot.yLo() + height / 2 &&
            blackspot.second < spot.yHi() + height / 2) {
            badspots++;
        }
		}*/
    // for now, if there are several bad spots then it is too dangerous
    //if (badspots > 1) {
        //return false;
    //}
	if (debugBall) {
		std::cout << "Filter white blob returned true " << midX << " " << midY << std::endl;
	}
    return true;
}

bool BallDetector::checkGradientInSpot(Spot spot) {
    int midX = spot.ix() + width / 2;
    int midY = -spot.iy() + height / 2;
	int diam = spot.innerDiam / 2;
	int radius = spot.innerDiam / 4;
    int leftX = max(0, (int)(spot.ix()) + width / 2 - radius);
    int rightX = min(width -1, (int)(spot.ix()) + width / 2 + radius);
    int topY = max(0, (int)(-spot.iy()) + height / 2 - radius);
    int bottomY = min(height - 1, (int)(-spot.iy() + height / 2) + radius);
	uint8_t gradient;
	int total = 0;
	int pixels = 0;

	for (int i = leftX; i < rightX; i+=2) {
		for (int j = topY; j < bottomY; j+=2) {
			gradient = edgeDetector->mag(i, j);
			total += gradient;
			pixels++;
		}
	}
	if (pixels > 8 && total  < pixels * 10) {
		if (debugBall) {
			std::cout << "Rejecting based on gradient " << midX << " " << midY <<
				" " << total << " " << pixels << std::endl;
		}
		return false;
	}
	return true;
}

bool BallDetector::checkDiagonalCircle(Spot spot) {
    int midX = spot.ix() + width / 2;
    int midY = -spot.iy() + height / 2;
	int diam = spot.innerDiam / 2;
    int leftX = spot.ix() + width / 2 - spot.innerDiam / 4;
    int rightX = spot.ix() + width / 2 + spot.innerDiam / 4;
    int topY = -spot.iy() + height / 2 - spot.innerDiam / 4;
    int bottomY = -spot.iy() + height / 2 + spot.innerDiam / 4;
	// scan each diagonal
	int THRESHOLD = 110;

	// normally check the gradient to get rid of crosses, but if ball is really large
	// it could be blurry and low gradient
	if (!checkGradientInSpot(spot)) {
		return false;
	}
	int length1, length2, length3, length4;
	// anything way off is bad
	int bad = max(15, diam);
	int x = rightX;
	int y = topY;
	getColor(x, y);
	for (int i = 0; i < 2; i++) {
		// top right corner
		for (x = rightX, y = topY ; x < min(width,rightX+bad+1) && y >= max(0,topY - bad-1) &&
				  getGreen() < THRESHOLD; x++, y--) {
			getColor(x, y);
		}
		//debugDraw.drawPoint(x, y, RED);
		length1 = x - rightX;
		if (length1 >= bad) {
			return false;
		}
		// top left corner
		getColor(leftX, topY);
		for (x = leftX, y = topY; x >= max(0,leftX-bad-1) && y >= max(0,topY-bad-1)
				 && getGreen() < THRESHOLD; x--, y--) {
			getColor(x, y);
		}
		length2 = leftX - x;
		if (length2 >= bad) {
			return false;
		}
		// bottom right corner
		getColor(rightX, bottomY);
		for (x = rightX, y = bottomY; x < min(width,rightX+bad+1) && y < min(height,bottomY+bad+1)
				 && getGreen() < THRESHOLD; x++, y++) {
			getColor(x, y);
		}
		length3 = x - rightX;
		if (length3 >= bad) {
			return false;
		}
		// bottom left
		getColor(leftX, bottomY);
		for (x = leftX, y = bottomY; x >= max(0,leftX - bad-1) && y < min(height, topY-bad-1)
				 && getGreen() < THRESHOLD; x--, y++) {
			getColor(x, y);
		}
		length4 = leftX - x;
		if (length4 >= bad) {
			return false;
		}
		if (debugBall) {
			std::cout << "Lengths: " << length1 << " " << length2 << " " << length3 <<
				" " << length4 << std::endl;
		}
		// if we already pass our tests then stop
		if (abs(length1 + length2 - length3 - length4) < 4 &&
			abs(length1 + length3 - length2 - length4) < 4 &&
			abs(length1 - length2 < 5)) {
			break;
		}
		// recalculate the center
		int topbot = (length1 + length2 - length3 - length4);
		if (topbot > 0) {
			topY -= topbot;
		} else {
			bottomY -= topbot;
		}
		int leftright = length1 + length3 - length2 - length4;
		if (leftright > 0) {
			rightX += leftright;
		} else {
			leftX += leftright;
		}
		x = rightX;
		y = topY;
		getColor(x, y);
	}
	// bunch of checks to ensure uniformity
	if (abs(length1 + length2 - length3 - length4) > 4) {
		return false;
	}
	if (abs(length1 + length3 - length2 - length4) > 4) {
		return false;
	}
	if (abs(length1 - length2) > 5) {
		return false;
	}
	int minl = min(min(length1, length2), min(length3, length4));
	int tooSmall = 3;
	if (diam > 10) {
		tooSmall = 2;
	}
	if (minl < tooSmall) {
		if (debugBall) {
			std::cout << "Min length is too small" << std::endl;
		}
		return false;
	}
	if (bottomY < height - 8 && topY > 5) {
		// straight up
		midX = (rightX + leftX) / 2;
		midY = (bottomY + topY) / 2;
		//debugDraw.drawPoint(midX, midY, BLUE);
		getColor(midX, topY);
		for (x = midX, y = topY; y > 0 && getGreen() < THRESHOLD; y--) {
			getColor(x, y);
		}
		int length5 = topY - y;
		// straight down
		getColor(midX, bottomY);
		for (x = midX, y = bottomY; y < height && getGreen() < THRESHOLD; y++) {
			getColor(x, y);
		}
		int elength5 = y - bottomY;
		if (elength5 > 2 * diam) {
			if (debugBall) {
				debugDraw.drawPoint(x, y, RED);
				std::cout << "Problem finding green below " << elength5 << std::endl;
			}
			return false;
		}
		// left
		getColor(leftX, midY);
		for (x = leftX, y = midY; x > 0 && getGreen() < THRESHOLD; x--) {
			getColor(x, y);
		}
		int length6 = leftX - x;
		// right
		getColor(rightX, midY);
		for (x = rightX, y = midY; x < width && getGreen() < THRESHOLD; x++) {
			getColor(x, y);
		}
		length6 += x - rightX;
		// allow extra leeway because bottom is generally really dark
		if (abs(length6 - length5 - elength5) > 6 && abs(length6 - 2 * length5) > length6 / 2) {
			if (debugBall) {
				std::cout << "Bad axis " << length5 << " " << elength5 << " " << length6 <<
					" " << bottomY << std::endl;
			}
			return false;
		}
	}
	if (debugBall) {
		std::cout << "Circle check passed" << std::endl;
	}
	return true;
}

bool BallDetector::checkBallHasNoGreenAndSomeWhite(int r) {
    int greens = 0, whites = 0;
    double counter = 0;
    int green_tolerance = r * 0.5;
    bool green_thresh_reached = false;
    r -= 3;
    for(int i = _best.centerX - (r * 0.75); i < _best.centerX + (r * 0.75); i+=2) {
        for(int j = _best.centerY - (r * 0.75); j < _best.centerY + (r * 0.75); j+=2) {
            if(debugBall) { debugDraw.drawDot(i, j, ORANGE); }
            counter++;
            getColor(i, j);
            if(isGreen()) {
                greens++;
                if(greens >= green_tolerance) { 
                    green_thresh_reached = true;
                }
            }
            if(isWhite()) {
                whites++;
            }
        }
    }

    if(debugBall) {
        std::cout<<"Greens: "<<greens<<std::endl;
        std::cout<<"Tolerance: "<<green_tolerance<<std::endl;
        std::cout<<"Whites: "<<whites<<std::endl;
        std::cout<<"Counter: "<<counter<<std::endl;
    }

    if(green_thresh_reached) { return false; }

    double white_percentage = whites / counter;
    if(white_percentage < 0.40) { return false; }

    if(debugBall) { debugDraw.drawPoint(_best.centerX, _best.centerY, GREEN); }
    return true;
}

bool BallDetector::checkGradientAroundSpot(int r) {
    int gradCheckOffset = 7;
    int gradCheckPixelCount = 10;;
    int left = _best.centerX - r - gradCheckOffset;
    int right = _best.centerX + r + gradCheckOffset;
    int bottom = _best.centerY + r + gradCheckOffset;
    double gradient = 0.0;
    std::cout<<"Right: "<<right<<std::endl;
    for(int i = 0; i < gradCheckPixelCount; i++) {
        int g = edgeDetector->mag(right + i, _best.centerY);
        debugDraw.drawDot(right+i, _best.centerY, RED);
        std::cout<<"Gradient: "<<g<<std::endl;
        gradient += g;
    }
    std::cout<<"Gradient Final: "<<gradient<<std::endl;
    std::cout<<"Average Grad: "<<gradient / gradCheckPixelCount<<std::endl;

}

/* We don't want white below the ball. The tricky thing is that it is ok
   if it is a field line.
 */
bool BallDetector::whiteBelowSpot(Spot spot) {
	int THRESHOLD = 110;
    // convert back to raw coordinates
    int bottomY = -spot.iy() + height / 2 + spot.innerDiam / 4;
	int topY = -spot.iy() + height / 2 - spot.innerDiam / 4;
    int midX = spot.ix() + width / 2;
	int spotHeight = bottomY - topY + 2;

	// The biggest thing is there should be no white and at least
	// some green below the spot
	getColor(midX, bottomY);
	int j;
	for (j = bottomY; j < height && !(getGreen() > THRESHOLD) &&
			 j - bottomY < spotHeight; j++) {
		getColor(midX, j);
	}
	if (j - bottomY > spotHeight) {
		return true;
	}
	return false;
}

bool BallDetector::greenAroundBallFromCentroid(imagePoint p) {
    int THRESHOLD = 110;
    int topCheckedPixels = 0, botCheckedPixels = 0;
    int topGreenSum = 0, botGreenSum = 0;

    double bx = 0, by = 0;
    imageToBillCoordinates(p.first, p.second, bx, by);
    int r = projectedBallRadius(std::make_pair(bx, by));

    int topY = std::round(p.second - r - 1);
    int bottomY = std::round(p.second + r + 1);

    getColor(p.first, topY);
    for(int i = 0; i < r && (topY - i) >= 0; i++) {
        topGreenSum += getGreen();
        topCheckedPixels++;
        getColor(p.first, topY - i);
    }

    getColor(p.first, bottomY);
    for(int i = 0; i < r && (bottomY + i <= width); i++) {
        botGreenSum += getGreen();
        botCheckedPixels++;
        getColor(p.first, bottomY + i);
    }

    if(debugBall) {
        debugDraw.drawDot(p.first, bottomY, RED);
        debugDraw.drawDot(p.first, bottomY + botCheckedPixels, RED);
        debugDraw.drawDot(p.first, topY, BLUE);
        debugDraw.drawDot(p.first, topY - topCheckedPixels, BLUE); //wont draw if too close to top
    }

    int topGreenAvg = 0, botGreenAvg = 0;
    ((topCheckedPixels > 0) ? topGreenAvg = topGreenSum / topCheckedPixels : topGreenAvg = 0);
    ((botCheckedPixels > 0) ? botGreenAvg = botGreenSum / botCheckedPixels : botGreenAvg = 0);

    // if(topGreenAvg < THRESHOLD && botGreenAvg < THRESHOLD) {
    //     if(debugBall) { 
    //         std::cout<<"[BALL INFO] Green Test Failed. Top. Avg: " << topGreenAvg <<
    //                    ", Bot. Avg: "<<botGreenAvg<<std::endl; 
    //     }
    //     return 0; 
    // }
    // if(topGreenAvg >= THRESHOLD || botGreenAvg >= THRESHOLD) {
    //     if(debugBall) { 
    //         std::cout<<"[BALL INFO] Green Test Passed - Top & Bottom\n"; 
    //         for(int i = 0; i < topCheckedPixels; i++) {
    //             debugDraw.drawDot(p.first, topY - i, GREEN);
    //         }
    //         for(int i = 0; i < botCheckedPixels; i++) {
    //             debugDraw.drawDot(p.first, bottomY + i, GREEN);
    //         }
    //     }
    //     return 1; 
    // }
    // if(topGreenAvg >= THRESHOLD) { 
    //     if(debugBall) { 
    //         std::cout<<"[BALL INFO] Green Test Passed - Top\n"; 
    //         for(int i = 0; i < topCheckedPixels; i++) {
    //             debugDraw.drawDot(p.first, topY - i, GREEN);
    //         }
    //     }
    //     return 2; 
    // }
    // if(botGreenAvg >= THRESHOLD) { 
    //     if(debugBall) { 
    //         std::cout<<"[BALL INFO] Green Test Passed - Bot\n";
    //         for(int i = 0; i < botCheckedPixels; i++) {
    //             debugDraw.drawDot(p.first, bottomY + i, GREEN);
    //         }
    //     }
    //     return 3; 
    // }
    // return -1;    

    if(topGreenAvg >= THRESHOLD || botGreenAvg >= THRESHOLD) {
        if(debugBall) { 
            std::cout<<"[BALL INFO] Green Test Passed\n"; 
            for(int i = 0; i < topCheckedPixels; i++) {
                debugDraw.drawDot(p.first, topY - i, GREEN);
            }
            for(int i = 0; i < botCheckedPixels; i++) {
                debugDraw.drawDot(p.first, bottomY + i, GREEN);
            }
        }
        return true;
    } else {
        if(debugBall) { 
            std::cout<<"[BALL INFO] Green Test Failed. Top. Avg: " << topGreenAvg <<
                        ", Bot. Avg: "<<botGreenAvg<<std::endl; 
        }
        return false;
    }
}

bool BallDetector::whiteNoBlack(Spot spot) {
	int THRESHOLD = 110;
    // convert back to raw coordinates
    int leftX = spot.ix() + width / 2 - spot.innerDiam / 4;
    int rightX = spot.ix() + width / 2 + spot.innerDiam / 4;
    int topY = -spot.iy() + height / 2 - spot.innerDiam / 4;
    int bottomY = -spot.iy() + height / 2 + spot.innerDiam / 4;
    int midX = spot.ix() + width / 2;
    int midY = -spot.iy() + height / 2;
	int spotHeight = bottomY - topY + 2;

	// don't take any chances at edges
	int extra = spot.innerDiam / 4;
	if (leftX - extra < 3 || rightX + extra > width - 3 || topY - extra < 3) {
		return false;
	}

	imagePoint p = imagePoint(midX, midY);
	if (!greenAroundBallFromCentroid(p)) {
		return false;
	}

	// The biggest thing is there should be no white and at least
	// some green above the ball
	int total = 0;
	int greens = 0;
	int whites = 0;
	int bigGreen = 0;
	for (int i = leftX; i < rightX; i+=2) {
		for (int j = max(0, topY - 2 * spotHeight); j < topY - spotHeight; j+=2) {
			getColor(i, j);
			//debugDraw.drawDot(i, j, BLUE);
			if (isWhite()) {
				whites++;
				if (whites > 1) {
					return false;
				}
			}
			bigGreen += getGreen();
			total++;
		}
	}

	if (total * THRESHOLD > bigGreen) {
		return false;
	}
	// check the diagonals - nicely sized spots on the bottom are
	// generally not false positives
	if ((!topCamera || bottomY < height - 5) && !checkDiagonalCircle(spot)) {
		return false;
	}
	return true;
}

bool BallDetector::filterWhiteSpot(Spot spot, intPairVector & blackSpots,
								   intPairVector & badBlack)
{
    // convert back to raw coordinates
    int leftX = spot.ix() + width / 2 - spot.innerDiam / 4;
    int rightX = spot.ix() + width / 2 + spot.innerDiam / 4;
    int topY = -spot.iy() + height / 2 - spot.innerDiam / 4;
    int bottomY = -spot.iy() + height / 2 + spot.innerDiam / 4;
    int midX = spot.ix() + width / 2;
    int midY = -spot.iy() + height / 2;

    // don't  bother if off the field
    if (topCamera && midY < field->horizonAt(midX)) {
        return false;
    }
    if (spot.innerDiam <= 14) {
		if (spot.green > 10) {
			if (debugBall) {
				std::cout << "Dangerous small ball " << spot.green << std::endl;
			}
			return false;
		}
    }

	if (whiteBelowSpot(spot)) {
		if (debugBall) {
			std::cout << "Spot with too much white below " << midX << " " << midY
					  << std::endl;
		}
		return false;
	}

    // count up how many black spots are inside
    int spots = 0;
    for (int j = 0; j < blackSpots.size(); j++) {
        std::pair<int,int> blackspot = blackSpots[j];
        if (blackspot.first > spot.xLo() + width / 2 &&
            blackspot.first < spot.xHi() + width / 2 &&
            blackspot.second > spot.yLo() + height / 2 &&
            blackspot.second < spot.yHi() + height / 2) {
            spots++;
        }
    }
    // for now, if there are no black spots then it is too dangerous
	int THRESHOLD = 110;
    if (spots < 1) {
		// when it is too small it is very dangerous
		if (spot.innerDiam < 6) {
			return false;
		}
		if (!topCamera || !whiteNoBlack(spot)) {
			return false;
		}
    } else if (spots == 1) {
		// circle detection can be hard if the ball is on a line or in front of a robot
		// check whiteness?
		imagePoint p = imagePoint(midX, midY);
		if (((!topCamera || spot.innerDiam < 25) && !checkGradientInSpot(spot)) ||
			!greenAroundBallFromCentroid(p) || spot.green > 40) {
			if (debugBall) {
				std::cout << "Checking one spot " << spot.green << " " << std::endl;
			}
			return false;
		}
	}

    // count up how many bad black spots are inside
    int badspots = 0;
    for (int j = 0; j < badBlack.size(); j++) {
        std::pair<int,int> blackspot = badBlack[j];
        if (blackspot.first > spot.xLo() + width / 2 &&
            blackspot.first < spot.xHi() + width / 2 &&
            blackspot.second > spot.yLo() + height / 2 &&
            blackspot.second < spot.yHi() + height / 2) {
            badspots++;
        }
    }
    // for now, if there are several bad spots then it is too dangerous
    if (badspots > 1 || (badspots == 1 && badspots == spots)) {
		if (debugBall) {
			std::cout << "Rejecting spot with scary bad spots " << std::endl;
		}
        return false;
    }

    // make sure there is some part of the main spot that isn't white
    // if there is actual green then bail - probably a corner or something
	// Note: this is a good idea, but it seems to reject real balls because the
	// spots are sometimes too small
	/*if (rightX - leftX > 4) {
		int nonWhite = 0;
		int green = 0;
		for (int i = leftX; i < rightX; i++) {
			for (int j = topY; j < bottomY; j++) {
				getColor(i, j);
				debugDraw.drawDot(i, j, BLUE);
				if (isGreen()) {
					green++;
					if (green > 2) { //2 should be a constant and increase this a little bit
						if (debugBall) {
							std::cout << "Rejecting spot because of green" << std::endl;
						}
						return false;
					}
				}
				if (!isWhite()) {
					nonWhite++;
				}
			}
		}
		if (debugBall && nonWhite == 0) {
			std::cout << "Rejecting spot because it is all white" << std::endl;
		}
		return nonWhite > 0;
		}*/
	return true;
}

/* Main ball finding routine. Uses white and black spot detection to find the
   ball.
*/
bool BallDetector::findBall(ImageLiteU8 white, double cameraHeight,
                            EdgeList& edges)
{
    Ball reset;
    _best = reset;
    width = white.width();
    height = white.height();
#ifdef OFFLINE
    candidates.clear();
#endif
    bool foundBall = false;
    int BOTTOMEDGEWHITEMAX = 25;
    int BUFFER = 10;
    edgeList = &edges;

    int startCol = 0;
    int endCol = width;
    int endRow = width;
    if(!topCamera) {
        adjustWindow(startCol, endCol, endRow);
    }

    // Then we are going to filter out all of the blobs that obviously
    // aren't part of the ball
    intPairVector blackSpots;
    intPairVector badBlackSpots;
	spotVector actualBlackSpots;
	spotVector actualWhiteSpots;

	debugBlackSpots.clear();
	debugWhiteSpots.clear();

    ImageLiteU16 smallerY;
    ImageLiteU8 smallerGreen;

	//int horiz = 0;
	if (topCamera) {
		//horiz = max(0, min(field->horizonAt(0), field->horizonAt(width - 1)));
        smallerY = ImageLiteU16(yImage, 0, 0, yImage.width(), yImage.height());
        smallerGreen = ImageLiteU8(greenImage, 0, 0, greenImage.width(),greenImage.height());
	} else {
        ((startCol - 3 > 0) ? startCol = startCol-3 : startCol = 0);
        ((endCol + 3 < width) ? endCol = endCol+3 : endCol = width);
        ((endRow + 3 < height) ? endRow = endRow+3 : endRow = height);
        smallerY = ImageLiteU16(yImage, startCol, 0, endCol, endRow);
        smallerGreen = ImageLiteU8(greenImage, startCol, 0, endCol, endRow);
    }

    if(debugBall) {
        std::cout<<"Top Camera: "<<topCamera<<std::endl;
        if(!topCamera) { debugDraw.drawBox(startCol, endCol, endRow, 0, YELLOW); }
    }

    if(!topCamera && (!smallerY.hasProperDimensions() || !smallerGreen.hasProperDimensions())) {
        return false;
    }
    SpotDetector darkSpotDetector;
    initializeSpotterSettings(darkSpotDetector, true, 3.0f, 3.0f, topCamera,
							  filterThresholdDark, greenThresholdDark, 0.5);

    if(darkSpotDetector.spotDetect(smallerY, *homography, &smallerGreen)) {
        SpotList darkSpots = darkSpotDetector.spots();
        std::cout<<"Real ball: "<<darkSpots.size()<<std::endl;
        processDarkSpots(darkSpots, blackSpots, badBlackSpots, actualBlackSpots);
		if (debugSpots) {
			ImageLiteU8 filteredImage = darkSpotDetector.filteredImage();
			int max = field->horizonAt(0);
			if (!topCamera) {
				max = 0;
			}
			int box = 1;
			for (int i = max; i < height && box != 0; i+= box) {
				uint8_t* row = filteredImage.pixelAddr(0, i);
				box = row[1];
				debugDraw.drawBox(1, box + 1, i+box, i, BLUE);
			}
		}
    }

    if(debugBall) {
        for(int z = 0; z < blackSpots.size(); z++) {
            std::pair<int, int> spot = blackSpots[z];
            std::cout<<"Dark Spot "<<z<<", X: "<<spot.first<<", Y: "
					 <<spot.second<<std::endl;
        }
    }

    SpotDetector whiteSpotDetector;
    initializeSpotterSettings(whiteSpotDetector, false, 13.0f, 13.0f,
							  topCamera, filterThresholdBrite, greenThresholdBrite,
							  0.5);
    if(whiteSpotDetector.spotDetect(smallerY, *homography, &smallerGreen)) {
		if (debugSpots) {
			int max = field->horizonAt(0);
			if (!topCamera) {
				max = 0;
			}
			ImageLiteU8 filteredImage = whiteSpotDetector.filteredImage();
			int box = 1;
			for (int i = max; i < height && box > 0; i+= box) {
				uint8_t* row = filteredImage.pixelAddr(0, i);
				box = row[1];
				int bx = 10 - width / 2;
				int by = -i + height / 2;
				imagePoint p = imagePoint(bx, by);
				int radius = projectedBallRadius(p);
				debugDraw.drawBox(10, box + 11, i+box, i, RED);
				debugDraw.drawBox(width - 2* radius - 1, width - 1, i + 2*radius, i, BLUE);
			}
		}
        SpotList whiteSpots = whiteSpotDetector.spots();
        if(processWhiteSpots(whiteSpots, blackSpots, badBlackSpots, actualWhiteSpots,
                             cameraHeight,foundBall)) {
#ifdef OFFLINE
            foundBall = true;
#else
            return true;
#endif
        }
    }

	// run blobber on parts of the image where spot detector won't work
	int bottomThird = max(field->horizonAt(width / 2), height *3 / 10);
	//debugDraw.drawLine(0, bottomThird, width - 1, bottomThird, BLUE);
	if (topCamera) {
		ImageLiteU8 bottomWhite(whiteImage, 0, bottomThird, whiteImage.width(),
								height - bottomThird);
		blobber.run(bottomWhite.pixelAddr(), bottomWhite.width(),
					bottomWhite.height(), bottomWhite.pitch());
	} else {
		bottomThird = 0;
		blobber.run(white.pixelAddr(), white.width(), endRow, white.pitch());
	}

    if(processBlobs(blobber, blackSpots, foundBall, badBlackSpots,
					actualWhiteSpots,
                 cameraHeight, bottomThird)) {
#ifdef OFFLINE
        foundBall = true;
#else
        return true;
#endif
    }

    if(blackSpots.size() != 0) {
        if (findCorrelatedBlackSpots(blackSpots, actualBlackSpots, cameraHeight, foundBall)) {
#ifdef OFFLINE
            foundBall = true;
#else
        return true;
#endif
	   }
    }

    return foundBall;
}

/* This next batch of functions checks whether pixels are a certain
   color. The first, getColor just sets the pixel to be checked. The
   rest should be self explanatory given the pixel having been set.
   It should be noted that the numbers are pretty arbitrary. Hopefully
   that means our system is robust and they aren't actually important.
*/

void BallDetector::getColor(int x, int y) {
    if (x < 0 || y < 0 || x >= width || y >= height) {
        currentX = 0;
        currentY = 0;
    } else {
        currentX = x;
        currentY = y;
    }
}

int BallDetector::getGreen() {
	return *(greenImage.pixelAddr(currentX, currentY));
}

bool BallDetector::isGreen() {
    if (*(greenImage.pixelAddr(currentX, currentY)) > 158) {
        return true;
    }
    return false;
}


int BallDetector::getWhite() {
	return *(whiteImage.pixelAddr(currentX, currentY));
}

bool BallDetector::isWhite() {
    if (*(whiteImage.pixelAddr(currentX, currentY)) > 160)// &&
        //*(yImage.pixelAddr(currentX, currentY)) < 350) {
    {
        return true;
    }
    return false;
}

bool BallDetector::isBlack() {
    if (*(blackImage.pixelAddr(currentX, currentY)) > 68) {
        return true;
    }
    return false;
}

void BallDetector::setImages(ImageLiteU8 white, ImageLiteU8 green,
                             ImageLiteU8 black,
                             ImageLiteU16 yImg,
							 EdgeDetector * edgeD) {
    whiteImage = white;
    greenImage = green;
    blackImage = black;
    yImage = yImg;
	edgeDetector = edgeD;
}

void BallDetector::billToImageCoordinates(double bx, double by, 
                                          double & ix, double & iy){

    ix = bx + width/2;
    iy = -1*by + height/2;
}

void BallDetector::imageToBillCoordinates(double ix, double iy, 
                                          double & bx, double & by) {
    bx = ix - width/2;
    by = (iy - height/2)*-1;
}

/* Ball functions.
 */

Ball::Ball(Spot & s, double x_, double y_, double cameraH_, int imgHeight_,
           int imgWidth_, bool top, double cx, double cy, double conf) :
    spot(s),
    radThresh(.3, .7),
    thresh(.5, .8),
    x_rel(x_),
    y_rel(y_),
    cameraH(cameraH_),
    imgHeight(imgHeight_),
    imgWidth(imgWidth_),
    topCamera(top),
	centerX(cx),
	centerY(cy),
    _confidence(conf)
{
    if (!top) {
        //radThresh = thresh;
        FuzzyThr relaxed(.3, .6);
        thresh = relaxed;
    }
    compute();
}

Ball::Ball() :
    thresh(0, 0),
    radThresh(0, 0),
    _confidence(0),
    dist(200000)
{ }

void Ball::compute()
{
    dist = hypot(x_rel, y_rel);
    radius = int(pixDiameterFromDist(dist));
    double hypotDist = hypot(dist, cameraH);
    expectedDiam = pixDiameterFromDist(hypotDist);

    if (dist > 500) {
        //_confidence = 0;
    }
}

std::string Ball::properties()
{
    std::string d("====Ball properties:====\n");
    d += "\tRelativePosition: " + to_string(x_rel) + " "+ to_string( y_rel) + "\n";
    d += "\tHomographyDistance is: " + to_string(dist) + "\n";
    //d += "\tdensity is: " + to_string(blob.area() / blob.count()) + "\n";
    //d += "\tcount is: " + to_string(blob.count()) + "\n";
    d += "\tlocated: (" + to_string(centerX) +  ", " +
        to_string(centerY) + ")\n";
    d += "\tprinceLens: " + to_string(radius) + " " +
        to_string(radius) + "\n";
    //d += "\taspectR is: " + to_string(blob.secondPrincipalLength() /
    //								  blob.firstPrincipalLength()) + "\n";
    d += "\texpect ball to be this diam: " + to_string(expectedDiam) + "\n";
    d += "\tdiamRatio: " + to_string(diameterRatio) + "\n";
    d += "\tdiam Confidence: " + to_string((diameterRatio> radThresh).f()) + "\n";
    d += "\n\tconfidence is: " + to_string(_confidence) +
        "\n====================\n";
    return d;
}

// The expected diameter of ball in image at distance d in CM
double Ball::pixDiameterFromDist(double d) const
{
    double trig = atan(BALL_RADIUS / d);
    return 2 * imgHeight * trig / VERT_FOV_RAD;
}



}
}
