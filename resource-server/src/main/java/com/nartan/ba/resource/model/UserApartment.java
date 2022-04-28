package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent User Apartment entity with JPA markup. User Apartment are stored in an relational
 * database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "user_apartment")
public class UserApartment implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userApartment_gen")
  @SequenceGenerator(name = "userApartment_gen", sequenceName = "userApartment_seq", allocationSize = 1)
  @Column(name = "user_apartment_id", nullable = false, unique = true)
  protected int userApartmentId;

  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
  private User user;

  @Column(name = "apartment_number", nullable = false)
  private String apartmentNumber;

  @OneToOne
  @JoinColumn(name = "building_id", referencedColumnName = "building_id", nullable = false)
  private Building building;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public UserApartment() {
  }

  /**
   * @return the userApartmentId
   */
  public int getUserApartmentId() {
    return userApartmentId;
  }

  /**
   * @param userApartmentId the userApartmentId to set
   */
  public void setUserApartmentId(int userApartmentId) {
    this.userApartmentId = userApartmentId;
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
    return "UserApartment [userApartmentId=" + userApartmentId + ", user=" + user
        + ", apartmentNumber="
        + apartmentNumber + ", building=" + building + ", dateCreated=" + dateCreated
        + ", dateModified="
        + dateModified + "]";
  }


}
