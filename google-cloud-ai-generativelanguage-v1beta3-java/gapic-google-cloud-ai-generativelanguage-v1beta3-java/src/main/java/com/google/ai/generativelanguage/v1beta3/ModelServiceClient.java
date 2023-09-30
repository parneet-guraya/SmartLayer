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

import com.google.ai.generativelanguage.v1beta3.stub.ModelServiceStub;
import com.google.ai.generativelanguage.v1beta3.stub.ModelServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for getting metadata information about Generative Models.
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
 * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
 *   ModelName name = ModelName.of("[MODEL]");
 *   Model response = modelServiceClient.getModel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ModelServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ModelServiceSettings to
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
 * ModelServiceSettings modelServiceSettings =
 *     ModelServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings);
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
 * ModelServiceSettings modelServiceSettings =
 *     ModelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings);
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
 * ModelServiceSettings modelServiceSettings = ModelServiceSettings.newHttpJsonBuilder().build();
 * ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelServiceClient implements BackgroundResource {
  private final ModelServiceSettings settings;
  private final ModelServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ModelServiceClient with default settings. */
  public static final ModelServiceClient create() throws IOException {
    return create(ModelServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ModelServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ModelServiceClient create(ModelServiceSettings settings) throws IOException {
    return new ModelServiceClient(settings);
  }

  /**
   * Constructs an instance of ModelServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ModelServiceSettings).
   */
  public static final ModelServiceClient create(ModelServiceStub stub) {
    return new ModelServiceClient(stub);
  }

  /**
   * Constructs an instance of ModelServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ModelServiceClient(ModelServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ModelServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ModelServiceClient(ModelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ModelServiceSettings getSettings() {
    return settings;
  }

  public ModelServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ModelName name = ModelName.of("[MODEL]");
   *   Model response = modelServiceClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model.
   *     <p>This name should match a model name returned by the `ListModels` method.
   *     <p>Format: `models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(ModelName name) {
    GetModelRequest request =
        GetModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = ModelName.of("[MODEL]").toString();
   *   Model response = modelServiceClient.getModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model.
   *     <p>This name should match a model name returned by the `ListModels` method.
   *     <p>Format: `models/{model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(String name) {
    GetModelRequest request = GetModelRequest.newBuilder().setName(name).build();
    return getModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder().setName(ModelName.of("[MODEL]").toString()).build();
   *   Model response = modelServiceClient.getModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Model getModel(GetModelRequest request) {
    return getModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific Model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetModelRequest request =
   *       GetModelRequest.newBuilder().setName(ModelName.of("[MODEL]").toString()).build();
   *   ApiFuture<Model> future = modelServiceClient.getModelCallable().futureCall(request);
   *   // Do something.
   *   Model response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return stub.getModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models available through the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   int pageSize = 883849137;
   *   String pageToken = "pageToken873572522";
   *   for (Model element : modelServiceClient.listModels(pageSize, pageToken).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param pageSize The maximum number of `Models` to return (per page).
   *     <p>The service may return fewer models. If unspecified, at most 50 models will be returned
   *     per page. This method returns at most 1000 models per page, even if you pass a larger
   *     page_size.
   * @param pageToken A page token, received from a previous `ListModels` call.
   *     <p>Provide the `page_token` returned by one request as an argument to the next request to
   *     retrieve the next page.
   *     <p>When paginating, all other parameters provided to `ListModels` must match the call that
   *     provided the page token.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(int pageSize, String pageToken) {
    ListModelsRequest request =
        ListModelsRequest.newBuilder().setPageSize(pageSize).setPageToken(pageToken).build();
    return listModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models available through the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Model element : modelServiceClient.listModels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelsPagedResponse listModels(ListModelsRequest request) {
    return listModelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models available through the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Model> future = modelServiceClient.listModelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Model element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return stub.listModelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists models available through the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListModelsRequest request =
   *       ListModelsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListModelsResponse response = modelServiceClient.listModelsCallable().call(request);
   *     for (Model element : response.getModelsList()) {
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
  public final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return stub.listModelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific TunedModel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   TunedModelName name = TunedModelName.of("[TUNED_MODEL]");
   *   TunedModel response = modelServiceClient.getTunedModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model.
   *     <p>Format: `tunedModels/my-model-id`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunedModel getTunedModel(TunedModelName name) {
    GetTunedModelRequest request =
        GetTunedModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTunedModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific TunedModel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = TunedModelName.of("[TUNED_MODEL]").toString();
   *   TunedModel response = modelServiceClient.getTunedModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model.
   *     <p>Format: `tunedModels/my-model-id`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunedModel getTunedModel(String name) {
    GetTunedModelRequest request = GetTunedModelRequest.newBuilder().setName(name).build();
    return getTunedModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific TunedModel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetTunedModelRequest request =
   *       GetTunedModelRequest.newBuilder()
   *           .setName(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .build();
   *   TunedModel response = modelServiceClient.getTunedModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunedModel getTunedModel(GetTunedModelRequest request) {
    return getTunedModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a specific TunedModel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   GetTunedModelRequest request =
   *       GetTunedModelRequest.newBuilder()
   *           .setName(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .build();
   *   ApiFuture<TunedModel> future = modelServiceClient.getTunedModelCallable().futureCall(request);
   *   // Do something.
   *   TunedModel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTunedModelRequest, TunedModel> getTunedModelCallable() {
    return stub.getTunedModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tuned models owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   int pageSize = 883849137;
   *   String pageToken = "pageToken873572522";
   *   for (TunedModel element :
   *       modelServiceClient.listTunedModels(pageSize, pageToken).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param pageSize Optional. The maximum number of `TunedModels` to return (per page). The service
   *     may return fewer tuned models.
   *     <p>If unspecified, at most 10 tuned models will be returned. This method returns at most
   *     1000 models per page, even if you pass a larger page_size.
   * @param pageToken Optional. A page token, received from a previous `ListTunedModels` call.
   *     <p>Provide the `page_token` returned by one request as an argument to the next request to
   *     retrieve the next page.
   *     <p>When paginating, all other parameters provided to `ListTunedModels` must match the call
   *     that provided the page token.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTunedModelsPagedResponse listTunedModels(int pageSize, String pageToken) {
    ListTunedModelsRequest request =
        ListTunedModelsRequest.newBuilder().setPageSize(pageSize).setPageToken(pageToken).build();
    return listTunedModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tuned models owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListTunedModelsRequest request =
   *       ListTunedModelsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TunedModel element : modelServiceClient.listTunedModels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTunedModelsPagedResponse listTunedModels(ListTunedModelsRequest request) {
    return listTunedModelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tuned models owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListTunedModelsRequest request =
   *       ListTunedModelsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TunedModel> future =
   *       modelServiceClient.listTunedModelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TunedModel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTunedModelsRequest, ListTunedModelsPagedResponse>
      listTunedModelsPagedCallable() {
    return stub.listTunedModelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tuned models owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   ListTunedModelsRequest request =
   *       ListTunedModelsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTunedModelsResponse response =
   *         modelServiceClient.listTunedModelsCallable().call(request);
   *     for (TunedModel element : response.getTunedModelsList()) {
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
  public final UnaryCallable<ListTunedModelsRequest, ListTunedModelsResponse>
      listTunedModelsCallable() {
    return stub.listTunedModelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tuned model. Intermediate tuning progress (if any) is accessed through the
   * [google.longrunning.Operations] service.
   *
   * <p>Status and results can be accessed through the Operations service. Example: GET
   * /v1/tunedModels/az2mb0bpw6i/operations/000-111-222
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   TunedModel tunedModel = TunedModel.newBuilder().build();
   *   TunedModel response = modelServiceClient.createTunedModelAsync(tunedModel).get();
   * }
   * }</pre>
   *
   * @param tunedModel Required. The tuned model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TunedModel, CreateTunedModelMetadata> createTunedModelAsync(
      TunedModel tunedModel) {
    CreateTunedModelRequest request =
        CreateTunedModelRequest.newBuilder().setTunedModel(tunedModel).build();
    return createTunedModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tuned model. Intermediate tuning progress (if any) is accessed through the
   * [google.longrunning.Operations] service.
   *
   * <p>Status and results can be accessed through the Operations service. Example: GET
   * /v1/tunedModels/az2mb0bpw6i/operations/000-111-222
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String tunedModelId = "tunedModelId1071842584";
   *   TunedModel tunedModel = TunedModel.newBuilder().build();
   *   TunedModel response =
   *       modelServiceClient.createTunedModelAsync(tunedModelId, tunedModel).get();
   * }
   * }</pre>
   *
   * @param tunedModelId Optional. The unique id for the tuned model if specified. This value should
   *     be up to 40 characters, the first character must be a letter, the last could be a letter or
   *     a number. The id must match the regular expression: [a-z]([a-z0-9-]{0,38}[a-z0-9])?.
   * @param tunedModel Required. The tuned model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TunedModel, CreateTunedModelMetadata> createTunedModelAsync(
      String tunedModelId, TunedModel tunedModel) {
    CreateTunedModelRequest request =
        CreateTunedModelRequest.newBuilder()
            .setTunedModelId(tunedModelId)
            .setTunedModel(tunedModel)
            .build();
    return createTunedModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tuned model. Intermediate tuning progress (if any) is accessed through the
   * [google.longrunning.Operations] service.
   *
   * <p>Status and results can be accessed through the Operations service. Example: GET
   * /v1/tunedModels/az2mb0bpw6i/operations/000-111-222
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   CreateTunedModelRequest request =
   *       CreateTunedModelRequest.newBuilder()
   *           .setTunedModelId("tunedModelId1071842584")
   *           .setTunedModel(TunedModel.newBuilder().build())
   *           .build();
   *   TunedModel response = modelServiceClient.createTunedModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TunedModel, CreateTunedModelMetadata> createTunedModelAsync(
      CreateTunedModelRequest request) {
    return createTunedModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tuned model. Intermediate tuning progress (if any) is accessed through the
   * [google.longrunning.Operations] service.
   *
   * <p>Status and results can be accessed through the Operations service. Example: GET
   * /v1/tunedModels/az2mb0bpw6i/operations/000-111-222
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   CreateTunedModelRequest request =
   *       CreateTunedModelRequest.newBuilder()
   *           .setTunedModelId("tunedModelId1071842584")
   *           .setTunedModel(TunedModel.newBuilder().build())
   *           .build();
   *   OperationFuture<TunedModel, CreateTunedModelMetadata> future =
   *       modelServiceClient.createTunedModelOperationCallable().futureCall(request);
   *   // Do something.
   *   TunedModel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTunedModelRequest, TunedModel, CreateTunedModelMetadata>
      createTunedModelOperationCallable() {
    return stub.createTunedModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tuned model. Intermediate tuning progress (if any) is accessed through the
   * [google.longrunning.Operations] service.
   *
   * <p>Status and results can be accessed through the Operations service. Example: GET
   * /v1/tunedModels/az2mb0bpw6i/operations/000-111-222
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   CreateTunedModelRequest request =
   *       CreateTunedModelRequest.newBuilder()
   *           .setTunedModelId("tunedModelId1071842584")
   *           .setTunedModel(TunedModel.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       modelServiceClient.createTunedModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTunedModelRequest, Operation> createTunedModelCallable() {
    return stub.createTunedModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tuned model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   TunedModel tunedModel = TunedModel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TunedModel response = modelServiceClient.updateTunedModel(tunedModel, updateMask);
   * }
   * }</pre>
   *
   * @param tunedModel Required. The tuned model to update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunedModel updateTunedModel(TunedModel tunedModel, FieldMask updateMask) {
    UpdateTunedModelRequest request =
        UpdateTunedModelRequest.newBuilder()
            .setTunedModel(tunedModel)
            .setUpdateMask(updateMask)
            .build();
    return updateTunedModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tuned model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UpdateTunedModelRequest request =
   *       UpdateTunedModelRequest.newBuilder()
   *           .setTunedModel(TunedModel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TunedModel response = modelServiceClient.updateTunedModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunedModel updateTunedModel(UpdateTunedModelRequest request) {
    return updateTunedModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tuned model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   UpdateTunedModelRequest request =
   *       UpdateTunedModelRequest.newBuilder()
   *           .setTunedModel(TunedModel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TunedModel> future =
   *       modelServiceClient.updateTunedModelCallable().futureCall(request);
   *   // Do something.
   *   TunedModel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTunedModelRequest, TunedModel> updateTunedModelCallable() {
    return stub.updateTunedModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tuned model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   TunedModelName name = TunedModelName.of("[TUNED_MODEL]");
   *   modelServiceClient.deleteTunedModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model. Format: `tunedModels/my-model-id`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTunedModel(TunedModelName name) {
    DeleteTunedModelRequest request =
        DeleteTunedModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTunedModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tuned model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   String name = TunedModelName.of("[TUNED_MODEL]").toString();
   *   modelServiceClient.deleteTunedModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model. Format: `tunedModels/my-model-id`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTunedModel(String name) {
    DeleteTunedModelRequest request = DeleteTunedModelRequest.newBuilder().setName(name).build();
    deleteTunedModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tuned model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteTunedModelRequest request =
   *       DeleteTunedModelRequest.newBuilder()
   *           .setName(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .build();
   *   modelServiceClient.deleteTunedModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTunedModel(DeleteTunedModelRequest request) {
    deleteTunedModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tuned model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
   *   DeleteTunedModelRequest request =
   *       DeleteTunedModelRequest.newBuilder()
   *           .setName(TunedModelName.of("[TUNED_MODEL]").toString())
   *           .build();
   *   ApiFuture<Empty> future = modelServiceClient.deleteTunedModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTunedModelRequest, Empty> deleteTunedModelCallable() {
    return stub.deleteTunedModelCallable();
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

  public static class ListModelsPagedResponse
      extends AbstractPagedListResponse<
          ListModelsRequest,
          ListModelsResponse,
          Model,
          ListModelsPage,
          ListModelsFixedSizeCollection> {

    public static ApiFuture<ListModelsPagedResponse> createAsync(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ApiFuture<ListModelsResponse> futureResponse) {
      ApiFuture<ListModelsPage> futurePage =
          ListModelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListModelsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListModelsPagedResponse(ListModelsPage page) {
      super(page, ListModelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelsPage
      extends AbstractPage<ListModelsRequest, ListModelsResponse, Model, ListModelsPage> {

    private ListModelsPage(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ListModelsResponse response) {
      super(context, response);
    }

    private static ListModelsPage createEmptyPage() {
      return new ListModelsPage(null, null);
    }

    @Override
    protected ListModelsPage createPage(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ListModelsResponse response) {
      return new ListModelsPage(context, response);
    }

    @Override
    public ApiFuture<ListModelsPage> createPageAsync(
        PageContext<ListModelsRequest, ListModelsResponse, Model> context,
        ApiFuture<ListModelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelsRequest,
          ListModelsResponse,
          Model,
          ListModelsPage,
          ListModelsFixedSizeCollection> {

    private ListModelsFixedSizeCollection(List<ListModelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelsFixedSizeCollection createEmptyCollection() {
      return new ListModelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelsFixedSizeCollection createCollection(
        List<ListModelsPage> pages, int collectionSize) {
      return new ListModelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTunedModelsPagedResponse
      extends AbstractPagedListResponse<
          ListTunedModelsRequest,
          ListTunedModelsResponse,
          TunedModel,
          ListTunedModelsPage,
          ListTunedModelsFixedSizeCollection> {

    public static ApiFuture<ListTunedModelsPagedResponse> createAsync(
        PageContext<ListTunedModelsRequest, ListTunedModelsResponse, TunedModel> context,
        ApiFuture<ListTunedModelsResponse> futureResponse) {
      ApiFuture<ListTunedModelsPage> futurePage =
          ListTunedModelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTunedModelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTunedModelsPagedResponse(ListTunedModelsPage page) {
      super(page, ListTunedModelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTunedModelsPage
      extends AbstractPage<
          ListTunedModelsRequest, ListTunedModelsResponse, TunedModel, ListTunedModelsPage> {

    private ListTunedModelsPage(
        PageContext<ListTunedModelsRequest, ListTunedModelsResponse, TunedModel> context,
        ListTunedModelsResponse response) {
      super(context, response);
    }

    private static ListTunedModelsPage createEmptyPage() {
      return new ListTunedModelsPage(null, null);
    }

    @Override
    protected ListTunedModelsPage createPage(
        PageContext<ListTunedModelsRequest, ListTunedModelsResponse, TunedModel> context,
        ListTunedModelsResponse response) {
      return new ListTunedModelsPage(context, response);
    }

    @Override
    public ApiFuture<ListTunedModelsPage> createPageAsync(
        PageContext<ListTunedModelsRequest, ListTunedModelsResponse, TunedModel> context,
        ApiFuture<ListTunedModelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTunedModelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTunedModelsRequest,
          ListTunedModelsResponse,
          TunedModel,
          ListTunedModelsPage,
          ListTunedModelsFixedSizeCollection> {

    private ListTunedModelsFixedSizeCollection(
        List<ListTunedModelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTunedModelsFixedSizeCollection createEmptyCollection() {
      return new ListTunedModelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTunedModelsFixedSizeCollection createCollection(
        List<ListTunedModelsPage> pages, int collectionSize) {
      return new ListTunedModelsFixedSizeCollection(pages, collectionSize);
    }
  }
}
