package com.nartan.ba.resource.model.mappers;

import javax.persistence.*;


/**
 * Persistent parking entity with JPA markup. Parking are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "parking")
public class Parking extends DateBase {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false, unique = true)
  protected int id;

  @OneToOne
  @JoinColumn(name = "building_id", referencedColumnName = "id", nullable = false)
  private Building building;

  @OneToOne
  @JoinColumn(name = "apartment_id", referencedColumnName = "id", nullable = false)
  private Apartment apartment;

  @Column(name = "parking_number", nullable = false)
  private String parkingNumber;

  @Column(name = "location")
  private String location;

  @Column(name = "status")
  private int status;

  public Parking() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

  public Apartment getApartment() {
    return apartment;
  }

  public void setApartment(Apartment apartment) {
    this.apartment = apartment;
  }

  public String getParkingNumber() {
    return parkingNumber;
  }

  public void setParkingNumber(String parkingNumber) {
    this.parkingNumber = parkingNumber;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Parking [id=" + id + ", building=" + building + ", apartment="
        + apartment
        + ", parkingNumber=" + parkingNumber + ", location=" + location + ", status=" + status
        + ", dateCreated=" + getCreationTime() + ", dateModified=" + getModificationTime() + "]";
  }


}
