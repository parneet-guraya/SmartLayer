// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta3/model_service.proto

package com.google.ai.generativelanguage.v1beta3;

public interface ListModelsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ai.generativelanguage.v1beta3.ListModelsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The returned Models.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.Model models = 1;</code>
   */
  java.util.List<com.google.ai.generativelanguage.v1beta3.Model> 
      getModelsList();
  /**
   * <pre>
   * The returned Models.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.Model models = 1;</code>
   */
  com.google.ai.generativelanguage.v1beta3.Model getModels(int index);
  /**
   * <pre>
   * The returned Models.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.Model models = 1;</code>
   */
  int getModelsCount();
  /**
   * <pre>
   * The returned Models.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.Model models = 1;</code>
   */
  java.util.List<? extends com.google.ai.generativelanguage.v1beta3.ModelOrBuilder> 
      getModelsOrBuilderList();
  /**
   * <pre>
   * The returned Models.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.Model models = 1;</code>
   */
  com.google.ai.generativelanguage.v1beta3.ModelOrBuilder getModelsOrBuilder(
      int index);

  /**
   * <pre>
   * A token, which can be sent as `page_token` to retrieve the next page.
   *
   * If this field is omitted, there are no more pages.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   * @return The nextPageToken.
   */
  java.lang.String getNextPageToken();
  /**
   * <pre>
   * A token, which can be sent as `page_token` to retrieve the next page.
   *
   * If this field is omitted, there are no more pages.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   * @return The bytes for nextPageToken.
   */
  com.google.protobuf.ByteString
      getNextPageTokenBytes();
}