package com.dbsBank.trial.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbsBank.trial.demo.repository.BankAdminDaoRepositroy;

import com.dbsBank.trial.demo.model.BankAdminLogin;
@Service
public class BankAdminLoginServiceImpl implements BankAdminService {
	public static  String htmlName="";
	public static String htmlPass="";
	@Autowired
	private BankAdminDaoRepositroy bankRepo;
	@Override
	public List<BankAdminLogin> getBankAdmin() {
		// TODO Auto-generated method stub
		return bankRepo.findAll();
	}
	@Override
	public Boolean addBankAdmin(BankAdminLogin newbnkAdmin) {
		// TODO Auto-generated method stub
		List<BankAdminLogin> adminList=bankRepo.findAll();
		Boolean flagSuccess=false;
		
		for(BankAdminLogin a:adminList)
		{
			String dBName=a.getUsername();
			String dBPass=a.getPassword();
			//System.out.println(htmlName+"	"+htmlPass+"	"+dBName+"	"+dBPass);
			if(htmlName.equals(dBName)&&htmlPass.equals(dBPass))
			{
				flagSuccess=true;
				break;
			}
			else
			{
				flagSuccess=false;
			}
		}
		System.out.print(flagSuccess);
		return flagSuccess;
	}

}
