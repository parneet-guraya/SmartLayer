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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the ModelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonModelServiceStub extends ModelServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(CreateTunedModelMetadata.getDescriptor())
          .add(TunedModel.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      ApiMethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setFullMethodName("google.ai.generativelanguage.v1beta3.ModelService/GetModel")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetModelRequest>newBuilder()
                  .setPath(
                      "/v1beta3/{name=models/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Model>newBuilder()
                  .setDefaultInstance(Model.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          ApiMethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setFullMethodName("google.ai.generativelanguage.v1beta3.ModelService/ListModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListModelsRequest>newBuilder()
                      .setPath(
                          "/v1beta3/models",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListModelsResponse>newBuilder()
                      .setDefaultInstance(ListModelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTunedModelRequest, TunedModel>
      getTunedModelMethodDescriptor =
          ApiMethodDescriptor.<GetTunedModelRequest, TunedModel>newBuilder()
              .setFullMethodName("google.ai.generativelanguage.v1beta3.ModelService/GetTunedModel")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTunedModelRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{name=tunedModels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTunedModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTunedModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TunedModel>newBuilder()
                      .setDefaultInstance(TunedModel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTunedModelsRequest, ListTunedModelsResponse>
      listTunedModelsMethodDescriptor =
          ApiMethodDescriptor.<ListTunedModelsRequest, ListTunedModelsResponse>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.ModelService/ListTunedModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTunedModelsRequest>newBuilder()
                      .setPath(
                          "/v1beta3/tunedModels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTunedModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTunedModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTunedModelsResponse>newBuilder()
                      .setDefaultInstance(ListTunedModelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTunedModelRequest, Operation>
      createTunedModelMethodDescriptor =
          ApiMethodDescriptor.<CreateTunedModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.ModelService/CreateTunedModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTunedModelRequest>newBuilder()
                      .setPath(
                          "/v1beta3/tunedModels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTunedModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTunedModelRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasTunedModelId()) {
                              serializer.putQueryParam(
                                  fields, "tunedModelId", request.getTunedModelId());
                            }
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tunedModel", request.getTunedModel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTunedModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateTunedModelRequest, TunedModel>
      updateTunedModelMethodDescriptor =
          ApiMethodDescriptor.<UpdateTunedModelRequest, TunedModel>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.ModelService/UpdateTunedModel")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTunedModelRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{tunedModel.name=tunedModels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTunedModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "tunedModel.name", request.getTunedModel().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTunedModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tunedModel", request.getTunedModel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TunedModel>newBuilder()
                      .setDefaultInstance(TunedModel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTunedModelRequest, Empty>
      deleteTunedModelMethodDescriptor =
          ApiMethodDescriptor.<DeleteTunedModelRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.ModelService/DeleteTunedModel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTunedModelRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{name=tunedModels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTunedModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTunedModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonModelServiceStub create(ModelServiceStubSettings settings)
      throws IOException {
    return new HttpJsonModelServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonModelServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonModelServiceStub(
        ModelServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonModelServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonModelServiceStub(
        ModelServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonModelServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonModelServiceStub(ModelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonModelServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonModelServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonModelServiceStub(
      ModelServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetModelRequest, Model> getModelTransportSettings =
        HttpJsonCallSettings.<GetModelRequest, Model>newBuilder()
            .setMethodDescriptor(getModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        HttpJsonCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTunedModelRequest, TunedModel> getTunedModelTransportSettings =
        HttpJsonCallSettings.<GetTunedModelRequest, TunedModel>newBuilder()
            .setMethodDescriptor(getTunedModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTunedModelsRequest, ListTunedModelsResponse>
        listTunedModelsTransportSettings =
            HttpJsonCallSettings.<ListTunedModelsRequest, ListTunedModelsResponse>newBuilder()
                .setMethodDescriptor(listTunedModelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateTunedModelRequest, Operation> createTunedModelTransportSettings =
        HttpJsonCallSettings.<CreateTunedModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createTunedModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTunedModelRequest, TunedModel> updateTunedModelTransportSettings =
        HttpJsonCallSettings.<UpdateTunedModelRequest, TunedModel>newBuilder()
            .setMethodDescriptor(updateTunedModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "tuned_model.name", String.valueOf(request.getTunedModel().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTunedModelRequest, Empty> deleteTunedModelTransportSettings =
        HttpJsonCallSettings.<DeleteTunedModelRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTunedModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
    this.updateTunedModelCallable =
        callableFactory.createUnaryCallable(
            updateTunedModelTransportSettings, settings.updateTunedModelSettings(), clientContext);
    this.deleteTunedModelCallable =
        callableFactory.createUnaryCallable(
            deleteTunedModelTransportSettings, settings.deleteTunedModelSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getModelMethodDescriptor);
    methodDescriptors.add(listModelsMethodDescriptor);
    methodDescriptors.add(getTunedModelMethodDescriptor);
    methodDescriptors.add(listTunedModelsMethodDescriptor);
    methodDescriptors.add(createTunedModelMethodDescriptor);
    methodDescriptors.add(updateTunedModelMethodDescriptor);
    methodDescriptors.add(deleteTunedModelMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
