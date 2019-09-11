package com.dbsBank.trial.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbsBank.trial.demo.model.BankAdminLogin;
import com.dbsBank.trial.demo.model.CustomerLogin;
import com.dbsBank.trial.demo.model.RegisterCustomer;
import com.dbsBank.trial.demo.model.UpdateCustomer;
import com.dbsBank.trial.demo.service.BankAdminLoginServiceImpl;
import com.dbsBank.trial.demo.service.BankAdminService;
import com.dbsBank.trial.demo.service.CustomerRegisterService;
import com.dbsBank.trial.demo.service.CustomerService;
import com.dbsBank.trial.demo.service.EmailService;
import com.dbsBank.trial.demo.service.OtpGenerateService;
import com.dbsBank.trial.demo.service.UpdateCustomerService;

import org.springframework.stereotype.Controller;


@Controller
public class BankAdminLoginController {
	@Autowired
	EmailService mailService;
	@Autowired
	private CustomerService serviceC;
	@Autowired
	private BankAdminService service;
	@Autowired
	private CustomerRegisterService CustServ;
	@Autowired
	private UpdateCustomerService CustUpdateSer;
	
	
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
		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
		OtpGenerateService otpObj = new OtpGenerateService();
		int otp = otpObj.generateOTP(registerCustomer.getUsername());
		String sendOtp=String.valueOf(otp);
		mailService.sendOtpMessage("indrajanallapu@gmail.com","OTP-BANK", sendOtp);
		boolean bolValue = true;
		if (bolValue == true) {
			return "successful";
		} else {
			return "Index1";
		}
	}
	@RequestMapping(value="/bankAdmin/modify.html",method=RequestMethod.POST)
	public String getupdateDetails(@ModelAttribute("updateCustomer") UpdateCustomer updateCustomer)
	{
		updateCustomer.setCustomerID("1");
		System.out.println("Inside BaLC");
		CustUpdateSer.updateCustomer(updateCustomer);
		return "LoggedIn";
	}
	@RequestMapping(value="/bankAdmin/otp",method=RequestMethod.GET)
	public String getOtp(Model model)
	{
		return "successful" ;
		
	}
	@RequestMapping(value="/bankAdmin/otp",method=RequestMethod.POST)
	public String successOtp(Model model,@ModelAttribute("registerCustomer") RegisterCustomer registerCustomer)
	{
		System.out.println(registerCustomer.getUsername());
		return "LoggedIn" ;
		
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
