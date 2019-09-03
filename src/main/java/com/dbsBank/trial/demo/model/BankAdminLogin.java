package com.dbsBank.trial.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table(name="bankadminlogin")
@Entity
public class BankAdminLogin {
	@Id
	private String username;
	public BankAdminLogin() {
	}
	@Override
	public String toString() {
		return "BankAdminLogin [username=" + username + ", password=" + password + "]";
	}
	private String password;
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
	

}
