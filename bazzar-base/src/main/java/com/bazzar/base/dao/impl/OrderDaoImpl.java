package com.bazzar.base.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.base.dao.OrderDao;
import com.bazzar.base.domain.order.Order;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

protected static Logger logger = Logger.getLogger ( "OrderDao" );
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrders ( ) {
		return sessionFactory.getCurrentSession ( ).createQuery ( "FROM Order o").list ();
	} 

	@SuppressWarnings("unchecked")
	public List<Order> getOrdersForCustomer ( Long customerId ) {
		return sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Order o WHERE o.customer_id = :customerId")
				.setLong ( "customerId", customerId ).list();
	}

	public Order getOrderByInvoice ( String invoiceNumber ) {
		return (Order) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Order o WHERE o.INVOICE_NUMBER = :invoiceNumber")
				.setString ( "invoiceNumber", invoiceNumber ).uniqueResult();
	}
	public Order getOrderBySession ( String session ) {
		return (Order) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Order o WHERE o.session = :session")
				.setString ( "session", session ).uniqueResult();
	}
	public Order getOrderByIp ( String ip ) {
		return (Order) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Order o WHERE o.ip = :ip")
				.setString ( "ip", ip ).uniqueResult();
	}
	public Order getOrder ( Long orderId ) {
		return ( Order ) sessionFactory.getCurrentSession ( ).get ( Order.class, orderId );
	}

	public Long createOrder ( Order order ) {
		return ( Long ) sessionFactory.getCurrentSession ( ).save ( order );
	}

	public void editOrder ( Order order ) {
		sessionFactory.getCurrentSession ( ).merge ( order );
	}

	public void delete(Long id) {
		Order order = getOrder ( id );
		order.setIsActive(false);
		this.editOrder(order);
	}

}
