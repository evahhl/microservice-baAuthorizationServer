package com.nartan.ba.resource.model.mappers;

import javax.persistence.*;


/**
 * Persistent Address entity with JPA markup. Address are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "address")
public class Address extends DateBase {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    protected int id;

    @Column(name = "street_name", nullable = false)
    protected String streetName;

    @Column(name = "ext_number", nullable = false)
    protected String extNumber;

    @Column(name = "int_number")
    protected String intNumber;

    @Column(name = "neighborhood", nullable = false)
    protected String neighborhood;
    
   /* @OneToOne	
    @JoinColumn(name = "zip_code", referencedColumnName = "zip_code", nullable = false)
    private ZipCode zipCode;*/

    @Column(name = "zip_code")
    protected String zipCode;

    @OneToOne
    @JoinColumn(name = "municipality_id", referencedColumnName = "id", nullable = false)
    private Municipality municipality;

    @OneToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id", nullable = false)
    private State state;

    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
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

    public String getExtNumber() {
        return extNumber;
    }

    public void setExtNumber(String extNumber) {
        this.extNumber = extNumber;
    }

    public String getIntNumber() {
        return intNumber;
    }

    public void setIntNumber(String interiorNumber) {
        this.intNumber = intNumber;
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

    @Override
    public String toString() {
        return "Address [id=" + id + ", streetName=" + streetName + ", extNumber="
                + extNumber + ", intNumber=" + intNumber + ", neighborhood=" + neighborhood + ", zipCode="
                + zipCode + ", municipality=" + municipality + ", state=" + state + ", country=" + country
                + ", creationTime=" + getCreationTime() + ", modificationTime=" + getModificationTime() + "]";
    }
}
