package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent staff entity with JPA markup. Staff are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "staff")
public class Staff implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_gen")
  @SequenceGenerator(name = "staff_gen", sequenceName = "staff_seq", allocationSize = 1)
  @Column(name = "staff_id", nullable = false, unique = true)
  protected int staffId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "status", nullable = false)
  private int status = 1;

  @OneToOne
  @JoinColumn(name = "building_id", referencedColumnName = "building_id", nullable = false)
  private Building building;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public Staff() {
  }

  /**
   * @return the staffId
   */
  public int getStaffId() {
    return staffId;
  }

  /**
   * @param staffId the staffId to set
   */
  public void setStaffId(int staffId) {
    this.staffId = staffId;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
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
    return "Staff [staffId=" + staffId + ", name=" + name + ", lastName=" + lastName + ", status="
        + status
        + ", building=" + building + ", dateCreated=" + dateCreated + ", dateModified="
        + dateModified + "]";
  }


}
