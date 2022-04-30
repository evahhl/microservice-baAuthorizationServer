package com.nartan.ba.resource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent country entity with JPA markup.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    protected int id;

    @Column(name = "country_name")
    protected String countryName;

    @Column(name = "status", nullable = false, length = 1)
    protected int status;

    @Column(name = "creation_time", nullable = false, updatable = false)
    protected Timestamp creationTime;

    @Column(name = "modification_time")
    protected Timestamp modificationTime;


    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int countryId) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public void setModificationTime(Timestamp modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "Country [id=" + id + ", countryName=" + countryName + ", status=" + status
                + ", creationTime=" + creationTime + ", modificationTime=" + modificationTime + "]";
    }

}
