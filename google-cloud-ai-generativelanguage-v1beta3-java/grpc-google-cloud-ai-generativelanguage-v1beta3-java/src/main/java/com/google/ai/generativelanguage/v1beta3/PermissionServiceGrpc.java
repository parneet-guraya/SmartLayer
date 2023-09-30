package com.google.ai.generativelanguage.v1beta3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Provides methods for managing permissions to PaLM API resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/ai/generativelanguage/v1beta3/permission_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PermissionServiceGrpc {

  private PermissionServiceGrpc() {}

  public static final String SERVICE_NAME = "google.ai.generativelanguage.v1beta3.PermissionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest,
      com.google.ai.generativelanguage.v1beta3.Permission> getCreatePermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePermission",
      requestType = com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.Permission.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest,
      com.google.ai.generativelanguage.v1beta3.Permission> getCreatePermissionMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest, com.google.ai.generativelanguage.v1beta3.Permission> getCreatePermissionMethod;
    if ((getCreatePermissionMethod = PermissionServiceGrpc.getCreatePermissionMethod) == null) {
      synchronized (PermissionServiceGrpc.class) {
        if ((getCreatePermissionMethod = PermissionServiceGrpc.getCreatePermissionMethod) == null) {
          PermissionServiceGrpc.getCreatePermissionMethod = getCreatePermissionMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest, com.google.ai.generativelanguage.v1beta3.Permission>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.Permission.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionServiceMethodDescriptorSupplier("CreatePermission"))
              .build();
        }
      }
    }
    return getCreatePermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.GetPermissionRequest,
      com.google.ai.generativelanguage.v1beta3.Permission> getGetPermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPermission",
      requestType = com.google.ai.generativelanguage.v1beta3.GetPermissionRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.Permission.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.GetPermissionRequest,
      com.google.ai.generativelanguage.v1beta3.Permission> getGetPermissionMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.GetPermissionRequest, com.google.ai.generativelanguage.v1beta3.Permission> getGetPermissionMethod;
    if ((getGetPermissionMethod = PermissionServiceGrpc.getGetPermissionMethod) == null) {
      synchronized (PermissionServiceGrpc.class) {
        if ((getGetPermissionMethod = PermissionServiceGrpc.getGetPermissionMethod) == null) {
          PermissionServiceGrpc.getGetPermissionMethod = getGetPermissionMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.GetPermissionRequest, com.google.ai.generativelanguage.v1beta3.Permission>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.GetPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.Permission.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionServiceMethodDescriptorSupplier("GetPermission"))
              .build();
        }
      }
    }
    return getGetPermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest,
      com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse> getListPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPermissions",
      requestType = com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest,
      com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse> getListPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest, com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse> getListPermissionsMethod;
    if ((getListPermissionsMethod = PermissionServiceGrpc.getListPermissionsMethod) == null) {
      synchronized (PermissionServiceGrpc.class) {
        if ((getListPermissionsMethod = PermissionServiceGrpc.getListPermissionsMethod) == null) {
          PermissionServiceGrpc.getListPermissionsMethod = getListPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest, com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionServiceMethodDescriptorSupplier("ListPermissions"))
              .build();
        }
      }
    }
    return getListPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest,
      com.google.ai.generativelanguage.v1beta3.Permission> getUpdatePermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePermission",
      requestType = com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.Permission.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest,
      com.google.ai.generativelanguage.v1beta3.Permission> getUpdatePermissionMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest, com.google.ai.generativelanguage.v1beta3.Permission> getUpdatePermissionMethod;
    if ((getUpdatePermissionMethod = PermissionServiceGrpc.getUpdatePermissionMethod) == null) {
      synchronized (PermissionServiceGrpc.class) {
        if ((getUpdatePermissionMethod = PermissionServiceGrpc.getUpdatePermissionMethod) == null) {
          PermissionServiceGrpc.getUpdatePermissionMethod = getUpdatePermissionMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest, com.google.ai.generativelanguage.v1beta3.Permission>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.Permission.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionServiceMethodDescriptorSupplier("UpdatePermission"))
              .build();
        }
      }
    }
    return getUpdatePermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest,
      com.google.protobuf.Empty> getDeletePermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePermission",
      requestType = com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest,
      com.google.protobuf.Empty> getDeletePermissionMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest, com.google.protobuf.Empty> getDeletePermissionMethod;
    if ((getDeletePermissionMethod = PermissionServiceGrpc.getDeletePermissionMethod) == null) {
      synchronized (PermissionServiceGrpc.class) {
        if ((getDeletePermissionMethod = PermissionServiceGrpc.getDeletePermissionMethod) == null) {
          PermissionServiceGrpc.getDeletePermissionMethod = getDeletePermissionMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionServiceMethodDescriptorSupplier("DeletePermission"))
              .build();
        }
      }
    }
    return getDeletePermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest,
      com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse> getTransferOwnershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TransferOwnership",
      requestType = com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest,
      com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse> getTransferOwnershipMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest, com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse> getTransferOwnershipMethod;
    if ((getTransferOwnershipMethod = PermissionServiceGrpc.getTransferOwnershipMethod) == null) {
      synchronized (PermissionServiceGrpc.class) {
        if ((getTransferOwnershipMethod = PermissionServiceGrpc.getTransferOwnershipMethod) == null) {
          PermissionServiceGrpc.getTransferOwnershipMethod = getTransferOwnershipMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest, com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TransferOwnership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionServiceMethodDescriptorSupplier("TransferOwnership"))
              .build();
        }
      }
    }
    return getTransferOwnershipMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PermissionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PermissionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PermissionServiceStub>() {
        @java.lang.Override
        public PermissionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PermissionServiceStub(channel, callOptions);
        }
      };
    return PermissionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PermissionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PermissionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PermissionServiceBlockingStub>() {
        @java.lang.Override
        public PermissionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PermissionServiceBlockingStub(channel, callOptions);
        }
      };
    return PermissionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PermissionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PermissionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PermissionServiceFutureStub>() {
        @java.lang.Override
        public PermissionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PermissionServiceFutureStub(channel, callOptions);
        }
      };
    return PermissionServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Provides methods for managing permissions to PaLM API resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Create a permission to a specific resource.
     * </pre>
     */
    default void createPermission(com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Permission> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePermissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about a specific Permission.
     * </pre>
     */
    default void getPermission(com.google.ai.generativelanguage.v1beta3.GetPermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Permission> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPermissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists permissions for the specific resource.
     * </pre>
     */
    default void listPermissions(com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the permission.
     * </pre>
     */
    default void updatePermission(com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Permission> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePermissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the permission.
     * </pre>
     */
    default void deletePermission(com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePermissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Transfers ownership of the tuned model.
     * This is the only way to change ownership of the tuned model.
     * The current owner will be downgraded to writer role.
     * </pre>
     */
    default void transferOwnership(com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTransferOwnershipMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PermissionService.
   * <pre>
   * Provides methods for managing permissions to PaLM API resources.
   * </pre>
   */
  public static abstract class PermissionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PermissionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PermissionService.
   * <pre>
   * Provides methods for managing permissions to PaLM API resources.
   * </pre>
   */
  public static final class PermissionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PermissionServiceStub> {
    private PermissionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PermissionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a permission to a specific resource.
     * </pre>
     */
    public void createPermission(com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Permission> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about a specific Permission.
     * </pre>
     */
    public void getPermission(com.google.ai.generativelanguage.v1beta3.GetPermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Permission> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists permissions for the specific resource.
     * </pre>
     */
    public void listPermissions(com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the permission.
     * </pre>
     */
    public void updatePermission(com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Permission> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the permission.
     * </pre>
     */
    public void deletePermission(com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Transfers ownership of the tuned model.
     * This is the only way to change ownership of the tuned model.
     * The current owner will be downgraded to writer role.
     * </pre>
     */
    public void transferOwnership(com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTransferOwnershipMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PermissionService.
   * <pre>
   * Provides methods for managing permissions to PaLM API resources.
   * </pre>
   */
  public static final class PermissionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PermissionServiceBlockingStub> {
    private PermissionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PermissionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a permission to a specific resource.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.Permission createPermission(com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePermissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about a specific Permission.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.Permission getPermission(com.google.ai.generativelanguage.v1beta3.GetPermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPermissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists permissions for the specific resource.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse listPermissions(com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the permission.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.Permission updatePermission(com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePermissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the permission.
     * </pre>
     */
    public com.google.protobuf.Empty deletePermission(com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePermissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Transfers ownership of the tuned model.
     * This is the only way to change ownership of the tuned model.
     * The current owner will be downgraded to writer role.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse transferOwnership(com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTransferOwnershipMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PermissionService.
   * <pre>
   * Provides methods for managing permissions to PaLM API resources.
   * </pre>
   */
  public static final class PermissionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PermissionServiceFutureStub> {
    private PermissionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PermissionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a permission to a specific resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.Permission> createPermission(
        com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePermissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about a specific Permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.Permission> getPermission(
        com.google.ai.generativelanguage.v1beta3.GetPermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPermissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists permissions for the specific resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse> listPermissions(
        com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.Permission> updatePermission(
        com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePermissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the permission.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deletePermission(
        com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePermissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Transfers ownership of the tuned model.
     * This is the only way to change ownership of the tuned model.
     * The current owner will be downgraded to writer role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse> transferOwnership(
        com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTransferOwnershipMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PERMISSION = 0;
  private static final int METHODID_GET_PERMISSION = 1;
  private static final int METHODID_LIST_PERMISSIONS = 2;
  private static final int METHODID_UPDATE_PERMISSION = 3;
  private static final int METHODID_DELETE_PERMISSION = 4;
  private static final int METHODID_TRANSFER_OWNERSHIP = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PERMISSION:
          serviceImpl.createPermission((com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Permission>) responseObserver);
          break;
        case METHODID_GET_PERMISSION:
          serviceImpl.getPermission((com.google.ai.generativelanguage.v1beta3.GetPermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Permission>) responseObserver);
          break;
        case METHODID_LIST_PERMISSIONS:
          serviceImpl.listPermissions((com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PERMISSION:
          serviceImpl.updatePermission((com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Permission>) responseObserver);
          break;
        case METHODID_DELETE_PERMISSION:
          serviceImpl.deletePermission((com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_TRANSFER_OWNERSHIP:
          serviceImpl.transferOwnership((com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreatePermissionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest,
              com.google.ai.generativelanguage.v1beta3.Permission>(
                service, METHODID_CREATE_PERMISSION)))
        .addMethod(
          getGetPermissionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.GetPermissionRequest,
              com.google.ai.generativelanguage.v1beta3.Permission>(
                service, METHODID_GET_PERMISSION)))
        .addMethod(
          getListPermissionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest,
              com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse>(
                service, METHODID_LIST_PERMISSIONS)))
        .addMethod(
          getUpdatePermissionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest,
              com.google.ai.generativelanguage.v1beta3.Permission>(
                service, METHODID_UPDATE_PERMISSION)))
        .addMethod(
          getDeletePermissionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_PERMISSION)))
        .addMethod(
          getTransferOwnershipMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest,
              com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse>(
                service, METHODID_TRANSFER_OWNERSHIP)))
        .build();
  }

  private static abstract class PermissionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PermissionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ai.generativelanguage.v1beta3.PermissionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PermissionService");
    }
  }

  private static final class PermissionServiceFileDescriptorSupplier
      extends PermissionServiceBaseDescriptorSupplier {
    PermissionServiceFileDescriptorSupplier() {}
  }

  private static final class PermissionServiceMethodDescriptorSupplier
      extends PermissionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PermissionServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PermissionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PermissionServiceFileDescriptorSupplier())
              .addMethod(getCreatePermissionMethod())
              .addMethod(getGetPermissionMethod())
              .addMethod(getListPermissionsMethod())
              .addMethod(getUpdatePermissionMethod())
              .addMethod(getDeletePermissionMethod())
              .addMethod(getTransferOwnershipMethod())
              .build();
        }
      }
    }
    return result;
  }
}
