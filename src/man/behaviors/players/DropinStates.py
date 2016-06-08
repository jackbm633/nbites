"""
Game controller states for pDropin, our drop-in player.
"""

import noggin_constants as nogginConstants
from math import fabs
from ..util import *
from .. import SweetMoves
from . import RoleConstants as roleConstants
from . import RoleSwitchingStates as roleSwitching
import KickOffConstants as kickOff

@superState('gameControllerResponder')
def gameInitial(player):
    """
    Ensure we are sitting down and head is snapped forward.
    In the future, we may wish to make the head move a bit slower here.
    """
    if player.firstFrame():
        player.inKickingState = False
        player.brain.fallController.enabled = False
        player.gainsOn()
        player.stand()
        player.zeroHeads()
        player.brain.resetInitialLocalization()
        player.lastStiffStatus = True
        
        # player.role = 4
        print "Commented out player role in drop in states"
        print "Player.role in gameInitial is", player.role
        print "player role in brain, gameInitial is", player.brain.role

    # If stiffnesses were JUST turned on, then stand up.
    if player.lastStiffStatus == False and player.brain.interface.stiffStatus.on:
        player.stand()
    # Remember last stiffness.
    player.lastStiffStatus = player.brain.interface.stiffStatus.on

    return player.stay()

@superState('gameControllerResponder')
def gameReady(player):
    """
    Stand up, and pan for localization, and walk to kicking off positions.
    """
    if player.firstFrame():
        player.inKickingState = False
        player.brain.fallController.enabled = True
        player.brain.nav.stand()
        player.brain.tracker.repeatWidePan()
        player.timeReadyBegan = player.brain.time
        if player.lastDiffState == 'gameInitial':
            print "Player role in game ready is", player.role
            print "player role in brain, gameReady is", player.brain.role
            player.brain.resetInitialLocalization()

        if player.wasPenalized:
            player.wasPenalized = False
            return player.goNow('afterPenalty')

    # Wait until the sensors are calibrated before moving.
    if not player.brain.motion.calibrated:
        return player.stay()

    return player.goNow('positionReady')

@superState('gameControllerResponder')
def gameSet(player):
    """
    Fixate on the ball, or scan to look for it
    """
    if player.firstFrame():
        player.inKickingState = False
        player.brain.fallController.enabled = True
        player.gainsOn()
        player.stand()
        player.brain.nav.stand()
        player.brain.tracker.performBasicPan()
        print "Player role in game set is", player.role

    elif player.brain.tracker.isStopped():
        player.brain.tracker.trackBall()

    # Wait until the sensors are calibrated before moving.
    if not player.brain.motion.calibrated:
        return player.stay()
    
    return player.stay()

@superState('gameControllerResponder')
def gamePlaying(player):
    if player.firstFrame():
        player.inKickingState = False
        # player.inKickOffPlay = (kickOff.shouldRunKickOffPlay(player) and 
        #                        (roleConstants.isChaser(player.role) or 
        #                         roleConstants.isCherryPicker(player.role)))
        player.inKickOffPlay = False
        player.passBack = False
        player.brain.fallController.enabled = True
        player.brain.nav.stand()
        player.brain.tracker.trackBall()
        print "player role in game playing is",player.role

    # TODO without pb, is this an issue?
    # if (player.lastDiffState == 'afterPenalty' and
    #     player.brain.play.isChaser()):
    #     # special behavior case
    #     return player.goNow('postPenaltyChaser')
    # Wait until the sensors are calibrated before moving.

    if player.wasPenalized:
        player.wasPenalized = False
        return player.goNow('afterPenalty')

    if not player.brain.motion.calibrated:
        return player.stay()

    if player.brain.gameController.timeSincePlaying < 10:
        if player.brain.gameController.ownKickOff:
            if (roleConstants.isChaser(player.role) or roleConstants.isCherryPicker(player.role)
               and player.brain.ball.vis.on):
                print "PLAYER ROLE IS CHASER/CHERRY PICKER", player.role
                player.shouldKickOff = True
                return player.goNow('approachBall')
            else:
                return player.goNow('playOffBall')
        else:
            return player.goNow('waitForKickoff')
    return player.goNow('playOffBall')
    
@superState('gameControllerResponder')
def gameFinished(player):
    """
    Ensure we are sitting down and head is snapped forward.
    In the future, we may wish to make the head move a bit slower here
    """
    if player.firstFrame():
        player.inKickingState = False
        player.brain.fallController.enabled = False
        player.stopWalking()
        player.zeroHeads()
        player.executeMove(SweetMoves.SIT_POS)

    if player.brain.nav.isStopped():
        player.gainsOff()

    return player.stay()

@superState('gameControllerResponder')
def gamePenalized(player):
    if player.firstFrame():
        player.inKickingState = False
        player.brain.fallController.enabled = False
        player.gainsOn()
        player.stand()
        player.penalizeHeads()
        player.wasPenalized = True

    return player.stay()

@superState('gameControllerResponder')
def waitForKickoff(player):
    if player.firstFrame():
        waitForKickoff.ballRelX = player.brain.ball.rel_x
        waitForKickoff.ballRelY = player.brain.ball.rel_y

    if (player.brain.gameController.timeSincePlaying > 10 or
        fabs(player.brain.ball.rel_x - waitForKickoff.ballRelX) > 20 or
        fabs(player.brain.ball.rel_y - waitForKickoff.ballRelY) > 20):
        return player.goNow('playOffBall')

    return player.stay()

waitForKickoff.ballRelX = "the relX position of the ball when we started"
waitForKickoff.ballRelY = "the relY position of the ball when we started"

### PENALTY KICK PLAY ###
@superState('gameControllerResponder')
def penaltyShotsGameSet(player):
    if player.firstFrame():
        player.gainsOn()
        player.stand()
        player.inKickingState = False
        player.brain.fallController.enabled = False
        player.brain.tracker.trackBall()

    # Wait until the sensors are calibrated before moving.
    if not player.brain.motion.calibrated:
        return player.stay()

    # Reset loc properly every frame
    player.brain.resetPenaltyKickLocalization()

    return player.stay()

@superState('gameControllerResponder')
def penaltyShotsGamePlaying(player):
    if player.firstFrame():
        player.stand()
        player.brain.fallController.enabled = True
        player.inKickingState = False
        player.shouldKickOff = False
        player.penaltyKicking = True
        player.brain.resetPenaltyKickLocalization()

    # Wait until the sensors are calibrated before moving.
    if (not player.brain.motion.calibrated):
        return player.stay()

    return player.goNow('prepareForPenaltyKick')


@superState('gameControllerResponder')
def fallen(player):
    player.inKickingState = False
    return player.stay()