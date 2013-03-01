package com.bazzar.base.services.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.CustomerDao;
import com.bazzar.base.dao.HomeDao;
import com.bazzar.base.dao.OrderDao;
import com.bazzar.base.domain.Address;
import com.bazzar.base.domain.Home;
import com.bazzar.base.domain.customer.Customer;
import com.bazzar.base.domain.lookup.AddressTypeLookup;
import com.bazzar.base.domain.order.Order;
import com.bazzar.base.domain.order.OrderDetail;
import com.bazzar.base.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	@Autowired
	HomeDao homeDao;
	@Autowired
	CustomerDao customerDao;
	
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}
	public List<Order> getOrdersForCustomer(Long customerId) {
		return orderDao.getOrdersForCustomer(customerId);
	}
	public Order getOrder(Long orderId) {
		return orderDao.getOrder(orderId);
	}
	public Long createOrder(Order order) {
		return orderDao.createOrder(order);
	}
	public void editOrder(Order order) {
		orderDao.editOrder(order);
	}
	public Order getOrderByInvoice(String invoiceNumber) {
		return orderDao.getOrderByInvoice(invoiceNumber);
	}
	public Order getOrderBySession(String session) {
		return orderDao.getOrderBySession(session);
	}
	public Order getOrderByIp(String ip) {
		return orderDao.getOrderByIp(ip);
	}
	public void delete ( Long orderId ){
		orderDao.delete ( orderId );
	}
	public Order calculateOrder ( Order order ){
		order = calculateSubTotal ( order );
		order = calculateTax ( order );
		//order = calculateShipping( order );
		order = calculateTotal ( order );
		return order; 
	}
	private Order calculateSubTotal ( Order order ){
		double subTotal = 0.00;
		Set <OrderDetail> orderDetails = order.getDetail();
		if ( !orderDetails.isEmpty ( ) ){
			Iterator <OrderDetail> odIter = orderDetails.iterator ( );
			while ( odIter.hasNext ( ) ){
				OrderDetail od = odIter.next();
				subTotal += od.getPrice ( ) * od.getQty ( );
			}
		}
		order.setTotalBeforeTax(subTotal);
		return order;
	}
	
	private Order calculateTax ( Order order ){
		Home company = homeDao.get((long) 1);
		Customer cust = customerDao.get(order.getCustomer_id());
		Set <Address> address = cust.getAddress();
		Iterator <Address> it = address.iterator();
		while ( it.hasNext () ){
			Address add = it.next();
			AddressTypeLookup addressType = add.getAddressType();
			if ( addressType.getCode ().equals ( "B" ) && add.getState ().getCode().equals (company.getHomeState()) )
				order.setOrderTax( order.getTotalBeforeTax() * company.getStateTax() / 100 );
		}
		return order;
	}
	
	//TODO make calculations for shipping
	@SuppressWarnings("unused")
	private Order calculateShipping ( Order order ){
		double shippingAndHandling = 0.00;
		order.setShippingHandling ( shippingAndHandling );
		return order;
	}
	
	private Order calculateTotal ( Order order ){
		order.setOrderTotal ( order.getTotalBeforeTax() + 
				order.getOrderTax() + order.getShippingHandling() );
		return order;
	}

}
