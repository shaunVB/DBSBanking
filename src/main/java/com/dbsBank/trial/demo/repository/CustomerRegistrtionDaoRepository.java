package com.dbsBank.trial.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsBank.trial.demo.model.BankAdminLogin;
import com.dbsBank.trial.demo.model.RegisterCustomer;
public interface CustomerRegistrtionDaoRepository extends JpaRepository<RegisterCustomer,Integer>{

}
