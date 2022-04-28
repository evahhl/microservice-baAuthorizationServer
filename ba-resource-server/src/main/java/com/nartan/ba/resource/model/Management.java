package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent management entity with JPA markup. Management are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "management")
public class Management implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "management_gen")
  @SequenceGenerator(name = "management_gen", sequenceName = "management_seq", allocationSize = 1)
  @Column(name = "management_id", nullable = false, unique = true)
  protected int managementId;

  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
  private User user;

  @OneToOne
  @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
  private Address address;

  @Column(name = "rfc", nullable = false, length = 13)
  protected String rfc;

  @OneToOne
  @JoinColumn(name = "type", referencedColumnName = "user_type_id", nullable = false)
  private UserType type;

  @Column(name = "status", nullable = false, length = 1, columnDefinition = "int default 1")
  protected int status;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public Management() {
  }

  /**
   * @return the managementId
   */
  public int getManagementId() {
    return managementId;
  }

  /**
   * @param managementId the managementId to set
   */
  public void setManagementId(int managementId) {
    this.managementId = managementId;
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
   * @return the address
   */
  public Address getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * @return the rfc
   */
  public String getRfc() {
    return rfc;
  }

  /**
   * @param rfc the rfc to set
   */
  public void setRfc(String rfc) {
    this.rfc = rfc;
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
    return "Management [managementId=" + managementId + ", user=" + user + ", address=" + address
        + ", rfc=" + rfc
        + ", type=" + type + ", status=" + status + ", dateCreated=" + dateCreated
        + ", dateModified="
        + dateModified + "]";
  }


}
