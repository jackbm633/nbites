//
//  ControlBrain.swift
//  nbControl
//
//  Created by Cory Alini on 11/26/16.
//  Copyright © 2016 gis.coryalini. All rights reserved.
//

import Foundation
import UIKit

//BOOL adjustHead;
//float adjustedHeadZ,adjustedHeadY;
//
//BOOL walkCommand, walkStop;
//float walkHeading,walkX,walkY;
//
//BOOL doSweetMove;
//int sweetMoveID;
//
//BOOL logInfo,logImage;



class ControlBrain {
    
    //BOOL walkCommand, walkStop;
    //float walkHeading,walkX,walkY;
    let walkingThreshold: Float = 100.0
    
    private func hypot(_ vec:CGPoint) -> Float {
        return sqrtf(Float(vec.x * vec.x) + Float(vec.y * vec.y))
    }

    private func theta(_ vec:CGPoint) -> Float {
        return atan2f(Float(vec.x), Float(vec.y))
    }
    
    func sendNewWalk(currPosition: CGPoint, transition:CGPoint) {
        var robot = blankRobotCommand()

        robot.walkCommand = true
        let distance = hypot(currPosition)
        let angle:Float = theta(currPosition) + Float(M_PI)

        print(
            String(format: "dist = %.2f theta = %.2f\n", distance, angle)
        )
        
        robot.walkHeading = angle
        if (distance < walkingThreshold) {
            print("stopping walk")
            robot.walkStop = true
        } else {
            print("walk active")
            robot.walkStop = false
            robot.walkY = distance
            robot.walkHeading = angle
        }

        if (robotManager.currentAddress() != nil) {
            robotManager.send(robot)
        }
    }
}

//        print("Curr position: [\(currPosition.x),\(currPosition.y)]")
//        print("\(currPosition.x),\(currPosition.y) -> \(transition.x),\(transition.y)")
//        var robot = RobotCommandStruct.init()
//        robot.walkCommand = true
//        
//        if (currPosition.x < 20.0 && currPosition.x > -20.0 && currPosition.y < 20.0 && currPosition.y > -20.0) {
//                robot.walkStop = true
//            print("robot not walking")
//        } else {
//            robot.walkY = 1
//            
//            let baseVector = CGPoint(x: 0.0, y: -100.0)
//            //let baseMag = sqrt(baseVector)
//            let dotProduct = Double(transition.x * baseVector.x + transition.y + baseVector.y)
//            let transitionMag = Double(sqrt(transition.x * transition.x + transition.y + transition.y))
//            let heading = acos(dotProduct/(transitionMag))
//            
//            robot.walkHeading = Float(heading)
//            print("Heading: \(robot.walkHeading)) ")
//        }



