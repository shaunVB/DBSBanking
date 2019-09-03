package com.dbsBank.trial.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsBank.trial.demo.model.BankAdminLogin;

public interface BankAdminDaoRepositroy extends JpaRepository<BankAdminLogin,String>{

}
