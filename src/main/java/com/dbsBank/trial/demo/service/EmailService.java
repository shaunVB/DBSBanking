package com.dbsBank.trial.demo.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
@Service("mailService")
public class EmailService{

	@Autowired
    private MailSender mailSender;
	  public void sendOtpMessage(String to, String subject, String message) {

		  SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(to);
	        msg.setSubject(subject);
	        msg.setText(message);
	        System.out.println("send last stage");
	        mailSender.send(msg);
		  }
		

	
	}
	

