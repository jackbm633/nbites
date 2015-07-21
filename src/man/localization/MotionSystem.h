/**
 * @brief  Define a class responsible for updating particles based on
 *         odometry measurements from the motion system
 *
 * @author EJ Googins <egoogins@bowdoin.edu>
 * @date   February 2013
 * @author Josh Imhoff <joshimhoff13@gmail.com>
 * @date   June 2015
 */

#pragma once

#include "Particle.h"
#include "RobotLocation.pb.h"

#include <cmath>

namespace man
{
namespace localization
{

// FUTURE WORK, this is a very simplistic motion model, future work includes 
//              varying the amount of noise added to particles as a function
//              of (1) the speed of robot and (2) the direction of motion 
//              (more noise in principal direction of motion)

class MotionSystem
{
public:
    // Constructor
    // @param xyNoise_, noise sampled from a gaussian with standard deviation
    //                  xyNoise_ added to particles' x and y components
    // @param hNoise_, noise sampled from a gaussian with standard deviation
    //                 xyNoise_ added to particles' h components
    MotionSystem(float xyNoise_, float hNoise_);

    // Destructor
    ~MotionSystem() {}

    // Adjusts swarm based on odometry info from motion
    // @param particles, the set of particles that represent localization belief
    // @param odometry, odometry from last motion frame
    void update(ParticleSet& particles,
                const messages::RobotLocation& odometry);

private:
    // Shift particle by samping from gaussians with standard deviations set by
    // the probalistic motion model
    // @param particle, the particle to shift
    void noiseShift(Particle* particle);

    boost::mt19937 rng;

    float xyNoise;
    float hNoise;

    messages::RobotLocation curOdometry;
    messages::RobotLocation lastOdometry;
};
} // namespace localization
} // namespace man
