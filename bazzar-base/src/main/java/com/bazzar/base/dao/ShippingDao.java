package com.bazzar.base.dao;

import java.util.List;

import com.bazzar.base.domain.order.Shipping;

public interface ShippingDao {
	
	public List <Shipping> get ();
	public Shipping get ( Long id );
	public void update ( Shipping shipping );
	public Long add ( Shipping shipping );
	public void delete ( Long id );
	
}
