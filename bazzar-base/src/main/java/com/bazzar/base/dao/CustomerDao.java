package com.bazzar.base.dao;

import com.bazzar.base.domain.customer.Customer;

public interface CustomerDao {
	
	public Long create ( Customer customer );
	public void update ( Customer customer );
	public Customer get ( Long id );
	public void delete ( Customer customer );
	public void delete ( Long id );
	
}
