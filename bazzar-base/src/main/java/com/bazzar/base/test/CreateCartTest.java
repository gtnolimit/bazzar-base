package com.bazzar.base.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.order.Cart;
import com.bazzar.base.domain.order.CartDetail;
import com.bazzar.base.services.CartService;

public class CreateCartTest {
	
	@Autowired
	CartService cartService;
	
	public CreateCartTest (){}
	
	public Cart addCart ( Cart cart, Item item, int qty, String session, String ip ){
		
		Cart cart_t;
		Set <CartDetail> detail = new HashSet <CartDetail> ();
		if ( cart == null ){
			cart_t = new Cart ();
			cart_t.setCPD(new Date ());
			cart_t.setIp(ip);
			cart_t.setSessionNumber(session);
		}
		else{
			cart_t = cart;
			detail = cart.getDetail();
		}
		cart_t.setUPD( new Date());
		detail.add(this.setCartDetail(item, qty));
		cart_t.setItemCount(detail.size());
		cart_t.setDetail(detail);
		return cart_t;
	}

	private CartDetail setCartDetail ( Item item, int qty ){
		CartDetail cd = new CartDetail ( );
		cd.setCPD ( new Date ( ) );
		cd.setUPD ( new Date ( ) );
		cd.setItemId ( item.getId ( ) );
		cd.setPrice ( item.getSalePrice ( ) );
		cd.setQty ( qty );
		return cd;
	}

}
