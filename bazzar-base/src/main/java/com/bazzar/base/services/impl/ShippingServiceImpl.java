package com.bazzar.base.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.ShippingDao;
import com.bazzar.base.domain.order.Shipping;
import com.bazzar.base.services.ShippingService;

@Service
public class ShippingServiceImpl implements ShippingService{

	@Autowired
	ShippingDao shippingDao;
	
	public List <Shipping> get() {
		return shippingDao.get ();
	}
	public Shipping get(Long id) {
		return shippingDao.get ( id );
	}
	public void update(Shipping shipping) {
		shippingDao.update ( shipping );
	}
	public Long add(Shipping shipping) {
		return shippingDao.add ( shipping );
	}
	public void delete(Long id) {
		shippingDao.delete ( id ); 
	}

}
