package com.dbsBank.trial.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsBank.trial.demo.model.CustomerList;

public interface CustomerListDao extends JpaRepository<CustomerList, Integer>{
	

}
