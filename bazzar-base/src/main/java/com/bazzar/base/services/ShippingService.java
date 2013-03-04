package com.bazzar.base.services;

import java.util.List;

import com.bazzar.base.domain.order.Shipping;

public interface ShippingService {

	public List <Shipping> get ();
	public Shipping get ( Long id );
	public void update ( Shipping shipping );
	public Long add ( Shipping shipping );
	public void delete ( Long id );
	
}
