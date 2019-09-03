package com.dbsBank.trial.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.dbsBank.trial.demo.model.BankAdminLogin;
import com.dbsBank.trial.demo.service.BankAdminLoginServiceImpl;
import com.dbsBank.trial.demo.service.BankAdminService;
import org.springframework.stereotype.Controller;


@Controller
public class BankAdminLoginController {
	@Autowired
	private BankAdminService service;
	@RequestMapping(value="/bankAdmin/login",method=RequestMethod.POST)
	public String createBankAdmin(BankAdminLogin newbnkAdmin,Model model)
	{
		System.out.println(newbnkAdmin.toString());
		BankAdminLoginServiceImpl balsi=new BankAdminLoginServiceImpl();
		balsi.htmlName=newbnkAdmin.getUsername();
		balsi.htmlPass=newbnkAdmin.getPassword();
		System.out.println(balsi.htmlName+":"+balsi.htmlPass);
		Boolean bolValue=service.addBankAdmin(newbnkAdmin);
		System.out.println(bolValue);
		if(bolValue==true)
		{
			return "LoggedIn";
		}
		else
		{
			return "Index";
		}
	}

}
