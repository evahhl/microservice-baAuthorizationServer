package com.nartan.ba.resource.model;

import javax.persistence.*;

/**
 * Persistent User Login entity with JPA markup. User Login are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "user_login")
public class UserLogin extends DateBase {

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

  public UserLogin() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public UserType getType() {
    return type;
  }

  public void setType(UserType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "UserLogin [email=" + email + ", password=" + password + ", user=" + user + ", type="
        + type
        + ", dateCreated=" + getCreationTime() + ", dateModified=" + getModificationTime() + "]";
  }


}
