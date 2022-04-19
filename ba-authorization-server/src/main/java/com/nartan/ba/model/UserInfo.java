package com.nartan.ba.model;

import java.io.Serializable;

/**
 * 
 *
 * @author Eva Hernandez
 */
public class UserInfo implements Serializable {

  private static final long serialVersionUID = 1L;
   
  protected int userId;
  private String name;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String mobileNumber;
  private int userTypeId;
  private String userTypeDescription;
  private int buildingId;
  private String buildingName;
  private String apartmentNumber;
 

   /**
	 * @param vuserLogin
	 */
	public UserInfo(VUserInfo vuserLogin) {
		this.userId = vuserLogin.getUserId();
		this.name = vuserLogin.getName();
		this.lastName = vuserLogin.getLastName();
		this.email = vuserLogin.getEmail();		
		this.phoneNumber = "******" +String.valueOf(vuserLogin.getPhoneNumber()).substring(6);
		this.mobileNumber = "******" + String.valueOf(vuserLogin.getMobileNumber()).substring(6);
		this.userTypeId = vuserLogin.getUserTypeId();
		this.userTypeDescription = vuserLogin.getUserTypeDescription();
		this.buildingId = vuserLogin.getBuildingId();
		this.buildingName = vuserLogin.getBuildingName();
		this.apartmentNumber = vuserLogin.getApartmentNumber();
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	
	
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "VUserInfo [userId=" + userId + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", mobileNumber=" + mobileNumber
				+ ", userTypeId=" + userTypeId + ", userTypeDescription=" + userTypeDescription + ", buildingId="
				+ buildingId + ", buildingName=" + buildingName + ", apartmentNumber=" + apartmentNumber + "]";
	}




}
