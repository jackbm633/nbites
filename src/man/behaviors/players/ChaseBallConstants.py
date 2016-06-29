from ..navigator import BrunswickSpeeds as speeds

# Ball on and off frame thresholds
BALL_ON_THRESH = 4
BALL_OFF_THRESH = 20
BALL_OFF_KICK_THRESH = 4 # 4 seconds, time threshold!

# Should decelerate
SLOW_CHASE_DIST = 80.

# Should position for kick
BALL_PFK_LEFT_Y = 16.0
PREPARE_FOR_KICK_DIST = 35.0
SETUP_DISTANCE_X = 6
SLOW_DOWN_TO_BALL_DIST = 25.
WAIT_COUNT = 0

# Should approach ball again
APPROACH_BALL_AGAIN_DIST = PREPARE_FOR_KICK_DIST + 25.0
BALL_MOVED_THR = 3

# lineUpKick
KICK_SETUP_MULTIPLIER = 3
WAYPOINT_DIST = 35
MAX_BEARING_DIFF = 90

# Potentials
# ATTRACTOR_BALL_DIST = 20
# REPULSOR_BALL_DIST = ATTRACTOR_BALL_DIST - 15
# ATTRACTOR_REPULSOR_RATIO = 2
# CLOSE_TO_ATTRACTOR_DIST = 10

# # Line up
LINE_UP_X = 30

# Line up PID params
LINE_UP_XP = 0.05
LINE_UP_XI = 0.0
LINE_UP_XD = 0.0

LINE_UP_HP = 0.3
LINE_UP_HI = 0.2
LINE_UP_HD = 0.0

# # Orbit
DEBUG_ORBIT = False
SHOULD_ORBIT_BEARING = 25
ORBIT_GOOD_BEARING = 7
SHOULD_CANCEL_ORBIT_BALL_DIST = APPROACH_BALL_AGAIN_DIST
ORBIT_TOO_LONG_THR = 8
ORBIT_Y_SPEED = speeds.SPEED_THREE
ORBIT_X = 25

# # Orbit PID params
ORBIT_XP = 0.01
ORBIT_XI = 0.01
ORBIT_XD = 0.0

ORBIT_YP = 0.007
ORBIT_YI = 0.0
ORBIT_YD = 0.0

ORBIT_HP = 0.8
ORBIT_HI = 0.2
ORBIT_HD = 0.0

ORBIT_BALL_DISTANCE = 25
ORBIT_DISTANCE_FAR = 10
ORBIT_DISTANCE_CLOSE = 4
ORBIT_DISTANCE_GOOD = 2
ORBIT_GOOD_BEARING = 6


# Should kick again
SHOULD_KICK_AGAIN_CLOSE_X = 9.5
SHOULD_KICK_AGAIN_FAR_X = 20
SHOULD_KICK_AGAIN_Y = 15

# Ball in position
## NOTE: important that these values slightly overestimate the values in
##        navigator's PFK. Otherwise there can be bad looping.
BALL_X_OFFSET = 2
BALL_Y_OFFSET = 3.5
GOOD_ENOUGH_H = 4

# States' constants

# Spin To Ball
FIND_BALL_SPIN_SPEED = .8
FACING_BALL_ACCEPTABLE_BEARING = 20
SHOULD_SPIN_TO_BALL_BEARING = 40.0
FACING_KICK_ACCEPTABLE_BEARING = 4

# find ball
SPUN_ONCE_TIME_THRESH = 8
WALK_FIND_BALL_TIME_THRESH = SPUN_ONCE_TIME_THRESH * 3 # Roughly 3 spins
SPEED_FOUR_SPUN_ONCE_TIME = 14
SPEED_FIVE_SPUN_ONCE_TIME = 12
SPEED_SIX_SPUN_ONCE_TIME = 10

SPIN_SEARCH_BEARING = 20

BACK_PEDAL_SPEED = -.75
BACK_PEDAL_TIME = 2

FRONT_SPIN_SEARCH_SPEED_X = .1
FRONT_SPIN_SEARCH_SPEED_Y = -.65
FRONT_SPIN_SEARCH_SPEED_H = .15
FRONT_SPIN_LOOK_TO_ANGLE = 15

FAR_BALL_SEARCH_DIST = 110.
SCRUM_DIST = 60.

# WATSON16 HACK
BALL_MEM_THRESH = .15
