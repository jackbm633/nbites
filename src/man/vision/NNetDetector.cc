#include "NNetDetector.h"

#include <unistd.h>

#include <iostream>
#include <cstdlib>
#include <iomanip>
#include <string>
#include <vector>
#include <queue>
#include <fstream>
#include <opencv2/opencv.hpp>   
#include <opencv2/core/core.hpp>  
#include <opencv2/highgui/highgui.hpp>

#include "../thirdparty/darknet-nao-master/darknet-nao-master/src/yolo_v2_class.hpp"    
// imported functions from .so file.

using namespace cv;

namespace man {
namespace vision {

// Uses the Darknet DLL (darknet.so) and corresponding neural network and
// config files to detect bounding boxes of the objects the network is trained
// on. 
// Example (for use with VisionModule.h)
// 	nNetDetector[i] = new NNetDetector(0.3), where the number passed to the
// 	NNetDetector constructor is the detection threshold. 
//	delete nNetDetector[i]
// Within visionModule::run_():
//	nNetDetector[i]->detect(im)



double threshold = 0.25;
std::vector<std::string> obj_names;
Detector detector("/home/nao/nbites/NNet/cfg", "/home/nao/nbites/NNet/weights");
#ifdef OFFLINE
	const std::string home_dir = getenv("HOME");
	const std::string weights_path = home_dir + "/nbites/NNet/weights";
	const std::string cfg_path = home_dir + "/nbites/NNet/cfg";
	const std::string names_path = home_dir + "/nbites/NNet/names";
	#else
	const std::string weights_path = "/home/nao/nbites/NNet/weights";
	const std::string cfg_path = "/home/nao/nbites/NNet/cfg";
	const std::string names_path = "/home/nao/nbites/NNet/names";
	#endif	

std::vector<std::string> NNetDetector::objects_names_from_file(
	std::string const filename) {
    std::ifstream file(filename);
    std::vector<std::string> file_lines;
    if (!file.is_open()) return file_lines;
    for(std::string line; getline(file, line);) file_lines.push_back(line);
    std::cout << "object names loaded \n";
    return file_lines;
}

NNetDetector::NNetDetector(double thresh): 
	threshold(thresh) {}
	
void NNetDetector::initialise(){
	Detector detector(cfg_path, weights_path);	
	
	obj_names = objects_names_from_file(names_path);
}
	


void NNetDetector::detect(std::deque<std::vector<unsigned char>> img, 
	int height, 
	int width){

	// We first convert the passed image to an OpenCV Mat for processing
	// purposes.
	
	std::vector<unsigned char> r_vec = img[0];
	std::vector<unsigned char> g_vec = img[1];
	std::vector<unsigned char> b_vec = img[2];
	
	cv::Mat r_mat = Mat(height, width/2, CV_8UC1);
	cv::Mat g_mat = Mat(height, width/2, CV_8UC1);
	cv::Mat b_mat = Mat(height, width/2, CV_8UC1);
	memcpy(r_mat.data, r_vec.data(), r_vec.size()*sizeof(uchar));
	memcpy(g_mat.data, g_vec.data(), g_vec.size()*sizeof(uchar));
	memcpy(b_mat.data, b_vec.data(), b_vec.size()*sizeof(uchar));

	cv::Mat planes[] = {b_mat, g_mat, r_mat};
	cv::Mat rgb_image;
	merge(planes, 3, rgb_image);

	// Now, we have our color image (rgb_image).



	std::vector<bbox_t> result_vec = detector.detect(rgb_image, 0.1, true);
	std::cout << "Detections: " << result_vec.size() << std::endl;
	std::cout << "Name\tX\tY\tW\tH\n";
	for (int i = 0; i < result_vec.size(); i++) {
		bbox_t b = result_vec[i];
		std::cout << obj_names[b.obj_id] << "\t" << b.x << "\t" << b.y  << "\t" 
			<< b.w << "\t" <<  b.h << std::endl;
	}
	
	
	
}

	



}
}
