package com.nartan.ba.resource.model;

import javax.persistence.*;

/**
 * Persistent User Apartment entity with JPA markup. User Apartment are stored in an relational
 * database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "user_apartment")
public class UserApartment extends DateBase {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false, unique = true)
  protected int id;

  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private User user;

  @OneToOne
  @JoinColumn(name = "apartment_id", referencedColumnName = "id", nullable = false)
  private Apartment apartment;

  @OneToOne
  @JoinColumn(name = "building_id", referencedColumnName = "id", nullable = false)
  private Building building;

  public UserApartment() {
  }

  public int getId() {
    return id;
  }

  public void setId(int userApartmentId) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Apartment getApartment() {
    return apartment;
  }

  public void setApartment(Apartment apartment) {
    this.apartment = apartment;
  }

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }


  @Override
  public String toString() {
    return "UserApartment [id=" + id + ", user=" + user
        + ", apartment="
        + apartment + ", building=" + building + ", dateCreated=" + getCreationTime()
        + ", dateModified="
        + getModificationTime() + "]";
  }


}
