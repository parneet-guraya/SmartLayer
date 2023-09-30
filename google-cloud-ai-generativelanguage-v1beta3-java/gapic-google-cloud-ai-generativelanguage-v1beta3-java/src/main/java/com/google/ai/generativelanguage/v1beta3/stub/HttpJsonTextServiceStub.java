/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ai.generativelanguage.v1beta3.stub;

import com.google.ai.generativelanguage.v1beta3.BatchEmbedTextRequest;
import com.google.ai.generativelanguage.v1beta3.BatchEmbedTextResponse;
import com.google.ai.generativelanguage.v1beta3.CountTextTokensRequest;
import com.google.ai.generativelanguage.v1beta3.CountTextTokensResponse;
import com.google.ai.generativelanguage.v1beta3.EmbedTextRequest;
import com.google.ai.generativelanguage.v1beta3.EmbedTextResponse;
import com.google.ai.generativelanguage.v1beta3.GenerateTextRequest;
import com.google.ai.generativelanguage.v1beta3.GenerateTextResponse;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the TextService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonTextServiceStub extends TextServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GenerateTextRequest, GenerateTextResponse>
      generateTextMethodDescriptor =
          ApiMethodDescriptor.<GenerateTextRequest, GenerateTextResponse>newBuilder()
              .setFullMethodName("google.ai.generativelanguage.v1beta3.TextService/GenerateText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateTextRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{model=models/*}:generateText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "model", request.getModel());
                            return fields;
                          })
                      .setAdditionalPaths("/v1beta3/{model=tunedModels/*}:generateText")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearModel().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateTextResponse>newBuilder()
                      .setDefaultInstance(GenerateTextResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EmbedTextRequest, EmbedTextResponse>
      embedTextMethodDescriptor =
          ApiMethodDescriptor.<EmbedTextRequest, EmbedTextResponse>newBuilder()
              .setFullMethodName("google.ai.generativelanguage.v1beta3.TextService/EmbedText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EmbedTextRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{model=models/*}:embedText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EmbedTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "model", request.getModel());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EmbedTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearModel().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EmbedTextResponse>newBuilder()
                      .setDefaultInstance(EmbedTextResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchEmbedTextRequest, BatchEmbedTextResponse>
      batchEmbedTextMethodDescriptor =
          ApiMethodDescriptor.<BatchEmbedTextRequest, BatchEmbedTextResponse>newBuilder()
              .setFullMethodName("google.ai.generativelanguage.v1beta3.TextService/BatchEmbedText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchEmbedTextRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{model=models/*}:batchEmbedText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchEmbedTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "model", request.getModel());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchEmbedTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearModel().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchEmbedTextResponse>newBuilder()
                      .setDefaultInstance(BatchEmbedTextResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CountTextTokensRequest, CountTextTokensResponse>
      countTextTokensMethodDescriptor =
          ApiMethodDescriptor.<CountTextTokensRequest, CountTextTokensResponse>newBuilder()
              .setFullMethodName("google.ai.generativelanguage.v1beta3.TextService/CountTextTokens")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CountTextTokensRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{model=models/*}:countTextTokens",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CountTextTokensRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "model", request.getModel());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CountTextTokensRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearModel().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CountTextTokensResponse>newBuilder()
                      .setDefaultInstance(CountTextTokensResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GenerateTextRequest, GenerateTextResponse> generateTextCallable;
  private final UnaryCallable<EmbedTextRequest, EmbedTextResponse> embedTextCallable;
  private final UnaryCallable<BatchEmbedTextRequest, BatchEmbedTextResponse> batchEmbedTextCallable;
  private final UnaryCallable<CountTextTokensRequest, CountTextTokensResponse>
      countTextTokensCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTextServiceStub create(TextServiceStubSettings settings)
      throws IOException {
    return new HttpJsonTextServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTextServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTextServiceStub(
        TextServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTextServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTextServiceStub(
        TextServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTextServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTextServiceStub(TextServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTextServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTextServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTextServiceStub(
      TextServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GenerateTextRequest, GenerateTextResponse> generateTextTransportSettings =
        HttpJsonCallSettings.<GenerateTextRequest, GenerateTextResponse>newBuilder()
            .setMethodDescriptor(generateTextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("model", String.valueOf(request.getModel()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EmbedTextRequest, EmbedTextResponse> embedTextTransportSettings =
        HttpJsonCallSettings.<EmbedTextRequest, EmbedTextResponse>newBuilder()
            .setMethodDescriptor(embedTextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("model", String.valueOf(request.getModel()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchEmbedTextRequest, BatchEmbedTextResponse>
        batchEmbedTextTransportSettings =
            HttpJsonCallSettings.<BatchEmbedTextRequest, BatchEmbedTextResponse>newBuilder()
                .setMethodDescriptor(batchEmbedTextMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("model", String.valueOf(request.getModel()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CountTextTokensRequest, CountTextTokensResponse>
        countTextTokensTransportSettings =
            HttpJsonCallSettings.<CountTextTokensRequest, CountTextTokensResponse>newBuilder()
                .setMethodDescriptor(countTextTokensMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("model", String.valueOf(request.getModel()));
                      return builder.build();
                    })
                .build();

    this.generateTextCallable =
        callableFactory.createUnaryCallable(
            generateTextTransportSettings, settings.generateTextSettings(), clientContext);
    this.embedTextCallable =
        callableFactory.createUnaryCallable(
            embedTextTransportSettings, settings.embedTextSettings(), clientContext);
    this.batchEmbedTextCallable =
        callableFactory.createUnaryCallable(
            batchEmbedTextTransportSettings, settings.batchEmbedTextSettings(), clientContext);
    this.countTextTokensCallable =
        callableFactory.createUnaryCallable(
            countTextTokensTransportSettings, settings.countTextTokensSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(generateTextMethodDescriptor);
    methodDescriptors.add(embedTextMethodDescriptor);
    methodDescriptors.add(batchEmbedTextMethodDescriptor);
    methodDescriptors.add(countTextTokensMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GenerateTextRequest, GenerateTextResponse> generateTextCallable() {
    return generateTextCallable;
  }

  @Override
  public UnaryCallable<EmbedTextRequest, EmbedTextResponse> embedTextCallable() {
    return embedTextCallable;
  }

  @Override
  public UnaryCallable<BatchEmbedTextRequest, BatchEmbedTextResponse> batchEmbedTextCallable() {
    return batchEmbedTextCallable;
  }

  @Override
  public UnaryCallable<CountTextTokensRequest, CountTextTokensResponse> countTextTokensCallable() {
    return countTextTokensCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
