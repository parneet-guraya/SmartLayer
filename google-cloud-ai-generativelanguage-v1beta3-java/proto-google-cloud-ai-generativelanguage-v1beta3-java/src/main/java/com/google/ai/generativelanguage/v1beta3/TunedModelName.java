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

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class TunedModelName implements ResourceName {
  private static final PathTemplate TUNED_MODEL =
      PathTemplate.createWithoutUrlEncoding("tunedModels/{tuned_model}");
  private volatile Map<String, String> fieldValuesMap;
  private final String tunedModel;

  @Deprecated
  protected TunedModelName() {
    tunedModel = null;
  }

  private TunedModelName(Builder builder) {
    tunedModel = Preconditions.checkNotNull(builder.getTunedModel());
  }

  public String getTunedModel() {
    return tunedModel;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TunedModelName of(String tunedModel) {
    return newBuilder().setTunedModel(tunedModel).build();
  }

  public static String format(String tunedModel) {
    return newBuilder().setTunedModel(tunedModel).build().toString();
  }

  public static TunedModelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        TUNED_MODEL.validatedMatch(
            formattedString, "TunedModelName.parse: formattedString not in valid format");
    return of(matchMap.get("tuned_model"));
  }

  public static List<TunedModelName> parseList(List<String> formattedStrings) {
    List<TunedModelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TunedModelName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TunedModelName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return TUNED_MODEL.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (tunedModel != null) {
            fieldMapBuilder.put("tuned_model", tunedModel);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return TUNED_MODEL.instantiate("tuned_model", tunedModel);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TunedModelName that = ((TunedModelName) o);
      return Objects.equals(this.tunedModel, that.tunedModel);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(tunedModel);
    return h;
  }

  /** Builder for tunedModels/{tuned_model}. */
  public static class Builder {
    private String tunedModel;

    protected Builder() {}

    public String getTunedModel() {
      return tunedModel;
    }

    public Builder setTunedModel(String tunedModel) {
      this.tunedModel = tunedModel;
      return this;
    }

    private Builder(TunedModelName tunedModelName) {
      this.tunedModel = tunedModelName.tunedModel;
    }

    public TunedModelName build() {
      return new TunedModelName(this);
    }
  }
}
