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

import com.google.ai.generativelanguage.v1beta3.stub.HttpJsonPermissionServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PermissionServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PermissionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPermissionServiceStub.getMethodDescriptors(),
            PermissionServiceSettings.getDefaultEndpoint());
    PermissionServiceSettings settings =
        PermissionServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PermissionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PermissionServiceClient.create(settings);
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
  public void createPermissionTest() throws Exception {
    Permission expectedResponse =
        Permission.newBuilder()
            .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .build();
    mockService.addResponse(expectedResponse);

    TunedModelName parent = TunedModelName.of("[TUNED_MODEL]");
    Permission permission = Permission.newBuilder().build();

    Permission actualResponse = client.createPermission(parent, permission);
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
  public void createPermissionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TunedModelName parent = TunedModelName.of("[TUNED_MODEL]");
      Permission permission = Permission.newBuilder().build();
      client.createPermission(parent, permission);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPermissionTest2() throws Exception {
    Permission expectedResponse =
        Permission.newBuilder()
            .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "tunedModels/tunedModel-5591";
    Permission permission = Permission.newBuilder().build();

    Permission actualResponse = client.createPermission(parent, permission);
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
  public void createPermissionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "tunedModels/tunedModel-5591";
      Permission permission = Permission.newBuilder().build();
      client.createPermission(parent, permission);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPermissionTest() throws Exception {
    Permission expectedResponse =
        Permission.newBuilder()
            .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .build();
    mockService.addResponse(expectedResponse);

    PermissionName name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]");

    Permission actualResponse = client.getPermission(name);
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
  public void getPermissionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PermissionName name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]");
      client.getPermission(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPermissionTest2() throws Exception {
    Permission expectedResponse =
        Permission.newBuilder()
            .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "tunedModels/tunedModel-7258/permissions/permission-7258";

    Permission actualResponse = client.getPermission(name);
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
  public void getPermissionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "tunedModels/tunedModel-7258/permissions/permission-7258";
      client.getPermission(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPermissionsTest() throws Exception {
    Permission responsesElement = Permission.newBuilder().build();
    ListPermissionsResponse expectedResponse =
        ListPermissionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPermissions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ResourceName parent = TunedModelName.of("[TUNED_MODEL]");

    ListPermissionsPagedResponse pagedListResponse = client.listPermissions(parent);

    List<Permission> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPermissionsList().get(0), resources.get(0));

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
  public void listPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName parent = TunedModelName.of("[TUNED_MODEL]");
      client.listPermissions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPermissionsTest2() throws Exception {
    Permission responsesElement = Permission.newBuilder().build();
    ListPermissionsResponse expectedResponse =
        ListPermissionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPermissions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "tunedModels/tunedModel-5591";

    ListPermissionsPagedResponse pagedListResponse = client.listPermissions(parent);

    List<Permission> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPermissionsList().get(0), resources.get(0));

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
  public void listPermissionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "tunedModels/tunedModel-5591";
      client.listPermissions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePermissionTest() throws Exception {
    Permission expectedResponse =
        Permission.newBuilder()
            .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .build();
    mockService.addResponse(expectedResponse);

    Permission permission =
        Permission.newBuilder()
            .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Permission actualResponse = client.updatePermission(permission, updateMask);
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
  public void updatePermissionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Permission permission =
          Permission.newBuilder()
              .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
              .setEmailAddress("emailAddress-1070931784")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePermission(permission, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePermissionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PermissionName name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]");

    client.deletePermission(name);

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
  public void deletePermissionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PermissionName name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]");
      client.deletePermission(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePermissionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "tunedModels/tunedModel-7258/permissions/permission-7258";

    client.deletePermission(name);

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
  public void deletePermissionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "tunedModels/tunedModel-7258/permissions/permission-7258";
      client.deletePermission(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void transferOwnershipTest() throws Exception {
    TransferOwnershipResponse expectedResponse = TransferOwnershipResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TransferOwnershipRequest request =
        TransferOwnershipRequest.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .build();

    TransferOwnershipResponse actualResponse = client.transferOwnership(request);
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
  public void transferOwnershipExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TransferOwnershipRequest request =
          TransferOwnershipRequest.newBuilder()
              .setName(TunedModelName.of("[TUNED_MODEL]").toString())
              .setEmailAddress("emailAddress-1070931784")
              .build();
      client.transferOwnership(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
