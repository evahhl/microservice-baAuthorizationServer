package com.nartan.ba.resource.model;

import javax.persistence.*;

/**
 * Persistent Municipality entity with JPA markup. Municipalities are stored in an relational
 * database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "municipality")
public class Municipality extends DateBase {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false, unique = true)
  protected int id;

  @Column(name = "municipality_name", nullable = false)
  protected String municipalityName;

  @Column(name = "state_id", nullable = false)
  protected int stateId;

  @Column(name = "status", nullable = false, length = 1)
  protected int status;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMunicipalityName() {
    return municipalityName;
  }

  public void setMunicipalityName(String municipalityName) {
    this.municipalityName = municipalityName;
  }

  public int getStateId() {
    return stateId;
  }

  public void setStateId(int stateId) {
    this.stateId = stateId;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Municipality [id=" + id + ", municipalityName="
        + municipalityName
        + ", stateId=" + stateId + ", status=" + status + ", dateCreated=" + getCreationTime()
        + ", dateModified="
        + getModificationTime() + "]";
  }


}
