package com.bazzar.base.dao;

import com.bazzar.base.domain.order.Cart;
import com.bazzar.base.domain.order.CartDetail;

public interface CartDao {
	
	public Long create ( Cart cart );
	public void saveOrUpdate ( Cart cart );
	public void delete ( Cart cart );
	public void delete ( Long cartId );
	public Cart edit ( Cart cart );
	public Cart save ( Cart cart );
	public Cart get ( Long cartId );
	
	public Cart findCartByCustomerId ( Long customerId );
	public Cart findCartBySession ( String session );
	public Cart findCartByIp ( String ip );
	public Cart findCartDetailBySessionAndItemId( String session, Long itemId );
	public CartDetail findCartDetailByItemId(Long id,
	        Long detailId);
	public CartDetail findCartDetailByDetailId(Long detailId);
	public void saveOrUpdate ( CartDetail cartDetail );
}
