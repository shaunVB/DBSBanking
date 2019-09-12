package com.dbsBank.trial.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table(name="custi")
@Entity
public class CustomerList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customerID")
	private int customerID;
	@Column(name="account_no")
	private int account_no;
	@Column(name="email")
	private String email;
	@Column(name="firstname")
	private String firstname;
	@Column(name="account_bal")
	private int account_bal;
	
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public int getAccount_bal() {
		return account_bal;
	}
	public void setAccount_bal(int account_bal) {
		this.account_bal = account_bal;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerList [customerID=" + customerID + ", account_no=" + account_no + ", account_bal=" + account_bal
				+ ", firstname=" + firstname + ", email=" + email + "]";
	}
}
