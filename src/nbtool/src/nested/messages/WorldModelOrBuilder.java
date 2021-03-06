// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WorldModel.proto

package messages;

public interface WorldModelOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // optional int64 timestamp = 1;
  /**
   * <code>optional int64 timestamp = 1;</code>
   */
  boolean hasTimestamp();
  /**
   * <code>optional int64 timestamp = 1;</code>
   */
  long getTimestamp();

  // optional float my_x = 2;
  /**
   * <code>optional float my_x = 2;</code>
   */
  boolean hasMyX();
  /**
   * <code>optional float my_x = 2;</code>
   */
  float getMyX();

  // optional float my_y = 3;
  /**
   * <code>optional float my_y = 3;</code>
   */
  boolean hasMyY();
  /**
   * <code>optional float my_y = 3;</code>
   */
  float getMyY();

  // optional float my_h = 4;
  /**
   * <code>optional float my_h = 4;</code>
   */
  boolean hasMyH();
  /**
   * <code>optional float my_h = 4;</code>
   */
  float getMyH();

  // optional float my_uncert = 5;
  /**
   * <code>optional float my_uncert = 5;</code>
   */
  boolean hasMyUncert();
  /**
   * <code>optional float my_uncert = 5;</code>
   */
  float getMyUncert();

  // optional float walking_to_x = 6;
  /**
   * <code>optional float walking_to_x = 6;</code>
   */
  boolean hasWalkingToX();
  /**
   * <code>optional float walking_to_x = 6;</code>
   */
  float getWalkingToX();

  // optional float walking_to_y = 7;
  /**
   * <code>optional float walking_to_y = 7;</code>
   */
  boolean hasWalkingToY();
  /**
   * <code>optional float walking_to_y = 7;</code>
   */
  float getWalkingToY();

  // optional bool ball_on = 8;
  /**
   * <code>optional bool ball_on = 8;</code>
   */
  boolean hasBallOn();
  /**
   * <code>optional bool ball_on = 8;</code>
   */
  boolean getBallOn();

  // optional int32 ball_age = 9;
  /**
   * <code>optional int32 ball_age = 9;</code>
   */
  boolean hasBallAge();
  /**
   * <code>optional int32 ball_age = 9;</code>
   */
  int getBallAge();

  // optional float ball_dist = 10;
  /**
   * <code>optional float ball_dist = 10;</code>
   */
  boolean hasBallDist();
  /**
   * <code>optional float ball_dist = 10;</code>
   */
  float getBallDist();

  // optional float ball_bearing = 11;
  /**
   * <code>optional float ball_bearing = 11;</code>
   */
  boolean hasBallBearing();
  /**
   * <code>optional float ball_bearing = 11;</code>
   */
  float getBallBearing();

  // optional float ball_vel_x = 12;
  /**
   * <code>optional float ball_vel_x = 12;</code>
   */
  boolean hasBallVelX();
  /**
   * <code>optional float ball_vel_x = 12;</code>
   */
  float getBallVelX();

  // optional float ball_vel_y = 13;
  /**
   * <code>optional float ball_vel_y = 13;</code>
   */
  boolean hasBallVelY();
  /**
   * <code>optional float ball_vel_y = 13;</code>
   */
  float getBallVelY();

  // optional float ball_uncert = 14;
  /**
   * <code>optional float ball_uncert = 14;</code>
   */
  boolean hasBallUncert();
  /**
   * <code>optional float ball_uncert = 14;</code>
   */
  float getBallUncert();

  // optional int32 role = 15;
  /**
   * <code>optional int32 role = 15;</code>
   */
  boolean hasRole();
  /**
   * <code>optional int32 role = 15;</code>
   */
  int getRole();

  // optional bool in_kicking_state = 16;
  /**
   * <code>optional bool in_kicking_state = 16;</code>
   */
  boolean hasInKickingState();
  /**
   * <code>optional bool in_kicking_state = 16;</code>
   */
  boolean getInKickingState();

  // optional float kicking_to_x = 17;
  /**
   * <code>optional float kicking_to_x = 17;</code>
   */
  boolean hasKickingToX();
  /**
   * <code>optional float kicking_to_x = 17;</code>
   */
  float getKickingToX();

  // optional float kicking_to_y = 18;
  /**
   * <code>optional float kicking_to_y = 18;</code>
   */
  boolean hasKickingToY();
  /**
   * <code>optional float kicking_to_y = 18;</code>
   */
  float getKickingToY();

  // optional bool fallen = 19;
  /**
   * <code>optional bool fallen = 19;</code>
   */
  boolean hasFallen();
  /**
   * <code>optional bool fallen = 19;</code>
   */
  boolean getFallen();

  // optional bool active = 20;
  /**
   * <code>optional bool active = 20;</code>
   */
  boolean hasActive();
  /**
   * <code>optional bool active = 20;</code>
   */
  boolean getActive();

  // optional bool claimed_ball = 21;
  /**
   * <code>optional bool claimed_ball = 21;</code>
   */
  boolean hasClaimedBall();
  /**
   * <code>optional bool claimed_ball = 21;</code>
   */
  boolean getClaimedBall();

  // optional int32 intention = 22;
  /**
   * <code>optional int32 intention = 22;</code>
   */
  boolean hasIntention();
  /**
   * <code>optional int32 intention = 22;</code>
   */
  int getIntention();

  // optional bool alive = 23;
  /**
   * <code>optional bool alive = 23;</code>
   */
  boolean hasAlive();
  /**
   * <code>optional bool alive = 23;</code>
   */
  boolean getAlive();
}
