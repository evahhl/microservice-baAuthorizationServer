package com.nartan.ba.resource.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Persistent building entity with JPA markup. Building are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "building")
public class Building implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    protected int id;

    @Column(name = "building_name", nullable = false)
    protected String buildingName;

    @Column(name = "phone_number", nullable = false, length = 10)
    protected String phoneNumber;

    @Column(name = "email", nullable = false)
    protected String email;

    @Column(name = "status", nullable = false, length = 1, columnDefinition = "int default 1")
    protected int status = 1;

    @Column(name = "creation_time", nullable = false, updatable = false)
    protected Timestamp creationTime;

    @Column(name = "date_modified")
    protected Timestamp dateModified;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

    public Building() {
    }

    public Building(int id, String buildingName, String phoneNumber, String email,
                    Timestamp creationTime, Timestamp dateModified) {
        this.id = id;
        this.buildingName = buildingName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creationTime = creationTime;
        this.dateModified = dateModified;
    }


    public int getBuildingId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified) {
        this.dateModified = dateModified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Building [id=" + id + ", buildingName=" + buildingName + ", address="
                + address
                + ", phoneNumber=" + phoneNumber + ", email=" + email + ", status=" + status
                + ", creationTime="
                + creationTime + ", dateModified=" + dateModified + "]";
    }


}
