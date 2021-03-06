package com.bazzar.base.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.CustomerDao;
import com.bazzar.base.dao.HomeDao;
import com.bazzar.base.dao.ItemDao;
import com.bazzar.base.dao.OrderDao;

import com.bazzar.base.domain.Address;
import com.bazzar.base.domain.Home;
import com.bazzar.base.domain.Picture;
import com.bazzar.base.domain.customer.Customer;
import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.order.Order;
import com.bazzar.base.domain.order.OrderDetail;
import com.bazzar.base.services.CreateInvoiceService;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class CreateInvoiceServiceImpl implements CreateInvoiceService{
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	ItemDao itemDao;
	@Autowired 
	HomeDao homeDao;
	@Autowired
	CustomerDao customerDao;
	
	private static String NEW_LINE = "\n";
	private static String TAB = "\t";
	private static String SPACE = " ";
	private static String LINE = "---------------------------------------------------------------------------------------------------------------------------";
	private static String PIPE = "|";
	
	private static String FILE = "c:/temp/FirstPdf.pdf";
	  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
	      Font.BOLD);
	  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	      Font.NORMAL, BaseColor.RED);
	  private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
	      Font.BOLD);
	  private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	      Font.BOLD);
	  
	  
	 public void CreateInvoiceServiceImpl (Order order){
		    try {
		        Document document = new Document();
		        PdfWriter.getInstance(document, new FileOutputStream(FILE));
		        document.open();
		        addMetaData(document);
		        addTitlePage(document);
		        addContent(document);
		        document.close();
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
	 }
	 
	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
	private static void addMetaData(Document document) {
	    document.addTitle("My first PDF");
	    document.addSubject("Using iText");
	    document.addKeywords("Java, PDF, iText");
	    document.addAuthor("Lars Vogel");
	    document.addCreator("Lars Vogel");
	}

	private static void addTitlePage(Document document)
	     throws DocumentException {
	    Paragraph preface = new Paragraph();
	    // We add one empty line
	    addEmptyLine(preface, 1);
	    // Lets write a big header
	    preface.add(new Paragraph("Title of the document", catFont));

	    addEmptyLine(preface, 1);
	    // Will create: Report generated by: _name, _date
	    preface.add(new Paragraph("Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	        smallBold));
	    addEmptyLine(preface, 3);
	    preface.add(new Paragraph("This document describes something which is very important ",
	        smallBold));

	    addEmptyLine(preface, 8);

	    preface.add(new Paragraph("This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-).",
	        redFont));

	    document.add(preface);
	    // Start a new page
	    document.newPage();
	}

	private static void addContent(Document document) throws DocumentException {
	    Anchor anchor = new Anchor("First Chapter", catFont);
	    anchor.setName("First Chapter");

	    // Second parameter is the number of the chapter
	    Chapter catPart = new Chapter(new Paragraph(anchor), 1);

	    Paragraph subPara = new Paragraph("Subcategory 1", subFont);
	    Section subCatPart = catPart.addSection(subPara);
	    subCatPart.add(new Paragraph("Hello"));

	    subPara = new Paragraph("Subcategory 2", subFont);
	    subCatPart = catPart.addSection(subPara);
	    subCatPart.add(new Paragraph("Paragraph 1"));
	    subCatPart.add(new Paragraph("Paragraph 2"));
	    subCatPart.add(new Paragraph("Paragraph 3"));

	    // Add a list
	    createList(subCatPart);
	    Paragraph paragraph = new Paragraph();
	    addEmptyLine(paragraph, 5);
	    subCatPart.add(paragraph);

	    // Add a table
	    createTable(subCatPart);

	    // Now add all this to the document
	    document.add(catPart);

	    // Next section
	    anchor = new Anchor("Second Chapter", catFont);
	    anchor.setName("Second Chapter");

	    // Second parameter is the number of the chapter
	    catPart = new Chapter(new Paragraph(anchor), 1);

	    subPara = new Paragraph("Subcategory", subFont);
	    subCatPart = catPart.addSection(subPara);
	    subCatPart.add(new Paragraph("This is a very important message"));

	    // Now add all this to the document
	    document.add(catPart);

	}

	private static void createTable(Section subCatPart)
	      throws BadElementException {
	    PdfPTable table = new PdfPTable(3);

	    // t.setBorderColor(BaseColor.GRAY);
	    // t.setPadding(4);
	    // t.setSpacing(4);
	    // t.setBorderWidth(1);

	    PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Table Header 2"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Table Header 3"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(c1);
	    table.setHeaderRows(1);

	    table.addCell("1.0");
	    table.addCell("1.1");
	    table.addCell("1.2");
	    table.addCell("2.1");
	    table.addCell("2.2");
	    table.addCell("2.3");

	    subCatPart.add(table);

	 }

	 private static void createList(Section subCatPart) {
	    List list = new List(true, false, 10);
	    list.add(new ListItem("First point"));
	    list.add(new ListItem("Second point"));
	    list.add(new ListItem("Third point"));
	    subCatPart.add(list);
	 }

	 private static void addEmptyLine(Paragraph paragraph, int number) {
	    for (int i = 0; i < number; i++) {
	      paragraph.add(new Paragraph(" "));
	    }
	 }

	public String createInvoiceText(Long orderId) {
		StringBuffer sb = new StringBuffer ();
		Order order = orderDao.getOrder ( orderId );
		Set <OrderDetail> orderDetailSet = order.getDetail ();
		Iterator <OrderDetail> it = orderDetailSet.iterator();
		Home home = homeDao.get ( ( long ) 1 );
		sb.append ( NEW_LINE );
		sb.append ( NEW_LINE );
		sb.append ( NEW_LINE );
		
		sb.append ( "INVOICE" );
		sb.append ( NEW_LINE );
		
		sb.append ( "Company : " + home.getCompanyName ( ) );
		sb.append ( NEW_LINE );
		
		sb.append ( "Invoice Date : " + new Date () );
		sb.append ( NEW_LINE );
		
		sb.append ( "Invoice # : " + order.getInvoiceNumber() );
		sb.append ( NEW_LINE );
		
		sb.append ( "Purchase Date : " + order.getPurchaseDate() );
		sb.append ( NEW_LINE );
		
		// order details
		int counter = 1;
		while ( it.hasNext () ){
			sb.append ( LINE );
			sb.append ( NEW_LINE );
			OrderDetail orderDetail = it.next ();
			Item item = itemDao.getItem ( orderDetail.getItemId () );
			double total = orderDetail.getPrice () * orderDetail.getQty ();
			sb.append ( PIPE + counter + TAB + PIPE + item.getSubject () + TAB + TAB + PIPE + orderDetail.getQty () + TAB + PIPE + orderDetail.getPrice() + TAB + PIPE + total );
			sb.append ( NEW_LINE );
			counter ++;
		}
		
		return sb.toString ();
	}

	public File createInvoicePDF(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String createInvoiceHtml ( Long orderId ) {
		Home home = homeDao.get ( ( long ) 1 );
		Order order = orderDao.getOrder ( orderId );
		Customer customer = customerDao.get( order.getCustomer_id () );
		Address shippingAddress = this.getCustomerAddress( customer.getAddress (), "S");
		Address billingAddress = this.getCustomerAddress( customer.getAddress (), "B");

		StringBuffer sb = new StringBuffer ();
		sb.append ( "<div align=\"center\">" );
		sb.append ( "<table width=\"870\" border=\"0\" bgcolor=\"darkgrey\">" );
		sb.append ( "<tr>" );
		sb.append ( "<td height=\"5\"></td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td align=\"center\">" );
		sb.append ( "<table width=\"850\" border=\"0\" bgcolor=\"white\" height=\"20\">" );
		sb.append ( "<tr>" );
		sb.append ( "<td width=\"300\" valign=\"bottom\">" );
		sb.append ( "<font size=\"5\" color=\"darkgrey\" style=\"Verdana\"><b>" + home.getCompanyName() +"</b></font>" );
		sb.append ( "</td>" );
		sb.append ( "<td width=\"275\" valign=\"bottom\" align=\"right\">" );
		sb.append ( "<font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Invoice Number : </font><font size=\"2\">" + order.getInvoiceNumber ( ) + "</font>" );
		sb.append ( "</td>" );
		sb.append ( "<td width=\"275\" valign=\"bottom\" align=\"right\">" );
		sb.append ( "<font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Ordered on : </font></font><font size=\"2\">" + order.getCPD() + "</font>" );
		sb.append ( "</td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"3\" height=\"10\"></td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td width=\"100%\" align=\"center\" valign=\"middle\" colspan=\"3\">" );
		sb.append ( "<font size=\"6\"><b>Thank you for your order.</b></font>" );
		sb.append ( "<br>" );
		sb.append ( "<font size=\"3\" color=\"darkgray\">We'll let you know when your items are on their way.</font>" );
		sb.append ( "</td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"3\" height=\"10\"></td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"3\" height=\"10\">" );
		sb.append ( "<table border=\"0\">" );
		sb.append ( "<tr>" );
		sb.append ( "<th width=\"20\">#</th>" );
		sb.append ( "<th width=\"200\">Item Pic</th>" );
		sb.append ( "<th width=\"500\">Name</th>" );
		sb.append ( "<th width=\"50\">Qty</th>" );
		sb.append ( "<th width=\"100\">Unit Price</th>" );
		sb.append ( "<th width=\"100\">Units Total</th>" );
		sb.append ( "</tr>" );

		//orderDetail start
		int counter = 0;
		Set <OrderDetail> orderDetailSet = order.getDetail();
		Iterator<OrderDetail> itOrderDetail = orderDetailSet.iterator();
		while ( itOrderDetail.hasNext () ){
			OrderDetail orderDetail = (OrderDetail) itOrderDetail.next();
			Item item = itemDao.getItem(orderDetail.getItemId());
			sb.append ( "<tr>" );
			sb.append ( "<td width=\"20\" align=\"center\"><font size=\"2\">" + ++counter + "</font></td>" );
			sb.append ( "<td width=\"100\" align=\"center\"><img height=\"100\" width=\"100\" src=\"" );
			Set <Picture> picSet = item.getPictureLocation();
			Iterator<Picture> itPicture = picSet.iterator();
			while ( itPicture.hasNext()){
				Picture pic = (Picture) itPicture.next();
				sb.append(pic.getPictureLocation());
				break;
			}
			sb.append ("\"></td>" );
			sb.append ( "<td width=\"600\" align=\"center\"><font size=\"2\">" + item.getSubject() + "</font></td>" );
			sb.append ( "<td width=\"50\" align=\"center\"><font size=\"2\">" + orderDetail.getQty() + "</font></td>" );
			sb.append ( "<td width=\"100\" align=\"center\"><font size=\"2\">$ " + orderDetail.getPrice() + "</font></td>" );
			double total = orderDetail.getPrice() * orderDetail.getQty() ;
			sb.append ( "<td width=\"100\" align=\"center\"><font size=\"2\">$ " + total + "</font></td>" );
			sb.append ( "</tr>" );
			sb.append ( "<tr>" );
			sb.append ( "<td colspan=\"6\" height=\"20\"></td>" );
			sb.append ( "</tr>" );
		}
		//orderDetail end
		
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"5\" align=\"right\"><font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Subtotal</font></td>" );
		sb.append ( "<td width=\"100\"><font size=\"2\">$ " + order.getTotalBeforeTax() + "</font></td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"5\" align=\"right\"><font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Shipping</font></td>" );
		sb.append ( "<td width=\"100\"><font size=\"2\">$ " + order.getShippingRate() + "</font></td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"5\" align=\"right\"><font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Handling</font></td>" );
		sb.append ( "<td width=\"100\"><font size=\"2\">$ " + order.getShippingHandling() + "</font></td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"5\" align=\"right\"><font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Estimated Tax</font></td>" );
		sb.append ( "<td width=\"100\"><font size=\"2\">$ " + order.getOrderTax() + "</font></td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"5\" align=\"right\"><font size=\"3\" style=\"Verdana\"><b>Order Total</b></font></td>" );
		sb.append ( "<td width=\"100\"><font size=\"2\"><b>$ " + order.getOrderTotal() + "</b></font></td>" );
		sb.append ( "</tr>" );

		sb.append ( "</table>" );
		sb.append ( "</td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"3\" height=\"10\"></td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td colspan=\"3\">" );
		sb.append ( "<table border=\"0\" bgcolor=\"white\">" );
		sb.append ( "<tr><td height=\"10\" colspan=\"6\"></td></tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td height=\"10\" colspan=\"3\" align=\"center\" width=\"400\"><font size=\"4\" color=\"darkgrey\" style=\"Verdana\"><b>Shipping Information</b></font></td>" );
		sb.append ( "<td height=\"10\" colspan=\"3\" align=\"center\" width=\"400\"><font size=\"4\" color=\"darkgrey\" style=\"Verdana\"><b>Payment Information</b></font></td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td width=\"150\" align=\"right\" valign=\"top\">" );
		sb.append ( "<font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Shipping Address:</font>" );
		sb.append ( "</td>" );
		sb.append ( "<td width=\"5\"></td>" );
		sb.append ( "<td align=\"top\" align=\"left\" width=\"245\">" );
		sb.append ( "<font size=\"2\">");
		
		// here will be shipping address
		if ( shippingAddress != null ) {
			sb.append ( shippingAddress.getAddressLine1 () );
			if ( shippingAddress.getAddressLine2() != null )
				sb.append ( " " + shippingAddress.getAddressLine2() );
			if ( shippingAddress.getAddressLine3() != null ) 
				sb.append ( " " + shippingAddress.getAddressLine3() );
			if ( shippingAddress.getCity() != null ) 
				sb.append ( "<br>" + shippingAddress.getCity() );
			if ( shippingAddress.getState() != null ) 
				sb.append ( " " + shippingAddress.getState() );
			if ( shippingAddress.getZip() != null ) 
				sb.append ( " " + shippingAddress.getZip() );
			if ( shippingAddress.getZip4() != null )
				sb.append ( "-" + shippingAddress.getZip4() );
			sb.append ( "</font>" );
		}
		
		sb.append ( "</td>" );
		sb.append ( "<td width=\"150\" align=\"right\" valign=\"top\">" );
		sb.append ( "<font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Billing Address:</font>" );
		sb.append ( "</td>" );
		sb.append ( "<td width=\"5\"></td>" );
		sb.append ( "<td align=\"top\" align=\"left\" width=\"245\">" );
		sb.append ( "<font size=\"2\">");
		
		//--------here will be billing address--------
		if ( billingAddress != null ) {
			sb.append ( billingAddress.getAddressLine1 () );
			if ( billingAddress.getAddressLine2() != null )
				sb.append ( " " +billingAddress.getAddressLine2() );
			if ( billingAddress.getAddressLine3() != null ) 
				sb.append ( " " + billingAddress.getAddressLine3() );
			if ( billingAddress.getCity() != null ) 
				sb.append ( "<br>" + billingAddress.getCity() );
			if ( billingAddress.getState() != null ) 
				sb.append ( " " + billingAddress.getState() );
			if ( billingAddress.getZip() != null ) 
				sb.append ( " " + billingAddress.getZip() );
			if ( billingAddress.getZip4() != null )
				sb.append ( "-" + billingAddress.getZip4() );
			sb.append ( "</font>" );
		}
		
		sb.append ( "</td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr><td height=\"10\" colspan=\"6\"></td></tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td width=\"150\" align=\"right\" valign=\"top\">" );
		sb.append ( "<font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Shipment Notifications:</font>" );
		sb.append ( "</td>" );
		sb.append ( "<td width=\"5\"></td>" );
		sb.append ( "<td align=\"top\" align=\"left\" width=\"245\">" );
		sb.append ( "<font size=\"2\">" );
		//----------here will be <br>customer name and email for shipping--------
		sb.append ( customer.getFirstName () + " " + customer.getLastName() );
		
		sb.append ( "</font>" );
		sb.append ( "</td>" );
		sb.append ( "<td width=\"150\" align=\"right\" valign=\"top\">" );
		sb.append ( "<font size=\"2\" color=\"darkgrey\" style=\"Verdana\">Billing Contact:</font>" );
		sb.append ( "</td>" );
		sb.append ( "<td width=\"5\"></td>" );
		sb.append ( "<td align=\"top\" align=\"left\" width=\"245\">" );
		sb.append ( "<font size=\"2\">" ); 
		sb.append ( customer.getFirstName () + " " + customer.getLastName() );
		//---------here will be <br>customer billing info-----------
		sb.append ( "</font>" );
		sb.append ( "</td>" );
		sb.append ( "</tr>" );
		sb.append ( "</table>" );
		sb.append ( "</td>" );
		sb.append ( "</tr>" );
		sb.append ( "</table>" );
		sb.append ( "</td>" );
		sb.append ( "</tr>" );
		sb.append ( "<tr>" );
		sb.append ( "<td height=\"5\"></td>" );
		sb.append ( "</tr>" );
		sb.append ( "</table>" );
		sb.append ( "</div>" );
		return sb.toString ();
	} 
	
	private Address getCustomerAddress ( Set <Address> add, String addType ){
		Iterator<Address> itAddress = add.iterator ();
		Address address = null;
		while ( itAddress.hasNext () ){
			Address address_p = (Address) itAddress.next ();
			if ( address_p.getAddressType () .getCode () .equalsIgnoreCase ( addType ) )
				address = address_p;
		}
		return address;
	}
}

