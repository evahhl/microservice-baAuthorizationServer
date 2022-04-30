package com.nartan.ba.resource.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent State entity with JPA markup. States are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "state")
public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    protected int id;

    @Column(name = "state_name", nullable = false, unique = true)
    protected String stateName;

    @Column(name = "status", nullable = false, length = 1)
    protected int status;

    @Column(name = "creation_time", nullable = false, updatable = false)
    protected Timestamp creationTime;

    @Column(name = "modification_time")
    protected Timestamp modificationTime;

    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false, columnDefinition = "int default 1")
    private Country countryId;

    public int getId() {
        return id;
    }

    public void setId(int stateId) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
        return "State [id=" + id + ", stateName=" + stateName + ", status=" + status
                + ", creationTime="
                + creationTime + ", modificationTime=" + modificationTime + "]";
    }

}
