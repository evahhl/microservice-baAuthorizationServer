package com.nartan.ba.post.model.entity;

import com.google.common.collect.ImmutableSet;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;
import java.util.StringJoiner;

@Document(collection = "comment")
public class Comment {

  @Transient
  public static final String SEQUENCE = "comment";

  @Id
  private int id;

  @NotBlank(message = "Comment message should not be null/empty.")
  private String message;

  @NotEmpty
  private int userId;

  private String by;

  private int likes;

  private Set<Integer> likedBy;

  private int status;

  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  protected Date dateCreated;

  public int getId() {
    return id;
  }

  public Comment setId(int id) {
    this.id = id;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public Comment setMessage(String message) {
    this.message = message;
    return this;
  }

  public int getUserId() {
    return userId;
  }

  public Comment setUserId(int userId) {
    this.userId = userId;
    return this;
  }

  public String getBy() {
    return by;
  }

  public Comment setBy(String by) {
    this.by = by;
    return this;
  }

  public int getLikes() {
    return likes;
  }

  public Comment setLikes(int likes) {
    this.likes = likes;
    return this;
  }

  public Set<Integer> getLikedBy() {
    return likedBy;
  }

  public Comment setLikedBy(Set<Integer> likedBy) {
    if (likedBy == null) {
      likedBy = ImmutableSet.of();
    }
    this.likedBy = likedBy;
    return this;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public Comment setDateCreated(Date date) {
    this.dateCreated = date;
    return this;
  }

  public int getStatus() {
    return status;
  }

  public Comment setStatus(int status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Comment.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("message='" + message + "'")
        .add("userId=" + userId)
        .add("by='" + by + "'")
        .add("likes=" + likes)
        .add("likedBy=" + likedBy)
        .add("status=" + status)
        .add("dateCreated=" + dateCreated)
        .toString();
  }
}
