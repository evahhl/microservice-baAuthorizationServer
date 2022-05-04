package com.nartan.ba.resource.model.mappers;

import javax.persistence.*;

/**
 * Persistent building entity with JPA markup. Building are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "building")
public class Building extends DateBase {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    protected int id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "phone_number", nullable = false, length = 10)
    protected String phoneNumber;

    @Column(name = "email", nullable = false)
    protected String email;

    @Column(name = "status", nullable = false, length = 1, columnDefinition = "int default 1")
    protected int status = 1;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

    public Building() {
    }

    public Building(int id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public int getBuildingId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Building [id=" + id + ", name=" + name + ", address="
                + address
                + ", phoneNumber=" + phoneNumber + ", email=" + email + ", status=" + status
                + ", creationTime="
                + getCreationTime() + ", modificationTime=" + getModificationTime() + "]";
    }


}
