package com.bazzar.base.ui.controller;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.bazzar.base.domain.order.Cart;
import com.bazzar.base.services.CartService;

@Controller
public class CartController {

	@Autowired
	private View jsonView_i;

	@Autowired
	private CartService cartService_i;

	private static final String CART_FIELD = "cart";
	private static final String ERROR_FIELD = "error";

	@RequestMapping(value = "/cart/{cartId}", method = RequestMethod.GET)
	public ModelAndView getCart(@PathVariable("cartId") String cartId) {
		Long _id = (long) 0;
		try {
			_id = Long.parseLong(cartId);
		} catch (Exception e) {
			String sMessage = "Error converting ID into numeric value";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		return new ModelAndView(jsonView_i, CART_FIELD, cartService_i.get(_id));
	}

	@RequestMapping(value = { "/cart/find/session/{session}" }, method = { RequestMethod.GET })
	public ModelAndView findCartBySession(
	        @PathVariable("session") String session,
	        HttpServletResponse httpResponse_p) {
		Cart cart;
		try {
			cart = cartService_i.findCartBySession(session);
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CART_FIELD, cart);
	}

	@RequestMapping(value = { "/cart/find/ip/{ip}" }, method = { RequestMethod.GET })
	public ModelAndView findCartByIp(@PathVariable("ip") String ip,
	        HttpServletResponse httpResponse_p) {
		Cart cart;
		try {
			cart = cartService_i.findCartByIp(ip);
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CART_FIELD, cart);
	}

	@RequestMapping(value = { "/cart/find/customer/{customerId}" }, method = { RequestMethod.GET })
	public ModelAndView findCartByCustomer(
	        @PathVariable("customerId") String customerId,
	        HttpServletResponse httpResponse_p) {
		Cart cart;
		try {
			Long id = Long.parseLong(customerId);
			cart = cartService_i.findCartByCustomerId(id);
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CART_FIELD, cart);
	}

	@RequestMapping(value = { "/cart/" }, method = { RequestMethod.POST })
	public ModelAndView createCart(@RequestBody Cart cart_p,
	        HttpServletResponse httpResponse_p, WebRequest request_p) {
		Long createCartId;
		try {
			createCartId = (long) cartService_i.create(cart_p);
			cart_p.setId(createCartId);
		} catch (Exception e) {
			String sMessage = "Error creating new cart. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("cart", request_p.getContextPath() + "/cart/"
		        + createCartId);
		return new ModelAndView(jsonView_i, CART_FIELD, cart_p);
	}

	@RequestMapping(value = { "/cart/" }, method = { RequestMethod.PUT })
	public ModelAndView saveOrUpdate(@RequestBody Cart cart_p,
	        HttpServletResponse httpResponse_p, WebRequest request_p) {
		try {
			cartService_i.saveOrUpdate(cart_p);
		} catch (Exception e) {
			String sMessage = "Error creating new cart. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("cart", request_p.getContextPath() + "/cart/"
		        + cart_p.getId());
		return new ModelAndView(jsonView_i, CART_FIELD, cart_p);
	}

	@RequestMapping(value = { "/cart/{cartId}/update/quantity" }, method = { RequestMethod.PUT })
	public ModelAndView updateQuantity(@PathVariable("cartId") Long cartId,
	        @RequestBody JSONObject cartData,
	        HttpServletResponse httpResponse_p, WebRequest request_p) {
		Cart cart = null;
		try {
			cart = cartService_i.updateQuantity(cartId, cartData);
		} catch (Exception e) {
			String sMessage = "Error updating cart quantities. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("cart", request_p.getContextPath() + "/cart/"
		        + cart.getId() + "/update/quantity");
		return new ModelAndView(jsonView_i, CART_FIELD, cart);
	}

	@RequestMapping(value = { "/cart/find/session/{sessionId}/item/{itemId}" }, method = { RequestMethod.GET })
	public ModelAndView findCartDetailBySessionAndItemId(
	        @PathVariable("sessionId") String sessionId,
	        @PathVariable("itemId") Long itemId,
	        HttpServletResponse httpResponse_p, WebRequest request_p) {
		Cart cart;
		try {
			cart = cartService_i.findCartDetailBySessionAndItemId(sessionId,
			        itemId);
		} catch (Exception e) {
			String sMessage = "Error finding cart detail. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CART_FIELD, cart);
	}

	@RequestMapping(value = "/cart/{cartId}", method = RequestMethod.DELETE)
	public ModelAndView removeCart(@PathVariable("cartId") String cartId_p,
	        HttpServletResponse httpResponse_p) {
		try {
			Long id = Long.parseLong(cartId_p);
			cartService_i.delete(id);
		} catch (Exception e) {
			String sMessage = "Error invoking getFunds. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CART_FIELD, null);
	}

	@RequestMapping(value = "/cart/{cartId}/detail/{detailId}", method = RequestMethod.DELETE)
	public ModelAndView removeCartDetail(@PathVariable("cartId") Long cartId_p,
	        @PathVariable("detailId") Long detailId_p,
	        HttpServletResponse httpResponse_p) {
		Cart cart;
		try {
			cart = cartService_i.deleteCartDetail(cartId_p, detailId_p);
		} catch (Exception e) {
			String sMessage = "Error invoking deleteCartItem. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CART_FIELD, cart);
	}

	public void setJsonView(View view) {
		jsonView_i = view;
	}

	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
}
