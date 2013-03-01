package com.bazzar.base.dao;

import java.util.List;

import com.bazzar.base.domain.order.Order;

public interface OrderDao {
	public List <Order> getOrders ();
	public List <Order> getOrdersForCustomer ( Long customerId );
	public Order getOrder ( Long orderId );
	public Long createOrder ( Order order );
	public void editOrder ( Order order );
	public Order getOrderByInvoice ( String invoiceNumber );
	public void delete ( Long id );
	public Order getOrderBySession ( String session);
	public Order getOrderByIp ( String ip);
}
