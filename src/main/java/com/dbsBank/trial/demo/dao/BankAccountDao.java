package com.dbsBank.trial.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dbsBank.trial.demo.entity.BankAccount;
import com.dbsBank.trial.demo.exception.BankTransactionException;
import com.dbsBank.trial.demo.model.CustomerList;
import com.dbsBank.trial.demo.repository.CustomerListDao;

@Repository
public class BankAccountDao {
public BankAccountDao() {
				}

@Autowired
private EntityManager entityManager;
public BankAccount findbyId(Long id) {
	return this.entityManager.find(BankAccount.class,id);
}

public CustomerList findbyId1(int id) {
	return this.entityManager.find(CustomerList.class,id);
}
@SuppressWarnings("unchecked")
public List<com.dbsBank.trial.demo.entity.BankAccount>listBankAccountInfo(){
	String sql="Select new "+com.dbsBank.trial.demo.entity.BankAccount.class.getName()+"(e.id,e.fullName,e.balance) from "+BankAccount.class.getName()+" e";
	Query query=entityManager.createQuery(sql,com.dbsBank.trial.demo.entity.BankAccount.class);
	return query.getResultList();
}
//
@Transactional(propagation=Propagation.MANDATORY)
public void addAmount(Long id,double amount)throws com.dbsBank.trial.demo.exception.BankTransactionException{
	BankAccount account=this.findbyId(id);
if(account==null)
{
	throw new com.dbsBank.trial.demo.exception.BankTransactionException("Account not found"+id);
}
double newBalance=account.getBalance()+amount;
if(account.getBalance()+amount<0) {
	throw new com.dbsBank.trial.demo.exception.BankTransactionException("Money in the account"+id+"not enough("+account.getBalance()+")");
}
account.setBalance(newBalance);
}

@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=com.dbsBank.trial.demo.exception.BankTransactionException.class)
public void sendMoney(Long fromAccountId,Long toAccountId,double amount) throws BankTransactionException

{
addAmount(toAccountId,amount);
addAmount(fromAccountId,-amount);
}
@SuppressWarnings("unchecked")
public List<com.dbsBank.trial.demo.model.CustomerList>listCustDetails(){
	String sql="Select new "+com.dbsBank.trial.demo.entity.BankAccount.class.getName()+"(e.id,e.fullName,e.balance) from "+BankAccount.class.getName()+" e";
	Query query=entityManager.createQuery(sql,com.dbsBank.trial.demo.entity.BankAccount.class);
	return query.getResultList();
}

public List<CustomerList> listCust(int i) {
	CustomerList account=this.findbyId1(i);
	String sql="Select new "+com.dbsBank.trial.demo.model.CustomerList.class.getName()+"(e.customerID,e.account_no,e.firstname,e.account_bal) from "+CustomerList.class.getName()+" e";
	Query query=entityManager.createQuery(sql,com.dbsBank.trial.demo.entity.BankAccount.class);
	return query.getResultList();
	
}
}


