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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PermissionServiceClientTest {
  private static MockPermissionService mockPermissionService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PermissionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPermissionService = new MockPermissionService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPermissionService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    PermissionServiceSettings settings =
        PermissionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PermissionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createPermissionTest() throws Exception {
    Permission expectedResponse =
        Permission.newBuilder()
            .setName(PermissionName.of("[TUNED_MODEL]", "[PERMISSION]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .build();
    mockPermissionService.addResponse(expectedResponse);

    TunedModelName parent = TunedModelName.of("[TUNED_MODEL]");
    Permission permission = Permission.newBuilder().build();

    Permission actualResponse = client.createPermission(parent, permission);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePermissionRequest actualRequest = ((CreatePermissionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(permission, actualRequest.getPermission());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPermissionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

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
    mockPermissionService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Permission permission = Permission.newBuilder().build();

    Permission actualResponse = client.createPermission(parent, permission);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePermissionRequest actualRequest = ((CreatePermissionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(permission, actualRequest.getPermission());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPermissionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockPermissionService.addResponse(expectedResponse);

    PermissionName name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]");

    Permission actualResponse = client.getPermission(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPermissionRequest actualRequest = ((GetPermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPermissionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

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
    mockPermissionService.addResponse(expectedResponse);

    String name = "name3373707";

    Permission actualResponse = client.getPermission(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPermissionRequest actualRequest = ((GetPermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPermissionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

    try {
      String name = "name3373707";
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
    mockPermissionService.addResponse(expectedResponse);

    ResourceName parent = TunedModelName.of("[TUNED_MODEL]");

    ListPermissionsPagedResponse pagedListResponse = client.listPermissions(parent);

    List<Permission> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPermissionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPermissionsRequest actualRequest = ((ListPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

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
    mockPermissionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPermissionsPagedResponse pagedListResponse = client.listPermissions(parent);

    List<Permission> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPermissionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPermissionsRequest actualRequest = ((ListPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockPermissionService.addResponse(expectedResponse);

    Permission permission = Permission.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Permission actualResponse = client.updatePermission(permission, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePermissionRequest actualRequest = ((UpdatePermissionRequest) actualRequests.get(0));

    Assert.assertEquals(permission, actualRequest.getPermission());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePermissionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

    try {
      Permission permission = Permission.newBuilder().build();
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
    mockPermissionService.addResponse(expectedResponse);

    PermissionName name = PermissionName.of("[TUNED_MODEL]", "[PERMISSION]");

    client.deletePermission(name);

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePermissionRequest actualRequest = ((DeletePermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePermissionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

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
    mockPermissionService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePermission(name);

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePermissionRequest actualRequest = ((DeletePermissionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePermissionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

    try {
      String name = "name3373707";
      client.deletePermission(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void transferOwnershipTest() throws Exception {
    TransferOwnershipResponse expectedResponse = TransferOwnershipResponse.newBuilder().build();
    mockPermissionService.addResponse(expectedResponse);

    TransferOwnershipRequest request =
        TransferOwnershipRequest.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setEmailAddress("emailAddress-1070931784")
            .build();

    TransferOwnershipResponse actualResponse = client.transferOwnership(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPermissionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferOwnershipRequest actualRequest = ((TransferOwnershipRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getEmailAddress(), actualRequest.getEmailAddress());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void transferOwnershipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPermissionService.addException(exception);

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
