package com.dbsBank.trial.demo.entity;


	import java.util.Date;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.Table;
	@Entity
	@Table(name="bank_Account")
	public class BankAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="balance",nullable=false)
	private double balance;
	@Column(name="full_name",length=50,nullable=false)
	private String fullName;
	private Date date;
	private Long toAccount;
	private Long fromAccount;
	private double amount;

	

	public BankAccount(Long id, double balance, String fullName, Date date, Long toAccount, Long fromAccount,
			double amount) {
		super();
		this.id = id;
		this.balance = balance;
		this.fullName = fullName;
		this.date = date;
		this.toAccount = toAccount;
		this.fromAccount = fromAccount;
		this.amount = amount;
	}



	public BankAccount(Long id, String fullName, double balance) {
		super();
		this.id = id;
		this.balance = balance;
		this.fullName = fullName;
	}



	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Long getFromAccount() {
		return fromAccount;
	}



	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}


	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", fullName=" + fullName + ", balance=" + balance + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	}


