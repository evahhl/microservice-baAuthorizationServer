package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent zip code entity with JPA markup. Zip Codes are stored in an H2 relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "cat_zip_code")
public class ZipCode implements Serializable {

  private static final long serialVersionUID = 1L;


  @Id
  @Column(name = "zip_code_id", nullable = false)
  protected int zipCodeId;

  @Column(name = "zip_code", nullable = false)
  protected String zipCode;

  @Column(name = "neighborhood", nullable = false)
  protected String neighborhood;

  @OneToOne
  @JoinColumn(name = "municipality_id", referencedColumnName = "municipality_id", nullable = false)
  private Municipality municipality;

  @OneToOne
  @JoinColumn(name = "state_id", referencedColumnName = "state_id", nullable = false)
  private State state;


  @OneToOne
  @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
  private Country country;

  @Column(name = "status", nullable = false)
  protected int status;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public ZipCode() {
  }

  /**
   * @return the zipCodeId
   */
  public int getZipCodeId() {
    return zipCodeId;
  }

  /**
   * @param zipCodeId the zipCodeId to set
   */
  public void setZipCodeId(int zipCodeId) {
    this.zipCodeId = zipCodeId;
  }

  /**
   * @return the zipCode
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * @param zipCode the zipCode to set
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  /**
   * @return the neighborhood
   */
  public String getNeighborhood() {
    return neighborhood;
  }

  /**
   * @param neighborhood the neighborhood to set
   */
  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  /**
   * @return the municipality
   */
  public Municipality getMunicipality() {
    return municipality;
  }

  /**
   * @param municipality the municipalityId to set
   */
  public void setMunicipality(Municipality municipality) {
    this.municipality = municipality;
  }

  /**
   * @return the state
   */
  public State getState() {
    return state;
  }

  /**
   * @param stateId the state to set
   */
  public void setState(State state) {
    this.state = state;
  }

  /**
   * @return the country
   */
  public Country getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(Country country) {
    this.country = country;
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
    return "ZipCode [zipCodeId=" + zipCodeId + ", zipCode=" + zipCode + ", neighborhood="
        + neighborhood
        + ", municipality=" + municipality + ", state=" + state + ", country=" + country
        + ", status=" + status + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified
        + "]";
  }


}

    