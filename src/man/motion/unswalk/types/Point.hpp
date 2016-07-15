#pragma once

#include <../../vision/Eigen/Eigen> // TODO Bella 2016 trying to figure this out
#include <iostream>

typedef Eigen::Vector2i Point;
typedef Eigen::Vector2f PointF;

namespace boost {
   namespace serialization {

      template <class Archive>
      void serialize(Archive & ar, Point& p, const unsigned int version)
      {
         ar & p[0];
         ar & p[1];
      }

      template <class Archive>
      void serialize(Archive & ar, PointF& p, const unsigned int version)
      {
         ar & p[0];
         ar & p[1];
      }
   
   }
}

// bella trying to include eigen from vision instead

// inline std::ostream& operator<<(std::ostream& os, const Point& point) {
//    int x = point[0];
//    int y = point[1];
   
//    os.write((char*) &x, sizeof(int));
//    os.write((char*) &y, sizeof(int));
//    return os;
// }

// inline std::istream& operator>>(std::istream& is, Point& point) {
//    int x, y;
   
//    is.read((char*) &x, sizeof(int));
//    is.read((char*) &y, sizeof(int));
   
//    point[0] = x;
//    point[1] = y;
   
//    return is;
// }
