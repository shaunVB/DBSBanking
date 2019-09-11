package com.dbsBank.trial.demo.service;

import com.dbsBank.trial.demo.exception.EmptyFieldException;
import com.dbsBank.trial.demo.model.RegisterCustomer;

public interface CustomerRegisterService {
	RegisterCustomer addCustomer(RegisterCustomer newCustomerRegister);
}
