package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent apartment entity with JPA markup. Apartment are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "apartment")
public class Apartment implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_gen")
  @SequenceGenerator(name = "apartment_gen", sequenceName = "apartment_seq", allocationSize = 1)
  @Column(name = "apartment_id", nullable = false, unique = true)
  protected int apartmentId;

  @Column(name = "apartment_number", nullable = false)
  protected String apartmentNumber;

  @OneToOne
  @JoinColumn(name = "building_id", referencedColumnName = "building_id", nullable = false)
  private Building building;

  @Column(name = "room_number")
  protected int roomNumber;

  @Column(name = "bathroom_number")
  protected int bathroomNumber;

  @Column(name = "size")
  protected int size;

  @Column(name = "parkingNumber")
  protected int parking_number;

  @Column(name = "location")
  protected String location;

  @Column(name = "balcony_number")
  protected int balconyNumber;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public Apartment() {
  }

  /**
   * @return the apartmentId
   */
  public int getApartmentId() {
    return apartmentId;
  }

  /**
   * @param apartmentId the apartmentId to set
   */
  public void setApartmentId(int apartmentId) {
    this.apartmentId = apartmentId;
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
   * @return the roomNumber
   */
  public int getRoomNumber() {
    return roomNumber;
  }

  /**
   * @param roomNumber the roomNumber to set
   */
  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  /**
   * @return the bathroomNumber
   */
  public int getBathroomNumber() {
    return bathroomNumber;
  }

  /**
   * @param bathroomNumber the bathroomNumber to set
   */
  public void setBathroomNumber(int bathroomNumber) {
    this.bathroomNumber = bathroomNumber;
  }

  /**
   * @return the size
   */
  public int getSize() {
    return size;
  }

  /**
   * @param size the size to set
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * @return the parking_number
   */
  public int getParking_number() {
    return parking_number;
  }

  /**
   * @param parking_number the parking_number to set
   */
  public void setParking_number(int parking_number) {
    this.parking_number = parking_number;
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
   * @return the balconyNumber
   */
  public int getBalconyNumber() {
    return balconyNumber;
  }

  /**
   * @param balconyNumber the balconyNumber to set
   */
  public void setBalconyNumber(int balconyNumber) {
    this.balconyNumber = balconyNumber;
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
    return "Apartment [apartmentId=" + apartmentId + ", apartmentNumber=" + apartmentNumber
        + ", building="
        + building + ", roomNumber=" + roomNumber + ", bathroomNumber=" + bathroomNumber + ", size="
        + size
        + ", parking_number=" + parking_number + ", location=" + location + ", balconyNumber="
        + balconyNumber
        + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + "]";
  }


}
