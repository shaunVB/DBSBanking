package com.dbsBank.trial.demo.form;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.stereotype.Component;

import com.dbsBank.trial.demo.service.CustomerServiceImpl;

public class SendMoneyForm {
	public SendMoneyForm(Long fromAccountId, Long toAccountId, Double amount) {
}
	public SendMoneyForm() {
	}
	int acc_numb=CustomerServiceImpl.account_number;
	String name=CustomerServiceImpl.usernameHold;
	private Long fromAccountId;
	public Long getFromAccountId() {
		return (long) this.acc_numb;
		//fromAccountId;
	}
	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public Long getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	private Long toAccountId;
	private Double amount;

}

