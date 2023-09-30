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

import static com.google.ai.generativelanguage.v1beta3.ModelServiceClient.ListModelsPagedResponse;
import static com.google.ai.generativelanguage.v1beta3.ModelServiceClient.ListTunedModelsPagedResponse;

import com.google.ai.generativelanguage.v1beta3.stub.HttpJsonModelServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ModelServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ModelServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonModelServiceStub.getMethodDescriptors(),
            ModelServiceSettings.getDefaultEndpoint());
    ModelServiceSettings settings =
        ModelServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ModelServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ModelServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void getModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[MODEL]").toString())
            .setBaseModelId("baseModelId-766553581")
            .setVersion("version351608024")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setInputTokenLimit(907518208)
            .setOutputTokenLimit(-2101721161)
            .addAllSupportedGenerationMethods(new ArrayList<String>())
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .build();
    mockService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[MODEL]");

    Model actualResponse = client.getModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[MODEL]");
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[MODEL]").toString())
            .setBaseModelId("baseModelId-766553581")
            .setVersion("version351608024")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setInputTokenLimit(907518208)
            .setOutputTokenLimit(-2101721161)
            .addAllSupportedGenerationMethods(new ArrayList<String>())
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "models/model-3760";

    Model actualResponse = client.getModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "models/model-3760";
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelsTest() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    int pageSize = 883849137;
    String pageToken = "pageToken873572522";

    ListModelsPagedResponse pagedListResponse = client.listModels(pageSize, pageToken);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listModelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      int pageSize = 883849137;
      String pageToken = "pageToken873572522";
      client.listModels(pageSize, pageToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTunedModelTest() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TunedModelName name = TunedModelName.of("[TUNED_MODEL]");

    TunedModel actualResponse = client.getTunedModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getTunedModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunedModelName name = TunedModelName.of("[TUNED_MODEL]");
      client.getTunedModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTunedModelTest2() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "tunedModels/tunedModel-550";

    TunedModel actualResponse = client.getTunedModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getTunedModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "tunedModels/tunedModel-550";
      client.getTunedModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTunedModelsTest() throws Exception {
    TunedModel responsesElement = TunedModel.newBuilder().build();
    ListTunedModelsResponse expectedResponse =
        ListTunedModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTunedModels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    int pageSize = 883849137;
    String pageToken = "pageToken873572522";

    ListTunedModelsPagedResponse pagedListResponse = client.listTunedModels(pageSize, pageToken);

    List<TunedModel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTunedModelsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listTunedModelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      int pageSize = 883849137;
      String pageToken = "pageToken873572522";
      client.listTunedModels(pageSize, pageToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTunedModelTest() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTunedModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TunedModel tunedModel = TunedModel.newBuilder().build();

    TunedModel actualResponse = client.createTunedModelAsync(tunedModel).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createTunedModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunedModel tunedModel = TunedModel.newBuilder().build();
      client.createTunedModelAsync(tunedModel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createTunedModelTest2() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTunedModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String tunedModelId = "tunedModelId1071842584";
    TunedModel tunedModel = TunedModel.newBuilder().build();

    TunedModel actualResponse = client.createTunedModelAsync(tunedModelId, tunedModel).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createTunedModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String tunedModelId = "tunedModelId1071842584";
      TunedModel tunedModel = TunedModel.newBuilder().build();
      client.createTunedModelAsync(tunedModelId, tunedModel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateTunedModelTest() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TunedModel tunedModel =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TunedModel actualResponse = client.updateTunedModel(tunedModel, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateTunedModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunedModel tunedModel =
          TunedModel.newBuilder()
              .setName(TunedModelName.of("[TUNED_MODEL]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setTemperature(321701236)
              .setTopP(110545926)
              .setTopK(110545921)
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setTuningTask(TuningTask.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTunedModel(tunedModel, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTunedModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TunedModelName name = TunedModelName.of("[TUNED_MODEL]");

    client.deleteTunedModel(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteTunedModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunedModelName name = TunedModelName.of("[TUNED_MODEL]");
      client.deleteTunedModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTunedModelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "tunedModels/tunedModel-550";

    client.deleteTunedModel(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteTunedModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "tunedModels/tunedModel-550";
      client.deleteTunedModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
