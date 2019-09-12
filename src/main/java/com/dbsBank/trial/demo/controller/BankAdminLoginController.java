package com.dbsBank.trial.demo.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dbsBank.trial.demo.model.BankAdminLogin;
import com.dbsBank.trial.demo.model.CustomerList;
import com.dbsBank.trial.demo.model.OtpEntity;
import com.dbsBank.trial.demo.model.RegisterCustomer;
import com.dbsBank.trial.demo.model.UpdateCustomer;
import com.dbsBank.trial.demo.repository.CustomerListDao;
import com.dbsBank.trial.demo.service.BankAdminLoginServiceImpl;
import com.dbsBank.trial.demo.service.BankAdminService;
import com.dbsBank.trial.demo.service.CustomerRegisterService;
import com.dbsBank.trial.demo.service.CustomerService;
import com.dbsBank.trial.demo.service.EmailService;
import com.dbsBank.trial.demo.service.OtpGenerateService;
import com.dbsBank.trial.demo.service.UpdateCustomerService;

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
	@Autowired
	private CustomerListDao customerList;
	
	public static String otpGlb="";
	
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
	public String getRegisterDetails(@ModelAttribute("registerCustomer") RegisterCustomer registerCustomer)
	{
	System.out.println("---------------------INSIDE----------------");
		//registerCustomer.setCustomerID(14);
		//System.out.println(registerCustomer.getCustomerID());
		CustServ.addCustomer(registerCustomer);
		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
			OtpGenerateService otpObj = new OtpGenerateService();
			int otp = otpObj.generateOTP(registerCustomer.getUsername());
			String sendOtp=String.valueOf(otp);
			otpGlb=sendOtp;
			String mailID=registerCustomer.getEmail();
			mailService.sendOtpMessage(mailID,"OTP-BOH", "Pleasse verify the otp for your account\n"+sendOtp);
			boolean bolValue = true;
			//System.out.println("IN SEND OTp");
		if (bolValue == true) {
			return "Successful";
		} else {
			return "Index1";
		}
	}
	
	@RequestMapping(value="/bankAdmin/modify.html",method=RequestMethod.POST)
	public String getupdateDetails(@ModelAttribute("updateCustomer") UpdateCustomer updateCustomer)
	{
		System.out.println(updateCustomer.getCustomerID());
		//updateCustomer.setCustomerID("1");
		updateCustomer.setCustomerID(updateCustomer.getCustomerID());
		updateCustomer.setAccount_bal(5000);
		
		CustUpdateSer.updateCustomer(updateCustomer);
		return "modifymessage";
	}
	@RequestMapping(value="/bankAdmin/otp",method=RequestMethod.GET)
	public String getOtp(Model model,@ModelAttribute("getOtp") OtpEntity otp)
	{
		String p=otp.getOtp();
		//System.out.println(p);
		if(BankAdminLoginController.otpGlb.equals(p))
		{
			//System.out.print("---------------------IN--------------------");
			return "registeredmessage" ;
				
		}
		//System.out.print("---------------------Fail--------------------");
		return "successful" ;
		
	}
	@RequestMapping(value="/bankAdmin/otp",method=RequestMethod.POST)
	public String successOtp(Model model,@ModelAttribute("registerCustomer") RegisterCustomer registerCustomer)
	{
		System.out.println(registerCustomer.getUsername());
		//System.out.println("POST -------IN");
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
	
	@RequestMapping(value="/bankAdmin/registeredmessage.html",method=RequestMethod.GET)
	public String goToregisteredmessage(Model model)
	{
		return "registeredmessage";
		
	}
	
	@RequestMapping(value="/bankAdmin/modifymessage.html",method=RequestMethod.GET)
	public String goTomodifymessage(Model model)
	{
		return "modifymessage";
		
	}
	
	@RequestMapping(value="/bankAdmin/deletemessage.html",method=RequestMethod.GET)
	public String goTodeletemessage(Model model)
	{
		return "deletemessage";
		
	}
	
	@RequestMapping(value="/bankAdmin/faq.html",method=RequestMethod.GET)
	public String goTofaq(Model model)
	{
		return "faq";
		
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
		//System.out.print("User deleted" +id);
		service.delete(id);
		return "deletemessage";
	}
	@RequestMapping(value="/bankAdmin/showList.html",method=RequestMethod.GET)
	public String showCustomerList(Model model)
	{
		List<CustomerList> cusList=customerList.findAll();
		model.addAttribute("CustList",cusList);
		return "showList";
	}
}
