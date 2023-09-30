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

package com.google.ai.generativelanguage.v1beta3.samples;

// [START generativelanguage_v1beta3_generated_ModelService_ListTunedModels_Paged_async]
import com.google.ai.generativelanguage.v1beta3.ListTunedModelsRequest;
import com.google.ai.generativelanguage.v1beta3.ListTunedModelsResponse;
import com.google.ai.generativelanguage.v1beta3.ModelServiceClient;
import com.google.ai.generativelanguage.v1beta3.TunedModel;
import com.google.common.base.Strings;

public class AsyncListTunedModelsPaged {

  public static void main(String[] args) throws Exception {
    asyncListTunedModelsPaged();
  }

  public static void asyncListTunedModelsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
      ListTunedModelsRequest request =
          ListTunedModelsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListTunedModelsResponse response =
            modelServiceClient.listTunedModelsCallable().call(request);
        for (TunedModel element : response.getTunedModelsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END generativelanguage_v1beta3_generated_ModelService_ListTunedModels_Paged_async]
