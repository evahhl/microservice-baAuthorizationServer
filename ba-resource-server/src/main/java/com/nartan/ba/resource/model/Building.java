package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Persistent building entity with JPA markup. Building are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "building")
public class Building implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "building_gen")
  @SequenceGenerator(name = "building_gen", sequenceName = "building_seq", allocationSize = 1)
  @Column(name = "building_id", nullable = false, unique = true)
  protected int buildingId;

  @Column(name = "building_name", nullable = false)
  protected String buildingName;

  @OneToOne
  @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
  private Address address;

  @Column(name = "phone_number", nullable = false, length = 10)
  protected String phoneNumber;

  @Column(name = "email", nullable = false)
  protected String email;

  @Column(name = "status", nullable = false, length = 1, columnDefinition = "int default 1")
  protected int status = 1;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public Building() {
  }

  /**
   * Default constructor for JPA only.
   *
   * @param buildingId
   * @param buildingName
   * @param phoneNumber
   * @param email
   * @param dateCreated
   * @param dateModified
   */
  public Building(int buildingId, String buildingName, String phoneNumber, String email,
      Timestamp dateCreated, Timestamp dateModified) {
    this.buildingId = buildingId;
    this.buildingName = buildingName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.dateCreated = dateCreated;
    this.dateModified = dateModified;
  }

  /**
   * @return the buildingId
   */
  public int getBuildingId() {
    return buildingId;
  }

  /**
   * @param buildingId the buildingId to set
   */
  public void setBuildingId(int buildingId) {
    this.buildingId = buildingId;
  }

  /**
   * @return the buildingName
   */
  public String getBuildingName() {
    return buildingName;
  }

  /**
   * @param buildingName the buildingName to set
   */
  public void setBuildingName(String buildingName) {
    this.buildingName = buildingName;
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
   * @return the phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
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
    return "Building [buildingId=" + buildingId + ", buildingName=" + buildingName + ", address="
        + address
        + ", phoneNumber=" + phoneNumber + ", email=" + email + ", status=" + status
        + ", dateCreated="
        + dateCreated + ", dateModified=" + dateModified + "]";
  }


}
