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

import com.google.ai.generativelanguage.v1beta3.PermissionServiceGrpc.PermissionServiceImplBase;
import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockPermissionServiceImpl extends PermissionServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPermissionServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void createPermission(
      CreatePermissionRequest request, StreamObserver<Permission> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Permission) {
      requests.add(request);
      responseObserver.onNext(((Permission) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePermission, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Permission.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPermission(
      GetPermissionRequest request, StreamObserver<Permission> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Permission) {
      requests.add(request);
      responseObserver.onNext(((Permission) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPermission, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Permission.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPermissions(
      ListPermissionsRequest request, StreamObserver<ListPermissionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPermissionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPermissionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPermissions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePermission(
      UpdatePermissionRequest request, StreamObserver<Permission> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Permission) {
      requests.add(request);
      responseObserver.onNext(((Permission) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePermission, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Permission.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePermission(
      DeletePermissionRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeletePermission, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void transferOwnership(
      TransferOwnershipRequest request,
      StreamObserver<TransferOwnershipResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferOwnershipResponse) {
      requests.add(request);
      responseObserver.onNext(((TransferOwnershipResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TransferOwnership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferOwnershipResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
