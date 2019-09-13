package com.dbsBank.trial.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbsBank.trial.demo.dao.BankAccountDao;
import com.dbsBank.trial.demo.entity.BankAccount;
import com.dbsBank.trial.demo.exception.BankTransactionException;
import com.dbsBank.trial.demo.form.SendMoneyForm;
import com.dbsBank.trial.demo.model.CustomerList;

@Controller
public class HomeController {
@Autowired
private BankAccountDao bankAccountDAO;

@RequestMapping(value="/acc",method=RequestMethod.GET)
public String showBankAccount(Model model)
{
	List<BankAccount> list=bankAccountDAO.listBankAccountInfo();
	model.addAttribute("accountInfos",list);
	return "accountsPage";
}
//@RequestMapping(value = "/?delete", method = RequestMethod.GET)
//public String Delete(Model model)
//{
//	
//}

@RequestMapping(value="/showDetails", method = RequestMethod.GET)
public String showTransactions(Model model)
{
	List<BankAccount> lstra = bankAccountDAO.listTransactions();
	model.addAttribute("transcactions",lstra);
	//List<BankAccount> list = bankAccountDAO.
	return "showCustDetails";
}

@RequestMapping(value="/sendMoney",method=RequestMethod.GET)
public String viewSendMoneyPage(Model model)
{
SendMoneyForm form=new SendMoneyForm();
model.addAttribute("sendMoneyForm",form);
return "sendMoneyPage";
}

@RequestMapping(value="/sendMoney",method=RequestMethod.POST)
public String processSendMoney(Model model,SendMoneyForm sendMoneyForm)
{
System.out.println("Send mMoney:"+sendMoneyForm.getAmount());

try
{
bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(),sendMoneyForm.getToAccountId(),sendMoneyForm.getAmount());
}
catch(BankTransactionException e){
	model.addAttribute("errorMessage","Error:"+e.getMessage());
	return "/sendMoneyPage";
}
return "sendMoneyPage";
}
//@RequestMapping(value="/showDetails",method=RequestMethod.GET)
//public String showDetails(Model model)
//{
////	List<CustomerList> ls=bankAccountDAO.listCust(1);
////	System.out.println(ls.toString());
////	model.addAttribute("custDetails",ls);
//	return "showCustDetails";
//}

@RequestMapping(value="/customer/home1.html",method=RequestMethod.GET)
public String goTohome1(Model model)
{
	return "home1";
	
}
@RequestMapping(value="/customer/index.html",method=RequestMethod.GET)
public String goToindex(Model model)
{
	return "index";
	
}
@RequestMapping(value="/customer/Index1.html",method=RequestMethod.GET)
public String goToIndex1(Model model)
{
	return "Index1";
	
}


}

