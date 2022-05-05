package com.nartan.ba.resource.model.mappers;

import javax.persistence.*;

/**
 * Persistent staff entity with JPA markup. Staff are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "staff")
public class Staff extends DateBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  protected int id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "status", nullable = false)
  private int status = 1;

  @OneToOne
  @JoinColumn(name = "building_id", referencedColumnName = "id", nullable = false)
  private Building building;

  public Staff() {
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

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Staff [staffId=" + id + ", name=" + name + ", lastName=" + lastName + ", status="
        + status
        + ", building=" + building + ", dateCreated=" + getCreationTime() + ", dateModified="
        + getModificationTime() + "]";
  }


}
