package com.nartan.ba.post.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import java.util.StringJoiner;

@Document(collection = "tag")
public class Tag {

  @Transient
  public static final String SEQUENCE_NAME = "tag_sequence";

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private int status;

  public int getId() {
    return id;
  }

  public Tag setId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Tag setName(String name) {
    this.name = name;
    return this;
  }

  public int getStatus() {
    return status;
  }

  public Tag setStatus(int status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Tag.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("name='" + name + "'")
        .add("status=" + status)
        .toString();
  }
}
