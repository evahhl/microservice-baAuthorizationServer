package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent User Login entity with JPA markup. User Login are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "user_login")
public class UserLogin implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "email", nullable = false, unique = true)
  protected String email;

  @Column(name = "password", nullable = false)
  protected String password;

  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
  private User user;

  @OneToOne
  @JoinColumn(name = "role_id", referencedColumnName = "user_type_id", nullable = false)
  private UserType type;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public UserLogin() {
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
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
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

  @Override
  public String toString() {
    return "UserLogin [email=" + email + ", password=" + password + ", user=" + user + ", type="
        + type
        + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + "]";
  }


}
