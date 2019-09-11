package com.dbsBank.trial.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsBank.trial.demo.model.UpdateCustomer;

public interface CustomerUpdateDaoRepository extends JpaRepository<UpdateCustomer,String>{

}
