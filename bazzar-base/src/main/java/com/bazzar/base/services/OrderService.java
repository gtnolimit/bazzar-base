package com.bazzar.base.services;

import java.util.List;

import com.bazzar.base.domain.order.Order;

public interface OrderService {

	public List <Order> getOrders ();
	public List <Order> getOrdersForCustomer ( Long customerId );
	public Order getOrder ( Long orderId );
	public void createOrUpdateOrder ( Order order );
	public void editOrder ( Order order );
	public Order getOrderByInvoice ( String invoiceNumber );
	public Order getOrderBySession ( String session );
	public Order getOrderByIp ( String ip );
	public void delete ( Long id );
	
	public Order calculateOrder ( Order order );
//	public Order calculateSubTotal ( Order order );
//	public Order calculateTax ( Order order );
//	public Order calculateShipping ( Order order );
//	public Order calculateTotal ( Order order );
}
