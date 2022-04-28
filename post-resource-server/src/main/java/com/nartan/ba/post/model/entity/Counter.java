package com.nartan.ba.post.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.StringJoiner;

@Document(collection = "counter")
public class Counter {
  @Id
  String id;
  int sequence;

  public String getId() {
    return id;
  }

  public Counter setId(String id) {
    this.id = id;
    return this;
  }

  public int getSequence() {
    return sequence;
  }

  public Counter setSequence(int sequence) {
    this.sequence = sequence;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Counter.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("sequence=" + sequence)
        .toString();
  }
}
