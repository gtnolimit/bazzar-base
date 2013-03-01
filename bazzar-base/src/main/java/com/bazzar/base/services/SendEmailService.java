package com.bazzar.base.services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.bazzar.base.dao.HomeDao;
import com.bazzar.base.domain.Home;

public class SendEmailService {
	
	@Autowired
	HomeDao homeDao;
	
	private Properties props = new Properties();
	private Home home;
	private Session session;
	
	SendEmailService ( String subject, String bodyText, String toEmail ){
		home = homeDao.get ( ( long ) 1 );
		setProperties ();
		session = Session.getDefaultInstance ( props,
				new javax.mail.Authenticator () {
					protected PasswordAuthentication getPasswordAuthentication () {
						return new PasswordAuthentication ( home.getSmtpUser (),home.getSmtpPass () );
					}
				});
		sendEmail ( subject, bodyText, home.getInfoEmail (), toEmail );
	}
	
	private void setProperties (){
		props.put("mail.smtp.host", home.getSmtpHost());
		props.put("mail.smtp.socketFactory.port", home.getSmtpPort());
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", home.getSmtpPort());
	}
	
	private void sendEmail (String subject, String bodyText, String fromEmail, String toEmail){
		try {
			 
			Message message = new MimeMessage ( session );
			message.setFrom ( new InternetAddress ( fromEmail ) );
			message.setRecipients ( Message.RecipientType.TO, InternetAddress.parse ( toEmail ) );
			message.setSubject ( subject );
			message.setText ( bodyText );
 
		 /* Set attachment
		 // Create the message part 
         BodyPart messageBodyPart = new MimeBodyPart();
         // Fill the message
         messageBodyPart.setText("This is message body");
         // Create a multipar message
         Multipart multipart = new MimeMultipart();
         // Set text message part
         multipart.addBodyPart(messageBodyPart);
         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         String filename = "file.txt";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);
         // Send the complete message parts
         message.setContent(multipart );
         */
			Transport.send ( message );
 
		} catch ( MessagingException e ) {
			throw new RuntimeException ( e );
		}
	}
}
