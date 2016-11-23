import math

from .. import SweetMoves
from ..headTracker import HeadMoves
from .. import StiffnessModes
from ..navigator import BrunswickSpeeds as speeds
from objects import RelRobotLocation
from ..navigator import Navigator
from ..util import *
import PMotion_proto

@superState('gameControllerResponder')
def gameInitial(player):
    if player.firstFrame():
        player.gainsOn()
        player.brain.nav.stand()
        player.runfallController = False
    return player.stay()

@superState('gameControllerResponder')
def gameReady(player):
    return player.stay()

@superState('gameControllerResponder')
def gameSet(player):
    return player.stay()

@superState('gameControllerResponder')
def gamePlaying(player):
    return player.goNow('controller')

@superState('gameControllerResponder')
def gamePenalized(player):
    return player.stay()

@superState('gameControllerResponder')
def fallen(player):
    player.inKickingState = False
    return player.stay()


@superState('gameControllerResponder')
def controller(player):
	if player.lastNum != player.currNum:
		if player.commandToDo == 1:
			player.lastNum = player.currNum
			return player.goNow('walkInDirection')
		else if player.commandToDo == 2:
			player.lastNum = player.currNum
			return player.goNow('kick')
		else if player.commandToDo == 3:
			player.lastNum = player.currNum
			return player.goNow('turnHead')
	return player.stay()

@superState('gameControllerResponder')
def walkInDirection(player):
    if player.firstFrame():
        player.brain.interface.motionRequest.reset_odometry = True
        player.brain.interface.motionRequest.timestamp = int(player.brain.time * 1000)
    elif player.counter == 1:
        player.setWalk(player.xDirection,player.yDirection,player.headingDirection)
    elif player.counter == 2:
        player.brain.nav.stand()
        player.lastNum = currNum
        return player.goNow('controller')
    return player.stay()

@superState('gameControllerResponder')
def kick(player):
    if player.firstFrame():
    	player.brain.nav.stand()
        player.executeMove(SweetMoves.LEFT_STRAIGHT_KICK)
        player.brain.nav.stand()
    return player.goNow('controller')

@superState('gameControllerResponder')
def turnHead(player):
	if player.firstFrame(): 
		player.brain.nav.stand()
		player.brain.tracker.lookToAngle(player.headAngle)
		player.brain.nav.stand()
	return player.goNow('controller')