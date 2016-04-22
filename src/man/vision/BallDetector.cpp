
#include "BallDetector.h"

#include <algorithm>
#include <iostream>


using std::to_string;

namespace man {
namespace vision {

BallDetector::BallDetector(FieldHomography* homography_,
                           Field* field_, bool topCamera_):
    blobber(),
    blobber2(),
    homography(homography_),
    field(field_),
    topCamera(topCamera_)
{
    // Note from Chown:  I don't know what these numbers mean,
    // they are holdovers from the Dan Zeller days
    blobber.secondThreshold(115);
    blobber.minWeight(4);
    blobber2.secondThreshold(115);
    blobber2.minWeight(4);
}

BallDetector::~BallDetector() { }

void BallDetector::setDebugImage(DebugImage * di) {
    debugDraw =  *di;
}

/* This function takes in a blob generated by the blobbing
   system running on the black image and determines if the
   blob could reasonably be interpreted at one of the black
   hexagons on a ball. The standard of proof is not particularly
   high - it should be of the right relative size. If it is
   ok, then add it to the current list of such blobs for later
   processing.
*/
void BallDetector::filterBlackBlobs(Blob currentBlob,
                                    std::vector<std::pair<int,int>> & blobs,
                                    std::vector<Blob> & actualBlobs)
{
    int MAX_BLACK_BLOB = 8;
    float MIN_BLACK_AREA = 7.0f;

    int centerX = static_cast<int>(currentBlob.centerX());
    int centerY = static_cast<int>(currentBlob.centerY());
	if (topCamera) {
		centerY = centerY + height / 2;
	}
    int prinLength = static_cast<int>(currentBlob.firstPrincipalLength());
    int prinLength2 = static_cast<int>(currentBlob.secondPrincipalLength());
    int minSecond = 1;
    // in principle the bottom camera might use a different standard
    // but for now we don't actally do this
    if (!topCamera) {
        minSecond = 1;
    }
    int maxB = MAX_BLACK_BLOB;
	int minB = 1;
    float minArea = MIN_BLACK_AREA;
    if (centerY < 100) {
        minArea = 5.0f;
        maxB = 5;
    } else if (centerY < 140) {
        maxB = 6;
    } else if (centerY < 200) {
        maxB = 7;
    }
    if (!topCamera) {
        maxB = MAX_BLACK_BLOB;
		minB = 3;
    }
    if (prinLength < maxB && prinLength >= minB &&
        prinLength2 >= minSecond && currentBlob.area() > minArea &&
        (centerY > field->horizonAt(centerX) || !topCamera)) {
        blobs.push_back(std::make_pair(centerX, centerY));
        actualBlobs.push_back(currentBlob);
        if (debugBall) {
            debugDraw.drawPoint(centerX, centerY, BLUE);
            std::cout << "Black blob " << centerX << " " << centerY <<
                " " << prinLength << " " << prinLength2 <<
                " " << currentBlob.area() << std::endl;
        }
    } else if (debugBall) {
        /*std::cout << "Rejected Black blob " << centerX << " " << centerY <<
          " " << prinLength << " " << prinLength2 <<
          " " << currentBlob.area() << std::endl; */
    }
}

/* This function takes in a white blob generated by the blobbing
   system and determines if it might be the ball. Most such blobs
   are going to be the wrong size (generally too big), but if they
   aren't, then we look to see if the blob contains any internal
   black blobs. If we have enough such blobs then it is a pretty
   good bet that this is a ball.
*/
int BallDetector::filterWhiteBlobs(Blob currentBlob,
                                   std::vector<std::pair<int,int>> & blobs,
                                   std::vector<std::pair<int,int>> blackBlobs)
{
    int MAX_WHITE_BLOB = 40;
    float MIN_AREA = 10.0f;
    int centerX = static_cast<int>(currentBlob.centerX());
    int centerY = static_cast<int>(currentBlob.centerY());
    int prinLength = static_cast<int>(currentBlob.firstPrincipalLength());
    int prinLength2 = static_cast<int>(currentBlob.secondPrincipalLength());
    int minSecond = 3;
    if (!topCamera) {
        minSecond = 3;
    }
	bool ratio = false;
	if (prinLength < prinLength2 * 2 || centerX < prinLength ||
		centerX > width - prinLength || centerY > height - prinLength) {
		ratio = true;
	}

    // see if the blob is of the right general shape for a ball
    if (prinLength < MAX_WHITE_BLOB && prinLength2 >= minSecond &&
        ratio && currentBlob.area() > MIN_AREA &&
        (centerY > field->horizonAt(centerX) || !topCamera)) {
        blobs.push_back(std::make_pair(centerX, centerY));
        if (debugBall) {
            debugDraw.drawPoint(centerX, centerY, BLUE);
            std::cout << "White blob " << centerX << " " << centerY <<
                " " << prinLength << " " << prinLength2 << std::endl;
        }
        int count = 0;
        // now loop through the black blobs and see if they are inside
        for (int i = 0; i < blackBlobs.size(); i++) {
            std::pair<int,int> p = blackBlobs[i];
            if (abs(p.first - centerX) <= prinLength &&
                abs(p.second - centerY) <= prinLength) {
                count++;
            } else if (ratio && !topCamera &&
					   abs(p.first - centerX) <= prinLength + 3 &&
					   abs(p.second - centerY) <= prinLength + 3) {
				count++;
			}
        }
        if (count < 2 && topCamera && nearSanityChecks(currentBlob)) {
            return 2;
        }
        return count;
    }
    return 0;
}

int BallDetector::scanX(int startX, int startY, int direction, int stop) {
    int newX = startX;
    for (int i = startX; i != stop && i >= 0 && i < width; i += direction) {
        getColor(i, startY);
        if (!(isWhite() || isBlack()) && isGreen()) {
            break;
        } else {
            newX = i;
        }
    }
    //std::cout << "Returning " << newX << std::endl;
    return newX;
}

int BallDetector::scanY(int startX, int startY, int direction, int stop) {
    int newY = startY;
    for (int i = startY; i != stop && i >= 0 && i < height; i += direction) {
        getColor(startX, i);
        if (!(isWhite() || isBlack()) && isGreen()) {
            break;
        } else {
            newY = i;
        }
    }
    return newY;
}

/* We have a potential ball on the horizon. Do some checking to
   screen out potential other stuff.
   This is a substantial area of possible improvement - more sanity
   checks are definitely needed!
*/
bool BallDetector::farSanityChecks(Blob blob)
{
    // if it is too close to the horizon - bad
    // if it is too greeen - bad
    int centerX = static_cast<int>(blob.centerX());
    int centerY = static_cast<int>(blob.centerY());
    int prinLength = static_cast<int>(blob.firstPrincipalLength());
    int prinLength2 = static_cast<int>(blob.secondPrincipalLength());
    // the black in the ball tends to make our blob footprint too small
    // try to expand it
    int leftX = centerX;
    int rightX = centerX;
    int bottomY = centerY;
    int topY = centerY;

    leftX = scanX(centerX - 1, centerY, -1, 1);
    rightX = scanX(centerX + 1, centerY, 1, width - 1);
    centerX = leftX + (rightX - leftX) / 2;
    topY = scanY(centerX, centerY - 1, -1, max(0, field->horizonAt(centerX)));
    bottomY = scanY(centerX, centerY + 1, 1, height - 1);
    centerY = topY + (bottomY - topY) / 2;
    int boxWidth = rightX - leftX;
    int boxHeight = bottomY - topY;
    leftX = scanX(centerX - 1, centerY, -1, 1);
    rightX = scanX(centerX + 1, centerY, 1, width - 1);
    centerX = leftX + (rightX - leftX) / 2;
    topY = scanY(centerX, centerY - 1, -1, max(0, field->horizonAt(centerX)));
    bottomY = scanY(centerX, centerY + 1, 1, height - 1);
    centerY = topY + (bottomY - topY) / 2;

    boxWidth = rightX - leftX;
    boxHeight = bottomY - topY;
    if (debugBall) {
        //debugDraw.drawBox(leftX, rightX, bottomY, topY, ORANGE);
        std::cout << "Box " << boxWidth << " " << boxHeight << std::endl;
        std::cout << "Ending at " << centerX << " " << centerY << std::endl;
    }
    int MINBOX = 8;
    if (boxWidth < MINBOX || boxHeight < MINBOX) {
        return false;
    }
    if (boxWidth > 2 * boxHeight || boxHeight > 2 * boxWidth) {
        return false;
    }
    return true;
}

/* We have a white blob that is relatively near us. For whatever
   reason we didn't see any black blobs in it. Make sure that
   wasn't just because our black detector was bad. Watch out for
   field crosses though.
 */
bool BallDetector::nearSanityChecks(Blob blob)
{
    int centerX = static_cast<int>(blob.centerX());
    int centerY = static_cast<int>(blob.centerY());
    int prinLength = static_cast<int>(blob.firstPrincipalLength());
    int prinLength2 = static_cast<int>(blob.secondPrincipalLength());
    // the black in the ball tends to make our blob footprint too small
    // try to expand it
    int leftX = centerX;
    int rightX = centerX;
    int bottomY = centerY;
    int topY = centerY;

    leftX = scanX(centerX - 1, centerY, -1, 1);
    rightX = scanX(centerX + 1, centerY, 1, width - 1);
    centerX = leftX + (rightX - leftX) / 2;
    topY = scanY(centerX, centerY - 1, -1, max(0, field->horizonAt(centerX)));
    bottomY = scanY(centerX, centerY + 1, 1, height - 1);
    centerY = topY + (bottomY - topY) / 2;
    int boxWidth = rightX - leftX;
    int boxHeight = bottomY - topY;
    if (debugBall) {
        //debugDraw.drawBox(leftX, rightX, bottomY, topY, ORANGE);
        std::cout << "Near Box " << boxWidth << " " << boxHeight << std::endl;
        std::cout << "Ending at " << centerX << " " << centerY << std::endl;
    }
    int MINBOXWIDTH = 15;
	int MINBOXHEIGHT = 15;
    int MAXBOX = 50;
	bool atEdge = false;
	if (centerX < prinLength || centerX > width - prinLength) {
		MINBOXWIDTH = 8;
		atEdge = true;
	}
    if (boxWidth < MINBOXWIDTH || boxHeight < MINBOXHEIGHT ||
		boxWidth > MAXBOX || boxHeight > MAXBOX) {
        return false;
    }
    if (boxWidth > 2 * boxHeight || (boxHeight > 2 * boxWidth && !atEdge)) {
        return false;
    }
	// field cross check
	int count = 0;
	for (int i = centerX - boxWidth / 4; i < centerX + boxWidth / 4; i++) {
		for (int j = centerY - boxHeight / 4; j < centerY - boxHeight / 4; j++) {
			getColor(i, j);
			if (isBlack()) {
				count++;
			}
		}
	}
	if (count < 5) {
		return false;
	}
    return true;

}

/* Our worst ball detector. Tries to find small white blobs
   off in the distance. The trouble is that such blobs might
   be other things. This will require a number of sanity checks.
*/
bool BallDetector::lookForFarAwayBalls(Blob blob)
{
    int FARAWAY_WHITE_SIZE = 15;
    float MIN_AREA = 10.0f;
    int centerX = static_cast<int>(blob.centerX());
    int centerY = static_cast<int>(blob.centerY());
    int prinLength = static_cast<int>(blob.firstPrincipalLength());
    int prinLength2 = static_cast<int>(blob.secondPrincipalLength());
    if (topCamera && centerY < height /3 &&
        prinLength < FARAWAY_WHITE_SIZE &&
        prinLength2 > prinLength / 2 && blob.area() > MIN_AREA &&
        prinLength2 >= 1 &&
        (centerY > field->horizonAt(centerX) || !topCamera)) {
        return farSanityChecks(blob);
    }/* else if (topCamera && centerY >= height / 3 &&
               centerY > field->horizonAt(centerX) &&
               prinLength > 3 && prinLength2 > 3) {
        return nearSanityChecks(blob);
        } */
    return false;
}

/* Checks if two black blobs are close enough to be potentially
   part of the same ball.
*/

bool BallDetector::blobsAreClose(std::pair<int,int> first,
                                 std::pair<int,int> second)
{
    int BOTTOM_CAMERA_BLOB_NEARNESS = 25;
    int TOP_CAMERA_BLOB_NEARNESS = 28;
    int TOTAL_CLOSENESS = 45;
    int closeness = TOP_CAMERA_BLOB_NEARNESS;
    int xdiff = abs(first.first - second.first);
    int ydiff = abs(first.second - second.second);
    int ymax = max(first.second, second.second);
    if (!topCamera) {
        closeness = BOTTOM_CAMERA_BLOB_NEARNESS;
    } else {
        if (ymax > 200) {
            closeness = TOP_CAMERA_BLOB_NEARNESS;
        } else if (ymax > 160) {
            closeness = 24;
            TOTAL_CLOSENESS = 35;
        } else if (ymax > 120) {
            closeness = 17;
            TOTAL_CLOSENESS = 30;
        } else {
            closeness = 15;
            TOTAL_CLOSENESS = 25;
        }
    }
    if (xdiff < closeness && ydiff < closeness &&
        (xdiff + ydiff) < TOTAL_CLOSENESS &&
        (xdiff > 0 || ydiff > 0)) {
		int yMid = (first.second + second.second) / 2;
		int xMid = (first.first + second.first) / 2;
		int count = 0;
		int count2 = 0;
		for (int i = min(first.first, second.first);
			 i < max(first.first, second.first); i++) {
			getColor(i, yMid);
			if (isGreen()) {
				count++;
			}
			if (isWhite()) {
				count2++;
			}
		}
		if (count > 1 || count2 == 0) {
			return false;
		}
        return true;
    }
    return false;
}

/* Sometimes our balls are not tidy blobs (e.g. they are up against a
   post or a robot). So we need other methods of finding them. This
   is one such method. It looks at our filtered list of black blobs
   and tries to find groups of them that are near each other. If there
   are enough of them then it is strong evidence of a ball.
*/
bool BallDetector::findCorrelatedBlackBlobs
(std::vector<std::pair<int,int>> & blackBlobs,
 std::vector<Blob> & actualBlobs,
 double cameraHeight, bool foundBall)
{
    // loop through the filtered blobs and see if any are close together
    int correlations[blackBlobs.size()];
    int correlatedTo[blackBlobs.size()][blackBlobs.size()];
    bool foundThree = false;
    // loop through filtered black blobs
    for (int i = 0; i < blackBlobs.size(); i++) {
        std::pair<int,int> p = blackBlobs[i];
        // initialize the correlations for this blob
        correlations[i] = 0;
        for (int k = 0; k < blackBlobs.size(); k++) {
            correlatedTo[i][k] = 0;
        }
        // we're going to check against all other black blobs
        for (int j = 0; j < blackBlobs.size(); j++) {
            std::pair<int,int> q = blackBlobs[j];
            if (blobsAreClose(p, q)) {
                correlations[i] += 1;
                correlatedTo[i][j] = 1;
                // Four close black blobs is good evidence for a ball
                if (correlations[i] > 2) {
                    // grab this blob from our vector
                    foundThree = true;
                    Blob newBall = actualBlobs[i];
                    // find our correlated blobs and merge them in
                    for (int k = 0; k < blackBlobs.size(); k++) {
                        if (correlatedTo[i][k] == 1) {
                            Blob merger = actualBlobs[k];
                            newBall.merge(merger);
                        }
                    }
                    makeBall(newBall, cameraHeight, 0.8, foundBall, true);
#ifdef OFFLINE
                    foundBall = true;
#else
                    return true;
#endif
                }
            }
        }
    }
    // If the best case didn't work out, look for 3 black blobs together
    for (int c = 0; c < blackBlobs.size(); c++) {
        if ((correlations[c] > 1 || (correlations[c] == 1 && !topCamera))
			 && !foundThree) {
            // good candidate ball
            Blob newBall = actualBlobs[c];
            for (int k = 0; k < blackBlobs.size(); k++) {
                if (correlatedTo[c][k] == 1) {
                    Blob merger = actualBlobs[k];
                    newBall.merge(merger);
                    // don't double count this blob
                    correlatedTo[k][c] = 0;
                    correlations[k] -= 1;
                    if (debugBall) {
                        std::cout << "Cor: " << blackBlobs[c].first <<
                            " " << blackBlobs[c].second << " " <<
                            blackBlobs[k].first << " " << blackBlobs[k].second <<
                            std::endl;
                    }
                }
            }
            makeBall(newBall, cameraHeight, 0.75, foundBall, true);
#ifdef OFFLINE
            foundBall = true;
#else
            return true;
#endif
        }
    }
    return foundBall;
}

/* This function is called when one of our detectors has found a
   ball. For now it creates a ball from the blob used to find it.
   Also, it might set this as the "best" ball based on confidence
   ratings. Since we process balls in terms of highest confidence
   methods first, in practice (on the robot) this won't matter as
   we will stop looking as soon as we find one. But for debugging it
   is helpful to find all of the possible balls that vision could
   detect in every image.
*/
void BallDetector::makeBall(Blob blob, double cameraHeight, double conf,
                            bool foundBall, bool isBlack)
{
    double bIX = (blob.centerX() - width/2);
    double bIY = (height / 2 - blob.centerY()) -
        blob.firstPrincipalLength();
	double cY = blob.centerY();
	if (topCamera && isBlack) {
		bIY = bIY + height / 2;
		cY = cY + height / 2;
	}
    double x_rel, y_rel;
    bool belowHoriz = homography->fieldCoords(bIX, bIY, x_rel, y_rel);
    Ball b(blob, x_rel, -1 * y_rel, cameraHeight, height,
           width, topCamera, false, false, false, blob.centerX(), cY);
    b._confidence = conf;
    if (!foundBall) {
        _best = b;
    }
    //edgeSanityCheck((int)blob.centerX(), (int)blob.centerY(), blob.firstPrincipalLength());
#ifdef OFFLINE
    candidates.push_back(b);
#endif
}

void BallDetector::sanityChecks(int bx, int by, int radius)
{

}

void BallDetector::edgeSanityCheck(int bx, int by, int radius)
{
    int count = 0;
    radius = max(12, radius);
    if (by > ( 2 * height ) / 2) {
        radius = max(20, radius);
    }
    // Get edges from vision
    for (int i = 0; i < goodEdges.size(); i++) {
        int x = goodEdges[i].x() + width/2;
        int y = height/2 - goodEdges[i].y();
        int ang = goodEdges[i].angle();

        if (abs(bx - x) < radius && abs(by - y) < radius) {
            if (debugBall) {
                debugDraw.drawPoint(x, y, BLUE);
            }
            count++;
        }
    }
    if (debugBall) {
        std::cout << "Edge count: " << count << std::endl;
    }

}

/* Filter the edge list down to possible balls */
void BallDetector::makeEdgeList(EdgeList & edges)
{
    // Get edges from vision
    goodEdges.clear();
    AngleBinsIterator<Edge> abi(edges);
    for (Edge* e = *abi; e; e = *++abi){
        // If we are part of a hough line, we are not a ball edge
        if (e->memberOf()) { continue; }

        int x = e->x() + width/2;
        int y = height/2 - e->y();
        // if we're off the field we aren't a ball edge
        if (y < field->horizonAt(x)) { continue; }
        goodEdges.push_back(*e);
    }
}

/* Main ball finding routine. Uses white and black blobbing to find the
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

    //makeEdgeList(edges);
	if (topCamera) {

		ImageLiteU8 bottomBlack(blackImage, 0, blackImage.height()/2,
								blackImage.width(), blackImage.height() / 2);
		// First we're going to run the blobber on the black image
		blobber.run(bottomBlack.pixelAddr(), bottomBlack.width(),
					bottomBlack.height(), bottomBlack.pitch());
	} else {
		blobber.run(blackImage.pixelAddr(), blackImage.width(),
					 blackImage.height(), blackImage.pitch());
	}

    // Then we are going to filter out all of the blobs that obviously
    // aren't part of the ball
    std::vector<std::pair<int,int>> blackBlobs;
    std::vector<Blob> actualBlackBlobs;
    for (auto i =blobber.blobs.begin(); i!=blobber.blobs.end(); i++) {
        filterBlackBlobs((*i), blackBlobs, actualBlackBlobs);
    }

	/*if (topCamera) {

		ImageLiteU8 bottomWhite(whiteImage, 0, whiteImage.height()/2,
								whiteImage.width(), whiteImage.height() / 2);
		// First we're going to run the blobber on the white image
		blobber2.run(bottomWhite.pixelAddr(), bottomWhite.width(),
					bottomWhite.height(), bottomWhite.pitch());
					} else { */
		blobber2.run(whiteImage.pixelAddr(), whiteImage.width(),
					 whiteImage.height(), whiteImage.pitch());
		//}
    // Now run the blobber on the white image
    std::vector<std::pair<int,int>> whiteBlobs;
    // loop through the white blobs hoping to find a ball sized blob
    for (auto i =blobber2.blobs.begin(); i!=blobber2.blobs.end(); i++) {
        int count = filterWhiteBlobs((*i), whiteBlobs, blackBlobs);
        int centerY = static_cast<int>((*i).centerY());
        int principalLength = static_cast<int>((*i).firstPrincipalLength());
        if (count > 1) {
            makeBall((*i), cameraHeight, 0.9, foundBall, false);
            foundBall = true;
        } else if (count == 2) {
            makeBall((*i), cameraHeight, 0.8, foundBall, false);
            foundBall = true;
        }else if (count > 0 && topCamera &&
                  centerY + principalLength > height - BUFFER &&
                  principalLength < BOTTOMEDGEWHITEMAX) {
            makeBall((*i), cameraHeight, 0.5, foundBall, false);
            foundBall = true;
        } else if (count == 1 && debugBall) {
			std::cout << "Found a white blob with one black spot " <<
				centerY << std::endl;
		}
#ifdef OFFLINE
#else
        if (foundBall) {
            return true;
        }
#endif
    }

