package com.nartan.ba.resource.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Persistent BuildingManagement entity with JPA markup. BuildingManagement are stored in an
 * relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "building_management")
public class BuildingManagement implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buildingManagement_gen")
  @SequenceGenerator(name = "buildingManagement_gen", sequenceName = "buildingManagement_seq", allocationSize = 1)
  @Column(name = "buildingManagement_id", nullable = false, unique = true)
  protected int buildingManagementId;

  @OneToOne
  @JoinColumn(name = "building_id", referencedColumnName = "building_id", nullable = false)
  private Building building;

  @OneToOne
  @JoinColumn(name = "management_id", referencedColumnName = "management_id", nullable = false)
  private Management management;

  /**
   * @return the buildingManagementId
   */
  public int getBuildingManagementId() {
    return buildingManagementId;
  }

  /**
   * @param buildingManagementId the buildingManagementId to set
   */
  public void setBuildingManagementId(int buildingManagementId) {
    this.buildingManagementId = buildingManagementId;
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
   * @return the management
   */
  public Management getManagement() {
    return management;
  }

  /**
   * @param management the management to set
   */
  public void setManagement(Management management) {
    this.management = management;
  }

  @Override
  public String toString() {
    return "BuildingManagement [buildingManagementId=" + buildingManagementId + ", building="
        + building
        + ", management=" + management + "]";
  }


}
