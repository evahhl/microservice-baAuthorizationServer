package com.nartan.ba.resource.model.mappers;

import javax.persistence.*;

/**
 * Persistent User Type entity with JPA markup. User Type are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "user_type")
public class UserType extends DateBase {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false, unique = true)
  protected int id;

  @Column(name = "description", nullable = false)
  private String description;

  public UserType() {
  }

  public int getId() {
    return id;
  }

  public void setId(int userTypeId) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "UserType [id=" + id + ", description=" + description
        + ", dateCreated=" + getCreationTime() + ", dateModified=" + getModificationTime() + "]";
  }

}
