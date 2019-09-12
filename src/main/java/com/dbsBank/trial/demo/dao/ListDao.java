//package com.dbsBank.trial.demo.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.dbsBank.trial.demo.entity.BankAccount;
//import com.dbsBank.trial.demo.model.CustomerList;
//
//@Repository
//public class ListDao {
//	@Autowired
//	private static EntityManager entityManager;
//	@SuppressWarnings("unchecked")
//	public static List<com.dbsBank.trial.demo.model.CustomerList>listCustomer(){
//		String sql="Select new "+com.dbsBank.trial.demo.model.CustomerList.class.getName()+"(e.customerID,e.account_no,e.account_bal,e.firstname,e.email) from "+CustomerList.class.getName()+" e";
//		Query query=entityManager.createQuery(sql,com.dbsBank.trial.demo.model.CustomerList.class);
//		System.out.println(query.getResultList().toString());
//		return query.getResultList();
//	}
//
//	public ListDao() {
//		
//		// TODO Auto-generated constructor stub
//	}
//	
//}
