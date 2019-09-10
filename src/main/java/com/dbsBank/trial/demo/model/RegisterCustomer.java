package com.dbsBank.trial.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.stereotype.Component;
@Component
@Table(name="custi")
@Entity
public class RegisterCustomer {
	public RegisterCustomer() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerID=88000;
	@GeneratedValue
	private String salutation;
	@GeneratedValue
	private String firstname;
	@GeneratedValue
	private String middlename;
	@GeneratedValue
	private String lastname;
	@GeneratedValue
	private String gender;
	@GeneratedValue
	private String email;
	@GeneratedValue
	private String pan;
	@GeneratedValue
	private String aadhar;
	@GeneratedValue
	private String mobile;
	@GeneratedValue
	private String country;
	@Override
	public String toString() {
		return "RegisterCustomer [customerID=" + customerID + ", salutation=" + salutation + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", gender=" + gender + ", email=" + email
				+ ", pan=" + pan + ", aadhar=" + aadhar + ", mobile=" + mobile + ", country=" + country + "]";
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}
