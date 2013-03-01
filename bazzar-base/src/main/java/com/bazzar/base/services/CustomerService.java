package com.bazzar.base.services;

import com.bazzar.base.domain.customer.Customer;

public interface CustomerService {
	
	public Long create ( Customer customer );
	public void edit ( Customer customer );
	public void delete ( Long id );
	public Customer get ( Long id );

}
