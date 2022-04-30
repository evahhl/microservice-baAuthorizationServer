package com.nartan.ba.resource.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent zip code entity with JPA markup. Zip Codes are stored in an H2 relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "zip_code")
public class ZipCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    protected int id;

    @Column(name = "zip_code", nullable = false)
    protected String zipCode;

    @Column(name = "neighborhood", nullable = false)
    protected String neighborhood;

    @Column(name = "status", nullable = false)
    protected int status;

    @Column(name = "creation_time", nullable = false, updatable = false)
    protected Timestamp creationTime;

    @Column(name = "modification_time")
    protected Timestamp modificationTime;

    @OneToOne
    @JoinColumn(name = "municipality_id", referencedColumnName = "id", nullable = false)
    private Municipality municipality;

    @OneToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id", nullable = false)
    private State state;

    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    public ZipCode() {
    }

    public int getId() {
        return id;
    }

    public void setId(int zipCodeId) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public void setModificationTime(Timestamp dateModified) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "ZipCode [id=" + id + ", zipCode=" + zipCode + ", neighborhood="
                + neighborhood
                + ", municipality=" + municipality + ", state=" + state + ", country=" + country
                + ", status=" + status + ", creationTime=" + creationTime + ", modificationTime=" + modificationTime
                + "]";
    }

}

    