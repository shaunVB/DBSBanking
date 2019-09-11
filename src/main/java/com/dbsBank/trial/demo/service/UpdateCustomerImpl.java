package com.dbsBank.trial.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbsBank.trial.demo.model.UpdateCustomer;
import com.dbsBank.trial.demo.repository.CustomerUpdateDaoRepository;

@Service
public class UpdateCustomerImpl implements UpdateCustomerService{
	@Autowired
	private CustomerUpdateDaoRepository custRepoUpdate;
	@Override
	public UpdateCustomer updateCustomer(UpdateCustomer newUpdateCustomer) {
		// TODO Auto-generated method stub
		System.out.println("Inside serv impl update");
		return custRepoUpdate.save(newUpdateCustomer);
	}

}