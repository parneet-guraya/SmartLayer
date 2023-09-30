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
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ModelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ModelServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    throw new UnsupportedOperationException("Not implemented: getModelCallable()");
  }

  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelsPagedCallable()");
  }

  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelsCallable()");
  }

  public UnaryCallable<GetTunedModelRequest, TunedModel> getTunedModelCallable() {
    throw new UnsupportedOperationException("Not implemented: getTunedModelCallable()");
  }

  public UnaryCallable<ListTunedModelsRequest, ListTunedModelsPagedResponse>
      listTunedModelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTunedModelsPagedCallable()");
  }

  public UnaryCallable<ListTunedModelsRequest, ListTunedModelsResponse> listTunedModelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTunedModelsCallable()");
  }

  public OperationCallable<CreateTunedModelRequest, TunedModel, CreateTunedModelMetadata>
      createTunedModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTunedModelOperationCallable()");
  }

  public UnaryCallable<CreateTunedModelRequest, Operation> createTunedModelCallable() {
    throw new UnsupportedOperationException("Not implemented: createTunedModelCallable()");
  }

  public UnaryCallable<UpdateTunedModelRequest, TunedModel> updateTunedModelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTunedModelCallable()");
  }

  public UnaryCallable<DeleteTunedModelRequest, Empty> deleteTunedModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTunedModelCallable()");
  }

  @Override
  public abstract void close();
}
