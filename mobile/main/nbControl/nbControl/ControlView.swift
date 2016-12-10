//
//  ControlView.swift
//  nbControl
//
//  Created by Cory Alini on 11/17/16.
//  Copyright © 2016 gis.coryalini. All rights reserved.
//


import UIKit
import CoreMotion

class ControlView: BezierPathsView, UIDynamicAnimatorDelegate{
   
    let cambridge_blue = UIColor(colorLiteralRed: 163.0/255.0, green: 187.0/255.0, blue: 173.0/255.0, alpha: 1.0)
    let jet = UIColor(colorLiteralRed: 46.0/255.0, green: 53.0/255.0, blue: 50.0/255.0, alpha: 1.0)
    let mygray = UIColor(colorLiteralRed: 200.0/255.0, green: 199.0/255.0, blue: 200.0/255.0, alpha: 1.0)
    
    var currentPosition: CGPoint {
        get {
            return currentPos!
        }
    }
    private var currentPos: CGPoint?
    private var snapBehaviour:UISnapBehavior!
    var circleCenter: CGPoint! = CGPoint(x:0.0, y:0.0)

    var realGravity = false
    private let circleSize = 5
    
    private let motionManager = CMMotionManager()
    
    private var dropSize: CGSize {
        let size = bounds.size.width / CGFloat(circleSize)
        return CGSize(width:size, height: size)
    }
    
    private lazy var animator: UIDynamicAnimator = {
        let lazyAnimator = UIDynamicAnimator(referenceView: self)
        lazyAnimator.delegate = self
        return lazyAnimator
    }()
    
    private let dropBehavior = DropItBehavior()
    
    private var attachment: UIAttachmentBehavior? {
        willSet {
            if attachment != nil {
                animator.removeBehavior(attachment!)
                bezierPaths[PathNames.Attachment] = nil
            }
        }
        didSet {
            if attachment != nil {
                animator.addBehavior(attachment!)
            }
        }
    }
    
    private var lastDropped : UIView?
    
    private struct PathNames {
        static let MiddleBarrier = "MiddleBarrier"
        static let Attachment = "Attachment"
    }

    override func awakeFromNib() {
        super.awakeFromNib()

        addController()
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        let barrierSize = dropSize
        let barrierOrigin = CGPoint(x: bounds.midX-barrierSize.width/2, y: bounds.midY - barrierSize.height/2)
        let path = UIBezierPath(ovalIn: CGRect(origin: barrierOrigin, size: barrierSize))
        mygray.setStroke()
        path.lineWidth = 8
        dropBehavior.addBarrier(path: path, named: PathNames.MiddleBarrier)
        bezierPaths[PathNames.MiddleBarrier] = path
        //        addController()
        
    }
    
    func addController() {
        print("addController()")
        let drop = UIView(frame: CGRect(x: self.center.x - CGFloat(30), y: self.center.y - CGFloat(30), width: 60.0, height: 60.0))
        drop.layer.cornerRadius = 30.0
        drop.backgroundColor = cambridge_blue
        addSubview(drop)
        dropBehavior.addDrop(drop: drop)
        lastDropped = drop
    
        circleCenter = lastDropped?.center
    }
    
    var animating: Bool = false {
        didSet {
            if animating {
                animator.addBehavior(dropBehavior)
                //updateRealGravity()
                //changeGrav()
            } else {
                animator.removeBehavior(dropBehavior)
            }
        }
    }
    func removeSnap(_ sender: UILongPressGestureRecognizer ) {
        sender.minimumPressDuration = 0.5
        if snapBehaviour != nil {
            animator.removeBehavior(snapBehaviour)
        }
    }
    
    func grabDrop(_ sender: UIPanGestureRecognizer) {
        let gesturePoint = sender.location(in: self)
        
        switch sender.state {
        case .began:
            if let viewToAttachTo = lastDropped, viewToAttachTo.superview != nil {
                dropBehavior.removeBarrier(path: bezierPaths[PathNames.MiddleBarrier]!,named: PathNames.MiddleBarrier)
                if snapBehaviour != nil {
                    animator.removeBehavior(snapBehaviour)
                }
                attachment = UIAttachmentBehavior(item: viewToAttachTo, attachedToAnchor: gesturePoint)
            }
        case .changed:
            attachment?.anchorPoint = gesturePoint
        case .ended:
            attachment = nil
            dropBehavior.addBarrier(path: bezierPaths[PathNames.MiddleBarrier]!,named: PathNames.MiddleBarrier)
            snapBehaviour = UISnapBehavior(item: lastDropped!, snapTo: circleCenter)
            snapBehaviour.damping = 5
            animator.addBehavior(snapBehaviour)
            currentPos = lastDropped?.frame.mid
        default: break
        }
    }
    
}

