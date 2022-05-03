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
  @Column(name = "id", nullable = false, unique = true)
  protected int id;

  @Column(name = "name", nullable = false, length = 80)
  protected String name;

  @OneToOne
  @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
  private Address address;

  @Column(name = "email")
  private String email;

  @Column(name = "rfc", nullable = false, length = 13)
  protected String rfc;

  @Column(name = "type", nullable = false, length = 13)
  protected String type;

  @Column(name = "phone_number", length = 10)
  private int phoneNumber;

  @Column(name = "mobile_phone", length = 10)
  private int mobileNumber;

  @Column(name = "additional_phone", length = 10)
  private int additionalNumber;

  @Column(name = "web", length = 180)
  private String web;

  @Column(name = "status", nullable = false, length = 1, columnDefinition = "int default 1")
  protected int status;

  public Management() {
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

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getRfc() {
    return rfc;
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getMobileNumber() { return mobileNumber; }

  public void setMobileNumber(int mobileNumber) { this.mobileNumber = mobileNumber;  }

  public int getAdditionalNumber() { return additionalNumber; }

  public void setAdditionalNumber(int additionalNumber) { this.additionalNumber = additionalNumber; }

  public String getWeb() { return web; }

  public void setWeb(String web) { this.web = web;  }

//  @Override
//  public String toString() {
//    return "Management [id=" + id + "name=" + name + ", address=" + address
//        + ", rfc=" + rfc + ", type=" + type  + ", phoneNumber=" + phoneNumber
//        + ", status=" + status + ", dateCreated=" + getCreationTime()
//        + ", email=" + email + ", dateModified="
//        + getModificationTime() + "]";
//  }


  @Override
  public String toString() {
    return "Management{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", address=" + address +
            ", email='" + email + '\'' +
            ", rfc='" + rfc + '\'' +
            ", type='" + type + '\'' +
            ", phoneNumber=" + phoneNumber +
            ", mobileNumber=" + mobileNumber +
            ", additionalNumber=" + additionalNumber +
            ", web='" + web + '\'' +
            ", status=" + status +
            ", dateCreated='" + getCreationTime() + '\'' +
            ", dateModified=" + getModificationTime() +
            '}';
  }
}
