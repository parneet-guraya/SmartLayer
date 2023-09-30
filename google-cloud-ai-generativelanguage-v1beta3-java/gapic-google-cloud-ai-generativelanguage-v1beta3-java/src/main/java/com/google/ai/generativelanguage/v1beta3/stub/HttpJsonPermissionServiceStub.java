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

import static com.google.ai.generativelanguage.v1beta3.PermissionServiceClient.ListPermissionsPagedResponse;

import com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest;
import com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest;
import com.google.ai.generativelanguage.v1beta3.GetPermissionRequest;
import com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest;
import com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse;
import com.google.ai.generativelanguage.v1beta3.Permission;
import com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest;
import com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse;
import com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest;
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
 * REST stub implementation for the PermissionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPermissionServiceStub extends PermissionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreatePermissionRequest, Permission>
      createPermissionMethodDescriptor =
          ApiMethodDescriptor.<CreatePermissionRequest, Permission>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/CreatePermission")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePermissionRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{parent=tunedModels/*}/permissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("permission", request.getPermission(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Permission>newBuilder()
                      .setDefaultInstance(Permission.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPermissionRequest, Permission>
      getPermissionMethodDescriptor =
          ApiMethodDescriptor.<GetPermissionRequest, Permission>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/GetPermission")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPermissionRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{name=tunedModels/*/permissions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Permission>newBuilder()
                      .setDefaultInstance(Permission.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPermissionsRequest, ListPermissionsResponse>
      listPermissionsMethodDescriptor =
          ApiMethodDescriptor.<ListPermissionsRequest, ListPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/ListPermissions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{parent=tunedModels/*}/permissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPermissionsResponse>newBuilder()
                      .setDefaultInstance(ListPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePermissionRequest, Permission>
      updatePermissionMethodDescriptor =
          ApiMethodDescriptor.<UpdatePermissionRequest, Permission>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/UpdatePermission")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePermissionRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{permission.name=tunedModels/*/permissions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "permission.name", request.getPermission().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("permission", request.getPermission(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Permission>newBuilder()
                      .setDefaultInstance(Permission.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePermissionRequest, Empty>
      deletePermissionMethodDescriptor =
          ApiMethodDescriptor.<DeletePermissionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/DeletePermission")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePermissionRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{name=tunedModels/*/permissions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePermissionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePermissionRequest> serializer =
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

  private static final ApiMethodDescriptor<TransferOwnershipRequest, TransferOwnershipResponse>
      transferOwnershipMethodDescriptor =
          ApiMethodDescriptor.<TransferOwnershipRequest, TransferOwnershipResponse>newBuilder()
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/TransferOwnership")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferOwnershipRequest>newBuilder()
                      .setPath(
                          "/v1beta3/{name=tunedModels/*}:transferOwnership",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferOwnershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferOwnershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferOwnershipResponse>newBuilder()
                      .setDefaultInstance(TransferOwnershipResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreatePermissionRequest, Permission> createPermissionCallable;
  private final UnaryCallable<GetPermissionRequest, Permission> getPermissionCallable;
  private final UnaryCallable<ListPermissionsRequest, ListPermissionsResponse>
      listPermissionsCallable;
  private final UnaryCallable<ListPermissionsRequest, ListPermissionsPagedResponse>
      listPermissionsPagedCallable;
  private final UnaryCallable<UpdatePermissionRequest, Permission> updatePermissionCallable;
  private final UnaryCallable<DeletePermissionRequest, Empty> deletePermissionCallable;
  private final UnaryCallable<TransferOwnershipRequest, TransferOwnershipResponse>
      transferOwnershipCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPermissionServiceStub create(PermissionServiceStubSettings settings)
      throws IOException {
    return new HttpJsonPermissionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPermissionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPermissionServiceStub(
        PermissionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPermissionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPermissionServiceStub(
        PermissionServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPermissionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPermissionServiceStub(
      PermissionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPermissionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPermissionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPermissionServiceStub(
      PermissionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreatePermissionRequest, Permission> createPermissionTransportSettings =
        HttpJsonCallSettings.<CreatePermissionRequest, Permission>newBuilder()
            .setMethodDescriptor(createPermissionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetPermissionRequest, Permission> getPermissionTransportSettings =
        HttpJsonCallSettings.<GetPermissionRequest, Permission>newBuilder()
            .setMethodDescriptor(getPermissionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPermissionsRequest, ListPermissionsResponse>
        listPermissionsTransportSettings =
            HttpJsonCallSettings.<ListPermissionsRequest, ListPermissionsResponse>newBuilder()
                .setMethodDescriptor(listPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePermissionRequest, Permission> updatePermissionTransportSettings =
        HttpJsonCallSettings.<UpdatePermissionRequest, Permission>newBuilder()
            .setMethodDescriptor(updatePermissionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("permission.name", String.valueOf(request.getPermission().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePermissionRequest, Empty> deletePermissionTransportSettings =
        HttpJsonCallSettings.<DeletePermissionRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePermissionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TransferOwnershipRequest, TransferOwnershipResponse>
        transferOwnershipTransportSettings =
            HttpJsonCallSettings.<TransferOwnershipRequest, TransferOwnershipResponse>newBuilder()
                .setMethodDescriptor(transferOwnershipMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.createPermissionCallable =
        callableFactory.createUnaryCallable(
            createPermissionTransportSettings, settings.createPermissionSettings(), clientContext);
    this.getPermissionCallable =
        callableFactory.createUnaryCallable(
            getPermissionTransportSettings, settings.getPermissionSettings(), clientContext);
    this.listPermissionsCallable =
        callableFactory.createUnaryCallable(
            listPermissionsTransportSettings, settings.listPermissionsSettings(), clientContext);
    this.listPermissionsPagedCallable =
        callableFactory.createPagedCallable(
            listPermissionsTransportSettings, settings.listPermissionsSettings(), clientContext);
    this.updatePermissionCallable =
        callableFactory.createUnaryCallable(
            updatePermissionTransportSettings, settings.updatePermissionSettings(), clientContext);
    this.deletePermissionCallable =
        callableFactory.createUnaryCallable(
            deletePermissionTransportSettings, settings.deletePermissionSettings(), clientContext);
    this.transferOwnershipCallable =
        callableFactory.createUnaryCallable(
            transferOwnershipTransportSettings,
            settings.transferOwnershipSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createPermissionMethodDescriptor);
    methodDescriptors.add(getPermissionMethodDescriptor);
    methodDescriptors.add(listPermissionsMethodDescriptor);
    methodDescriptors.add(updatePermissionMethodDescriptor);
    methodDescriptors.add(deletePermissionMethodDescriptor);
    methodDescriptors.add(transferOwnershipMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreatePermissionRequest, Permission> createPermissionCallable() {
    return createPermissionCallable;
  }

  @Override
  public UnaryCallable<GetPermissionRequest, Permission> getPermissionCallable() {
    return getPermissionCallable;
  }

  @Override
  public UnaryCallable<ListPermissionsRequest, ListPermissionsResponse> listPermissionsCallable() {
    return listPermissionsCallable;
  }

  @Override
  public UnaryCallable<ListPermissionsRequest, ListPermissionsPagedResponse>
      listPermissionsPagedCallable() {
    return listPermissionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePermissionRequest, Permission> updatePermissionCallable() {
    return updatePermissionCallable;
  }

  @Override
  public UnaryCallable<DeletePermissionRequest, Empty> deletePermissionCallable() {
    return deletePermissionCallable;
  }

  @Override
  public UnaryCallable<TransferOwnershipRequest, TransferOwnershipResponse>
      transferOwnershipCallable() {
    return transferOwnershipCallable;
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
