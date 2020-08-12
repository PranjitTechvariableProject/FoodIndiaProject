package com.techVariable.FoodIndia.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendor")
public class VendorVO {
	@Id
	@Column(name="VENDOR_ID")
	private int id;
	@Column(name="VENDOR_NAME")
	private String name;
	@Column(name="VENDOR_PHONE_NUMBER")
	private String phoneNumber;
	@Column(name="JOINING_DATE")
	private Date joiningDate;
	@Column(name="STATE")
	private String state;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	@Column(name="ZIP_CODE")
	private int zipCode;
	@Override
	public String toString() {
		return "VendorVO [name=" + name + ", phoneNumber=" + phoneNumber + ", joiningDate=" + joiningDate + ", state="
				+ state + ", country=" + country + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", zipCode=" + zipCode + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
