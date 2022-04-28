package com.nartan.ba.post.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@AutoValue
@JsonSerialize(as = PostDto.class)
@JsonDeserialize(builder = AutoValue_PostDto.Builder.class)
public abstract class PostDto {

  @JsonProperty("id")
  @NotEmpty(message = "id cannot be empty.")
  public abstract int id();

  @JsonProperty("post")
  @NotEmpty(message = "Post content should not be null/empty.")
  public abstract String post();

  @JsonProperty("description")
  @NotEmpty(message = "Post description should not be null/empty.")
  public abstract String description();

  @JsonProperty("userId")
  public abstract int userId();

  @JsonProperty("by")
  public abstract String by();

  @JsonProperty("tags")
  public abstract List<TagDto> tags();

  @JsonProperty("likes")
  public abstract int likes();

  @JsonProperty("comments")
  public abstract List<CommentDto> comments();

  @JsonProperty("liked")
  public abstract Boolean liked();

  @JsonProperty("dateCreated")
  @NotEmpty(message = "Data cannot be empty.")
  public abstract Date dateCreated();

  public static Builder builder() {
    return new AutoValue_PostDto.Builder();
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  @JsonPOJOBuilder(withPrefix = "")
  public abstract static class Builder {

    @JsonProperty("id")
    @NotEmpty(message = "id cannot be empty.")
    public abstract Builder id(int id);

    @JsonProperty("post")
    @NotEmpty(message = "Post content should not be null/empty.")
    public abstract Builder post(String post);

    @JsonProperty("description")
    @NotEmpty(message = "Post description should not be null/empty.")
    public abstract Builder description(String description);

    @JsonProperty("userId")
    public abstract Builder userId(int userId);

    @JsonProperty("by")
    public abstract Builder by(String by);

    @JsonProperty("tags")
    public abstract Builder tags(List<TagDto> tags);

    @JsonProperty("likes")
    public abstract Builder likes(int likes);

    @JsonProperty("comments")
    public abstract Builder comments(List<CommentDto> comments);

    @JsonProperty("liked")
    public abstract Builder liked(Boolean liked);

    @JsonProperty("dateCreated")
    @NotEmpty(message = "Data cannot be empty.")
    public abstract Builder dateCreated(Date dateCreated);

    public abstract PostDto build();
  }
}
