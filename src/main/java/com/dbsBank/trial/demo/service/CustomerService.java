package com.dbsBank.trial.demo.service;

import java.util.List;

import com.dbsBank.trial.demo.model.CustomerLogin;

public interface CustomerService {
	
	public List<CustomerLogin> getcustomers();

	

	public Boolean addCus(CustomerLogin newCustomer);


	
}
