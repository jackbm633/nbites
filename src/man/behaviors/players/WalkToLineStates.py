from ..navigator import Navigator
from ..headTracker import HeadMoves
from ..navigator import BrunswickSpeeds as speeds
from objects import RobotLocation, RelRobotLocation
from ..util import *

@superState('gameControllerResponder')
def gameInitial(player):
	if player.firstFrame():
		player.gainsOn()
		player.brain.nav.stand()
	return player.stay()

@superState('gameControllerResponder')
def gameReady(player):
	if player.firstFrame():
		print("in game ready")
	return player.stay()

@superState('gameControllerResponder')
def gameSet(player):
	if player.firstFrame():
		print("in game set") 
	return player.stay()

@superState('gameControllerResponder')
def gamePlaying(player):
	print player.brain.vision
	#dest = player.brain.visionLines(0).inner.r #first line distance

	#player.brain.nav.walk(7,0,0) #walk speed towards line
	
	#if dest < 10: #if we've gotten sufficiently close to the line we stop
	#	player.brain.nav.stand()
		
	return player.stay()

@superState('gameControllerResponder')
def gamePenalized(player):
	return player.stay()

@superState('gameControllerResponder')
def fallen(player):
	player.inKickingState = False
	return player.stay()
