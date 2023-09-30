package com.google.ai.generativelanguage.v1beta3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Provides methods for getting metadata information about Generative Models.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/ai/generativelanguage/v1beta3/model_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ModelServiceGrpc {

  private ModelServiceGrpc() {}

  public static final String SERVICE_NAME = "google.ai.generativelanguage.v1beta3.ModelService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.GetModelRequest,
      com.google.ai.generativelanguage.v1beta3.Model> getGetModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetModel",
      requestType = com.google.ai.generativelanguage.v1beta3.GetModelRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.Model.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.GetModelRequest,
      com.google.ai.generativelanguage.v1beta3.Model> getGetModelMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.GetModelRequest, com.google.ai.generativelanguage.v1beta3.Model> getGetModelMethod;
    if ((getGetModelMethod = ModelServiceGrpc.getGetModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getGetModelMethod = ModelServiceGrpc.getGetModelMethod) == null) {
          ModelServiceGrpc.getGetModelMethod = getGetModelMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.GetModelRequest, com.google.ai.generativelanguage.v1beta3.Model>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.GetModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.Model.getDefaultInstance()))
              .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("GetModel"))
              .build();
        }
      }
    }
    return getGetModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.ListModelsRequest,
      com.google.ai.generativelanguage.v1beta3.ListModelsResponse> getListModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListModels",
      requestType = com.google.ai.generativelanguage.v1beta3.ListModelsRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.ListModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.ListModelsRequest,
      com.google.ai.generativelanguage.v1beta3.ListModelsResponse> getListModelsMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.ListModelsRequest, com.google.ai.generativelanguage.v1beta3.ListModelsResponse> getListModelsMethod;
    if ((getListModelsMethod = ModelServiceGrpc.getListModelsMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getListModelsMethod = ModelServiceGrpc.getListModelsMethod) == null) {
          ModelServiceGrpc.getListModelsMethod = getListModelsMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.ListModelsRequest, com.google.ai.generativelanguage.v1beta3.ListModelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListModels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.ListModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.ListModelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("ListModels"))
              .build();
        }
      }
    }
    return getListModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest,
      com.google.ai.generativelanguage.v1beta3.TunedModel> getGetTunedModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTunedModel",
      requestType = com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.TunedModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest,
      com.google.ai.generativelanguage.v1beta3.TunedModel> getGetTunedModelMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest, com.google.ai.generativelanguage.v1beta3.TunedModel> getGetTunedModelMethod;
    if ((getGetTunedModelMethod = ModelServiceGrpc.getGetTunedModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getGetTunedModelMethod = ModelServiceGrpc.getGetTunedModelMethod) == null) {
          ModelServiceGrpc.getGetTunedModelMethod = getGetTunedModelMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest, com.google.ai.generativelanguage.v1beta3.TunedModel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTunedModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.TunedModel.getDefaultInstance()))
              .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("GetTunedModel"))
              .build();
        }
      }
    }
    return getGetTunedModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest,
      com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse> getListTunedModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTunedModels",
      requestType = com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest,
      com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse> getListTunedModelsMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest, com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse> getListTunedModelsMethod;
    if ((getListTunedModelsMethod = ModelServiceGrpc.getListTunedModelsMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getListTunedModelsMethod = ModelServiceGrpc.getListTunedModelsMethod) == null) {
          ModelServiceGrpc.getListTunedModelsMethod = getListTunedModelsMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest, com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTunedModels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("ListTunedModels"))
              .build();
        }
      }
    }
    return getListTunedModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest,
      com.google.longrunning.Operation> getCreateTunedModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTunedModel",
      requestType = com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest,
      com.google.longrunning.Operation> getCreateTunedModelMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest, com.google.longrunning.Operation> getCreateTunedModelMethod;
    if ((getCreateTunedModelMethod = ModelServiceGrpc.getCreateTunedModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getCreateTunedModelMethod = ModelServiceGrpc.getCreateTunedModelMethod) == null) {
          ModelServiceGrpc.getCreateTunedModelMethod = getCreateTunedModelMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTunedModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("CreateTunedModel"))
              .build();
        }
      }
    }
    return getCreateTunedModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest,
      com.google.ai.generativelanguage.v1beta3.TunedModel> getUpdateTunedModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTunedModel",
      requestType = com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest.class,
      responseType = com.google.ai.generativelanguage.v1beta3.TunedModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest,
      com.google.ai.generativelanguage.v1beta3.TunedModel> getUpdateTunedModelMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest, com.google.ai.generativelanguage.v1beta3.TunedModel> getUpdateTunedModelMethod;
    if ((getUpdateTunedModelMethod = ModelServiceGrpc.getUpdateTunedModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getUpdateTunedModelMethod = ModelServiceGrpc.getUpdateTunedModelMethod) == null) {
          ModelServiceGrpc.getUpdateTunedModelMethod = getUpdateTunedModelMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest, com.google.ai.generativelanguage.v1beta3.TunedModel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTunedModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.TunedModel.getDefaultInstance()))
              .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("UpdateTunedModel"))
              .build();
        }
      }
    }
    return getUpdateTunedModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest,
      com.google.protobuf.Empty> getDeleteTunedModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTunedModel",
      requestType = com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest,
      com.google.protobuf.Empty> getDeleteTunedModelMethod() {
    io.grpc.MethodDescriptor<com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest, com.google.protobuf.Empty> getDeleteTunedModelMethod;
    if ((getDeleteTunedModelMethod = ModelServiceGrpc.getDeleteTunedModelMethod) == null) {
      synchronized (ModelServiceGrpc.class) {
        if ((getDeleteTunedModelMethod = ModelServiceGrpc.getDeleteTunedModelMethod) == null) {
          ModelServiceGrpc.getDeleteTunedModelMethod = getDeleteTunedModelMethod =
              io.grpc.MethodDescriptor.<com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTunedModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ModelServiceMethodDescriptorSupplier("DeleteTunedModel"))
              .build();
        }
      }
    }
    return getDeleteTunedModelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ModelServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModelServiceStub>() {
        @java.lang.Override
        public ModelServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModelServiceStub(channel, callOptions);
        }
      };
    return ModelServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModelServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModelServiceBlockingStub>() {
        @java.lang.Override
        public ModelServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModelServiceBlockingStub(channel, callOptions);
        }
      };
    return ModelServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ModelServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModelServiceFutureStub>() {
        @java.lang.Override
        public ModelServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModelServiceFutureStub(channel, callOptions);
        }
      };
    return ModelServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Provides methods for getting metadata information about Generative Models.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Gets information about a specific Model.
     * </pre>
     */
    default void getModel(com.google.ai.generativelanguage.v1beta3.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Model> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists models available through the API.
     * </pre>
     */
    default void listModels(com.google.ai.generativelanguage.v1beta3.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.ListModelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListModelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about a specific TunedModel.
     * </pre>
     */
    default void getTunedModel(com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.TunedModel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTunedModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists tuned models owned by the user.
     * </pre>
     */
    default void listTunedModels(com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTunedModelsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a tuned model.
     * Intermediate tuning progress (if any) is accessed through the
     * [google.longrunning.Operations] service.
     * Status and results can be accessed through the Operations service.
     * Example:
     *   GET /v1/tunedModels/az2mb0bpw6i/operations/000-111-222
     * </pre>
     */
    default void createTunedModel(com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTunedModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a tuned model.
     * </pre>
     */
    default void updateTunedModel(com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.TunedModel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTunedModelMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a tuned model.
     * </pre>
     */
    default void deleteTunedModel(com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTunedModelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ModelService.
   * <pre>
   * Provides methods for getting metadata information about Generative Models.
   * </pre>
   */
  public static abstract class ModelServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ModelServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ModelService.
   * <pre>
   * Provides methods for getting metadata information about Generative Models.
   * </pre>
   */
  public static final class ModelServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ModelServiceStub> {
    private ModelServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets information about a specific Model.
     * </pre>
     */
    public void getModel(com.google.ai.generativelanguage.v1beta3.GetModelRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Model> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists models available through the API.
     * </pre>
     */
    public void listModels(com.google.ai.generativelanguage.v1beta3.ListModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.ListModelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about a specific TunedModel.
     * </pre>
     */
    public void getTunedModel(com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.TunedModel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTunedModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists tuned models owned by the user.
     * </pre>
     */
    public void listTunedModels(com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTunedModelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a tuned model.
     * Intermediate tuning progress (if any) is accessed through the
     * [google.longrunning.Operations] service.
     * Status and results can be accessed through the Operations service.
     * Example:
     *   GET /v1/tunedModels/az2mb0bpw6i/operations/000-111-222
     * </pre>
     */
    public void createTunedModel(com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTunedModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a tuned model.
     * </pre>
     */
    public void updateTunedModel(com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.TunedModel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTunedModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a tuned model.
     * </pre>
     */
    public void deleteTunedModel(com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTunedModelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ModelService.
   * <pre>
   * Provides methods for getting metadata information about Generative Models.
   * </pre>
   */
  public static final class ModelServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ModelServiceBlockingStub> {
    private ModelServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets information about a specific Model.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.Model getModel(com.google.ai.generativelanguage.v1beta3.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetModelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists models available through the API.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.ListModelsResponse listModels(com.google.ai.generativelanguage.v1beta3.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListModelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about a specific TunedModel.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.TunedModel getTunedModel(com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTunedModelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists tuned models owned by the user.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse listTunedModels(com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTunedModelsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a tuned model.
     * Intermediate tuning progress (if any) is accessed through the
     * [google.longrunning.Operations] service.
     * Status and results can be accessed through the Operations service.
     * Example:
     *   GET /v1/tunedModels/az2mb0bpw6i/operations/000-111-222
     * </pre>
     */
    public com.google.longrunning.Operation createTunedModel(com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTunedModelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a tuned model.
     * </pre>
     */
    public com.google.ai.generativelanguage.v1beta3.TunedModel updateTunedModel(com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTunedModelMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a tuned model.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTunedModel(com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTunedModelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ModelService.
   * <pre>
   * Provides methods for getting metadata information about Generative Models.
   * </pre>
   */
  public static final class ModelServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ModelServiceFutureStub> {
    private ModelServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets information about a specific Model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.Model> getModel(
        com.google.ai.generativelanguage.v1beta3.GetModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetModelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists models available through the API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.ListModelsResponse> listModels(
        com.google.ai.generativelanguage.v1beta3.ListModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListModelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about a specific TunedModel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.TunedModel> getTunedModel(
        com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTunedModelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists tuned models owned by the user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse> listTunedModels(
        com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTunedModelsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a tuned model.
     * Intermediate tuning progress (if any) is accessed through the
     * [google.longrunning.Operations] service.
     * Status and results can be accessed through the Operations service.
     * Example:
     *   GET /v1/tunedModels/az2mb0bpw6i/operations/000-111-222
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createTunedModel(
        com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTunedModelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a tuned model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.ai.generativelanguage.v1beta3.TunedModel> updateTunedModel(
        com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTunedModelMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a tuned model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTunedModel(
        com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTunedModelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MODEL = 0;
  private static final int METHODID_LIST_MODELS = 1;
  private static final int METHODID_GET_TUNED_MODEL = 2;
  private static final int METHODID_LIST_TUNED_MODELS = 3;
  private static final int METHODID_CREATE_TUNED_MODEL = 4;
  private static final int METHODID_UPDATE_TUNED_MODEL = 5;
  private static final int METHODID_DELETE_TUNED_MODEL = 6;

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
        case METHODID_GET_MODEL:
          serviceImpl.getModel((com.google.ai.generativelanguage.v1beta3.GetModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.Model>) responseObserver);
          break;
        case METHODID_LIST_MODELS:
          serviceImpl.listModels((com.google.ai.generativelanguage.v1beta3.ListModelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.ListModelsResponse>) responseObserver);
          break;
        case METHODID_GET_TUNED_MODEL:
          serviceImpl.getTunedModel((com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.TunedModel>) responseObserver);
          break;
        case METHODID_LIST_TUNED_MODELS:
          serviceImpl.listTunedModels((com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse>) responseObserver);
          break;
        case METHODID_CREATE_TUNED_MODEL:
          serviceImpl.createTunedModel((com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TUNED_MODEL:
          serviceImpl.updateTunedModel((com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.ai.generativelanguage.v1beta3.TunedModel>) responseObserver);
          break;
        case METHODID_DELETE_TUNED_MODEL:
          serviceImpl.deleteTunedModel((com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
          getGetModelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.GetModelRequest,
              com.google.ai.generativelanguage.v1beta3.Model>(
                service, METHODID_GET_MODEL)))
        .addMethod(
          getListModelsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.ListModelsRequest,
              com.google.ai.generativelanguage.v1beta3.ListModelsResponse>(
                service, METHODID_LIST_MODELS)))
        .addMethod(
          getGetTunedModelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.GetTunedModelRequest,
              com.google.ai.generativelanguage.v1beta3.TunedModel>(
                service, METHODID_GET_TUNED_MODEL)))
        .addMethod(
          getListTunedModelsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest,
              com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse>(
                service, METHODID_LIST_TUNED_MODELS)))
        .addMethod(
          getCreateTunedModelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.CreateTunedModelRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_TUNED_MODEL)))
        .addMethod(
          getUpdateTunedModelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.UpdateTunedModelRequest,
              com.google.ai.generativelanguage.v1beta3.TunedModel>(
                service, METHODID_UPDATE_TUNED_MODEL)))
        .addMethod(
          getDeleteTunedModelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.ai.generativelanguage.v1beta3.DeleteTunedModelRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_TUNED_MODEL)))
        .build();
  }

  private static abstract class ModelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModelServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ai.generativelanguage.v1beta3.ModelServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModelService");
    }
  }

  private static final class ModelServiceFileDescriptorSupplier
      extends ModelServiceBaseDescriptorSupplier {
    ModelServiceFileDescriptorSupplier() {}
  }

  private static final class ModelServiceMethodDescriptorSupplier
      extends ModelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ModelServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ModelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ModelServiceFileDescriptorSupplier())
              .addMethod(getGetModelMethod())
              .addMethod(getListModelsMethod())
              .addMethod(getGetTunedModelMethod())
              .addMethod(getListTunedModelsMethod())
              .addMethod(getCreateTunedModelMethod())
              .addMethod(getUpdateTunedModelMethod())
              .addMethod(getDeleteTunedModelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
