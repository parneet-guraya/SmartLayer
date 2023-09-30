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
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (generativelanguage.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getModel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelServiceStubSettings.Builder modelServiceSettingsBuilder =
 *     ModelServiceStubSettings.newBuilder();
 * modelServiceSettingsBuilder
 *     .getModelSettings()
 *     .setRetrySettings(
 *         modelServiceSettingsBuilder
 *             .getModelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ModelServiceStubSettings modelServiceSettings = modelServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelServiceStubSettings extends StubSettings<ModelServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<GetModelRequest, Model> getModelSettings;
  private final PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings;
  private final UnaryCallSettings<GetTunedModelRequest, TunedModel> getTunedModelSettings;
  private final PagedCallSettings<
          ListTunedModelsRequest, ListTunedModelsResponse, ListTunedModelsPagedResponse>
      listTunedModelsSettings;
  private final UnaryCallSettings<CreateTunedModelRequest, Operation> createTunedModelSettings;
  private final OperationCallSettings<CreateTunedModelRequest, TunedModel, CreateTunedModelMetadata>
      createTunedModelOperationSettings;
  private final UnaryCallSettings<UpdateTunedModelRequest, TunedModel> updateTunedModelSettings;
  private final UnaryCallSettings<DeleteTunedModelRequest, Empty> deleteTunedModelSettings;

  private static final PagedListDescriptor<ListModelsRequest, ListModelsResponse, Model>
      LIST_MODELS_PAGE_STR_DESC =
          new PagedListDescriptor<ListModelsRequest, ListModelsResponse, Model>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListModelsRequest injectToken(ListModelsRequest payload, String token) {
              return ListModelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListModelsRequest injectPageSize(ListModelsRequest payload, int pageSize) {
              return ListModelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListModelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListModelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Model> extractResources(ListModelsResponse payload) {
              return payload.getModelsList() == null
                  ? ImmutableList.<Model>of()
                  : payload.getModelsList();
            }
          };

  private static final PagedListDescriptor<
          ListTunedModelsRequest, ListTunedModelsResponse, TunedModel>
      LIST_TUNED_MODELS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTunedModelsRequest, ListTunedModelsResponse, TunedModel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTunedModelsRequest injectToken(
                ListTunedModelsRequest payload, String token) {
              return ListTunedModelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTunedModelsRequest injectPageSize(
                ListTunedModelsRequest payload, int pageSize) {
              return ListTunedModelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTunedModelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTunedModelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TunedModel> extractResources(ListTunedModelsResponse payload) {
              return payload.getTunedModelsList() == null
                  ? ImmutableList.<TunedModel>of()
                  : payload.getTunedModelsList();
            }
          };

  private static final PagedListResponseFactory<
          ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      LIST_MODELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>() {
            @Override
            public ApiFuture<ListModelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListModelsRequest, ListModelsResponse> callable,
                ListModelsRequest request,
                ApiCallContext context,
                ApiFuture<ListModelsResponse> futureResponse) {
              PageContext<ListModelsRequest, ListModelsResponse, Model> pageContext =
                  PageContext.create(callable, LIST_MODELS_PAGE_STR_DESC, request, context);
              return ListModelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTunedModelsRequest, ListTunedModelsResponse, ListTunedModelsPagedResponse>
      LIST_TUNED_MODELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTunedModelsRequest, ListTunedModelsResponse, ListTunedModelsPagedResponse>() {
            @Override
            public ApiFuture<ListTunedModelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTunedModelsRequest, ListTunedModelsResponse> callable,
                ListTunedModelsRequest request,
                ApiCallContext context,
                ApiFuture<ListTunedModelsResponse> futureResponse) {
              PageContext<ListTunedModelsRequest, ListTunedModelsResponse, TunedModel> pageContext =
                  PageContext.create(callable, LIST_TUNED_MODELS_PAGE_STR_DESC, request, context);
              return ListTunedModelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getModel. */
  public UnaryCallSettings<GetModelRequest, Model> getModelSettings() {
    return getModelSettings;
  }

  /** Returns the object with the settings used for calls to listModels. */
  public PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings() {
    return listModelsSettings;
  }

  /** Returns the object with the settings used for calls to getTunedModel. */
  public UnaryCallSettings<GetTunedModelRequest, TunedModel> getTunedModelSettings() {
    return getTunedModelSettings;
  }

  /** Returns the object with the settings used for calls to listTunedModels. */
  public PagedCallSettings<
          ListTunedModelsRequest, ListTunedModelsResponse, ListTunedModelsPagedResponse>
      listTunedModelsSettings() {
    return listTunedModelsSettings;
  }

  /** Returns the object with the settings used for calls to createTunedModel. */
  public UnaryCallSettings<CreateTunedModelRequest, Operation> createTunedModelSettings() {
    return createTunedModelSettings;
  }

  /** Returns the object with the settings used for calls to createTunedModel. */
  public OperationCallSettings<CreateTunedModelRequest, TunedModel, CreateTunedModelMetadata>
      createTunedModelOperationSettings() {
    return createTunedModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTunedModel. */
  public UnaryCallSettings<UpdateTunedModelRequest, TunedModel> updateTunedModelSettings() {
    return updateTunedModelSettings;
  }

  /** Returns the object with the settings used for calls to deleteTunedModel. */
  public UnaryCallSettings<DeleteTunedModelRequest, Empty> deleteTunedModelSettings() {
    return deleteTunedModelSettings;
  }

  public ModelServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcModelServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonModelServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "generativelanguage.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "generativelanguage.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ModelServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ModelServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ModelServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ModelServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getModelSettings = settingsBuilder.getModelSettings().build();
    listModelsSettings = settingsBuilder.listModelsSettings().build();
    getTunedModelSettings = settingsBuilder.getTunedModelSettings().build();
    listTunedModelsSettings = settingsBuilder.listTunedModelsSettings().build();
    createTunedModelSettings = settingsBuilder.createTunedModelSettings().build();
    createTunedModelOperationSettings = settingsBuilder.createTunedModelOperationSettings().build();
    updateTunedModelSettings = settingsBuilder.updateTunedModelSettings().build();
    deleteTunedModelSettings = settingsBuilder.deleteTunedModelSettings().build();
  }

  /** Builder for ModelServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ModelServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetModelRequest, Model> getModelSettings;
    private final PagedCallSettings.Builder<
            ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings;
    private final UnaryCallSettings.Builder<GetTunedModelRequest, TunedModel> getTunedModelSettings;
    private final PagedCallSettings.Builder<
            ListTunedModelsRequest, ListTunedModelsResponse, ListTunedModelsPagedResponse>
        listTunedModelsSettings;
    private final UnaryCallSettings.Builder<CreateTunedModelRequest, Operation>
        createTunedModelSettings;
    private final OperationCallSettings.Builder<
            CreateTunedModelRequest, TunedModel, CreateTunedModelMetadata>
        createTunedModelOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTunedModelRequest, TunedModel>
        updateTunedModelSettings;
    private final UnaryCallSettings.Builder<DeleteTunedModelRequest, Empty>
        deleteTunedModelSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listModelsSettings = PagedCallSettings.newBuilder(LIST_MODELS_PAGE_STR_FACT);
      getTunedModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTunedModelsSettings = PagedCallSettings.newBuilder(LIST_TUNED_MODELS_PAGE_STR_FACT);
      createTunedModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTunedModelOperationSettings = OperationCallSettings.newBuilder();
      updateTunedModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTunedModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getModelSettings,
              listModelsSettings,
              getTunedModelSettings,
              listTunedModelsSettings,
              createTunedModelSettings,
              updateTunedModelSettings,
              deleteTunedModelSettings);
      initDefaults(this);
    }

    protected Builder(ModelServiceStubSettings settings) {
      super(settings);

      getModelSettings = settings.getModelSettings.toBuilder();
      listModelsSettings = settings.listModelsSettings.toBuilder();
      getTunedModelSettings = settings.getTunedModelSettings.toBuilder();
      listTunedModelsSettings = settings.listTunedModelsSettings.toBuilder();
      createTunedModelSettings = settings.createTunedModelSettings.toBuilder();
      createTunedModelOperationSettings = settings.createTunedModelOperationSettings.toBuilder();
      updateTunedModelSettings = settings.updateTunedModelSettings.toBuilder();
      deleteTunedModelSettings = settings.deleteTunedModelSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getModelSettings,
              listModelsSettings,
              getTunedModelSettings,
              listTunedModelsSettings,
              createTunedModelSettings,
              updateTunedModelSettings,
              deleteTunedModelSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getTunedModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listTunedModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createTunedModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateTunedModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteTunedModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createTunedModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTunedModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TunedModel.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateTunedModelMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to getModel. */
    public UnaryCallSettings.Builder<GetModelRequest, Model> getModelSettings() {
      return getModelSettings;
    }

    /** Returns the builder for the settings used for calls to listModels. */
    public PagedCallSettings.Builder<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings() {
      return listModelsSettings;
    }

    /** Returns the builder for the settings used for calls to getTunedModel. */
    public UnaryCallSettings.Builder<GetTunedModelRequest, TunedModel> getTunedModelSettings() {
      return getTunedModelSettings;
    }

    /** Returns the builder for the settings used for calls to listTunedModels. */
    public PagedCallSettings.Builder<
            ListTunedModelsRequest, ListTunedModelsResponse, ListTunedModelsPagedResponse>
        listTunedModelsSettings() {
      return listTunedModelsSettings;
    }

    /** Returns the builder for the settings used for calls to createTunedModel. */
    public UnaryCallSettings.Builder<CreateTunedModelRequest, Operation>
        createTunedModelSettings() {
      return createTunedModelSettings;
    }

    /** Returns the builder for the settings used for calls to createTunedModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateTunedModelRequest, TunedModel, CreateTunedModelMetadata>
        createTunedModelOperationSettings() {
      return createTunedModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTunedModel. */
    public UnaryCallSettings.Builder<UpdateTunedModelRequest, TunedModel>
        updateTunedModelSettings() {
      return updateTunedModelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTunedModel. */
    public UnaryCallSettings.Builder<DeleteTunedModelRequest, Empty> deleteTunedModelSettings() {
      return deleteTunedModelSettings;
    }

    @Override
    public ModelServiceStubSettings build() throws IOException {
      return new ModelServiceStubSettings(this);
    }
  }
}
