package com.nartan.ba.resource.model;

import com.nartan.ba.resource.model.Country;
import com.nartan.ba.resource.model.Municipality;
import com.nartan.ba.resource.model.State;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Persistent Address entity with JPA markup. Address are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_gen")
  @SequenceGenerator(name = "address_gen", sequenceName = "address_seq", allocationSize = 1)
  @Column(name = "address_id", nullable = false, unique = true)
  protected int addressId;

  @Column(name = "street_name", nullable = false)
  protected String streetName;

  @Column(name = "exterior_number", nullable = false)
  protected String exteriorNumber;

  @Column(name = "interior_number")
  protected String interiorNumber;

  @Column(name = "neighborhood", nullable = false)
  protected String neighborhood;
    
   /* @OneToOne	
    @JoinColumn(name = "zip_code", referencedColumnName = "zip_code", nullable = false)
    private ZipCode zipCode;*/

  @Column(name = "zip_code")
  protected String zipCode;

  @OneToOne
  @JoinColumn(name = "municipality_id", referencedColumnName = "municipality_id", nullable = false)
  private Municipality municipality;

  @OneToOne
  @JoinColumn(name = "state_id", referencedColumnName = "state_id", nullable = false)
  private State state;

  @OneToOne
  @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
  private Country country;

  @Column(name = "date_created", nullable = false, updatable = false)
  @CreationTimestamp
  protected Timestamp dateCreated;

  @Column(name = "date_modified")
  @UpdateTimestamp
  protected Timestamp dateModified;

  public Address() {
  }

  /**
   * @return the addressId
   */
  public int getAddressId() {
    return addressId;
  }

  /**
   * @param addressId the addressId to set
   */
  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }

  /**
   * @return the streetName
   */
  public String getStreetName() {
    return streetName;
  }

  /**
   * @param streetName the streetName to set
   */
  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  /**
   * @return the exteriorNumber
   */
  public String getExteriorNumber() {
    return exteriorNumber;
  }

  /**
   * @param exteriorNumber the exteriorNumber to set
   */
  public void setExteriorNumber(String exteriorNumber) {
    this.exteriorNumber = exteriorNumber;
  }

  /**
   * @return the interiorNumber
   */
  public String getInteriorNumber() {
    return interiorNumber;
  }

  /**
   * @param interiorNumber the interiorNumber to set
   */
  public void setInteriorNumber(String interiorNumber) {
    this.interiorNumber = interiorNumber;
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
   * @return the municipality
   */
  public Municipality getMunicipality() {
    return municipality;
  }

  /**
   * @param municipality the municipality to set
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
   * @param state the state to set
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
    return "Address [addressId=" + addressId + ", streetName=" + streetName + ", exteriorNumber="
        + exteriorNumber
        + ", interiorNumber=" + interiorNumber + ", neighborhood=" + neighborhood + ", zipCode="
        + zipCode
        + ", municipality=" + municipality + ", state=" + state + ", country=" + country
        + ", dateCreated="
        + dateCreated + ", dateModified=" + dateModified + "]";
  }


}
