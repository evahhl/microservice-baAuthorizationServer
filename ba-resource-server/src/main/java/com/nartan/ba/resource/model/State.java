package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent State entity with JPA markup. States are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "cat_state")
public class State implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_gen")
  @SequenceGenerator(name = "state_gen", sequenceName = "state_seq", allocationSize = 1)
  @Column(name = "state_id", nullable = false, unique = true)
  protected int stateId;

  @Column(name = "state_name", nullable = false, unique = true)
  protected String stateName;

  @OneToOne
  @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false, columnDefinition = "int default 1")
  private Country countryId;

  @Column(name = "status", nullable = false, length = 1)
  protected int status;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public int getStateId() {
    return stateId;
  }

  public void setStateId(int stateId) {
    this.stateId = stateId;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
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
    return "State [stateId=" + stateId + ", stateName=" + stateName + ", status=" + status
        + ", dateCreated="
        + dateCreated + ", dateModified=" + dateModified + "]";
  }


}
