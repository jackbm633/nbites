#pragma once

#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <queue>
#include <fstream>
#include <deque>

#include <opencv2/opencv.hpp>            // C++
#include "opencv2/core/version.hpp"

#include "Images.h"
#include "../thirdparty/darknet-nao-master/darknet-nao-master/src/yolo_v2_class.hpp" 

namespace man {
namespace vision{

// Uses the Darknet DLL (darknet.so) and corresponding neural network and
// config files to detect bounding boxes of the objects the network is trained
// on. 
// Example (for use with VisionModule.h)
// 	nNetDetector[i] = new NNetDetector(0.3), where the number passed to the
// 	NNetDetector constructor is the detection threshold. 
//	delete nNetDetector[i]
// Within visionModule::run_():
//	nNetDetector[i]->detect(im)

class NNetDetector {

	

private:
	double threshold;
	
	
	


public:
	NNetDetector(double thresh);
	void detect(std::deque<std::vector<unsigned char>> img, 
		int height, int width);
	void initialise();
	std::vector<std::string> objects_names_from_file(std::string const filename);

};


}
}