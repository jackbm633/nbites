// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: StiffnessControl.proto

package messages;

public final class StiffnessControlOuterClass {
  private StiffnessControlOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface StiffnessControlOrBuilder extends
      // @@protoc_insertion_point(interface_extends:messages.StiffnessControl)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional bool remove = 1;</code>
     */
    boolean hasRemove();
    /**
     * <code>optional bool remove = 1;</code>
     */
    boolean getRemove();
  }
  /**
   * Protobuf type {@code messages.StiffnessControl}
   */
  public static final class StiffnessControl extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:messages.StiffnessControl)
      StiffnessControlOrBuilder {
    // Use StiffnessControl.newBuilder() to construct.
    private StiffnessControl(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private StiffnessControl(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final StiffnessControl defaultInstance;
    public static StiffnessControl getDefaultInstance() {
      return defaultInstance;
    }

    public StiffnessControl getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private StiffnessControl(
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
              remove_ = input.readBool();
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
      return messages.StiffnessControlOuterClass.internal_static_messages_StiffnessControl_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages.StiffnessControlOuterClass.internal_static_messages_StiffnessControl_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.StiffnessControlOuterClass.StiffnessControl.class, messages.StiffnessControlOuterClass.StiffnessControl.Builder.class);
    }

    public static com.google.protobuf.Parser<StiffnessControl> PARSER =
        new com.google.protobuf.AbstractParser<StiffnessControl>() {
      public StiffnessControl parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new StiffnessControl(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<StiffnessControl> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int REMOVE_FIELD_NUMBER = 1;
    private boolean remove_;
    /**
     * <code>optional bool remove = 1;</code>
     */
    public boolean hasRemove() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional bool remove = 1;</code>
     */
    public boolean getRemove() {
      return remove_;
    }

    private void initFields() {
      remove_ = false;
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
        output.writeBool(1, remove_);
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
          .computeBoolSize(1, remove_);
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

    public static messages.StiffnessControlOuterClass.StiffnessControl parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static messages.StiffnessControlOuterClass.StiffnessControl parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static messages.StiffnessControlOuterClass.StiffnessControl parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static messages.StiffnessControlOuterClass.StiffnessControl parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static messages.StiffnessControlOuterClass.StiffnessControl parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static messages.StiffnessControlOuterClass.StiffnessControl parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static messages.StiffnessControlOuterClass.StiffnessControl parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static messages.StiffnessControlOuterClass.StiffnessControl parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static messages.StiffnessControlOuterClass.StiffnessControl parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static messages.StiffnessControlOuterClass.StiffnessControl parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(messages.StiffnessControlOuterClass.StiffnessControl prototype) {
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
     * Protobuf type {@code messages.StiffnessControl}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:messages.StiffnessControl)
        messages.StiffnessControlOuterClass.StiffnessControlOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return messages.StiffnessControlOuterClass.internal_static_messages_StiffnessControl_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return messages.StiffnessControlOuterClass.internal_static_messages_StiffnessControl_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                messages.StiffnessControlOuterClass.StiffnessControl.class, messages.StiffnessControlOuterClass.StiffnessControl.Builder.class);
      }

      // Construct using messages.StiffnessControlOuterClass.StiffnessControl.newBuilder()
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
        remove_ = false;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return messages.StiffnessControlOuterClass.internal_static_messages_StiffnessControl_descriptor;
      }

      public messages.StiffnessControlOuterClass.StiffnessControl getDefaultInstanceForType() {
        return messages.StiffnessControlOuterClass.StiffnessControl.getDefaultInstance();
      }

      public messages.StiffnessControlOuterClass.StiffnessControl build() {
        messages.StiffnessControlOuterClass.StiffnessControl result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public messages.StiffnessControlOuterClass.StiffnessControl buildPartial() {
        messages.StiffnessControlOuterClass.StiffnessControl result = new messages.StiffnessControlOuterClass.StiffnessControl(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.remove_ = remove_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof messages.StiffnessControlOuterClass.StiffnessControl) {
          return mergeFrom((messages.StiffnessControlOuterClass.StiffnessControl)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(messages.StiffnessControlOuterClass.StiffnessControl other) {
        if (other == messages.StiffnessControlOuterClass.StiffnessControl.getDefaultInstance()) return this;
        if (other.hasRemove()) {
          setRemove(other.getRemove());
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
        messages.StiffnessControlOuterClass.StiffnessControl parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (messages.StiffnessControlOuterClass.StiffnessControl) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private boolean remove_ ;
      /**
       * <code>optional bool remove = 1;</code>
       */
      public boolean hasRemove() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional bool remove = 1;</code>
       */
      public boolean getRemove() {
        return remove_;
      }
      /**
       * <code>optional bool remove = 1;</code>
       */
      public Builder setRemove(boolean value) {
        bitField0_ |= 0x00000001;
        remove_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool remove = 1;</code>
       */
      public Builder clearRemove() {
        bitField0_ = (bitField0_ & ~0x00000001);
        remove_ = false;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:messages.StiffnessControl)
    }

    static {
      defaultInstance = new StiffnessControl(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:messages.StiffnessControl)
  }

  public interface StiffStatusOrBuilder extends
      // @@protoc_insertion_point(interface_extends:messages.StiffStatus)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional bool on = 1;</code>
     */
    boolean hasOn();
    /**
     * <code>optional bool on = 1;</code>
     */
    boolean getOn();
  }
  /**
   * Protobuf type {@code messages.StiffStatus}
   */
  public static final class StiffStatus extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:messages.StiffStatus)
      StiffStatusOrBuilder {
    // Use StiffStatus.newBuilder() to construct.
    private StiffStatus(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private StiffStatus(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final StiffStatus defaultInstance;
    public static StiffStatus getDefaultInstance() {
      return defaultInstance;
    }

    public StiffStatus getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private StiffStatus(
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
              on_ = input.readBool();
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
      return messages.StiffnessControlOuterClass.internal_static_messages_StiffStatus_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages.StiffnessControlOuterClass.internal_static_messages_StiffStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.StiffnessControlOuterClass.StiffStatus.class, messages.StiffnessControlOuterClass.StiffStatus.Builder.class);
    }

    public static com.google.protobuf.Parser<StiffStatus> PARSER =
        new com.google.protobuf.AbstractParser<StiffStatus>() {
      public StiffStatus parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new StiffStatus(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<StiffStatus> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int ON_FIELD_NUMBER = 1;
    private boolean on_;
    /**
     * <code>optional bool on = 1;</code>
     */
    public boolean hasOn() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional bool on = 1;</code>
     */
    public boolean getOn() {
      return on_;
    }

    private void initFields() {
      on_ = false;
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
        output.writeBool(1, on_);
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
          .computeBoolSize(1, on_);
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

    public static messages.StiffnessControlOuterClass.StiffStatus parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static messages.StiffnessControlOuterClass.StiffStatus parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static messages.StiffnessControlOuterClass.StiffStatus parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static messages.StiffnessControlOuterClass.StiffStatus parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static messages.StiffnessControlOuterClass.StiffStatus parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static messages.StiffnessControlOuterClass.StiffStatus parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static messages.StiffnessControlOuterClass.StiffStatus parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static messages.StiffnessControlOuterClass.StiffStatus parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static messages.StiffnessControlOuterClass.StiffStatus parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static messages.StiffnessControlOuterClass.StiffStatus parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(messages.StiffnessControlOuterClass.StiffStatus prototype) {
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
     * Protobuf type {@code messages.StiffStatus}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:messages.StiffStatus)
        messages.StiffnessControlOuterClass.StiffStatusOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return messages.StiffnessControlOuterClass.internal_static_messages_StiffStatus_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return messages.StiffnessControlOuterClass.internal_static_messages_StiffStatus_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                messages.StiffnessControlOuterClass.StiffStatus.class, messages.StiffnessControlOuterClass.StiffStatus.Builder.class);
      }

      // Construct using messages.StiffnessControlOuterClass.StiffStatus.newBuilder()
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
        on_ = false;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return messages.StiffnessControlOuterClass.internal_static_messages_StiffStatus_descriptor;
      }

      public messages.StiffnessControlOuterClass.StiffStatus getDefaultInstanceForType() {
        return messages.StiffnessControlOuterClass.StiffStatus.getDefaultInstance();
      }

      public messages.StiffnessControlOuterClass.StiffStatus build() {
        messages.StiffnessControlOuterClass.StiffStatus result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public messages.StiffnessControlOuterClass.StiffStatus buildPartial() {
        messages.StiffnessControlOuterClass.StiffStatus result = new messages.StiffnessControlOuterClass.StiffStatus(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.on_ = on_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof messages.StiffnessControlOuterClass.StiffStatus) {
          return mergeFrom((messages.StiffnessControlOuterClass.StiffStatus)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(messages.StiffnessControlOuterClass.StiffStatus other) {
        if (other == messages.StiffnessControlOuterClass.StiffStatus.getDefaultInstance()) return this;
        if (other.hasOn()) {
          setOn(other.getOn());
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
        messages.StiffnessControlOuterClass.StiffStatus parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (messages.StiffnessControlOuterClass.StiffStatus) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private boolean on_ ;
      /**
       * <code>optional bool on = 1;</code>
       */
      public boolean hasOn() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional bool on = 1;</code>
       */
      public boolean getOn() {
        return on_;
      }
      /**
       * <code>optional bool on = 1;</code>
       */
      public Builder setOn(boolean value) {
        bitField0_ |= 0x00000001;
        on_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool on = 1;</code>
       */
      public Builder clearOn() {
        bitField0_ = (bitField0_ & ~0x00000001);
        on_ = false;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:messages.StiffStatus)
    }

    static {
      defaultInstance = new StiffStatus(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:messages.StiffStatus)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_StiffnessControl_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_StiffnessControl_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_StiffStatus_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_StiffStatus_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026StiffnessControl.proto\022\010messages\"\"\n\020St" +
      "iffnessControl\022\016\n\006remove\030\001 \001(\010\"\031\n\013StiffS" +
      "tatus\022\n\n\002on\030\001 \001(\010"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_messages_StiffnessControl_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messages_StiffnessControl_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_StiffnessControl_descriptor,
        new java.lang.String[] { "Remove", });
    internal_static_messages_StiffStatus_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_messages_StiffStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_StiffStatus_descriptor,
        new java.lang.String[] { "On", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}