package com.nartan.ba.resource.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Persistent apartment entity with JPA markup. Apartment are stored in an relational database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "apartment")
public class Apartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    protected int id;

    @Column(name = "apartment_number", nullable = false)
    protected String apartmentNumber;

    @Column(name = "room_number")
    protected int roomNumber;

    @Column(name = "bathroom_number")
    protected int bathroomNumber;

    @Column(name = "size")
    protected int size;

    @Column(name = "parkingNumber")
    protected int parking_number;

    @Column(name = "location")
    protected String location;

    @Column(name = "balcony_number")
    protected int balconyNumber;

    @Column(name = "creation_time", nullable = false, updatable = false)
    protected Timestamp creationTime;

    @Column(name = "modification_time")
    protected Timestamp modificationTime;

    @OneToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id", nullable = false)
    private Building building;

    public Apartment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBathroomNumber() {
        return bathroomNumber;
    }

    public void setBathroomNumber(int bathroomNumber) {
        this.bathroomNumber = bathroomNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getParking_number() {
        return parking_number;
    }

    public void setParking_number(int parking_number) {
        this.parking_number = parking_number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBalconyNumber() {
        return balconyNumber;
    }

    public void setBalconyNumber(int balconyNumber) {
        this.balconyNumber = balconyNumber;
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
        return "Apartment [id=" + id + ", apartmentNumber=" + apartmentNumber
                + ", building="
                + building + ", roomNumber=" + roomNumber + ", bathroomNumber=" + bathroomNumber + ", size="
                + size
                + ", parking_number=" + parking_number + ", location=" + location + ", balconyNumber="
                + balconyNumber
                + ", creationTime=" + creationTime + ", modificationTime=" + modificationTime + "]";
    }
}
