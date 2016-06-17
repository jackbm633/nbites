# values in this file changed to range [-1,1] for each component of the walk vector
# with -1 being backwards and 1 being forwards
# converted to the appropriate cm/s value by the walk engine according to gait limits

#TODO TODO TODO TODO!!!!!!!!!! clean this shit up.


MAX_X_MAGNITUDE = 1
MIN_X_MAGNITUDE = 0.05
FWD_MAX_SPEED   = MAX_X_MAGNITUDE
FWD_MIN_SPEED   = MIN_X_MAGNITUDE
REV_MAX_SPEED   = -MAX_X_MAGNITUDE
REV_MIN_SPEED   = -MIN_X_MAGNITUDE

MAX_Y_MAGNITUDE = 1
MIN_Y_MAGNITUDE = 0.1
LEFT_MAX_SPEED  = MAX_Y_MAGNITUDE
LEFT_MIN_SPEED  = MIN_Y_MAGNITUDE
RIGHT_MAX_SPEED = -MAX_Y_MAGNITUDE
RIGHT_MIN_SPEED = -MIN_Y_MAGNITUDE

MAX_SPIN_MAGNITUDE   = 1
MIN_SPIN_MAGNITUDE   = 0.1
LEFT_SPIN_MAX_SPEED  = MAX_SPIN_MAGNITUDE
LEFT_SPIN_MIN_SPEED  = MIN_SPIN_MAGNITUDE
RIGHT_SPIN_MAX_SPEED = -MAX_SPIN_MAGNITUDE
RIGHT_SPIN_MAX_SPEED = -MIN_SPIN_MAGNITUDE

MAX_OMNI_X_MAGNITUDE = 0.75
MIN_OMNI_X_MAGNITUDE = 0.05
MAX_OMNI_Y_MAGNITUDE = 0.75
MIN_OMNI_Y_MAGNITUDE = 0.1
OMNI_FWD_MAX_SPEED   = MAX_OMNI_X_MAGNITUDE
OMNI_FWD_MIN_SPEED   = MIN_OMNI_X_MAGNITUDE
OMNI_REV_MAX_SPEED   = -MAX_OMNI_X_MAGNITUDE
OMNI_REV_MIN_SPEED   = -MIN_OMNI_X_MAGNITUDE
OMNI_LEFT_MAX_SPEED  = MAX_OMNI_Y_MAGNITUDE
OMNI_LEFT_MIN_SPEED  = MIN_OMNI_Y_MAGNITUDE
OMNI_RIGHT_MAX_SPEED = -MAX_OMNI_Y_MAGNITUDE
OMNI_RIGHT_MIN_SPEED = -MIN_OMNI_Y_MAGNITUDE

MAX_SPIN_WHILE_X_MAGNITUDE   = 0.75
MIN_SPIN_WHILE_X_MAGNITUDE   = 0.1
LEFT_SPIN_WHILE_X_MAX_SPEED  = MAX_SPIN_WHILE_X_MAGNITUDE
LEFT_SPIN_WHILE_X_MIN_SPEED  = MIN_SPIN_WHILE_X_MAGNITUDE
RIGHT_SPIN_WHILE_X_MAX_SPEED = -MAX_SPIN_WHILE_X_MAGNITUDE
RIGHT_SPIN_WHILE_X_MIN_SPEED = -MIN_SPIN_WHILE_X_MAGNITUDE

# Calculate linear divisions between max and min omni speeds
SPEED_STEP  = (MAX_OMNI_X_MAGNITUDE - MIN_OMNI_X_MAGNITUDE) / 9

SPEED_TEN   = SPEED_STEP * 9 + MIN_OMNI_X_MAGNITUDE # FULL_SPEED
SPEED_NINE  = SPEED_STEP * 8 + MIN_OMNI_X_MAGNITUDE # HASTY_SPEED
SPEED_EIGHT = SPEED_STEP * 7 + MIN_OMNI_X_MAGNITUDE # FAST_SPEED
SPEED_SEVEN = SPEED_STEP * 6 + MIN_OMNI_X_MAGNITUDE # QUICK_SPEED
SPEED_SIX   = SPEED_STEP * 5 + MIN_OMNI_X_MAGNITUDE # BRISK_SPEED
SPEED_FIVE  = SPEED_STEP * 4 + MIN_OMNI_X_MAGNITUDE # MEDIUM_SPEED
SPEED_FOUR  = SPEED_STEP * 3 + MIN_OMNI_X_MAGNITUDE # GRADUAL_SPEED
SPEED_THREE = SPEED_STEP * 2 + MIN_OMNI_X_MAGNITUDE # CAREFUL_SPEED
SPEED_TWO   = SPEED_STEP * 1 + MIN_OMNI_X_MAGNITUDE # SLOW_SPEED
SPEED_ONE   = MIN_OMNI_X_MAGNITUDE                  # SLUGGISH_SPEED
