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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
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
 * gRPC stub implementation for the PermissionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPermissionServiceStub extends PermissionServiceStub {
  private static final MethodDescriptor<CreatePermissionRequest, Permission>
      createPermissionMethodDescriptor =
          MethodDescriptor.<CreatePermissionRequest, Permission>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/CreatePermission")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Permission.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPermissionRequest, Permission>
      getPermissionMethodDescriptor =
          MethodDescriptor.<GetPermissionRequest, Permission>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/GetPermission")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Permission.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPermissionsRequest, ListPermissionsResponse>
      listPermissionsMethodDescriptor =
          MethodDescriptor.<ListPermissionsRequest, ListPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/ListPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePermissionRequest, Permission>
      updatePermissionMethodDescriptor =
          MethodDescriptor.<UpdatePermissionRequest, Permission>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/UpdatePermission")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Permission.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePermissionRequest, Empty>
      deletePermissionMethodDescriptor =
          MethodDescriptor.<DeletePermissionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/DeletePermission")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TransferOwnershipRequest, TransferOwnershipResponse>
      transferOwnershipMethodDescriptor =
          MethodDescriptor.<TransferOwnershipRequest, TransferOwnershipResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ai.generativelanguage.v1beta3.PermissionService/TransferOwnership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferOwnershipRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TransferOwnershipResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPermissionServiceStub create(PermissionServiceStubSettings settings)
      throws IOException {
    return new GrpcPermissionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPermissionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPermissionServiceStub(
        PermissionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPermissionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPermissionServiceStub(
        PermissionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPermissionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPermissionServiceStub(
      PermissionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcPermissionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPermissionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPermissionServiceStub(
      PermissionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreatePermissionRequest, Permission> createPermissionTransportSettings =
        GrpcCallSettings.<CreatePermissionRequest, Permission>newBuilder()
            .setMethodDescriptor(createPermissionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPermissionRequest, Permission> getPermissionTransportSettings =
        GrpcCallSettings.<GetPermissionRequest, Permission>newBuilder()
            .setMethodDescriptor(getPermissionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPermissionsRequest, ListPermissionsResponse>
        listPermissionsTransportSettings =
            GrpcCallSettings.<ListPermissionsRequest, ListPermissionsResponse>newBuilder()
                .setMethodDescriptor(listPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdatePermissionRequest, Permission> updatePermissionTransportSettings =
        GrpcCallSettings.<UpdatePermissionRequest, Permission>newBuilder()
            .setMethodDescriptor(updatePermissionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("permission.name", String.valueOf(request.getPermission().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePermissionRequest, Empty> deletePermissionTransportSettings =
        GrpcCallSettings.<DeletePermissionRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePermissionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TransferOwnershipRequest, TransferOwnershipResponse>
        transferOwnershipTransportSettings =
            GrpcCallSettings.<TransferOwnershipRequest, TransferOwnershipResponse>newBuilder()
                .setMethodDescriptor(transferOwnershipMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
