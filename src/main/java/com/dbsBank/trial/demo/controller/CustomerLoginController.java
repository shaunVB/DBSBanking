package com.dbsBank.trial.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbsBank.trial.demo.model.CustomerLogin;
import com.dbsBank.trial.demo.service.CustomerService;
import com.dbsBank.trial.demo.service.CustomerServiceImpl;

@Controller
public class CustomerLoginController {

		@Autowired
		private CustomerService service;
		@RequestMapping(value = "/customer/login", method = RequestMethod.GET)
		public String createCus()
		{
			return "index1";
		}
		@RequestMapping(value="/customer/login",method=RequestMethod.POST)
		public String createCustomer(CustomerLogin newCustomer,Model model)
		{
			System.out.println(newCustomer.toString()+"\n");
			CustomerServiceImpl cusimpl=new CustomerServiceImpl();

			cusimpl.htmlName=newCustomer.getUsername();
			cusimpl.htmlPass=newCustomer.getPassword();
			System.out.println(cusimpl.htmlName+":"+cusimpl.htmlPass);
			Boolean bolValue=service.addCus(newCustomer);
			System.out.println("\n"+bolValue);
			if(bolValue==true)
			{
				System.out.println("inside cust login contr");
				return "menu";
			}
			else
			{
				return "Index1";
			}
		}

}

