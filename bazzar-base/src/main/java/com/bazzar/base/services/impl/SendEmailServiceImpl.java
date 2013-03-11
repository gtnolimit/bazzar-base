package com.bazzar.base.services.impl;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
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
	
	public void sendSimpleEmail ( String subject, String bodyText, String toEmail )
		throws MessagingException{
		Home home = homeDao.get( (long) 1 );
		
		final String username = home.getSmtpUser ();
		final String password = home.getSmtpPass ();
		final String port = home.getSmtpPort();
		final String host = home.getSmtpHost();
		final String infoEmail = home.getInfoEmail();		
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
 
		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication( username, password );
			}
		});
 
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(infoEmail));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse( toEmail ));
		message.setSubject( subject );
		message.setText( bodyText );
 	}

	public void sendHtmlEmail( String subject, String message, String toAddress ) 
    		throws AddressException, MessagingException {
 
		Home home = homeDao.get( (long) 1 );
		
		final String username = home.getSmtpUser ();
		final String password = home.getSmtpPass ();
		final String port = home.getSmtpPort();
		final String host = home.getSmtpHost();
		final String infoEmail = home.getInfoEmail();		

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(infoEmail));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setContent(message, "text/html");
 
        Transport.send(msg);
    }
 
}
