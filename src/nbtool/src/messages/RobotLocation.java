// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RobotLocation.proto

package messages;

/**
 * Protobuf type {@code messages.RobotLocation}
 */
public final class RobotLocation extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:messages.RobotLocation)
    RobotLocationOrBuilder {
  // Use RobotLocation.newBuilder() to construct.
  private RobotLocation(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private RobotLocation(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final RobotLocation defaultInstance;
  public static RobotLocation getDefaultInstance() {
    return defaultInstance;
  }

  public RobotLocation getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private RobotLocation(
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
            x_ = input.readFloat();
            break;
          }
          case 21: {
            bitField0_ |= 0x00000002;
            y_ = input.readFloat();
            break;
          }
          case 29: {
            bitField0_ |= 0x00000004;
            h_ = input.readFloat();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            timestamp_ = input.readInt64();
            break;
          }
          case 45: {
            bitField0_ |= 0x00000010;
            uncert_ = input.readFloat();
            break;
          }
          case 48: {
            bitField0_ |= 0x00000020;
            lost_ = input.readBool();
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
    return messages._File_RobotLocation.internal_static_messages_RobotLocation_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_RobotLocation.internal_static_messages_RobotLocation_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.RobotLocation.class, messages.RobotLocation.Builder.class);
  }

  public static com.google.protobuf.Parser<RobotLocation> PARSER =
      new com.google.protobuf.AbstractParser<RobotLocation>() {
    public RobotLocation parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RobotLocation(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<RobotLocation> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  public static final int X_FIELD_NUMBER = 1;
  private float x_;
  /**
   * <code>optional float x = 1;</code>
   */
  public boolean hasX() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional float x = 1;</code>
   */
  public float getX() {
    return x_;
  }

  public static final int Y_FIELD_NUMBER = 2;
  private float y_;
  /**
   * <code>optional float y = 2;</code>
   */
  public boolean hasY() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional float y = 2;</code>
   */
  public float getY() {
    return y_;
  }

  public static final int H_FIELD_NUMBER = 3;
  private float h_;
  /**
   * <code>optional float h = 3;</code>
   */
  public boolean hasH() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional float h = 3;</code>
   */
  public float getH() {
    return h_;
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 4;
  private long timestamp_;
  /**
   * <code>optional int64 timestamp = 4;</code>
   */
  public boolean hasTimestamp() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional int64 timestamp = 4;</code>
   */
  public long getTimestamp() {
    return timestamp_;
  }

  public static final int UNCERT_FIELD_NUMBER = 5;
  private float uncert_;
  /**
   * <code>optional float uncert = 5;</code>
   */
  public boolean hasUncert() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional float uncert = 5;</code>
   */
  public float getUncert() {
    return uncert_;
  }

  public static final int LOST_FIELD_NUMBER = 6;
  private boolean lost_;
  /**
   * <code>optional bool lost = 6;</code>
   */
  public boolean hasLost() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <code>optional bool lost = 6;</code>
   */
  public boolean getLost() {
    return lost_;
  }

  private void initFields() {
    x_ = 0F;
    y_ = 0F;
    h_ = 0F;
    timestamp_ = 0L;
    uncert_ = 0F;
    lost_ = false;
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
      output.writeFloat(1, x_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeFloat(2, y_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeFloat(3, h_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt64(4, timestamp_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeFloat(5, uncert_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeBool(6, lost_);
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
        .computeFloatSize(1, x_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, y_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, h_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, timestamp_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(5, uncert_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(6, lost_);
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

  public static messages.RobotLocation parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.RobotLocation parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.RobotLocation parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.RobotLocation parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.RobotLocation parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.RobotLocation parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.RobotLocation parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.RobotLocation parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.RobotLocation parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.RobotLocation parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.RobotLocation prototype) {
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
   * Protobuf type {@code messages.RobotLocation}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:messages.RobotLocation)
      messages.RobotLocationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_RobotLocation.internal_static_messages_RobotLocation_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_RobotLocation.internal_static_messages_RobotLocation_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.RobotLocation.class, messages.RobotLocation.Builder.class);
    }

    // Construct using messages.RobotLocation.newBuilder()
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
      x_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000001);
      y_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000002);
      h_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000004);
      timestamp_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000008);
      uncert_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000010);
      lost_ = false;
      bitField0_ = (bitField0_ & ~0x00000020);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_RobotLocation.internal_static_messages_RobotLocation_descriptor;
    }

    public messages.RobotLocation getDefaultInstanceForType() {
      return messages.RobotLocation.getDefaultInstance();
    }

    public messages.RobotLocation build() {
      messages.RobotLocation result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.RobotLocation buildPartial() {
      messages.RobotLocation result = new messages.RobotLocation(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.x_ = x_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.y_ = y_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.h_ = h_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.timestamp_ = timestamp_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.uncert_ = uncert_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.lost_ = lost_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.RobotLocation) {
        return mergeFrom((messages.RobotLocation)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.RobotLocation other) {
      if (other == messages.RobotLocation.getDefaultInstance()) return this;
      if (other.hasX()) {
        setX(other.getX());
      }
      if (other.hasY()) {
        setY(other.getY());
      }
      if (other.hasH()) {
        setH(other.getH());
      }
      if (other.hasTimestamp()) {
        setTimestamp(other.getTimestamp());
      }
      if (other.hasUncert()) {
        setUncert(other.getUncert());
      }
      if (other.hasLost()) {
        setLost(other.getLost());
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
      messages.RobotLocation parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.RobotLocation) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private float x_ ;
    /**
     * <code>optional float x = 1;</code>
     */
    public boolean hasX() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional float x = 1;</code>
     */
    public float getX() {
      return x_;
    }
    /**
     * <code>optional float x = 1;</code>
     */
    public Builder setX(float value) {
      bitField0_ |= 0x00000001;
      x_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float x = 1;</code>
     */
    public Builder clearX() {
      bitField0_ = (bitField0_ & ~0x00000001);
      x_ = 0F;
      onChanged();
      return this;
    }

    private float y_ ;
    /**
     * <code>optional float y = 2;</code>
     */
    public boolean hasY() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional float y = 2;</code>
     */
    public float getY() {
      return y_;
    }
    /**
     * <code>optional float y = 2;</code>
     */
    public Builder setY(float value) {
      bitField0_ |= 0x00000002;
      y_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float y = 2;</code>
     */
    public Builder clearY() {
      bitField0_ = (bitField0_ & ~0x00000002);
      y_ = 0F;
      onChanged();
      return this;
    }

    private float h_ ;
    /**
     * <code>optional float h = 3;</code>
     */
    public boolean hasH() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional float h = 3;</code>
     */
    public float getH() {
      return h_;
    }
    /**
     * <code>optional float h = 3;</code>
     */
    public Builder setH(float value) {
      bitField0_ |= 0x00000004;
      h_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float h = 3;</code>
     */
    public Builder clearH() {
      bitField0_ = (bitField0_ & ~0x00000004);
      h_ = 0F;
      onChanged();
      return this;
    }

    private long timestamp_ ;
    /**
     * <code>optional int64 timestamp = 4;</code>
     */
    public boolean hasTimestamp() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int64 timestamp = 4;</code>
     */
    public long getTimestamp() {
      return timestamp_;
    }
    /**
     * <code>optional int64 timestamp = 4;</code>
     */
    public Builder setTimestamp(long value) {
      bitField0_ |= 0x00000008;
      timestamp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 timestamp = 4;</code>
     */
    public Builder clearTimestamp() {
      bitField0_ = (bitField0_ & ~0x00000008);
      timestamp_ = 0L;
      onChanged();
      return this;
    }

    private float uncert_ ;
    /**
     * <code>optional float uncert = 5;</code>
     */
    public boolean hasUncert() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional float uncert = 5;</code>
     */
    public float getUncert() {
      return uncert_;
    }
    /**
     * <code>optional float uncert = 5;</code>
     */
    public Builder setUncert(float value) {
      bitField0_ |= 0x00000010;
      uncert_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float uncert = 5;</code>
     */
    public Builder clearUncert() {
      bitField0_ = (bitField0_ & ~0x00000010);
      uncert_ = 0F;
      onChanged();
      return this;
    }

    private boolean lost_ ;
    /**
     * <code>optional bool lost = 6;</code>
     */
    public boolean hasLost() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional bool lost = 6;</code>
     */
    public boolean getLost() {
      return lost_;
    }
    /**
     * <code>optional bool lost = 6;</code>
     */
    public Builder setLost(boolean value) {
      bitField0_ |= 0x00000020;
      lost_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool lost = 6;</code>
     */
    public Builder clearLost() {
      bitField0_ = (bitField0_ & ~0x00000020);
      lost_ = false;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:messages.RobotLocation)
  }

  static {
    defaultInstance = new RobotLocation(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.RobotLocation)
}

