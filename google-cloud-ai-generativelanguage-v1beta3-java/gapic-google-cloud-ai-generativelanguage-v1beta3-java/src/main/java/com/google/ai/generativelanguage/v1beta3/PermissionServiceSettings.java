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

package com.google.ai.generativelanguage.v1beta3;

import static com.google.ai.generativelanguage.v1beta3.PermissionServiceClient.ListPermissionsPagedResponse;

import com.google.ai.generativelanguage.v1beta3.stub.PermissionServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PermissionServiceClient}.
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
 * <p>For example, to set the total timeout of createPermission to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PermissionServiceSettings.Builder permissionServiceSettingsBuilder =
 *     PermissionServiceSettings.newBuilder();
 * permissionServiceSettingsBuilder
 *     .createPermissionSettings()
 *     .setRetrySettings(
 *         permissionServiceSettingsBuilder
 *             .createPermissionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PermissionServiceSettings permissionServiceSettings = permissionServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PermissionServiceSettings extends ClientSettings<PermissionServiceSettings> {

  /** Returns the object with the settings used for calls to createPermission. */
  public UnaryCallSettings<CreatePermissionRequest, Permission> createPermissionSettings() {
    return ((PermissionServiceStubSettings) getStubSettings()).createPermissionSettings();
  }

  /** Returns the object with the settings used for calls to getPermission. */
  public UnaryCallSettings<GetPermissionRequest, Permission> getPermissionSettings() {
    return ((PermissionServiceStubSettings) getStubSettings()).getPermissionSettings();
  }

  /** Returns the object with the settings used for calls to listPermissions. */
  public PagedCallSettings<
          ListPermissionsRequest, ListPermissionsResponse, ListPermissionsPagedResponse>
      listPermissionsSettings() {
    return ((PermissionServiceStubSettings) getStubSettings()).listPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to updatePermission. */
  public UnaryCallSettings<UpdatePermissionRequest, Permission> updatePermissionSettings() {
    return ((PermissionServiceStubSettings) getStubSettings()).updatePermissionSettings();
  }

  /** Returns the object with the settings used for calls to deletePermission. */
  public UnaryCallSettings<DeletePermissionRequest, Empty> deletePermissionSettings() {
    return ((PermissionServiceStubSettings) getStubSettings()).deletePermissionSettings();
  }

  /** Returns the object with the settings used for calls to transferOwnership. */
  public UnaryCallSettings<TransferOwnershipRequest, TransferOwnershipResponse>
      transferOwnershipSettings() {
    return ((PermissionServiceStubSettings) getStubSettings()).transferOwnershipSettings();
  }

  public static final PermissionServiceSettings create(PermissionServiceStubSettings stub)
      throws IOException {
    return new PermissionServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PermissionServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PermissionServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PermissionServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PermissionServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PermissionServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PermissionServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PermissionServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PermissionServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected PermissionServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PermissionServiceSettings. */
  public static class Builder extends ClientSettings.Builder<PermissionServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PermissionServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(PermissionServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PermissionServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PermissionServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(PermissionServiceStubSettings.newHttpJsonBuilder());
    }

    public PermissionServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((PermissionServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createPermission. */
    public UnaryCallSettings.Builder<CreatePermissionRequest, Permission>
        createPermissionSettings() {
      return getStubSettingsBuilder().createPermissionSettings();
    }

    /** Returns the builder for the settings used for calls to getPermission. */
    public UnaryCallSettings.Builder<GetPermissionRequest, Permission> getPermissionSettings() {
      return getStubSettingsBuilder().getPermissionSettings();
    }

    /** Returns the builder for the settings used for calls to listPermissions. */
    public PagedCallSettings.Builder<
            ListPermissionsRequest, ListPermissionsResponse, ListPermissionsPagedResponse>
        listPermissionsSettings() {
      return getStubSettingsBuilder().listPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to updatePermission. */
    public UnaryCallSettings.Builder<UpdatePermissionRequest, Permission>
        updatePermissionSettings() {
      return getStubSettingsBuilder().updatePermissionSettings();
    }

    /** Returns the builder for the settings used for calls to deletePermission. */
    public UnaryCallSettings.Builder<DeletePermissionRequest, Empty> deletePermissionSettings() {
      return getStubSettingsBuilder().deletePermissionSettings();
    }

    /** Returns the builder for the settings used for calls to transferOwnership. */
    public UnaryCallSettings.Builder<TransferOwnershipRequest, TransferOwnershipResponse>
        transferOwnershipSettings() {
      return getStubSettingsBuilder().transferOwnershipSettings();
    }

    @Override
    public PermissionServiceSettings build() throws IOException {
      return new PermissionServiceSettings(this);
    }
  }
}
