package com.bazzar.base.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.CustomerDao;
import com.bazzar.base.domain.customer.Customer;
import com.bazzar.base.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public Long create(Customer customer) {
		return customerDao.create(customer);
	}

	public void edit(Customer customer) {
		customerDao.update(customer);
	}
	public void delete(Long id) {
		customerDao.delete ( id );
	}

	public Customer get(Long id) {
		return customerDao.get ( id );
	}

}
