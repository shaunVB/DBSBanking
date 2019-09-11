package com.dbsBank.trial.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table(name="custi")
@Entity
public class CustomerLogin {
	
	@Id
	private String username;
	private String password;
	private int account_no;
	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public CustomerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerLogin [username=" + username + ", password=" + password + ", account_no=" + account_no + "]";
	}

	
	
	

}

