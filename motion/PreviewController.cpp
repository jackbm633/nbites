#include "PreviewController.h"
//#include <iostream>
//using namespace std;

//#include <boost/numeric/ublas/io.hpp>              // for cout

// generated by scilab.
//const float PreviewController::weights[NUM_PREVIEW_FRAMES] =
//{39.929727, -8.999180, -8.042051, -7.186710, -6.422341, -5.739270, -5.128849, -4.583352, -4.095873, -3.660242, -3.270944, -2.923051, -2.612159, -2.334333, -2.086057, -1.864187, -1.665915, -1.488730, -1.330391, -1.188892, -1.062444, -0.949444, -0.848462, -0.758221, -0.677577, -0.605511, -0.541110, -0.483558, -0.432128, -0.386167, -0.345095, -0.308391, -0.275591, -0.246280, -0.220086, -0.196678, -0.175759, -0.157066, -0.140360, -0.125432};
const float PreviewController::weights[NUM_PREVIEW_FRAMES] =
{39.929727, -8.999180, -8.042051, -7.186710, -6.422341, -5.739270, -5.128849, -4.583352, -4.095873, -3.660242, -3.270944, -2.923051, -2.612159, -2.334333, -2.086057, -1.864187, -1.665915, -1.488730, -1.330391, -1.188892, -1.062444, -0.949444, -0.848462, -0.758221, -0.677577, -0.605511, -0.541110, -0.483558, -0.432128, -0.386167, -0.345095, -0.308391, -0.275591, -0.246280, -0.220086, -0.196678, -0.175759, -0.157066, -0.140360, -0.125432, -0.112091, -0.100169, -0.089515, -0.079995, -0.071487, -0.063883, -0.057089, -0.051017, -0.045591, -0.040742, -0.036409, -0.032536, -0.029076, -0.025983, -0.023220, -0.020750, -0.018543, -0.016571, -0.014808, -0.013233};

const float PreviewController::A_c_values[9] =
{ 1.0021071,   0.0192912,  -0.0039916,
  0.0000001,   0.8936414,  -0.2828039,
  2.0021066,   0.3560861,  -0.1084655 };

const float PreviewController::b_values[3] =
{ - 0.0000422,
  - 0.0063292,
    0.02 };

const float PreviewController::c_values[3] =
{ 0.0f, 0.0f, 1.0f };

PreviewController::PreviewController()
    : WalkController(), stateVector(ufvector3(3)),
      A_c(ufmatrix3(3,3)), b(ufvector3(3)), c(ufrowVector3(1,3)) {
    // instantiate the ublas matrices with their respective values
    // TODO: there might be a better way to do this.
    for (int i=0; i < 3; i++)
        stateVector(i) = 0.0f;

    for (int i=0; i < 3; i++)
        A_c(0, i) = A_c_values[i];
    for (int i=0; i < 3; i++)
        A_c(1, i) = A_c_values[3+i];
    for (int i=0; i < 3; i++)
        A_c(2, i) = A_c_values[6+i];

    for (int i=0; i < 3; i++)
        b(i) = b_values[i];

    for (int i=0; i < 3; i++)
        c(0,i) = c_values[i];

#ifdef DEBUG_CONTROLLER_GAINS
    FILE * gains_log;
    gains_log = fopen("/tmp/gains_log.xls","w");
    int j = 0;
    fprintf(gains_log,"time\tgain\n");
    //write the controller gains
    for(unsigned int i  = 0; i < NUM_PREVIEW_FRAMES; i++){
        fprintf(gains_log,"%d\t%f\n",j++,weights[j]);
    }
    fclose(gains_log);
#endif

}

/**
 * Tick calculates the next state vector for the robot, given the zmp_ref
 *
 */
const float PreviewController::tick(const list<float> *zmp_ref) {
    float control = 0.0f; // This is 'u' in mathematical notation
    unsigned int counter = 0;
    for (list<float>::const_iterator i = zmp_ref->begin();
         counter < NUM_PREVIEW_FRAMES; counter++, i++) {
        control += weights[counter]* (*i);
    }
    stateVector.assign(prod(A_c, stateVector) + b*control);
    return getPosition();
}

/**
 * Initialize the position of the robot (vel and accel assumed to be 0)
 */
void PreviewController::initState(float x, float v, float p){
    stateVector(0) = x;
    stateVector(1) = v;
    stateVector(2) = p;

}
