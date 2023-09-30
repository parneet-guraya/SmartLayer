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

import com.google.ai.generativelanguage.v1beta3.stub.PermissionServiceStub;
import com.google.ai.generativelanguage.v1beta3.stub.PermissionServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for managing permissions to PaLM API resources.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
 *   TunedModelName parent = TunedModelName.of("[TUNED_MODEL]");
 *   Permission permission = Permission.newBuilder().build();
 *   Permission response = permissionServiceClient.createPermission(parent, permission);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PermissionServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of PermissionServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PermissionServiceSettings permissionServiceSettings =
 *     PermissionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PermissionServiceClient permissionServiceClient =
 *     PermissionServiceClient.create(permissionServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PermissionServiceSettings permissionServiceSettings =
 *     PermissionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PermissionServiceClient permissionServiceClient =
 *     PermissionServiceClient.create(permissionServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PermissionServiceSettings permissionServiceSettings =
 *     PermissionServiceSettings.newHttpJsonBuilder().build();
 * PermissionServiceClient permissionServiceClient =
 *     PermissionServiceClient.create(permissionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PermissionServiceClient implements BackgroundResource {
  private final PermissionServiceSettings settings;
  private final PermissionServiceStub stub;

  /** Constructs an instance of PermissionServiceClient with default settings. */
  public static final PermissionServiceClient create() throws IOException {
    return create(PermissionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PermissionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PermissionServiceClient create(PermissionServiceSettings settings)
      throws IOException {
    return new PermissionServiceClient(settings);
  }

  /**
   * Constructs an instance of PermissionServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(PermissionServiceSettings).
   */
  public static final PermissionServiceClient create(PermissionServiceStub stub) {
    return new PermissionServiceClient(stub);
  }

  /**
   * Constructs an instance of PermissionServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PermissionServiceClient(PermissionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PermissionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PermissionServiceClient(PermissionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PermissionServiceSettings getSettings() {
    return settings;
  }

  public PermissionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a permission to a specific resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   TunedModelName parent = TunedModelName.of("[TUNED_MODEL]");
   *   Permission permission = Permission.newBuilder().build();
   *   Permission response = permissionServiceClient.createPermission(parent, permission);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `Permission`. Format:
   *     tunedModels/{tuned_model}
   * @param permission Required. The permission to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Permission createPermission(TunedModelName parent, Permission permission) {
    CreatePermissionRequest request =
        CreatePermissionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPermission(permission)
            .build();
    return createPermission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a permission to a specific resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   String parent = TunedModelName.of("[TUNED_MODEL]").toString();
   *   Permission permission = Permission.newBuilder().build();
   *   Permission response = permissionServiceClient.createPermission(parent, permission);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `Permission`. Format:
   *     tunedModels/{tuned_model}
   * @param permission Required. The permission to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Permission createPermission(String parent, Permission permission) {
    CreatePermissionRequest request =
        CreatePermissionRequest.newBuilder().setParent(parent).setPermission(permission).build();
    return createPermission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a permission to a specific resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   CreatePermissionRequest request =
   *       CreatePermissionRequest.newBuilder()
   *           .setParent(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .setPermission(Permission.newBuilder().build())
   *           .build();
   *   Permission response = permissionServiceClient.createPermission(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Permission createPermission(CreatePermissionRequest request) {
    return createPermissionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a permission to a specific resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   CreatePermissionRequest request =
   *       CreatePermissionRequest.newBuilder()
   *           .setParent(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .setPermission(Permission.newBuilder().build())
   *           .build();
   *   ApiFuture<Permission> future =
   *       permissionServiceClient.createPermissionCallable().futureCall(request);
   *   // Do something.
   *   Permission response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePermissionRequest, Permission> createPermissionCallable() {
    return stub.createPermissionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific Permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   PermissionName name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]");
   *   Permission response = permissionServiceClient.getPermission(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the permission.
   *     <p>Format: `tunedModels/{tuned_model}permissions/{permission}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Permission getPermission(PermissionName name) {
    GetPermissionRequest request =
        GetPermissionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPermission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific Permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   String name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString();
   *   Permission response = permissionServiceClient.getPermission(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the permission.
   *     <p>Format: `tunedModels/{tuned_model}permissions/{permission}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Permission getPermission(String name) {
    GetPermissionRequest request = GetPermissionRequest.newBuilder().setName(name).build();
    return getPermission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific Permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   GetPermissionRequest request =
   *       GetPermissionRequest.newBuilder()
   *           .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
   *           .build();
   *   Permission response = permissionServiceClient.getPermission(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Permission getPermission(GetPermissionRequest request) {
    return getPermissionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific Permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   GetPermissionRequest request =
   *       GetPermissionRequest.newBuilder()
   *           .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
   *           .build();
   *   ApiFuture<Permission> future =
   *       permissionServiceClient.getPermissionCallable().futureCall(request);
   *   // Do something.
   *   Permission response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPermissionRequest, Permission> getPermissionCallable() {
    return stub.getPermissionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permissions for the specific resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   ResourceName parent = TunedModelName.of("[TUNED_MODEL]");
   *   for (Permission element : permissionServiceClient.listPermissions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the permissions. Format:
   *     tunedModels/{tuned_model}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPermissionsPagedResponse listPermissions(ResourceName parent) {
    ListPermissionsRequest request =
        ListPermissionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permissions for the specific resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   String parent = ModelName.of("[MODEL]").toString();
   *   for (Permission element : permissionServiceClient.listPermissions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the permissions. Format:
   *     tunedModels/{tuned_model}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPermissionsPagedResponse listPermissions(String parent) {
    ListPermissionsRequest request = ListPermissionsRequest.newBuilder().setParent(parent).build();
    return listPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permissions for the specific resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   ListPermissionsRequest request =
   *       ListPermissionsRequest.newBuilder()
   *           .setParent(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Permission element : permissionServiceClient.listPermissions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPermissionsPagedResponse listPermissions(ListPermissionsRequest request) {
    return listPermissionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permissions for the specific resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   ListPermissionsRequest request =
   *       ListPermissionsRequest.newBuilder()
   *           .setParent(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Permission> future =
   *       permissionServiceClient.listPermissionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Permission element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPermissionsRequest, ListPermissionsPagedResponse>
      listPermissionsPagedCallable() {
    return stub.listPermissionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permissions for the specific resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   ListPermissionsRequest request =
   *       ListPermissionsRequest.newBuilder()
   *           .setParent(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPermissionsResponse response =
   *         permissionServiceClient.listPermissionsCallable().call(request);
   *     for (Permission element : response.getPermissionsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPermissionsRequest, ListPermissionsResponse>
      listPermissionsCallable() {
    return stub.listPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   Permission permission = Permission.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Permission response = permissionServiceClient.updatePermission(permission, updateMask);
   * }
   * }</pre>
   *
   * @param permission Required. The permission to update.
   *     <p>The permission's `name` field is used to identify the permission to update.
   * @param updateMask Required. The list of fields to update. Accepted ones: - role
   *     (`Permission.role` field)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Permission updatePermission(Permission permission, FieldMask updateMask) {
    UpdatePermissionRequest request =
        UpdatePermissionRequest.newBuilder()
            .setPermission(permission)
            .setUpdateMask(updateMask)
            .build();
    return updatePermission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   UpdatePermissionRequest request =
   *       UpdatePermissionRequest.newBuilder()
   *           .setPermission(Permission.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Permission response = permissionServiceClient.updatePermission(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Permission updatePermission(UpdatePermissionRequest request) {
    return updatePermissionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   UpdatePermissionRequest request =
   *       UpdatePermissionRequest.newBuilder()
   *           .setPermission(Permission.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Permission> future =
   *       permissionServiceClient.updatePermissionCallable().futureCall(request);
   *   // Do something.
   *   Permission response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePermissionRequest, Permission> updatePermissionCallable() {
    return stub.updatePermissionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   PermissionName name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]");
   *   permissionServiceClient.deletePermission(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the permission. Format:
   *     `tunedModels/{tuned_model}/permissions/{permission}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePermission(PermissionName name) {
    DeletePermissionRequest request =
        DeletePermissionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deletePermission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   String name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString();
   *   permissionServiceClient.deletePermission(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the permission. Format:
   *     `tunedModels/{tuned_model}/permissions/{permission}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePermission(String name) {
    DeletePermissionRequest request = DeletePermissionRequest.newBuilder().setName(name).build();
    deletePermission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   DeletePermissionRequest request =
   *       DeletePermissionRequest.newBuilder()
   *           .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
   *           .build();
   *   permissionServiceClient.deletePermission(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePermission(DeletePermissionRequest request) {
    deletePermissionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   DeletePermissionRequest request =
   *       DeletePermissionRequest.newBuilder()
   *           .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       permissionServiceClient.deletePermissionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePermissionRequest, Empty> deletePermissionCallable() {
    return stub.deletePermissionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers ownership of the tuned model. This is the only way to change ownership of the tuned
   * model. The current owner will be downgraded to writer role.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   TransferOwnershipRequest request =
   *       TransferOwnershipRequest.newBuilder()
   *           .setName(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .setEmailAddress("emailAddress-1070931784")
   *           .build();
   *   TransferOwnershipResponse response = permissionServiceClient.transferOwnership(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TransferOwnershipResponse transferOwnership(TransferOwnershipRequest request) {
    return transferOwnershipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers ownership of the tuned model. This is the only way to change ownership of the tuned
   * model. The current owner will be downgraded to writer role.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PermissionServiceClient permissionServiceClient = PermissionServiceClient.create()) {
   *   TransferOwnershipRequest request =
   *       TransferOwnershipRequest.newBuilder()
   *           .setName(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .setEmailAddress("emailAddress-1070931784")
   *           .build();
   *   ApiFuture<TransferOwnershipResponse> future =
   *       permissionServiceClient.transferOwnershipCallable().futureCall(request);
   *   // Do something.
   *   TransferOwnershipResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferOwnershipRequest, TransferOwnershipResponse>
      transferOwnershipCallable() {
    return stub.transferOwnershipCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListPermissionsPagedResponse
      extends AbstractPagedListResponse<
          ListPermissionsRequest,
          ListPermissionsResponse,
          Permission,
          ListPermissionsPage,
          ListPermissionsFixedSizeCollection> {

    public static ApiFuture<ListPermissionsPagedResponse> createAsync(
        PageContext<ListPermissionsRequest, ListPermissionsResponse, Permission> context,
        ApiFuture<ListPermissionsResponse> futureResponse) {
      ApiFuture<ListPermissionsPage> futurePage =
          ListPermissionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPermissionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPermissionsPagedResponse(ListPermissionsPage page) {
      super(page, ListPermissionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPermissionsPage
      extends AbstractPage<
          ListPermissionsRequest, ListPermissionsResponse, Permission, ListPermissionsPage> {

    private ListPermissionsPage(
        PageContext<ListPermissionsRequest, ListPermissionsResponse, Permission> context,
        ListPermissionsResponse response) {
      super(context, response);
    }

    private static ListPermissionsPage createEmptyPage() {
      return new ListPermissionsPage(null, null);
    }

    @Override
    protected ListPermissionsPage createPage(
        PageContext<ListPermissionsRequest, ListPermissionsResponse, Permission> context,
        ListPermissionsResponse response) {
      return new ListPermissionsPage(context, response);
    }

    @Override
    public ApiFuture<ListPermissionsPage> createPageAsync(
        PageContext<ListPermissionsRequest, ListPermissionsResponse, Permission> context,
        ApiFuture<ListPermissionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPermissionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPermissionsRequest,
          ListPermissionsResponse,
          Permission,
          ListPermissionsPage,
          ListPermissionsFixedSizeCollection> {

    private ListPermissionsFixedSizeCollection(
        List<ListPermissionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPermissionsFixedSizeCollection createEmptyCollection() {
      return new ListPermissionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPermissionsFixedSizeCollection createCollection(
        List<ListPermissionsPage> pages, int collectionSize) {
      return new ListPermissionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
