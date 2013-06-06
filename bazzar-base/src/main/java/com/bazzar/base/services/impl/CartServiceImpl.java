package com.bazzar.base.services.impl;

import java.util.Iterator;
import java.util.Set;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.CartDao;
import com.bazzar.base.dao.ItemDao;
import com.bazzar.base.domain.order.Cart;
import com.bazzar.base.domain.order.CartDetail;
import com.bazzar.base.services.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;

	@Autowired
	ItemDao itemDao;

	public Long create(Cart cart) {
		return cartDao.create(cart);
	}

	public void saveOrUpdate(Cart cart) {
		cartDao.saveOrUpdate(cart);
	}

	public void delete(Cart cart) {
		cartDao.delete(cart);
	}

	public void delete(Long cartId) {
		cartDao.delete(cartId);
	}

	public Cart edit(Cart cart) {
		return cartDao.edit(cart);
	}

	public Cart get(Long cartId) {
		return cartDao.get(cartId);
	}

	public Cart findCartByCustomerId(Long customerId) {
		return cartDao.findCartByCustomerId(customerId);
	}

	public Cart findCartBySession(String session) {
		return cartDao.findCartBySession(session);
	}

	public Cart findCartByIp(String ip) {
		return cartDao.findCartByIp(ip);
	}

	public Cart calculateSubTotal(Cart cart) {
		double subTotal = 0.00;
		Set<CartDetail> detail = cart.getDetail();
		Iterator<CartDetail> it = detail.iterator();
		while (it.hasNext()) {
			CartDetail cd = (CartDetail) it.next();
			subTotal += cd.getPrice() * cd.getQty();
		}
		cart.setShoppingCartSubTotal(subTotal);
		return cart;
	}

	public Cart findCartDetailBySessionAndItemId(String sessionNumber,
	        Long itemId) {
		return cartDao.findCartDetailBySessionAndItemId(sessionNumber, itemId);
	}

	@Override
	public Cart deleteCartDetail(Long cartId, Long detailId) {
		Cart cart = cartDao.get(cartId);
		cart.getDetail().remove(
		        cartDao.findCartDetailByItemId(cartId, detailId));
		cartDao.saveOrUpdate(cart);
		return cart;
	}

	@Override
	public Cart updateQuantity(Long cartId, JSONObject cartData) {
		if (cartData.containsKey("details")) {
			for (Iterator i = cartData.getJSONArray("details").iterator(); i
			        .hasNext();) {
				JSONObject detail = (JSONObject) i.next();
				CartDetail cartDetail = cartDao.findCartDetailByDetailId(detail
				        .getLong("id"));
				cartDetail.setQty(detail.getInt("quantity"));
				cartDao.saveOrUpdate(cartDetail);
			}
		}

		if (cartId != null) {
			return cartDao.get(cartId);
		}

		return null;
	}

}
