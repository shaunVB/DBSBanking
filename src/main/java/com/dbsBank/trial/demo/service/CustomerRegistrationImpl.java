package com.dbsBank.trial.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dbsBank.trial.demo.repository.CustomerRegistrtionDaoRepository;
import com.dbsBank.trial.demo.exception.EmptyFieldException;
import com.dbsBank.trial.demo.model.RegisterCustomer;
@Service
public class CustomerRegistrationImpl implements  CustomerRegisterService{
	@Autowired
	private CustomerRegistrtionDaoRepository custRepo;
	@Override
	public RegisterCustomer addCustomer(RegisterCustomer newCustomerRegister) {
		// TODO Auto-generated method stub
			return custRepo.save(newCustomerRegister);
		
		
		
	}

}
