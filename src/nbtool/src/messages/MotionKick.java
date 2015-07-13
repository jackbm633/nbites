// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PMotion.proto

package messages;

/**
 * Protobuf type {@code messages.MotionKick}
 */
public final class MotionKick extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:messages.MotionKick)
    MotionKickOrBuilder {
  // Use MotionKick.newBuilder() to construct.
  private MotionKick(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private MotionKick(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final MotionKick defaultInstance;
  public static MotionKick getDefaultInstance() {
    return defaultInstance;
  }

  public MotionKick getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private MotionKick(
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
          case 8: {
            bitField0_ |= 0x00000001;
            performMotionKick_ = input.readBool();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            kickType_ = input.readInt32();
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
    return messages._File_PMotion.internal_static_messages_MotionKick_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_PMotion.internal_static_messages_MotionKick_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.MotionKick.class, messages.MotionKick.Builder.class);
  }

  public static com.google.protobuf.Parser<MotionKick> PARSER =
      new com.google.protobuf.AbstractParser<MotionKick>() {
    public MotionKick parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MotionKick(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<MotionKick> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  public static final int PERFORM_MOTION_KICK_FIELD_NUMBER = 1;
  private boolean performMotionKick_;
  /**
   * <code>optional bool perform_motion_kick = 1;</code>
   */
  public boolean hasPerformMotionKick() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional bool perform_motion_kick = 1;</code>
   */
  public boolean getPerformMotionKick() {
    return performMotionKick_;
  }

  public static final int KICK_TYPE_FIELD_NUMBER = 2;
  private int kickType_;
  /**
   * <code>optional int32 kick_type = 2;</code>
   */
  public boolean hasKickType() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int32 kick_type = 2;</code>
   */
  public int getKickType() {
    return kickType_;
  }

  private void initFields() {
    performMotionKick_ = false;
    kickType_ = 0;
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeBool(1, performMotionKick_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt32(2, kickType_);
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
        .computeBoolSize(1, performMotionKick_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, kickType_);
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

  public static messages.MotionKick parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.MotionKick parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.MotionKick parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.MotionKick parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.MotionKick parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.MotionKick parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.MotionKick parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.MotionKick parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.MotionKick parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.MotionKick parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.MotionKick prototype) {
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
   * Protobuf type {@code messages.MotionKick}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:messages.MotionKick)
      messages.MotionKickOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_PMotion.internal_static_messages_MotionKick_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_PMotion.internal_static_messages_MotionKick_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.MotionKick.class, messages.MotionKick.Builder.class);
    }

    // Construct using messages.MotionKick.newBuilder()
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
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      performMotionKick_ = false;
      bitField0_ = (bitField0_ & ~0x00000001);
      kickType_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_PMotion.internal_static_messages_MotionKick_descriptor;
    }

    public messages.MotionKick getDefaultInstanceForType() {
      return messages.MotionKick.getDefaultInstance();
    }

    public messages.MotionKick build() {
      messages.MotionKick result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.MotionKick buildPartial() {
      messages.MotionKick result = new messages.MotionKick(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.performMotionKick_ = performMotionKick_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.kickType_ = kickType_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.MotionKick) {
        return mergeFrom((messages.MotionKick)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.MotionKick other) {
      if (other == messages.MotionKick.getDefaultInstance()) return this;
      if (other.hasPerformMotionKick()) {
        setPerformMotionKick(other.getPerformMotionKick());
      }
      if (other.hasKickType()) {
        setKickType(other.getKickType());
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
      messages.MotionKick parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.MotionKick) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private boolean performMotionKick_ ;
    /**
     * <code>optional bool perform_motion_kick = 1;</code>
     */
    public boolean hasPerformMotionKick() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional bool perform_motion_kick = 1;</code>
     */
    public boolean getPerformMotionKick() {
      return performMotionKick_;
    }
    /**
     * <code>optional bool perform_motion_kick = 1;</code>
     */
    public Builder setPerformMotionKick(boolean value) {
      bitField0_ |= 0x00000001;
      performMotionKick_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool perform_motion_kick = 1;</code>
     */
    public Builder clearPerformMotionKick() {
      bitField0_ = (bitField0_ & ~0x00000001);
      performMotionKick_ = false;
      onChanged();
      return this;
    }

    private int kickType_ ;
    /**
     * <code>optional int32 kick_type = 2;</code>
     */
    public boolean hasKickType() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 kick_type = 2;</code>
     */
    public int getKickType() {
      return kickType_;
    }
    /**
     * <code>optional int32 kick_type = 2;</code>
     */
    public Builder setKickType(int value) {
      bitField0_ |= 0x00000002;
      kickType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 kick_type = 2;</code>
     */
    public Builder clearKickType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      kickType_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:messages.MotionKick)
  }

  static {
    defaultInstance = new MotionKick(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.MotionKick)
}

