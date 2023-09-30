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

import com.google.ai.generativelanguage.v1beta3.ModelServiceGrpc.ModelServiceImplBase;
import com.google.api.core.BetaApi;
import com.google.longrunning.Operation;
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
public class MockModelServiceImpl extends ModelServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockModelServiceImpl() {
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
  public void getModel(GetModelRequest request, StreamObserver<Model> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Model) {
      requests.add(request);
      responseObserver.onNext(((Model) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Model.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModels(
      ListModelsRequest request, StreamObserver<ListModelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListModelsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListModelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListModels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListModelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTunedModel(
      GetTunedModelRequest request, StreamObserver<TunedModel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TunedModel) {
      requests.add(request);
      responseObserver.onNext(((TunedModel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTunedModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TunedModel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTunedModels(
      ListTunedModelsRequest request, StreamObserver<ListTunedModelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTunedModelsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTunedModelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTunedModels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTunedModelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTunedModel(
      CreateTunedModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTunedModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTunedModel(
      UpdateTunedModelRequest request, StreamObserver<TunedModel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TunedModel) {
      requests.add(request);
      responseObserver.onNext(((TunedModel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTunedModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TunedModel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTunedModel(
      DeleteTunedModelRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTunedModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
