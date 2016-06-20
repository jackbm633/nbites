// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PMotion.proto

package messages;

/**
 * Protobuf type {@code messages.HeadJointCommand}
 */
public  final class HeadJointCommand extends
    com.google.protobuf.GeneratedMessage
    implements HeadJointCommandOrBuilder {
  // Use HeadJointCommand.newBuilder() to construct.
  private HeadJointCommand(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private HeadJointCommand(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final HeadJointCommand defaultInstance;
  public static HeadJointCommand getDefaultInstance() {
    return defaultInstance;
  }

  public HeadJointCommand getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private HeadJointCommand(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 13: {
            bitField0_ |= 0x00000001;
            time_ = input.readFloat();
            break;
          }
          case 18: {
            messages.JointAngles.Builder subBuilder = null;
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
              subBuilder = angles_.toBuilder();
            }
            angles_ = input.readMessage(messages.JointAngles.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(angles_);
              angles_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000002;
            break;
          }
          case 26: {
            messages.JointAngles.Builder subBuilder = null;
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
              subBuilder = stiffness_.toBuilder();
            }
            stiffness_ = input.readMessage(messages.JointAngles.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(stiffness_);
              stiffness_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000004;
            break;
          }
          case 32: {
            int rawValue = input.readEnum();
            messages.HeadJointCommand.InterpolationType value = messages.HeadJointCommand.InterpolationType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(4, rawValue);
            } else {
              bitField0_ |= 0x00000008;
              interpolation_ = value;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return messages._File_PMotion.internal_static_messages_HeadJointCommand_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_PMotion.internal_static_messages_HeadJointCommand_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.HeadJointCommand.class, messages.HeadJointCommand.Builder.class);
  }

  public static com.google.protobuf.Parser<HeadJointCommand> PARSER =
      new com.google.protobuf.AbstractParser<HeadJointCommand>() {
    public HeadJointCommand parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new HeadJointCommand(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<HeadJointCommand> getParserForType() {
    return PARSER;
  }

  /**
   * Protobuf enum {@code messages.HeadJointCommand.InterpolationType}
   */
  public enum InterpolationType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>SMOOTH = 0;</code>
     */
    SMOOTH(0, 0),
    /**
     * <code>LINEAR = 1;</code>
     */
    LINEAR(1, 1),
    ;

    /**
     * <code>SMOOTH = 0;</code>
     */
    public static final int SMOOTH_VALUE = 0;
    /**
     * <code>LINEAR = 1;</code>
     */
    public static final int LINEAR_VALUE = 1;


    public final int getNumber() { return value; }

    public static InterpolationType valueOf(int value) {
      switch (value) {
        case 0: return SMOOTH;
        case 1: return LINEAR;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<InterpolationType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<InterpolationType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<InterpolationType>() {
            public InterpolationType findValueByNumber(int number) {
              return InterpolationType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return messages.HeadJointCommand.getDescriptor().getEnumTypes().get(0);
    }

    private static final InterpolationType[] VALUES = values();

    public static InterpolationType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private InterpolationType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:messages.HeadJointCommand.InterpolationType)
  }

  private int bitField0_;
  // optional float time = 1;
  public static final int TIME_FIELD_NUMBER = 1;
  private float time_;
  /**
   * <code>optional float time = 1;</code>
   */
  public boolean hasTime() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional float time = 1;</code>
   */
  public float getTime() {
    return time_;
  }

  // optional .messages.JointAngles angles = 2;
  public static final int ANGLES_FIELD_NUMBER = 2;
  private messages.JointAngles angles_;
  /**
   * <code>optional .messages.JointAngles angles = 2;</code>
   */
  public boolean hasAngles() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional .messages.JointAngles angles = 2;</code>
   */
  public messages.JointAngles getAngles() {
    return angles_;
  }
  /**
   * <code>optional .messages.JointAngles angles = 2;</code>
   */
  public messages.JointAnglesOrBuilder getAnglesOrBuilder() {
    return angles_;
  }

  // optional .messages.JointAngles stiffness = 3;
  public static final int STIFFNESS_FIELD_NUMBER = 3;
  private messages.JointAngles stiffness_;
  /**
   * <code>optional .messages.JointAngles stiffness = 3;</code>
   */
  public boolean hasStiffness() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional .messages.JointAngles stiffness = 3;</code>
   */
  public messages.JointAngles getStiffness() {
    return stiffness_;
  }
  /**
   * <code>optional .messages.JointAngles stiffness = 3;</code>
   */
  public messages.JointAnglesOrBuilder getStiffnessOrBuilder() {
    return stiffness_;
  }

  // optional .messages.HeadJointCommand.InterpolationType interpolation = 4;
  public static final int INTERPOLATION_FIELD_NUMBER = 4;
  private messages.HeadJointCommand.InterpolationType interpolation_;
  /**
   * <code>optional .messages.HeadJointCommand.InterpolationType interpolation = 4;</code>
   */
  public boolean hasInterpolation() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional .messages.HeadJointCommand.InterpolationType interpolation = 4;</code>
   */
  public messages.HeadJointCommand.InterpolationType getInterpolation() {
    return interpolation_;
  }

  private void initFields() {
    time_ = 0F;
    angles_ = messages.JointAngles.getDefaultInstance();
    stiffness_ = messages.JointAngles.getDefaultInstance();
    interpolation_ = messages.HeadJointCommand.InterpolationType.SMOOTH;
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) return isInitialized == 1;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeFloat(1, time_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeMessage(2, angles_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeMessage(3, stiffness_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeEnum(4, interpolation_.getNumber());
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, time_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, angles_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, stiffness_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(4, interpolation_.getNumber());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static messages.HeadJointCommand parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.HeadJointCommand parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.HeadJointCommand parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.HeadJointCommand parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.HeadJointCommand parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.HeadJointCommand parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.HeadJointCommand parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.HeadJointCommand parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.HeadJointCommand parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.HeadJointCommand parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.HeadJointCommand prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code messages.HeadJointCommand}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder>
     implements messages.HeadJointCommandOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_PMotion.internal_static_messages_HeadJointCommand_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_PMotion.internal_static_messages_HeadJointCommand_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.HeadJointCommand.class, messages.HeadJointCommand.Builder.class);
    }

    // Construct using messages.HeadJointCommand.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        getAnglesFieldBuilder();
        getStiffnessFieldBuilder();
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      time_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (anglesBuilder_ == null) {
        angles_ = messages.JointAngles.getDefaultInstance();
      } else {
        anglesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      if (stiffnessBuilder_ == null) {
        stiffness_ = messages.JointAngles.getDefaultInstance();
      } else {
        stiffnessBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      interpolation_ = messages.HeadJointCommand.InterpolationType.SMOOTH;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_PMotion.internal_static_messages_HeadJointCommand_descriptor;
    }

    public messages.HeadJointCommand getDefaultInstanceForType() {
      return messages.HeadJointCommand.getDefaultInstance();
    }

    public messages.HeadJointCommand build() {
      messages.HeadJointCommand result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.HeadJointCommand buildPartial() {
      messages.HeadJointCommand result = new messages.HeadJointCommand(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.time_ = time_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      if (anglesBuilder_ == null) {
        result.angles_ = angles_;
      } else {
        result.angles_ = anglesBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      if (stiffnessBuilder_ == null) {
        result.stiffness_ = stiffness_;
      } else {
        result.stiffness_ = stiffnessBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.interpolation_ = interpolation_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.HeadJointCommand) {
        return mergeFrom((messages.HeadJointCommand)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.HeadJointCommand other) {
      if (other == messages.HeadJointCommand.getDefaultInstance()) return this;
      if (other.hasTime()) {
        setTime(other.getTime());
      }
      if (other.hasAngles()) {
        mergeAngles(other.getAngles());
      }
      if (other.hasStiffness()) {
        mergeStiffness(other.getStiffness());
      }
      if (other.hasInterpolation()) {
        setInterpolation(other.getInterpolation());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      messages.HeadJointCommand parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.HeadJointCommand) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    // optional float time = 1;
    private float time_ ;
    /**
     * <code>optional float time = 1;</code>
     */
    public boolean hasTime() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional float time = 1;</code>
     */
    public float getTime() {
      return time_;
    }
    /**
     * <code>optional float time = 1;</code>
     */
    public Builder setTime(float value) {
      bitField0_ |= 0x00000001;
      time_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float time = 1;</code>
     */
    public Builder clearTime() {
      bitField0_ = (bitField0_ & ~0x00000001);
      time_ = 0F;
      onChanged();
      return this;
    }

    // optional .messages.JointAngles angles = 2;
    private messages.JointAngles angles_ = messages.JointAngles.getDefaultInstance();
    private com.google.protobuf.SingleFieldBuilder<
        messages.JointAngles, messages.JointAngles.Builder, messages.JointAnglesOrBuilder> anglesBuilder_;
    /**
     * <code>optional .messages.JointAngles angles = 2;</code>
     */
    public boolean hasAngles() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .messages.JointAngles angles = 2;</code>
     */
    public messages.JointAngles getAngles() {
      if (anglesBuilder_ == null) {
        return angles_;
      } else {
        return anglesBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .messages.JointAngles angles = 2;</code>
     */
    public Builder setAngles(messages.JointAngles value) {
      if (anglesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        angles_ = value;
        onChanged();
      } else {
        anglesBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .messages.JointAngles angles = 2;</code>
     */
    public Builder setAngles(
        messages.JointAngles.Builder builderForValue) {
      if (anglesBuilder_ == null) {
        angles_ = builderForValue.build();
        onChanged();
      } else {
        anglesBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .messages.JointAngles angles = 2;</code>
     */
    public Builder mergeAngles(messages.JointAngles value) {
      if (anglesBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002) &&
            angles_ != messages.JointAngles.getDefaultInstance()) {
          angles_ =
            messages.JointAngles.newBuilder(angles_).mergeFrom(value).buildPartial();
        } else {
          angles_ = value;
        }
        onChanged();
      } else {
        anglesBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>optional .messages.JointAngles angles = 2;</code>
     */
    public Builder clearAngles() {
      if (anglesBuilder_ == null) {
        angles_ = messages.JointAngles.getDefaultInstance();
        onChanged();
      } else {
        anglesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }
    /**
     * <code>optional .messages.JointAngles angles = 2;</code>
     */
    public messages.JointAngles.Builder getAnglesBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getAnglesFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .messages.JointAngles angles = 2;</code>
     */
    public messages.JointAnglesOrBuilder getAnglesOrBuilder() {
      if (anglesBuilder_ != null) {
        return anglesBuilder_.getMessageOrBuilder();
      } else {
        return angles_;
      }
    }
    /**
     * <code>optional .messages.JointAngles angles = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        messages.JointAngles, messages.JointAngles.Builder, messages.JointAnglesOrBuilder> 
        getAnglesFieldBuilder() {
      if (anglesBuilder_ == null) {
        anglesBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            messages.JointAngles, messages.JointAngles.Builder, messages.JointAnglesOrBuilder>(
                angles_,
                getParentForChildren(),
                isClean());
        angles_ = null;
      }
      return anglesBuilder_;
    }

    // optional .messages.JointAngles stiffness = 3;
    private messages.JointAngles stiffness_ = messages.JointAngles.getDefaultInstance();
    private com.google.protobuf.SingleFieldBuilder<
        messages.JointAngles, messages.JointAngles.Builder, messages.JointAnglesOrBuilder> stiffnessBuilder_;
    /**
     * <code>optional .messages.JointAngles stiffness = 3;</code>
     */
    public boolean hasStiffness() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional .messages.JointAngles stiffness = 3;</code>
     */
    public messages.JointAngles getStiffness() {
      if (stiffnessBuilder_ == null) {
        return stiffness_;
      } else {
        return stiffnessBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .messages.JointAngles stiffness = 3;</code>
     */
    public Builder setStiffness(messages.JointAngles value) {
      if (stiffnessBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        stiffness_ = value;
        onChanged();
      } else {
        stiffnessBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .messages.JointAngles stiffness = 3;</code>
     */
    public Builder setStiffness(
        messages.JointAngles.Builder builderForValue) {
      if (stiffnessBuilder_ == null) {
        stiffness_ = builderForValue.build();
        onChanged();
      } else {
        stiffnessBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .messages.JointAngles stiffness = 3;</code>
     */
    public Builder mergeStiffness(messages.JointAngles value) {
      if (stiffnessBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004) &&
            stiffness_ != messages.JointAngles.getDefaultInstance()) {
          stiffness_ =
            messages.JointAngles.newBuilder(stiffness_).mergeFrom(value).buildPartial();
        } else {
          stiffness_ = value;
        }
        onChanged();
      } else {
        stiffnessBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      return this;
    }
    /**
     * <code>optional .messages.JointAngles stiffness = 3;</code>
     */
    public Builder clearStiffness() {
      if (stiffnessBuilder_ == null) {
        stiffness_ = messages.JointAngles.getDefaultInstance();
        onChanged();
      } else {
        stiffnessBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }
    /**
     * <code>optional .messages.JointAngles stiffness = 3;</code>
     */
    public messages.JointAngles.Builder getStiffnessBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getStiffnessFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .messages.JointAngles stiffness = 3;</code>
     */
    public messages.JointAnglesOrBuilder getStiffnessOrBuilder() {
      if (stiffnessBuilder_ != null) {
        return stiffnessBuilder_.getMessageOrBuilder();
      } else {
        return stiffness_;
      }
    }
    /**
     * <code>optional .messages.JointAngles stiffness = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        messages.JointAngles, messages.JointAngles.Builder, messages.JointAnglesOrBuilder> 
        getStiffnessFieldBuilder() {
      if (stiffnessBuilder_ == null) {
        stiffnessBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            messages.JointAngles, messages.JointAngles.Builder, messages.JointAnglesOrBuilder>(
                stiffness_,
                getParentForChildren(),
                isClean());
        stiffness_ = null;
      }
      return stiffnessBuilder_;
    }

    // optional .messages.HeadJointCommand.InterpolationType interpolation = 4;
    private messages.HeadJointCommand.InterpolationType interpolation_ = messages.HeadJointCommand.InterpolationType.SMOOTH;
    /**
     * <code>optional .messages.HeadJointCommand.InterpolationType interpolation = 4;</code>
     */
    public boolean hasInterpolation() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional .messages.HeadJointCommand.InterpolationType interpolation = 4;</code>
     */
    public messages.HeadJointCommand.InterpolationType getInterpolation() {
      return interpolation_;
    }
    /**
     * <code>optional .messages.HeadJointCommand.InterpolationType interpolation = 4;</code>
     */
    public Builder setInterpolation(messages.HeadJointCommand.InterpolationType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000008;
      interpolation_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .messages.HeadJointCommand.InterpolationType interpolation = 4;</code>
     */
    public Builder clearInterpolation() {
      bitField0_ = (bitField0_ & ~0x00000008);
      interpolation_ = messages.HeadJointCommand.InterpolationType.SMOOTH;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:messages.HeadJointCommand)
  }

  static {
    defaultInstance = new HeadJointCommand(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.HeadJointCommand)
}

