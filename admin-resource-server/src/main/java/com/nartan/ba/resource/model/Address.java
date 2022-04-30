package com.nartan.ba.resource.model;

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
    @Column(name = "id", nullable = false, unique = true)
    protected int id;

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

    @Column(name = "creation_time", nullable = false, updatable = false)
    protected Timestamp creationTime;

    @Column(name = "modification_time")
    protected Timestamp modificationTime;

    @OneToOne
    @JoinColumn(name = "municipality_id", referencedColumnName = "municipality_id", nullable = false)
    private Municipality municipality;

    @OneToOne
    @JoinColumn(name = "state_id", referencedColumnName = "state_id", nullable = false)
    private State state;

    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private Country country;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getExteriorNumber() {
        return exteriorNumber;
    }

    public void setExteriorNumber(String exteriorNumber) {
        this.exteriorNumber = exteriorNumber;
    }

    public String getInteriorNumber() {
        return interiorNumber;
    }

    public void setInteriorNumber(String interiorNumber) {
        this.interiorNumber = interiorNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Timestamp modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", streetName=" + streetName + ", exteriorNumber="
                + exteriorNumber
                + ", interiorNumber=" + interiorNumber + ", neighborhood=" + neighborhood + ", zipCode="
                + zipCode
                + ", municipality=" + municipality + ", state=" + state + ", country=" + country
                + ", creationTime="
                + creationTime + ", modificationTime=" + modificationTime + "]";
    }
}
