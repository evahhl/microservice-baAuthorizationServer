package com.nartan.ba.resource.model.mappers;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Persistent State entity with JPA markup. States are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "state")
public class State extends DateBase {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    protected int id;

    @Column(name = "state_name", nullable = false, unique = true)
    protected String stateName;

    @JsonIgnore
    @Column(name = "status", nullable = false, length = 1, columnDefinition = "int default 1")
    protected int status;


    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false, columnDefinition = "int default 1")
    private Country countryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "State [id=" + id + ", stateName=" + stateName + ", status=" + status
                + ", creationTime="
                + getCreationTime() + ", modificationTime=" + getModificationTime() + "]";
    }

}
