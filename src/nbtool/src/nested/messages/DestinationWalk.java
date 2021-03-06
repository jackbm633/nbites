// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PMotion.proto

package messages;

/**
 * Protobuf type {@code messages.DestinationWalk}
 */
public  final class DestinationWalk extends
    com.google.protobuf.GeneratedMessage
    implements DestinationWalkOrBuilder {
  // Use DestinationWalk.newBuilder() to construct.
  private DestinationWalk(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private DestinationWalk(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final DestinationWalk defaultInstance;
  public static DestinationWalk getDefaultInstance() {
    return defaultInstance;
  }

  public DestinationWalk getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private DestinationWalk(
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
            relX_ = input.readFloat();
            break;
          }
          case 21: {
            bitField0_ |= 0x00000002;
            relY_ = input.readFloat();
            break;
          }
          case 29: {
            bitField0_ |= 0x00000004;
            relH_ = input.readFloat();
            break;
          }
          case 37: {
            bitField0_ |= 0x00000008;
            gain_ = input.readFloat();
            break;
          }
          case 42: {
            messages.MotionKick.Builder subBuilder = null;
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
              subBuilder = kick_.toBuilder();
            }
            kick_ = input.readMessage(messages.MotionKick.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(kick_);
              kick_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000010;
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
    return messages._File_PMotion.internal_static_messages_DestinationWalk_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_PMotion.internal_static_messages_DestinationWalk_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.DestinationWalk.class, messages.DestinationWalk.Builder.class);
  }

  public static com.google.protobuf.Parser<DestinationWalk> PARSER =
      new com.google.protobuf.AbstractParser<DestinationWalk>() {
    public DestinationWalk parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DestinationWalk(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<DestinationWalk> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  // optional float rel_x = 1;
  public static final int REL_X_FIELD_NUMBER = 1;
  private float relX_;
  /**
   * <code>optional float rel_x = 1;</code>
   */
  public boolean hasRelX() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional float rel_x = 1;</code>
   */
  public float getRelX() {
    return relX_;
  }

  // optional float rel_y = 2;
  public static final int REL_Y_FIELD_NUMBER = 2;
  private float relY_;
  /**
   * <code>optional float rel_y = 2;</code>
   */
  public boolean hasRelY() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional float rel_y = 2;</code>
   */
  public float getRelY() {
    return relY_;
  }

  // optional float rel_h = 3;
  public static final int REL_H_FIELD_NUMBER = 3;
  private float relH_;
  /**
   * <code>optional float rel_h = 3;</code>
   */
  public boolean hasRelH() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional float rel_h = 3;</code>
   */
  public float getRelH() {
    return relH_;
  }

  // optional float gain = 4;
  public static final int GAIN_FIELD_NUMBER = 4;
  private float gain_;
  /**
   * <code>optional float gain = 4;</code>
   */
  public boolean hasGain() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional float gain = 4;</code>
   */
  public float getGain() {
    return gain_;
  }

  // optional .messages.MotionKick kick = 5;
  public static final int KICK_FIELD_NUMBER = 5;
  private messages.MotionKick kick_;
  /**
   * <code>optional .messages.MotionKick kick = 5;</code>
   */
  public boolean hasKick() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional .messages.MotionKick kick = 5;</code>
   */
  public messages.MotionKick getKick() {
    return kick_;
  }
  /**
   * <code>optional .messages.MotionKick kick = 5;</code>
   */
  public messages.MotionKickOrBuilder getKickOrBuilder() {
    return kick_;
  }

  private void initFields() {
    relX_ = 0F;
    relY_ = 0F;
    relH_ = 0F;
    gain_ = 0F;
    kick_ = messages.MotionKick.getDefaultInstance();
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
      output.writeFloat(1, relX_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeFloat(2, relY_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeFloat(3, relH_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeFloat(4, gain_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeMessage(5, kick_);
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
        .computeFloatSize(1, relX_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, relY_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, relH_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(4, gain_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, kick_);
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

  public static messages.DestinationWalk parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.DestinationWalk parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.DestinationWalk parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.DestinationWalk parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.DestinationWalk parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.DestinationWalk parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.DestinationWalk parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.DestinationWalk parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.DestinationWalk parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.DestinationWalk parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.DestinationWalk prototype) {
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
   * Protobuf type {@code messages.DestinationWalk}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder>
     implements messages.DestinationWalkOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_PMotion.internal_static_messages_DestinationWalk_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_PMotion.internal_static_messages_DestinationWalk_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.DestinationWalk.class, messages.DestinationWalk.Builder.class);
    }

    // Construct using messages.DestinationWalk.newBuilder()
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
        getKickFieldBuilder();
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      relX_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000001);
      relY_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000002);
      relH_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000004);
      gain_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000008);
      if (kickBuilder_ == null) {
        kick_ = messages.MotionKick.getDefaultInstance();
      } else {
        kickBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_PMotion.internal_static_messages_DestinationWalk_descriptor;
    }

    public messages.DestinationWalk getDefaultInstanceForType() {
      return messages.DestinationWalk.getDefaultInstance();
    }

    public messages.DestinationWalk build() {
      messages.DestinationWalk result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.DestinationWalk buildPartial() {
      messages.DestinationWalk result = new messages.DestinationWalk(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.relX_ = relX_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.relY_ = relY_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.relH_ = relH_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.gain_ = gain_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      if (kickBuilder_ == null) {
        result.kick_ = kick_;
      } else {
        result.kick_ = kickBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.DestinationWalk) {
        return mergeFrom((messages.DestinationWalk)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.DestinationWalk other) {
      if (other == messages.DestinationWalk.getDefaultInstance()) return this;
      if (other.hasRelX()) {
        setRelX(other.getRelX());
      }
      if (other.hasRelY()) {
        setRelY(other.getRelY());
      }
      if (other.hasRelH()) {
        setRelH(other.getRelH());
      }
      if (other.hasGain()) {
        setGain(other.getGain());
      }
      if (other.hasKick()) {
        mergeKick(other.getKick());
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
      messages.DestinationWalk parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.DestinationWalk) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    // optional float rel_x = 1;
    private float relX_ ;
    /**
     * <code>optional float rel_x = 1;</code>
     */
    public boolean hasRelX() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional float rel_x = 1;</code>
     */
    public float getRelX() {
      return relX_;
    }
    /**
     * <code>optional float rel_x = 1;</code>
     */
    public Builder setRelX(float value) {
      bitField0_ |= 0x00000001;
      relX_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float rel_x = 1;</code>
     */
    public Builder clearRelX() {
      bitField0_ = (bitField0_ & ~0x00000001);
      relX_ = 0F;
      onChanged();
      return this;
    }

    // optional float rel_y = 2;
    private float relY_ ;
    /**
     * <code>optional float rel_y = 2;</code>
     */
    public boolean hasRelY() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional float rel_y = 2;</code>
     */
    public float getRelY() {
      return relY_;
    }
    /**
     * <code>optional float rel_y = 2;</code>
     */
    public Builder setRelY(float value) {
      bitField0_ |= 0x00000002;
      relY_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float rel_y = 2;</code>
     */
    public Builder clearRelY() {
      bitField0_ = (bitField0_ & ~0x00000002);
      relY_ = 0F;
      onChanged();
      return this;
    }

    // optional float rel_h = 3;
    private float relH_ ;
    /**
     * <code>optional float rel_h = 3;</code>
     */
    public boolean hasRelH() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional float rel_h = 3;</code>
     */
    public float getRelH() {
      return relH_;
    }
    /**
     * <code>optional float rel_h = 3;</code>
     */
    public Builder setRelH(float value) {
      bitField0_ |= 0x00000004;
      relH_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float rel_h = 3;</code>
     */
    public Builder clearRelH() {
      bitField0_ = (bitField0_ & ~0x00000004);
      relH_ = 0F;
      onChanged();
      return this;
    }

    // optional float gain = 4;
    private float gain_ ;
    /**
     * <code>optional float gain = 4;</code>
     */
    public boolean hasGain() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional float gain = 4;</code>
     */
    public float getGain() {
      return gain_;
    }
    /**
     * <code>optional float gain = 4;</code>
     */
    public Builder setGain(float value) {
      bitField0_ |= 0x00000008;
      gain_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float gain = 4;</code>
     */
    public Builder clearGain() {
      bitField0_ = (bitField0_ & ~0x00000008);
      gain_ = 0F;
      onChanged();
      return this;
    }

    // optional .messages.MotionKick kick = 5;
    private messages.MotionKick kick_ = messages.MotionKick.getDefaultInstance();
    private com.google.protobuf.SingleFieldBuilder<
        messages.MotionKick, messages.MotionKick.Builder, messages.MotionKickOrBuilder> kickBuilder_;
    /**
     * <code>optional .messages.MotionKick kick = 5;</code>
     */
    public boolean hasKick() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional .messages.MotionKick kick = 5;</code>
     */
    public messages.MotionKick getKick() {
      if (kickBuilder_ == null) {
        return kick_;
      } else {
        return kickBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .messages.MotionKick kick = 5;</code>
     */
    public Builder setKick(messages.MotionKick value) {
      if (kickBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        kick_ = value;
        onChanged();
      } else {
        kickBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <code>optional .messages.MotionKick kick = 5;</code>
     */
    public Builder setKick(
        messages.MotionKick.Builder builderForValue) {
      if (kickBuilder_ == null) {
        kick_ = builderForValue.build();
        onChanged();
      } else {
        kickBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <code>optional .messages.MotionKick kick = 5;</code>
     */
    public Builder mergeKick(messages.MotionKick value) {
      if (kickBuilder_ == null) {
        if (((bitField0_ & 0x00000010) == 0x00000010) &&
            kick_ != messages.MotionKick.getDefaultInstance()) {
          kick_ =
            messages.MotionKick.newBuilder(kick_).mergeFrom(value).buildPartial();
        } else {
          kick_ = value;
        }
        onChanged();
      } else {
        kickBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <code>optional .messages.MotionKick kick = 5;</code>
     */
    public Builder clearKick() {
      if (kickBuilder_ == null) {
        kick_ = messages.MotionKick.getDefaultInstance();
        onChanged();
      } else {
        kickBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }
    /**
     * <code>optional .messages.MotionKick kick = 5;</code>
     */
    public messages.MotionKick.Builder getKickBuilder() {
      bitField0_ |= 0x00000010;
      onChanged();
      return getKickFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .messages.MotionKick kick = 5;</code>
     */
    public messages.MotionKickOrBuilder getKickOrBuilder() {
      if (kickBuilder_ != null) {
        return kickBuilder_.getMessageOrBuilder();
      } else {
        return kick_;
      }
    }
    /**
     * <code>optional .messages.MotionKick kick = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        messages.MotionKick, messages.MotionKick.Builder, messages.MotionKickOrBuilder> 
        getKickFieldBuilder() {
      if (kickBuilder_ == null) {
        kickBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            messages.MotionKick, messages.MotionKick.Builder, messages.MotionKickOrBuilder>(
                kick_,
                getParentForChildren(),
                isClean());
        kick_ = null;
      }
      return kickBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:messages.DestinationWalk)
  }

  static {
    defaultInstance = new DestinationWalk(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.DestinationWalk)
}

