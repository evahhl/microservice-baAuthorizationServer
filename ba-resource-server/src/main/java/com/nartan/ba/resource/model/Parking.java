package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Persistent parking entity with JPA markup. Parking are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "parking")
public class Parking implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_gen")
  @SequenceGenerator(name = "parking_gen", sequenceName = "parking_seq", allocationSize = 1)
  @Column(name = "parking_id", nullable = false, unique = true)
  protected int parkingId;

  @OneToOne
  @JoinColumn(name = "building_id", referencedColumnName = "building_id", nullable = false)
  private Building building;

  @Column(name = "apartment_number", nullable = false)
  private String apartmentNumber;

  @Column(name = "parking_number", nullable = false)
  private String parkingNumber;

  @Column(name = "location")
  private String location;

  @Column(name = "status")
  private int status;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public Parking() {
  }

  /**
   * @return the parkingId
   */
  public int getParkingId() {
    return parkingId;
  }

  /**
   * @param parkingId the parkingId to set
   */
  public void setParkingId(int parkingId) {
    this.parkingId = parkingId;
  }

  /**
   * @return the building
   */
  public Building getBuilding() {
    return building;
  }

  /**
   * @param building the building to set
   */
  public void setBuilding(Building building) {
    this.building = building;
  }

  /**
   * @return the apartmentNumber
   */
  public String getApartmentNumber() {
    return apartmentNumber;
  }

  /**
   * @param apartmentNumber the apartmentNumber to set
   */
  public void setApartmentNumber(String apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
  }

  /**
   * @return the parkingNumber
   */
  public String getParkingNumber() {
    return parkingNumber;
  }

  /**
   * @param parkingNumber the parkingNumber to set
   */
  public void setParkingNumber(String parkingNumber) {
    this.parkingNumber = parkingNumber;
  }

  /**
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(String location) {
    this.location = location;
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
    return "Parking [parkingId=" + parkingId + ", building=" + building + ", apartmentNumber="
        + apartmentNumber
        + ", parkingNumber=" + parkingNumber + ", location=" + location + ", status=" + status
        + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + "]";
  }


}
