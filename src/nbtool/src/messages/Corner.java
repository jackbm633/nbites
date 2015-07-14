// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Vision.proto

package messages;

/**
 * Protobuf type {@code messages.Corner}
 */
public final class Corner extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:messages.Corner)
    CornerOrBuilder {
  // Use Corner.newBuilder() to construct.
  private Corner(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private Corner(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final Corner defaultInstance;
  public static Corner getDefaultInstance() {
    return defaultInstance;
  }

  public Corner getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private Corner(
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
          case 24: {
            bitField0_ |= 0x00000004;
            id_ = input.readInt32();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            correspondence_ = input.readInt32();
            break;
          }
          case 45: {
            bitField0_ |= 0x00000010;
            prob_ = input.readFloat();
            break;
          }
          case 48: {
            bitField0_ |= 0x00000020;
            line1_ = input.readInt32();
            break;
          }
          case 56: {
            bitField0_ |= 0x00000040;
            line2_ = input.readInt32();
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
    return messages._File_Vision.internal_static_messages_Corner_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return messages._File_Vision.internal_static_messages_Corner_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            messages.Corner.class, messages.Corner.Builder.class);
  }

  public static com.google.protobuf.Parser<Corner> PARSER =
      new com.google.protobuf.AbstractParser<Corner>() {
    public Corner parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Corner(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<Corner> getParserForType() {
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

  public static final int ID_FIELD_NUMBER = 3;
  private int id_;
  /**
   * <code>optional int32 id = 3;</code>
   */
  public boolean hasId() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int32 id = 3;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int CORRESPONDENCE_FIELD_NUMBER = 4;
  private int correspondence_;
  /**
   * <code>optional int32 correspondence = 4;</code>
   */
  public boolean hasCorrespondence() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional int32 correspondence = 4;</code>
   */
  public int getCorrespondence() {
    return correspondence_;
  }

  public static final int PROB_FIELD_NUMBER = 5;
  private float prob_;
  /**
   * <code>optional float prob = 5;</code>
   */
  public boolean hasProb() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional float prob = 5;</code>
   */
  public float getProb() {
    return prob_;
  }

  public static final int LINE1_FIELD_NUMBER = 6;
  private int line1_;
  /**
   * <code>optional int32 line1 = 6;</code>
   */
  public boolean hasLine1() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <code>optional int32 line1 = 6;</code>
   */
  public int getLine1() {
    return line1_;
  }

  public static final int LINE2_FIELD_NUMBER = 7;
  private int line2_;
  /**
   * <code>optional int32 line2 = 7;</code>
   */
  public boolean hasLine2() {
    return ((bitField0_ & 0x00000040) == 0x00000040);
  }
  /**
   * <code>optional int32 line2 = 7;</code>
   */
  public int getLine2() {
    return line2_;
  }

  private void initFields() {
    x_ = 0F;
    y_ = 0F;
    id_ = 0;
    correspondence_ = 0;
    prob_ = 0F;
    line1_ = 0;
    line2_ = 0;
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
      output.writeInt32(3, id_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, correspondence_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeFloat(5, prob_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeInt32(6, line1_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      output.writeInt32(7, line2_);
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
        .computeInt32Size(3, id_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, correspondence_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(5, prob_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, line1_);
    }
    if (((bitField0_ & 0x00000040) == 0x00000040)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, line2_);
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

  public static messages.Corner parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.Corner parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.Corner parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static messages.Corner parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static messages.Corner parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.Corner parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static messages.Corner parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static messages.Corner parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static messages.Corner parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static messages.Corner parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(messages.Corner prototype) {
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
   * Protobuf type {@code messages.Corner}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:messages.Corner)
      messages.CornerOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages._File_Vision.internal_static_messages_Corner_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages._File_Vision.internal_static_messages_Corner_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.Corner.class, messages.Corner.Builder.class);
    }

    // Construct using messages.Corner.newBuilder()
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
      id_ = 0;
      bitField0_ = (bitField0_ & ~0x00000004);
      correspondence_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      prob_ = 0F;
      bitField0_ = (bitField0_ & ~0x00000010);
      line1_ = 0;
      bitField0_ = (bitField0_ & ~0x00000020);
      line2_ = 0;
      bitField0_ = (bitField0_ & ~0x00000040);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return messages._File_Vision.internal_static_messages_Corner_descriptor;
    }

    public messages.Corner getDefaultInstanceForType() {
      return messages.Corner.getDefaultInstance();
    }

    public messages.Corner build() {
      messages.Corner result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public messages.Corner buildPartial() {
      messages.Corner result = new messages.Corner(this);
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
      result.id_ = id_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.correspondence_ = correspondence_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.prob_ = prob_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      result.line1_ = line1_;
      if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
        to_bitField0_ |= 0x00000040;
      }
      result.line2_ = line2_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof messages.Corner) {
        return mergeFrom((messages.Corner)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(messages.Corner other) {
      if (other == messages.Corner.getDefaultInstance()) return this;
      if (other.hasX()) {
        setX(other.getX());
      }
      if (other.hasY()) {
        setY(other.getY());
      }
      if (other.hasId()) {
        setId(other.getId());
      }
      if (other.hasCorrespondence()) {
        setCorrespondence(other.getCorrespondence());
      }
      if (other.hasProb()) {
        setProb(other.getProb());
      }
      if (other.hasLine1()) {
        setLine1(other.getLine1());
      }
      if (other.hasLine2()) {
        setLine2(other.getLine2());
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
      messages.Corner parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (messages.Corner) e.getUnfinishedMessage();
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

    private int id_ ;
    /**
     * <code>optional int32 id = 3;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 id = 3;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>optional int32 id = 3;</code>
     */
    public Builder setId(int value) {
      bitField0_ |= 0x00000004;
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 id = 3;</code>
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000004);
      id_ = 0;
      onChanged();
      return this;
    }

    private int correspondence_ ;
    /**
     * <code>optional int32 correspondence = 4;</code>
     */
    public boolean hasCorrespondence() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int32 correspondence = 4;</code>
     */
    public int getCorrespondence() {
      return correspondence_;
    }
    /**
     * <code>optional int32 correspondence = 4;</code>
     */
    public Builder setCorrespondence(int value) {
      bitField0_ |= 0x00000008;
      correspondence_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 correspondence = 4;</code>
     */
    public Builder clearCorrespondence() {
      bitField0_ = (bitField0_ & ~0x00000008);
      correspondence_ = 0;
      onChanged();
      return this;
    }

    private float prob_ ;
    /**
     * <code>optional float prob = 5;</code>
     */
    public boolean hasProb() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional float prob = 5;</code>
     */
    public float getProb() {
      return prob_;
    }
    /**
     * <code>optional float prob = 5;</code>
     */
    public Builder setProb(float value) {
      bitField0_ |= 0x00000010;
      prob_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional float prob = 5;</code>
     */
    public Builder clearProb() {
      bitField0_ = (bitField0_ & ~0x00000010);
      prob_ = 0F;
      onChanged();
      return this;
    }

    private int line1_ ;
    /**
     * <code>optional int32 line1 = 6;</code>
     */
    public boolean hasLine1() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional int32 line1 = 6;</code>
     */
    public int getLine1() {
      return line1_;
    }
    /**
     * <code>optional int32 line1 = 6;</code>
     */
    public Builder setLine1(int value) {
      bitField0_ |= 0x00000020;
      line1_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 line1 = 6;</code>
     */
    public Builder clearLine1() {
      bitField0_ = (bitField0_ & ~0x00000020);
      line1_ = 0;
      onChanged();
      return this;
    }

    private int line2_ ;
    /**
     * <code>optional int32 line2 = 7;</code>
     */
    public boolean hasLine2() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <code>optional int32 line2 = 7;</code>
     */
    public int getLine2() {
      return line2_;
    }
    /**
     * <code>optional int32 line2 = 7;</code>
     */
    public Builder setLine2(int value) {
      bitField0_ |= 0x00000040;
      line2_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 line2 = 7;</code>
     */
    public Builder clearLine2() {
      bitField0_ = (bitField0_ & ~0x00000040);
      line2_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:messages.Corner)
  }

  static {
    defaultInstance = new Corner(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:messages.Corner)
}

