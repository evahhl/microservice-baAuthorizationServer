package com.nartan.ba.post.model.dto;

import com.nartan.ba.post.model.dto.PostDto.Builder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@AutoValue
@JsonDeserialize(builder = AutoValue_CommentDto.Builder.class)
public abstract class CommentDto {

  @JsonProperty("id")
  public abstract int id();

  @JsonProperty("message")
  @NotBlank(message = "Comment message should not be null/empty.")
  public abstract String message();

  @JsonProperty("userId")
  public abstract int userId();

  @JsonProperty("by")
  public abstract String by();

  @JsonProperty("likes")
  public abstract int likes();

  @JsonProperty("liked")
  public abstract Boolean liked();

  @JsonProperty("dateCreated")
  public abstract Date dateCreated();

  public static Builder builder() {
    return new AutoValue_CommentDto.Builder();
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    @JsonProperty("id")
    public abstract Builder id(int id);

    @JsonProperty("message")
    @NotBlank(message = "Comment message should not be null/empty.")
    public abstract Builder message(String message);

    @JsonProperty("userId")
    public abstract Builder userId(int userId);

    @JsonProperty("by")
    public abstract Builder by(String by);

    @JsonProperty("likes")
    public abstract Builder likes(int likes);

    @JsonProperty("liked")
    public abstract Builder liked(Boolean liked);

    @JsonProperty("dateCreated")
    public abstract Builder dateCreated(Date dateCreated);

    public abstract CommentDto build();
  }
}
