package com.nartan.ba.resource.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent country entity with JPA markup.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "cat_country")
public class Country implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_gen")
  @SequenceGenerator(name = "country_gen", sequenceName = "country_seq", allocationSize = 1)
  @Column(name = "country_id", nullable = false)
  protected int countryId;

  @Column(name = "country_name")
  protected String countryName;

  @Column(name = "status", nullable = false, length = 1)
  protected int status;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;


  public Country() {
  }


  /**
   * @return the countryId
   */
  public int getCountryId() {
    return countryId;
  }


  /**
   * @param countryId the countryId to set
   */
  public void setCountryId(int countryId) {
    this.countryId = countryId;
  }


  /**
   * @return the countryName
   */
  public String getCountryName() {
    return countryName;
  }


  /**
   * @param countryName the countryName to set
   */
  public void setCountryName(String countryName) {
    this.countryName = countryName;
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
    return "Country [countryId=" + countryId + ", countryName=" + countryName + ", status=" + status
        + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + "]";
  }


}
