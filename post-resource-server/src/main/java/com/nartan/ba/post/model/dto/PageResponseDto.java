package com.nartan.ba.post.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
@JsonDeserialize(builder = AutoValue_PageResponseDto.Builder.class)
public abstract class PageResponseDto<T> {

  @JsonProperty("pageNumber")
  public abstract int pageNumber();

  @JsonProperty("pageSize")
  public abstract int pageSize();

  @JsonProperty("totalPages")
  public abstract long totalPages();

  @JsonProperty("results")
  public abstract List<T> results();

  public static <T> Builder<T> builder() {
    return new AutoValue_PageResponseDto.Builder<T>();
  }

  public abstract Builder<T> toBuilder();

  @AutoValue.Builder
  public abstract static class Builder<T> {

    @JsonProperty("pageNumber")
    public abstract Builder<T> pageNumber(int pageNumber);

    @JsonProperty("pageSize")
    public abstract Builder<T> pageSize(int pageSize);

    @JsonProperty("totalPages")
    public abstract Builder<T> totalPages(long totalPages);

    @JsonProperty("results")
    public abstract Builder<T> results(List<T> results);

    public abstract PageResponseDto<T> build();
  }
}
