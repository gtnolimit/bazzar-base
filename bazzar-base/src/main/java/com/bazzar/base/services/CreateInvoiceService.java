package com.bazzar.base.services;

import java.io.File;

public interface CreateInvoiceService {
	
	public String createInvoiceText ( Long orderId );
	public File createInvoicePDF ( Long orderId );
	public String createInvoiceHtml ( Long orderId );

}
