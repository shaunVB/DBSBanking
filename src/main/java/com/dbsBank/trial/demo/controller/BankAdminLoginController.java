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

import com.dbsBank.trial.demo.exception.EmptyFieldException;
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
	
	
	@RequestMapping(value="/bankAdmin/login",method=RequestMethod.POST)
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
			return "redirect:/";
		}
	}
	@RequestMapping(value="bankAdmin/login",method=RequestMethod.GET)
	public String getRegisterDetails(Model model,@ModelAttribute("registerCustomer") RegisterCustomer registerCustomer)
	{
	System.out.println("---------------------INSIDE----------------");
		registerCustomer.setCustomerID(14);
		System.out.println(registerCustomer.getCustomerID());
		CustServ.addCustomer(registerCustomer);
		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
			OtpGenerateService otpObj = new OtpGenerateService();
			int otp = otpObj.generateOTP(registerCustomer.getUsername());
			String sendOtp=String.valueOf(otp);
			mailService.sendOtpMessage("indrajanallapu@gmail.com","OTP-BANK", sendOtp);
			boolean bolValue = true;
			System.out.println("IN SEND OTp");
		if (bolValue == true) {
			return "Successful";
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
		System.out.print("---------------------IN--------------------");
		return "Successful" ;
		
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
	@RequestMapping(value="/bankAdmin/LoggedIn.html",method=RequestMethod.GET)
	public String goToLoggedIn(Model model)
	{
		return "LoggedIn";
		
	}
	@RequestMapping(value="/bankAdmin/home.html",method=RequestMethod.GET)
	public String goTohome(Model model)
	{
		return "home";
		
	}
	@RequestMapping(value="/bankAdmin/index.html",method=RequestMethod.GET)
	public String goToindex(Model model)
	{
		return "index";
		
	}
	@RequestMapping(value="/bankAdmin/Index1.html",method=RequestMethod.GET)
	public String goToIndex1(Model model)
	{
		return "Index1";
		
	}
	
	@RequestMapping(value="/bankAdmin/Successful.html",method=RequestMethod.GET)
	public String goToSuccessful(Model model)
	{
		return "Successful";
		
	}
	
	@RequestMapping(value = "/bankAdmin/delete.html",method=RequestMethod.GET)
	 public String delete(Model model)
	 {
		RegisterCustomer reg = new RegisterCustomer();
		model.addAttribute("registerCustomer",reg);
		return "delete";
	 }
	@RequestMapping(value= "/bankAdmin/delete.html",method=RequestMethod.POST)
	public String delet(Model model, RegisterCustomer reg)
	{
		Integer id= reg.getCustomerID();
		System.out.print("User deleted" +id);
	 service.delete(id);
		return "LoggeddIn";
	}
	
}
