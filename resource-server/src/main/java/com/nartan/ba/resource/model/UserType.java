package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent User Type entity with JPA markup. User Type are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "user_type")
public class UserType implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_type_gen")
  @SequenceGenerator(name = "user_type_gen", sequenceName = "user_type_seq", allocationSize = 1)
  @Column(name = "user_type_id", nullable = false, unique = true)
  protected int userTypeId;

  @Column(name = "user_type_description", nullable = false)
  private String userTypeDescription;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public UserType() {
  }

  /**
   * @return the userTypeId
   */
  public int getUserTypeId() {
    return userTypeId;
  }

  /**
   * @param userTypeId the userTypeId to set
   */
  public void setUserTypeId(int userTypeId) {
    this.userTypeId = userTypeId;
  }

  /**
   * @return the userTypeDescription
   */
  public String getUserTypeDescription() {
    return userTypeDescription;
  }

  /**
   * @param userTypeDescription the userTypeDescription to set
   */
  public void setUserTypeDescription(String userTypeDescription) {
    this.userTypeDescription = userTypeDescription;
  }

  /**
   * @return the dateCreated
   */
  public Timestamp getDateCreated() {
    return dateCreated;
  }

  /**
   * @param dateCreated the dateCreated to set
   */
  public void setDateCreated(Timestamp dateCreated) {
    this.dateCreated = dateCreated;
  }

  /**
   * @return the dateModified
   */
  public Timestamp getDateModified() {
    return dateModified;
  }

  /**
   * @param dateModified the dateModified to set
   */
  public void setDateModified(Timestamp dateModified) {
    this.dateModified = dateModified;
  }

  @Override
  public String toString() {
    return "UserType [userTypeId=" + userTypeId + ", userTypeDescription=" + userTypeDescription
        + ", dateCreated="
        + dateCreated + ", dateModified=" + dateModified + "]";
  }


}
