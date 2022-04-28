package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent User Building entity with JPA markup. User Building are stored in an relational
 * database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "user_building")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
  @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
  @Column(name = "user_id", nullable = false, unique = true)
  protected int userId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone_number", nullable = false, length = 10)
  private int phoneNumber;

  @Column(name = "mobile_phone", nullable = false, length = 10)
  private int mobileNumber;

  @OneToOne
  @JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id", nullable = false)
  private UserType type;

  @Column(name = "status", nullable = false, length = 1, columnDefinition = "int default 1")
  private int status = 1;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public User() {
  }

  /**
   * @return the userId
   */
  public int getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the phoneNumber
   */
  public int getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * @return the mobileNumber
   */
  public int getMobileNumber() {
    return mobileNumber;
  }

  /**
   * @param mobileNumber the mobileNumber to set
   */
  public void setMobileNumber(int mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  /**
   * @return the type
   */
  public UserType getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(UserType type) {
    this.type = type;
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

  /**
   * @return the status
   */
  public int getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "User [userId=" + userId + ", name=" + name + ", lastName=" + lastName + ", email="
        + email
        + ", phoneNumber=" + phoneNumber + ", mobileNumber=" + mobileNumber + ", type=" + type
        + ", status="
        + status + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + "]";
  }


}
