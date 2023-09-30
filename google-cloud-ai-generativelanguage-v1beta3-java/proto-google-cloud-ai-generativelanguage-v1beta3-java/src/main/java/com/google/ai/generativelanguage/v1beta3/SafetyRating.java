// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta3/safety.proto

package com.google.ai.generativelanguage.v1beta3;

/**
 * <pre>
 * Safety rating for a piece of content.
 *
 * The safety rating contains the category of harm and the
 * harm probability level in that category for a piece of content.
 * Content is classified for safety across a number of
 * harm categories and the probability of the harm classification is included
 * here.
 * </pre>
 *
 * Protobuf type {@code google.ai.generativelanguage.v1beta3.SafetyRating}
 */
public final class SafetyRating extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.ai.generativelanguage.v1beta3.SafetyRating)
    SafetyRatingOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SafetyRating.newBuilder() to construct.
  private SafetyRating(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SafetyRating() {
    category_ = 0;
    probability_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SafetyRating();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.ai.generativelanguage.v1beta3.SafetyProto.internal_static_google_ai_generativelanguage_v1beta3_SafetyRating_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.ai.generativelanguage.v1beta3.SafetyProto.internal_static_google_ai_generativelanguage_v1beta3_SafetyRating_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.ai.generativelanguage.v1beta3.SafetyRating.class, com.google.ai.generativelanguage.v1beta3.SafetyRating.Builder.class);
  }

  /**
   * <pre>
   * The probability that a piece of content is harmful.
   *
   * The classification system gives the probability of the content being
   * unsafe. This does not indicate the severity of harm for a piece of content.
   * </pre>
   *
   * Protobuf enum {@code google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability}
   */
  public enum HarmProbability
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     * Probability is unspecified.
     * </pre>
     *
     * <code>HARM_PROBABILITY_UNSPECIFIED = 0;</code>
     */
    HARM_PROBABILITY_UNSPECIFIED(0),
    /**
     * <pre>
     * Content has a negligible chance of being unsafe.
     * </pre>
     *
     * <code>NEGLIGIBLE = 1;</code>
     */
    NEGLIGIBLE(1),
    /**
     * <pre>
     * Content has a low chance of being unsafe.
     * </pre>
     *
     * <code>LOW = 2;</code>
     */
    LOW(2),
    /**
     * <pre>
     * Content has a medium chance of being unsafe.
     * </pre>
     *
     * <code>MEDIUM = 3;</code>
     */
    MEDIUM(3),
    /**
     * <pre>
     * Content has a high chance of being unsafe.
     * </pre>
     *
     * <code>HIGH = 4;</code>
     */
    HIGH(4),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     * Probability is unspecified.
     * </pre>
     *
     * <code>HARM_PROBABILITY_UNSPECIFIED = 0;</code>
     */
    public static final int HARM_PROBABILITY_UNSPECIFIED_VALUE = 0;
    /**
     * <pre>
     * Content has a negligible chance of being unsafe.
     * </pre>
     *
     * <code>NEGLIGIBLE = 1;</code>
     */
    public static final int NEGLIGIBLE_VALUE = 1;
    /**
     * <pre>
     * Content has a low chance of being unsafe.
     * </pre>
     *
     * <code>LOW = 2;</code>
     */
    public static final int LOW_VALUE = 2;
    /**
     * <pre>
     * Content has a medium chance of being unsafe.
     * </pre>
     *
     * <code>MEDIUM = 3;</code>
     */
    public static final int MEDIUM_VALUE = 3;
    /**
     * <pre>
     * Content has a high chance of being unsafe.
     * </pre>
     *
     * <code>HIGH = 4;</code>
     */
    public static final int HIGH_VALUE = 4;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static HarmProbability valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static HarmProbability forNumber(int value) {
      switch (value) {
        case 0: return HARM_PROBABILITY_UNSPECIFIED;
        case 1: return NEGLIGIBLE;
        case 2: return LOW;
        case 3: return MEDIUM;
        case 4: return HIGH;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<HarmProbability>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        HarmProbability> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<HarmProbability>() {
            public HarmProbability findValueByNumber(int number) {
              return HarmProbability.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.google.ai.generativelanguage.v1beta3.SafetyRating.getDescriptor().getEnumTypes().get(0);
    }

    private static final HarmProbability[] VALUES = values();

    public static HarmProbability valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private HarmProbability(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability)
  }

  public static final int CATEGORY_FIELD_NUMBER = 3;
  private int category_ = 0;
  /**
   * <pre>
   * Required. The category for this rating.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta3.HarmCategory category = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The enum numeric value on the wire for category.
   */
  @java.lang.Override public int getCategoryValue() {
    return category_;
  }
  /**
   * <pre>
   * Required. The category for this rating.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta3.HarmCategory category = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The category.
   */
  @java.lang.Override public com.google.ai.generativelanguage.v1beta3.HarmCategory getCategory() {
    com.google.ai.generativelanguage.v1beta3.HarmCategory result = com.google.ai.generativelanguage.v1beta3.HarmCategory.forNumber(category_);
    return result == null ? com.google.ai.generativelanguage.v1beta3.HarmCategory.UNRECOGNIZED : result;
  }

  public static final int PROBABILITY_FIELD_NUMBER = 4;
  private int probability_ = 0;
  /**
   * <pre>
   * Required. The probability of harm for this content.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability probability = 4 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The enum numeric value on the wire for probability.
   */
  @java.lang.Override public int getProbabilityValue() {
    return probability_;
  }
  /**
   * <pre>
   * Required. The probability of harm for this content.
   * </pre>
   *
   * <code>.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability probability = 4 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The probability.
   */
  @java.lang.Override public com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability getProbability() {
    com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability result = com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability.forNumber(probability_);
    return result == null ? com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (category_ != com.google.ai.generativelanguage.v1beta3.HarmCategory.HARM_CATEGORY_UNSPECIFIED.getNumber()) {
      output.writeEnum(3, category_);
    }
    if (probability_ != com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability.HARM_PROBABILITY_UNSPECIFIED.getNumber()) {
      output.writeEnum(4, probability_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (category_ != com.google.ai.generativelanguage.v1beta3.HarmCategory.HARM_CATEGORY_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, category_);
    }
    if (probability_ != com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability.HARM_PROBABILITY_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(4, probability_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.ai.generativelanguage.v1beta3.SafetyRating)) {
      return super.equals(obj);
    }
    com.google.ai.generativelanguage.v1beta3.SafetyRating other = (com.google.ai.generativelanguage.v1beta3.SafetyRating) obj;

    if (category_ != other.category_) return false;
    if (probability_ != other.probability_) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CATEGORY_FIELD_NUMBER;
    hash = (53 * hash) + category_;
    hash = (37 * hash) + PROBABILITY_FIELD_NUMBER;
    hash = (53 * hash) + probability_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ai.generativelanguage.v1beta3.SafetyRating parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.ai.generativelanguage.v1beta3.SafetyRating prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Safety rating for a piece of content.
   *
   * The safety rating contains the category of harm and the
   * harm probability level in that category for a piece of content.
   * Content is classified for safety across a number of
   * harm categories and the probability of the harm classification is included
   * here.
   * </pre>
   *
   * Protobuf type {@code google.ai.generativelanguage.v1beta3.SafetyRating}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.ai.generativelanguage.v1beta3.SafetyRating)
      com.google.ai.generativelanguage.v1beta3.SafetyRatingOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.ai.generativelanguage.v1beta3.SafetyProto.internal_static_google_ai_generativelanguage_v1beta3_SafetyRating_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.ai.generativelanguage.v1beta3.SafetyProto.internal_static_google_ai_generativelanguage_v1beta3_SafetyRating_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.ai.generativelanguage.v1beta3.SafetyRating.class, com.google.ai.generativelanguage.v1beta3.SafetyRating.Builder.class);
    }

    // Construct using com.google.ai.generativelanguage.v1beta3.SafetyRating.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      category_ = 0;
      probability_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.ai.generativelanguage.v1beta3.SafetyProto.internal_static_google_ai_generativelanguage_v1beta3_SafetyRating_descriptor;
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.SafetyRating getDefaultInstanceForType() {
      return com.google.ai.generativelanguage.v1beta3.SafetyRating.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.SafetyRating build() {
      com.google.ai.generativelanguage.v1beta3.SafetyRating result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.SafetyRating buildPartial() {
      com.google.ai.generativelanguage.v1beta3.SafetyRating result = new com.google.ai.generativelanguage.v1beta3.SafetyRating(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.ai.generativelanguage.v1beta3.SafetyRating result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.category_ = category_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.probability_ = probability_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.ai.generativelanguage.v1beta3.SafetyRating) {
        return mergeFrom((com.google.ai.generativelanguage.v1beta3.SafetyRating)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.ai.generativelanguage.v1beta3.SafetyRating other) {
      if (other == com.google.ai.generativelanguage.v1beta3.SafetyRating.getDefaultInstance()) return this;
      if (other.category_ != 0) {
        setCategoryValue(other.getCategoryValue());
      }
      if (other.probability_ != 0) {
        setProbabilityValue(other.getProbabilityValue());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 24: {
              category_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 24
            case 32: {
              probability_ = input.readEnum();
              bitField0_ |= 0x00000002;
              break;
            } // case 32
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int category_ = 0;
    /**
     * <pre>
     * Required. The category for this rating.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.HarmCategory category = 3 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return The enum numeric value on the wire for category.
     */
    @java.lang.Override public int getCategoryValue() {
      return category_;
    }
    /**
     * <pre>
     * Required. The category for this rating.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.HarmCategory category = 3 [(.google.api.field_behavior) = REQUIRED];</code>
     * @param value The enum numeric value on the wire for category to set.
     * @return This builder for chaining.
     */
    public Builder setCategoryValue(int value) {
      category_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Required. The category for this rating.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.HarmCategory category = 3 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return The category.
     */
    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.HarmCategory getCategory() {
      com.google.ai.generativelanguage.v1beta3.HarmCategory result = com.google.ai.generativelanguage.v1beta3.HarmCategory.forNumber(category_);
      return result == null ? com.google.ai.generativelanguage.v1beta3.HarmCategory.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * Required. The category for this rating.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.HarmCategory category = 3 [(.google.api.field_behavior) = REQUIRED];</code>
     * @param value The category to set.
     * @return This builder for chaining.
     */
    public Builder setCategory(com.google.ai.generativelanguage.v1beta3.HarmCategory value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      category_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Required. The category for this rating.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.HarmCategory category = 3 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return This builder for chaining.
     */
    public Builder clearCategory() {
      bitField0_ = (bitField0_ & ~0x00000001);
      category_ = 0;
      onChanged();
      return this;
    }

    private int probability_ = 0;
    /**
     * <pre>
     * Required. The probability of harm for this content.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability probability = 4 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return The enum numeric value on the wire for probability.
     */
    @java.lang.Override public int getProbabilityValue() {
      return probability_;
    }
    /**
     * <pre>
     * Required. The probability of harm for this content.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability probability = 4 [(.google.api.field_behavior) = REQUIRED];</code>
     * @param value The enum numeric value on the wire for probability to set.
     * @return This builder for chaining.
     */
    public Builder setProbabilityValue(int value) {
      probability_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Required. The probability of harm for this content.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability probability = 4 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return The probability.
     */
    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability getProbability() {
      com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability result = com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability.forNumber(probability_);
      return result == null ? com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * Required. The probability of harm for this content.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability probability = 4 [(.google.api.field_behavior) = REQUIRED];</code>
     * @param value The probability to set.
     * @return This builder for chaining.
     */
    public Builder setProbability(com.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      probability_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Required. The probability of harm for this content.
     * </pre>
     *
     * <code>.google.ai.generativelanguage.v1beta3.SafetyRating.HarmProbability probability = 4 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return This builder for chaining.
     */
    public Builder clearProbability() {
      bitField0_ = (bitField0_ & ~0x00000002);
      probability_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:google.ai.generativelanguage.v1beta3.SafetyRating)
  }

  // @@protoc_insertion_point(class_scope:google.ai.generativelanguage.v1beta3.SafetyRating)
  private static final com.google.ai.generativelanguage.v1beta3.SafetyRating DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.ai.generativelanguage.v1beta3.SafetyRating();
  }

  public static com.google.ai.generativelanguage.v1beta3.SafetyRating getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SafetyRating>
      PARSER = new com.google.protobuf.AbstractParser<SafetyRating>() {
    @java.lang.Override
    public SafetyRating parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<SafetyRating> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SafetyRating> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.ai.generativelanguage.v1beta3.SafetyRating getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
