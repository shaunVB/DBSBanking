package com.dbsBank.trial.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import com.dbsBank.trial.demo.model.RegisterCustomer;
import org.springframework.stereotype.Component;


@Table(name="custi")
public class UpdateCustomer {
	
	public UpdateCustomer() {
	}

	private String customerID;
	@GeneratedValue
	private String firstname;
	@GeneratedValue
	private String middlename;
	@GeneratedValue
	private String lastname;
	@GeneratedValue
	private String email;
	private String mobile;
	
	
	@Override
	public String toString() {
		return "UpdateCustomer [customerID=" + customerID + ", firstname=" + firstname + ", middlename=" + middlename
				+ ", lastname=" + lastname + ", email=" + email + ", mobile=" + mobile + ", country=" + country + "]";
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	private String country;
	
}
