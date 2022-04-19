package com.nartan.ba.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent User Building entity with JPA markup. User Building are stored in an relational
 * database.
 *
 * @author Eva Hernandez
 */
@Entity
@Table(name = "v_user_info")
public class VUserInfo implements Serializable {

  private static final long serialVersionUID = 1L;
 
  @Id
  @Column(name = "user_id", nullable = false, unique = true)
  protected int userId;
  
  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false)
  private String email;
  
  @Column(name = "password", nullable = false)
  protected String password;

  @Column(name = "phone_number", nullable = false, length = 10)
  private int phoneNumber;

  @Column(name = "mobile_phone", nullable = false, length = 10)
  private int mobileNumber;
 
  @Column(name = "user_type_id", nullable = false, unique = true)
  private int userTypeId;

  @Column(name = "user_type_description", nullable = false, unique = true)
  private String userTypeDescription;
  
  @Column(name = "building_id")
  private int buildingId;

  @Column(name = "building_name")
  private String buildingName;
  
  @Column(name = "apartment_number")
  private String apartmentNumber;
  
  public VUserInfo() {
  }



/**
 * @return the userId
 */
public int getUserId() {
	return userId;
}



/**
 * @param userId the userId to set
 */
public void setUserId(int userId) {
	this.userId = userId;
}



/**
 * @return the name
 */
public String getName() {
	return name;
}



/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}



/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}



/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}



/**
 * @return the email
 */
public String getEmail() {
	return email;
}



/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}



/**
 * @return the phoneNumber
 */
public int getPhoneNumber() {
	return phoneNumber;
}



/**
 * @param phoneNumber the phoneNumber to set
 */
public void setPhoneNumber(int phoneNumber) {
	this.phoneNumber = phoneNumber;
}



/**
 * @return the mobileNumber
 */
public int getMobileNumber() {
	return mobileNumber;
}



/**
 * @param mobileNumber the mobileNumber to set
 */
public void setMobileNumber(int mobileNumber) {
	this.mobileNumber = mobileNumber;
}



/**
 * @return the userTypeId
 */
public int getUserTypeId() {
	return userTypeId;
}



/**
 * @param userTypeId the userTypeId to set
 */
public void setUserTypeId(int userTypeId) {
	this.userTypeId = userTypeId;
}



/**
 * @return the userTypeDescription
 */
public String getUserTypeDescription() {
	return userTypeDescription;
}



/**
 * @param userTypeDescription the userTypeDescription to set
 */
public void setUserTypeDescription(String userTypeDescription) {
	this.userTypeDescription = userTypeDescription;
}



/**
 * @return the buildingId
 */
public int getBuildingId() {
	return buildingId;
}



/**
 * @param buildingId the buildingId to set
 */
public void setBuildingId(int buildingId) {
	this.buildingId = buildingId;
}



/**
 * @return the buildingName
 */
public String getBuildingName() {
	return buildingName;
}



/**
 * @param buildingName the buildingName to set
 */
public void setBuildingName(String buildingName) {
	this.buildingName = buildingName;
}



/**
 * @return the apartmentNumber
 */
public String getApartmentNumber() {
	return apartmentNumber;
}



/**
 * @param apartmentNumber the apartmentNumber to set
 */
public void setApartmentNumber(String apartmentNumber) {
	this.apartmentNumber = apartmentNumber;
}





/**
 * @return the password
 */
public String getPassword() {
	return password;
}



/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}



/**
 * @return the serialversionuid
 */
public static long getSerialversionuid() {
	return serialVersionUID;
}



@Override
public String toString() {
	return "VUserInfo [userId=" + userId + ", name=" + name + ", lastName=" + lastName + ", email=" + email
			+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", mobileNumber=" + mobileNumber
			+ ", userTypeId=" + userTypeId + ", userTypeDescription=" + userTypeDescription + ", buildingId="
			+ buildingId + ", buildingName=" + buildingName + ", apartmentNumber=" + apartmentNumber + "]";
}




}
