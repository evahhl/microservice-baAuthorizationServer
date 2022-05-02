package com.nartan.ba.resource.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * Persistent apartment entity with JPA markup. Apartment are stored in an relational database.
 *
 * @author Eva Hernandez
 */
public class DateBase implements Serializable {

    @Column(name = "creation_time", nullable = false, updatable = false)
    private Date creationTime;

    @Column(name = "modification_time")
    private Date modificationTime;

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "Base [creationTime=" + creationTime + ", modificationTime=" + modificationTime + "]";
    }
}