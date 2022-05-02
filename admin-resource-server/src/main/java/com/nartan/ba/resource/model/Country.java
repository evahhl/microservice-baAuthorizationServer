package com.nartan.ba.resource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent country entity with JPA markup.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "country")
public class Country extends DateBase {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    protected int id;

    @Column(name = "country_name")
    protected String countryName;

    @Column(name = "status", nullable = false, length = 1)
    protected int status;

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Country [id=" + id + ", countryName=" + countryName + ", status=" + status
                + ", creationTime=" + getCreationTime() + ", modificationTime=" + getModificationTime() + "]";
    }

}
