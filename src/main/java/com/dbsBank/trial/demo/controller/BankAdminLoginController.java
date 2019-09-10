package com.dbsBank.trial.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbsBank.trial.demo.model.BankAdminLogin;
import com.dbsBank.trial.demo.model.RegisterCustomer;
import com.dbsBank.trial.demo.service.BankAdminLoginServiceImpl;
import com.dbsBank.trial.demo.service.BankAdminService;
import com.dbsBank.trial.demo.service.CustomerRegisterService;

import org.springframework.stereotype.Controller;


@Controller
public class BankAdminLoginController {
	@Autowired
	private BankAdminService service;
	@Autowired
	private CustomerRegisterService CustServ;
	@RequestMapping(value="/bankAdmin/login",method=RequestMethod.GET)
	public String createBankAdmin(BankAdminLogin newbnkAdmin,Model model)
	{
		RegisterCustomer form=new RegisterCustomer();
		model.addAttribute("Successful",form);
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
	@RequestMapping(value="/bankAdmin/login",method=RequestMethod.POST)
//	public String getRegisterDetails(Model model)
	public String getRegisterDetails(@ModelAttribute("registerCustomer") RegisterCustomer registerCustomer)
	{
		//RegisterCustomer registerCustomer=new RegisterCustomer();
		registerCustomer.setCustomerID(14);
		//registerCustomer.setCountry("country");
		CustServ.addCustomer(registerCustomer);
		return "successful";
	}
	@RequestMapping(value="/bankAdmin/modify.html",method=RequestMethod.GET)
	public String goToModify(Model model)
	{
		return "modify";
		
	}
	@RequestMapping(value="/bankAdmin/delete.html",method=RequestMethod.GET)
	public String goToDelete(Model model)
	{
		return "delete";
		
	}@RequestMapping(value="/bankAdmin/LoggedIn.html",method=RequestMethod.GET)
	public String goToLoggedIn(Model model)
	{
		return "LoggedIn";
		
	}
}
