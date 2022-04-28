package com.nartan.ba.post.model.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

@Document(collection = "post")
public class Post {

  @Transient
  public static final String SEQUENCE = "post";

  @Id
  @GeneratedValue
  private int id;

  @NotEmpty(message = "Post content should not be null or empty.")
  private String post;

  @NotEmpty(message = "Post description should not be null or empty.")
  private String description;

  @NotNull
  private int userId;

  private String by;

  @NotNull
  private List<Tag> tags;

  private int likes;

  @NotNull
  private List<Comment> comments;

  @NotNull
  private Set<Integer> likedBy;

  private int status;

  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  protected Date dateCreated;

  public int getId() {
    return id;
  }

  public Post setId(int id) {
    this.id = id;
    return this;
  }

  public String getPost() {
    return post;
  }

  public Post setPost(String post) {
    this.post = post;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Post setDescription(String description) {
    this.description = description;
    return this;
  }

  public int getUserId() {
    return userId;
  }

  public Post setUserId(int userId) {
    this.userId = userId;
    return this;
  }

  public String getBy() {
    return by;
  }

  public Post setBy(String by) {
    this.by = by;
    return this;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public Post setTags(List<Tag> tags) {
    if (tags == null) {
      tags = ImmutableList.of();
    }
    this.tags = tags;
    return this;
  }

  public int getLikes() {
    return likes;
  }

  public Post setLikes(int likes) {
    this.likes = likes;
    return this;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public Post setComments(List<Comment> comments) {
    if (comments == null) {
      comments = ImmutableList.of();
    }
    this.comments = comments;
    return this;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public Post setDateCreated(Date date) {
    this.dateCreated = date;
    return this;
  }

  public Set<Integer> getLikedBy() {
    return likedBy;
  }

  public Post setLikedBy(Set<Integer> likedBy) {
    if (likedBy == null) {
      likedBy = ImmutableSet.of();
    }
    this.likedBy = likedBy;
    return this;
  }

  public int getStatus() {
    return status;
  }

  public Post setStatus(int status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("post='" + post + "'")
        .add("description='" + description + "'")
        .add("userId=" + userId)
        .add("by='" + by + "'")
        .add("tags=" + tags)
        .add("likes=" + likes)
        .add("comments=" + comments)
        .add("likedBy=" + likedBy)
        .add("status=" + status)
        .add("dateCreated=" + dateCreated)
        .toString();
  }
}
