package com.bazzar.base.services;

public interface SendEmailService {
	
	public void sendEmail ( String subject, String body, String toAddress );
}
