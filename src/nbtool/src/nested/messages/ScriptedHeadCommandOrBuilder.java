// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PMotion.proto

package messages;

public interface ScriptedHeadCommandOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // repeated .messages.HeadJointCommand command = 1;
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  java.util.List<messages.HeadJointCommand> 
      getCommandList();
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  messages.HeadJointCommand getCommand(int index);
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  int getCommandCount();
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  java.util.List<? extends messages.HeadJointCommandOrBuilder> 
      getCommandOrBuilderList();
  /**
   * <code>repeated .messages.HeadJointCommand command = 1;</code>
   */
  messages.HeadJointCommandOrBuilder getCommandOrBuilder(
      int index);
}
