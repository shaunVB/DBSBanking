package com.dbsBank.trial.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsBank.trial.demo.model.CustomerLogin;

public interface CustomerDaoRepository extends JpaRepository<CustomerLogin, String> {

}

