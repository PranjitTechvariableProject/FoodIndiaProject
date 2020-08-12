package com.techVariable.FoodIndia.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")

public class UserVO {
	@Id
	@Column(name="CUSTOMER_ID")
	private int id;
	@Column(name="CUSTOMER_NAME")
	private String name;
	@Column(name="CUSTOMER_PHONE_NUMBER")
	private String phoneNumber;
	@Column(name="EMAIL_ADDRESS")
	private String email;
	@Column(name="STATE")
	private String state;
	@Column(name="CONTRY")
	private String country;
	@Column(name="ADDRESSLINE2F")
	private String addressLine1;
	@Column(name="ADDRESS_LINE1")
	private String addressLine2;
	@Column(name="ZIP_CODE")
	private int zipCode;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", state="
				+ state + ", country=" + country + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", zipCode=" + zipCode + "]";
	}


}
