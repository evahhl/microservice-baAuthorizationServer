package com.nartan.ba.resource.model;

import javax.persistence.*;

/**
 * Persistent management entity with JPA markup. Management are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "management")
public class Management extends DateBase {

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
        + ", type=" + type + ", status=" + status + ", dateCreated=" + getCreationTime()
        + ", dateModified="
        + getModificationTime() + "]";
  }


}
