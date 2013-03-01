package com.bazzar.base.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.base.dao.CustomerDao;
import com.bazzar.base.domain.customer.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Long create(Customer customer) {
		return ( Long ) sessionFactory.getCurrentSession ().save ( customer );
	}

	public void update(Customer customer) {
		sessionFactory.getCurrentSession ().merge ( customer );
	}

	public Customer get(Long id) {
		return (Customer) sessionFactory.getCurrentSession ( )
				.createQuery("FROM Customer c WHERE c.id = :id")
				.setParameter("id", id).uniqueResult();
	}

	public void delete(Customer customer) {
		customer.setActive(false);
		this.update(customer);
	}

	public void delete(Long id) {
		Customer customer = this.get(id);
		this.delete(customer);
	}

}
