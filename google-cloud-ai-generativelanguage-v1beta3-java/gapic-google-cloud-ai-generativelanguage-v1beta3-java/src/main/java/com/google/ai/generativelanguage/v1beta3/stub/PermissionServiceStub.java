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

import static com.google.ai.generativelanguage.v1beta3.PermissionServiceClient.ListPermissionsPagedResponse;

import com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest;
import com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest;
import com.google.ai.generativelanguage.v1beta3.GetPermissionRequest;
import com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest;
import com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse;
import com.google.ai.generativelanguage.v1beta3.Permission;
import com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest;
import com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse;
import com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PermissionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class PermissionServiceStub implements BackgroundResource {

  public UnaryCallable<CreatePermissionRequest, Permission> createPermissionCallable() {
    throw new UnsupportedOperationException("Not implemented: createPermissionCallable()");
  }

  public UnaryCallable<GetPermissionRequest, Permission> getPermissionCallable() {
    throw new UnsupportedOperationException("Not implemented: getPermissionCallable()");
  }

  public UnaryCallable<ListPermissionsRequest, ListPermissionsPagedResponse>
      listPermissionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPermissionsPagedCallable()");
  }

  public UnaryCallable<ListPermissionsRequest, ListPermissionsResponse> listPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPermissionsCallable()");
  }

  public UnaryCallable<UpdatePermissionRequest, Permission> updatePermissionCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePermissionCallable()");
  }

  public UnaryCallable<DeletePermissionRequest, Empty> deletePermissionCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePermissionCallable()");
  }

  public UnaryCallable<TransferOwnershipRequest, TransferOwnershipResponse>
      transferOwnershipCallable() {
    throw new UnsupportedOperationException("Not implemented: transferOwnershipCallable()");
  }

  @Override
  public abstract void close();
}
