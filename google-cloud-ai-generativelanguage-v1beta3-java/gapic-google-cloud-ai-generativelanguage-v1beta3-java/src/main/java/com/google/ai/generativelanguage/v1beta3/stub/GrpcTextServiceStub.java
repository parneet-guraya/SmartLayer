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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TextService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTextServiceStub extends TextServiceStub {
  private static final MethodDescriptor<GenerateTextRequest, GenerateTextResponse>
      generateTextMethodDescriptor =
          MethodDescriptor.<GenerateTextRequest, GenerateTextResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ai.generativelanguage.v1beta3.TextService/GenerateText")
              .setRequestMarshaller(ProtoUtils.marshaller(GenerateTextRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateTextResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EmbedTextRequest, EmbedTextResponse>
      embedTextMethodDescriptor =
          MethodDescriptor.<EmbedTextRequest, EmbedTextResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ai.generativelanguage.v1beta3.TextService/EmbedText")
              .setRequestMarshaller(ProtoUtils.marshaller(EmbedTextRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EmbedTextResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchEmbedTextRequest, BatchEmbedTextResponse>
      batchEmbedTextMethodDescriptor =
          MethodDescriptor.<BatchEmbedTextRequest, BatchEmbedTextResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ai.generativelanguage.v1beta3.TextService/BatchEmbedText")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchEmbedTextRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchEmbedTextResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CountTextTokensRequest, CountTextTokensResponse>
      countTextTokensMethodDescriptor =
          MethodDescriptor.<CountTextTokensRequest, CountTextTokensResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ai.generativelanguage.v1beta3.TextService/CountTextTokens")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CountTextTokensRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CountTextTokensResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GenerateTextRequest, GenerateTextResponse> generateTextCallable;
  private final UnaryCallable<EmbedTextRequest, EmbedTextResponse> embedTextCallable;
  private final UnaryCallable<BatchEmbedTextRequest, BatchEmbedTextResponse> batchEmbedTextCallable;
  private final UnaryCallable<CountTextTokensRequest, CountTextTokensResponse>
      countTextTokensCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTextServiceStub create(TextServiceStubSettings settings)
      throws IOException {
    return new GrpcTextServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTextServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcTextServiceStub(TextServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTextServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTextServiceStub(
        TextServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTextServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTextServiceStub(TextServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTextServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTextServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTextServiceStub(
      TextServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GenerateTextRequest, GenerateTextResponse> generateTextTransportSettings =
        GrpcCallSettings.<GenerateTextRequest, GenerateTextResponse>newBuilder()
            .setMethodDescriptor(generateTextMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("model", String.valueOf(request.getModel()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EmbedTextRequest, EmbedTextResponse> embedTextTransportSettings =
        GrpcCallSettings.<EmbedTextRequest, EmbedTextResponse>newBuilder()
            .setMethodDescriptor(embedTextMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("model", String.valueOf(request.getModel()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchEmbedTextRequest, BatchEmbedTextResponse>
        batchEmbedTextTransportSettings =
            GrpcCallSettings.<BatchEmbedTextRequest, BatchEmbedTextResponse>newBuilder()
                .setMethodDescriptor(batchEmbedTextMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("model", String.valueOf(request.getModel()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CountTextTokensRequest, CountTextTokensResponse>
        countTextTokensTransportSettings =
            GrpcCallSettings.<CountTextTokensRequest, CountTextTokensResponse>newBuilder()
                .setMethodDescriptor(countTextTokensMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
