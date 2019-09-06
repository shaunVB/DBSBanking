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
return "redirect:/";
}
}
