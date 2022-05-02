package com.nartan.ba.resource.model;

import javax.persistence.*;

/**
 * Persistent User Building entity with JPA markup. User Building are stored in an relational
 * database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "user_building")
public class User extends DateBase {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false, unique = true)
  protected int id;

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


  public User() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(int mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public UserType getType() {
    return type;
  }

  public void setType(UserType type) {
    this.type = type;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email="
        + email
        + ", phoneNumber=" + phoneNumber + ", mobileNumber=" + mobileNumber + ", type=" + type
        + ", status="
        + status + ", dateCreated=" + getCreationTime() + ", dateModified=" + getModificationTime() + "]";
  }


}
