package com.dbsBank.trial.demo.entity;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;
	@Entity
	@Table(name="bank_Account")
	public class BankAccount {
	public BankAccount() {
		}
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;
	public BankAccount(Long id, String fullName, double balance) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.balance = balance;
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
	@Column(name="full_name",length=50,nullable=false)
	private String fullName;
	@Column(name="balance",nullable=false)
	private double balance;
	}


