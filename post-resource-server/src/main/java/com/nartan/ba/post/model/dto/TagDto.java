package com.nartan.ba.post.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.validation.constraints.NotBlank;

@AutoValue
@JsonDeserialize(builder = AutoValue_TagDto.Builder.class)
public abstract class TagDto {

  @JsonProperty("id")
  public abstract int id();

  @JsonProperty("name")
  public abstract String name();

  public static Builder builder() {
    return new AutoValue_TagDto.Builder();
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    @JsonProperty("id")
    public abstract Builder id(int id);

    @JsonProperty("name")
    @NotBlank(message = "Tag name should not be null/empty.")
    public abstract Builder name(String name);

    public abstract TagDto build();
  }
}
