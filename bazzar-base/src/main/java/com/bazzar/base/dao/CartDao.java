package com.bazzar.base.dao;

import com.bazzar.base.domain.order.Cart;

public interface CartDao {
	
	public Long create ( Cart cart );
	public void delete ( Cart cart );
	public void delete ( Long cartId );
	public Cart edit ( Cart cart );
	public Cart get ( Long cartId );
	
	public Cart findCartByCustomerId ( Long customerId );
	public Cart findCartBySession ( String session );
	public Cart findCartByIp ( String ip );

}