    if (findCorrelatedBlackBlobs(blackBlobs, actualBlackBlobs, cameraHeight,
                                 foundBall)) {
#ifdef OFFLINE
        foundBall = true;
#else
        return true;
#endif
	}

    for (auto i =blobber2.blobs.begin(); i!=blobber2.blobs.end(); i++) {
        if (lookForFarAwayBalls((*i))) {
            makeBall((*i), cameraHeight, 0.5, foundBall, false);
#ifdef OFFLINE
            std::cout << "Found faraway ball" << std::endl;
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

bool BallDetector::isGreen() {
    if (*(greenImage.pixelAddr(currentX, currentY)) > 158) {
        return true;
    }
    return false;
}

bool BallDetector::isWhite() {
    if (*(whiteImage.pixelAddr(currentX, currentY)) > 88)// &&
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
                             ImageLiteU16 yImg) {
    whiteImage = white;
    greenImage = green;
    blackImage = black;
    yImage = yImg;
}

/* Ball functions.
 */

Ball::Ball(Blob& b, double x_, double y_, double cameraH_, int imgHeight_,
           int imgWidth_, bool top, bool os, bool ot, bool ob, double cx,
	double cy) :
    blob(b),
    radThresh(.3, .7),
    thresh(.5, .8),
    x_rel(x_),
    y_rel(y_),
    cameraH(cameraH_),
    imgHeight(imgHeight_),
    imgWidth(imgWidth_),
    topCamera(top),
    occludedSide(os),
    occludedTop(ot),
    occludedBottom(ob),
	centerX(cx),
	centerY(cy),
    _confidence(0)
{
    if (!top) {
        //radThresh = thresh;
        FuzzyThr relaxed(.3, .6);
        thresh = relaxed;
    }
    compute();
}

Ball::Ball() :
    blob(0),
    thresh(0, 0),
    radThresh(0, 0),
    _confidence(0),
    dist(200000)
{ }

void Ball::compute()
{
    dist = hypot(x_rel, y_rel);
    double density = blob.area() / blob.count();
    double aspectRatio = (blob.secondPrincipalLength() /
                          blob.firstPrincipalLength());

    double hypotDist = hypot(dist, cameraH);

    expectedDiam = pixDiameterFromDist(hypotDist);

    diameterRatio;
    if (expectedDiam > 2 * firstPrincipalLength) {
        diameterRatio = 2 * firstPrincipalLength / expectedDiam;
    } else {
        diameterRatio = expectedDiam / (2 * firstPrincipalLength);
    }

    // We have sort of lost the ability to detect occlusion, so this
    // could be drastically simplified again. But maybe we'll detect it again?
    if ((occludedSide || occludedTop || occludedBottom) && density > 0.9) {
        _confidence = ((density > thresh) & (aspectRatio > thresh) &
                       (diameterRatio > radThresh)).f();
        _confidence = ((density > thresh) &
                       (diameterRatio > radThresh)).f() * 0.85;
    } else {
        _confidence = ((density > thresh) & (aspectRatio > thresh) &
                       (diameterRatio > radThresh)).f();
    }


    // Hack/Sanity check to ensure we don't see crazy balls
    if (dist > 600) {
        _confidence = 0;
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
    d += "\tprinceLens: " + to_string(firstPrincipalLength) + " " +
        to_string(firstPrincipalLength) + "\n";
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
