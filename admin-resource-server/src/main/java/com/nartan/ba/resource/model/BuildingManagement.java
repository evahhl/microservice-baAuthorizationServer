package com.nartan.ba.resource.model;

import javax.persistence.*;

/**
 * Persistent BuildingManagement entity with JPA markup. BuildingManagement are stored in an
 * relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "building_management")
public class BuildingManagement extends DateBase {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false, unique = true)
  protected int id;

  @OneToOne
  @JoinColumn(name = "building_id", referencedColumnName = "id", nullable = false)
  private Building building;

  @OneToOne
  @JoinColumn(name = "management_id", referencedColumnName = "id", nullable = false)
  private Management management;

  public int getId() {
    return id;
  }

  public void setId(int buildingManagementId) {
    this.id = id;
  }

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

  public Management getManagement() {
    return management;
  }

  public void setManagement(Management management) {
    this.management = management;
  }

  @Override
  public String toString() {
    return "BuildingManagement [id=" + id + ", building="
        + building
        + ", management=" + management + "]";
  }

}
