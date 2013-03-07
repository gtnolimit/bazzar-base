package com.bazzar.base.services.impl;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.HomeDao;
import com.bazzar.base.domain.Home;
import com.bazzar.base.services.SendEmailService;

@Service
public class SendEmailServiceImpl implements SendEmailService{
	
	@Autowired
	HomeDao homeDao;
	
	private Home home;
	
	public void sendEmail ( String subject, String bodyText, String toEmail ){
		final String username = "gtnolimit@gmail.com";
		final String password = "ozi97yng";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bazzar@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse( toEmail ));
			message.setSubject( subject );
			message.setText( bodyText );
 
			Transport.send(message);
  
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		

	}
}
