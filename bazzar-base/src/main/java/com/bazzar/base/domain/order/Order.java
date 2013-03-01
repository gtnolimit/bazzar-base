package com.bazzar.base.domain.order;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bazzar.base.domain.DBBase;
import com.bazzar.base.domain.Note;
import com.bazzar.base.domain.lookup.OrderStatusLookup;

@Entity
@Table(name = "ORDERS")
public class Order extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="SESSION_NUMBER")
	private String sessionNumber;
	@Column(name="IP")
	private String ip;
	@Column(name="INVOICE_NUMBER")
	private String invoiceNumber;
	@Column ( name = "CUSTOMER_ID")
	private Long customer_id;
	@Column(name="TRACKING_NUMBER")
	private String trackingNumber;
	@Column(name="URL_TRACKING_NUMBER")
	private String urlTrackingNumber;
	@Column(name="SHIPPING_COMPANY")
	private String shippingCompany;
	@Column(name="PURCHASE_DATE")
	private Date purchaseDate;
	@Column(name="CANCELED_DATE")
	private Date canceledDate;
	@Column(name="REFUNDED_DATE")
	private Date refundedDate;
	@Column(name="SHIPPED_DATE")
	private Date shippedDate;
	@Column(name="BEFORE_TAX_TOTAL")
	private double totalBeforeTax;
	@Column(name="SHIPPING_TOTAL")
	private double shippingHandling;
	@Column(name="REFUNDABLE_TOTAL")
	private double refundableTotal;
	@Column(name="ORDER_TOTAL")
	private double orderTotal;
	@Column(name="ORDER_TAX")
	private double orderTax;
	@Column(name="INVOICE_PDF_LOCATOR")
	private String invoicePdfLocator;
	@Column(name="STATUS")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="ORDER_STATUS")
	private OrderStatusLookup orderStatus;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ORDER_SHIPPING",
	     joinColumns = @JoinColumn( name="ORDER_ID"),
	     inverseJoinColumns = @JoinColumn( name="SHIPPING_ID")
	)
	private Set <Shipping> shipping = new HashSet <Shipping> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ORDER_PAYMENT",
	     joinColumns = @JoinColumn( name="ORDER_ID"),
	    inverseJoinColumns = @JoinColumn( name="PAYMENT_ID")
	)
	private Set <Payment> payment = new HashSet <Payment> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ORDER_DETAILS",
	     joinColumns = @JoinColumn( name="ORDER_ID"),
	     inverseJoinColumns = @JoinColumn( name="DETAIL_ID")
	)
	private Set <OrderDetail> detail = new HashSet <OrderDetail> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ORDER_NOTE",
	     joinColumns = @JoinColumn( name="ORDER_ID"),
	     inverseJoinColumns = @JoinColumn( name="NOTE_ID")
	)
	private Set <Note> note = new HashSet <Note> ();
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSessionNumber() {
		return sessionNumber;
	}
	public void setSessionNumber(String sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	public String getUrlTrackingNumber() {
		return urlTrackingNumber;
	}
	public void setUrlTrackingNumber(String urlTrackingNumber) {
		this.urlTrackingNumber = urlTrackingNumber;
	}
	public String getShippingCompany() {
		return shippingCompany;
	}
	public void setShippingCompany(String shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public String getInvoicePdfLocator() {
		return invoicePdfLocator;
	}
	public void setInvoicePdfLocator(String invoicePdfLocator) {
		this.invoicePdfLocator = invoicePdfLocator;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public Set<Payment> getPayment() {
		return payment;
	}
	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}
	public Date getCanceledDate() {
		return canceledDate;
	}
	public void setCanceledDate(Date canceledDate) {
		this.canceledDate = canceledDate;
	}
	public Date getRefundedDate() {
		return refundedDate;
	}
	public void setRefundedDate(Date refundedDate) {
		this.refundedDate = refundedDate;
	}
	public Set<OrderDetail> getDetail() {
		return detail;
	}
	public void setDetail(Set<OrderDetail> detail) {
		this.detail = detail;
	}
	public Set<Note> getNote() {
		return note;
	}
	public void setNote(Set<Note> note) {
		this.note = note;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}
	public double getTotalBeforeTax() {
		return totalBeforeTax;
	}
	public void setTotalBeforeTax(double totalBeforeTax) {
		this.totalBeforeTax = totalBeforeTax;
	}
	public double getShippingHandling() {
		return shippingHandling;
	}
	public void setShippingHandling(double shippingHandling) {
		this.shippingHandling = shippingHandling;
	}
	public double getRefundableTotal() {
		return refundableTotal;
	}
	public void setRefundableTotal(double refundableTotal) {
		this.refundableTotal = refundableTotal;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public double getOrderTax() {
		return orderTax;
	}
	public void setOrderTax(double orderTax) {
		this.orderTax = orderTax;
	}
	public OrderStatusLookup getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatusLookup orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Set<Shipping> getShipping() {
		return shipping;
	}
	public void setShipping(Set<Shipping> shipping) {
		this.shipping = shipping;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}
