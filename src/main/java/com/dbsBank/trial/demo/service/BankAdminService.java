package com.dbsBank.trial.demo.service;

import java.util.List;

import com.dbsBank.trial.demo.model.BankAdminLogin;;

public interface BankAdminService {
	List<BankAdminLogin> getBankAdmin();

	Boolean addBankAdmin(BankAdminLogin newbnkAdmin);
}
