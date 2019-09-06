package com.dbsBank.trial.demo.form;

public class SendMoneyForm {
	public SendMoneyForm(Long fromAccountId, Long toAccountId, Double amount) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}
	public SendMoneyForm() {
	}
	private Long fromAccountId;
	public Long getFromAccountId() {
		return fromAccountId;
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

