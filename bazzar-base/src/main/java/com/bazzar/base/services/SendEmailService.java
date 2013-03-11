package com.bazzar.base.services;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface SendEmailService {
	
	public void sendSimpleEmail ( String subject, String body, String toAddress ) throws MessagingException;
	public void sendHtmlEmail ( String subject, String body, String toAddress ) throws AddressException, MessagingException;
}
