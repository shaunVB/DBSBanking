package com.dbsBank.trial.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbsBank.trial.demo.model.CustomerLogin;
import com.dbsBank.trial.demo.repository.CustomerDaoRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	public static  String htmlName="";
	public static String htmlPass="";
	public static  String usernameHold="";
	public static int account_number;
	@Autowired
	CustomerDaoRepository cusRepo;
	@Override
	public List<CustomerLogin> getcustomers() {
		// TODO Auto-generated method stub
		return cusRepo.findAll();
	}
	@Override
	public Boolean addCus(CustomerLogin cus) {
		// TODO Auto-generated method stub
		CustomerLogin cl=new CustomerLogin();
		this.usernameHold=cl.getUsername();
		this.account_number=cl.getAccount_no();
		List<CustomerLogin> adminList=cusRepo.findAll();
		Boolean flagSuccess=false;
		
		for(CustomerLogin a:adminList)
		{
			
			String cusLogname=a.getUsername();
			System.out.print(cusLogname+"datauser\n");
			String cusLogpass=a.getPassword();
			System.out.print(cusLogpass+"datapass\n");
			System.out.println(htmlName+"	"+htmlPass+"	"+cusLogname+"	"+cusLogpass);
			if(htmlName.equals(cusLogname)&&htmlPass.equals(cusLogpass))
			{
				flagSuccess=true;
				break;
			}
			else
			{
				flagSuccess=false;
			}
		}
		System.out.print("\nflag:"+flagSuccess);
		return flagSuccess;
	}
	
}
