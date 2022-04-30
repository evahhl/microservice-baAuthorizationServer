package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent Municipality entity with JPA markup. Municipalities are stored in an relational
 * database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "municipality")
public class Municipality implements Serializable {

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

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

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
    return "Municipality [id=" + id + ", municipalityName="
        + municipalityName
        + ", stateId=" + stateId + ", status=" + status + ", dateCreated=" + dateCreated
        + ", dateModified="
        + dateModified + "]";
  }


}
