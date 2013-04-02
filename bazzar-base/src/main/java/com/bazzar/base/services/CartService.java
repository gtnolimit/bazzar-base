package com.bazzar.base.services;

import net.sf.json.JSONObject;

import com.bazzar.base.domain.order.Cart;

public interface CartService {

	public Long create ( Cart cart );
	public void saveOrUpdate(Cart cart);
	public void delete ( Cart cart );
	public void delete ( Long cartId );
	public Cart edit ( Cart cart );
	public Cart get ( Long cartId );
	
	public Cart findCartByCustomerId ( Long customerId );
	public Cart findCartBySession ( String session );
	public Cart findCartByIp ( String ip );
	
	public Cart calculateSubTotal ( Cart cart );
	public Cart findCartDetailBySessionAndItemId(String sessionNumber, Long itemId);
	public Cart deleteCartDetail(Long cartId, Long detailId);
	public Cart updateQuantity(JSONObject cartData);

}
