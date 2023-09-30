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

import static com.google.ai.generativelanguage.v1beta3.ModelServiceClient.ListModelsPagedResponse;
import static com.google.ai.generativelanguage.v1beta3.ModelServiceClient.ListTunedModelsPagedResponse;

import com.google.ai.generativelanguage.v1beta3.CreateTunedModelMetadata;
import com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest;
import com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest;
import com.google.ai.generativelanguage.v1beta3.GetModelRequest;
import com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest;
import com.google.ai.generativelanguage.v1beta3.ListModelsRequest;
import com.google.ai.generativelanguage.v1beta3.ListModelsResponse;
import com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest;
import com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse;
import com.google.ai.generativelanguage.v1beta3.Model;
import com.google.ai.generativelanguage.v1beta3.TunedModel;
import com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ModelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcModelServiceStub extends ModelServiceStub {
  private static final MethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      MethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.ai.generativelanguage.v1beta3.ModelService/GetModel")
          .setRequestMarshaller(ProtoUtils.marshaller(GetModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          MethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ai.generativelanguage.v1beta3.ModelService/ListModels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListModelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTunedModelRequest, TunedModel>
      getTunedModelMethodDescriptor =
          MethodDescriptor.<GetTunedModelRequest, TunedModel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ai.generativelanguage.v1beta3.ModelService/GetTunedModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTunedModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TunedModel.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTunedModelsRequest, ListTunedModelsResponse>
      listTunedModelsMethodDescriptor =
          MethodDescriptor.<ListTunedModelsRequest, ListTunedModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.ModelService/ListTunedModels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTunedModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTunedModelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTunedModelRequest, Operation>
      createTunedModelMethodDescriptor =
          MethodDescriptor.<CreateTunedModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.ModelService/CreateTunedModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTunedModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTunedModelRequest, TunedModel>
      updateTunedModelMethodDescriptor =
          MethodDescriptor.<UpdateTunedModelRequest, TunedModel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.ModelService/UpdateTunedModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTunedModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TunedModel.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTunedModelRequest, Empty>
      deleteTunedModelMethodDescriptor =
          MethodDescriptor.<DeleteTunedModelRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.ModelService/DeleteTunedModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTunedModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetModelRequest, Model> getModelCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<GetTunedModelRequest, TunedModel> getTunedModelCallable;
  private final UnaryCallable<ListTunedModelsRequest, ListTunedModelsResponse>
      listTunedModelsCallable;
  private final UnaryCallable<ListTunedModelsRequest, ListTunedModelsPagedResponse>
      listTunedModelsPagedCallable;
  private final UnaryCallable<CreateTunedModelRequest, Operation> createTunedModelCallable;
  private final OperationCallable<CreateTunedModelRequest, TunedModel, CreateTunedModelMetadata>
      createTunedModelOperationCallable;
  private final UnaryCallable<UpdateTunedModelRequest, TunedModel> updateTunedModelCallable;
  private final UnaryCallable<DeleteTunedModelRequest, Empty> deleteTunedModelCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcModelServiceStub create(ModelServiceStubSettings settings)
      throws IOException {
    return new GrpcModelServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcModelServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcModelServiceStub(ModelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcModelServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcModelServiceStub(
        ModelServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcModelServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelServiceStub(ModelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcModelServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcModelServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelServiceStub(
      ModelServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetModelRequest, Model> getModelTransportSettings =
        GrpcCallSettings.<GetModelRequest, Model>newBuilder()
            .setMethodDescriptor(getModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        GrpcCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .build();
    GrpcCallSettings<GetTunedModelRequest, TunedModel> getTunedModelTransportSettings =
        GrpcCallSettings.<GetTunedModelRequest, TunedModel>newBuilder()
            .setMethodDescriptor(getTunedModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTunedModelsRequest, ListTunedModelsResponse>
        listTunedModelsTransportSettings =
            GrpcCallSettings.<ListTunedModelsRequest, ListTunedModelsResponse>newBuilder()
                .setMethodDescriptor(listTunedModelsMethodDescriptor)
                .build();
    GrpcCallSettings<CreateTunedModelRequest, Operation> createTunedModelTransportSettings =
        GrpcCallSettings.<CreateTunedModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createTunedModelMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateTunedModelRequest, TunedModel> updateTunedModelTransportSettings =
        GrpcCallSettings.<UpdateTunedModelRequest, TunedModel>newBuilder()
            .setMethodDescriptor(updateTunedModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "tuned_model.name", String.valueOf(request.getTunedModel().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTunedModelRequest, Empty> deleteTunedModelTransportSettings =
        GrpcCallSettings.<DeleteTunedModelRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTunedModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getModelCallable =
        callableFactory.createUnaryCallable(
            getModelTransportSettings, settings.getModelSettings(), clientContext);
    this.listModelsCallable =
        callableFactory.createUnaryCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelsPagedCallable =
        callableFactory.createPagedCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.getTunedModelCallable =
        callableFactory.createUnaryCallable(
            getTunedModelTransportSettings, settings.getTunedModelSettings(), clientContext);
    this.listTunedModelsCallable =
        callableFactory.createUnaryCallable(
            listTunedModelsTransportSettings, settings.listTunedModelsSettings(), clientContext);
    this.listTunedModelsPagedCallable =
        callableFactory.createPagedCallable(
            listTunedModelsTransportSettings, settings.listTunedModelsSettings(), clientContext);
    this.createTunedModelCallable =
        callableFactory.createUnaryCallable(
            createTunedModelTransportSettings, settings.createTunedModelSettings(), clientContext);
    this.createTunedModelOperationCallable =
        callableFactory.createOperationCallable(
            createTunedModelTransportSettings,
            settings.createTunedModelOperationSettings(),
            clientContext,
            operationsStub);
    this.updateTunedModelCallable =
        callableFactory.createUnaryCallable(
            updateTunedModelTransportSettings, settings.updateTunedModelSettings(), clientContext);
    this.deleteTunedModelCallable =
        callableFactory.createUnaryCallable(
            deleteTunedModelTransportSettings, settings.deleteTunedModelSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return getModelCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return listModelsCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return listModelsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTunedModelRequest, TunedModel> getTunedModelCallable() {
    return getTunedModelCallable;
  }

  @Override
  public UnaryCallable<ListTunedModelsRequest, ListTunedModelsResponse> listTunedModelsCallable() {
    return listTunedModelsCallable;
  }

  @Override
  public UnaryCallable<ListTunedModelsRequest, ListTunedModelsPagedResponse>
      listTunedModelsPagedCallable() {
    return listTunedModelsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTunedModelRequest, Operation> createTunedModelCallable() {
    return createTunedModelCallable;
  }

  @Override
  public OperationCallable<CreateTunedModelRequest, TunedModel, CreateTunedModelMetadata>
      createTunedModelOperationCallable() {
    return createTunedModelOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTunedModelRequest, TunedModel> updateTunedModelCallable() {
    return updateTunedModelCallable;
  }

  @Override
  public UnaryCallable<DeleteTunedModelRequest, Empty> deleteTunedModelCallable() {
    return deleteTunedModelCallable;
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
