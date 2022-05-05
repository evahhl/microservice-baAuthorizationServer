package com.nartan.ba.resource.model;

import com.nartan.ba.resource.model.mappers.Country;
import com.nartan.ba.resource.model.mappers.DateBase;
import com.nartan.ba.resource.model.mappers.City;
import com.nartan.ba.resource.model.mappers.State;

public class AddressResponse extends DateBase {

    private static final long serialVersionUID = 1L;

    protected int id;

    protected String streetName;

    protected String extNumber;

    protected String intNumber;

    protected String neighborhood;

    protected String zipCode;

    private City city;

    private State state;

    private Country country;

    public AddressResponse() {
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

    public void setExtNumber(String exteriorNumber) {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
                + zipCode + ", city=" + city + ", state=" + state + ", country=" + country
                + ", creationTime=" + getCreationTime() + ", modificationTime=" + getModificationTime() + "]";
    }
}
