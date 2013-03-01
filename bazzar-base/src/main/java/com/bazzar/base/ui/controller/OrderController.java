package com.bazzar.base.ui.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.bazzar.base.domain.order.Order;
import com.bazzar.base.services.impl.OrderServiceImpl;

@Controller
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderService_i;
	
	@Autowired
	private View jsonView_i;

	private static final String ORDER_FIELD = "order";
	private static final String ORDERS_FIELD = "orders";
	private static final String ERROR_FIELD = "error";

	@RequestMapping(value = { "/order/find/invoice/{invoiceNumber}" }, method = { RequestMethod.GET })
	public ModelAndView findOrderByInvoice(@PathVariable("invoiceNumbe") String invoiceNumbe,
				   HttpServletResponse httpResponse_p) {
		Order order;
		try {
			order = orderService_i.getOrderByInvoice( invoiceNumbe );
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ORDER_FIELD, order);
	}
	@RequestMapping(value = { "/order/find/session/{session}" }, method = { RequestMethod.GET })
	public ModelAndView findOrderBySession(@PathVariable("session") String session,
				   HttpServletResponse httpResponse_p) {
		Order order;
		try {
			order = orderService_i.getOrderBySession( session );
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ORDER_FIELD, order);
	}
	@RequestMapping(value = { "/order/find/ip/{ip}" }, method = { RequestMethod.GET })
	public ModelAndView findOrderByIp(@PathVariable("ip") String ip,
				   HttpServletResponse httpResponse_p) {
		Order order;
		try {
			order = orderService_i.getOrderByIp( ip );
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ORDER_FIELD, order);
	}
	@RequestMapping(value = { "/order/find/customer/{customerId}" }, method = { RequestMethod.GET })
	public ModelAndView findOrderByCustomer(@PathVariable("customerId") String customerId,
				   HttpServletResponse httpResponse_p) {
		List <Order> order;
		try {
			Long id = Long.parseLong(customerId);
			order = orderService_i.getOrdersForCustomer( id );
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ORDERS_FIELD, order);
	}
	@RequestMapping(value = { "/order/{orderId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateOrder(@RequestBody Order order_p, @PathVariable("orderId") String orderId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			orderService_i.editOrder(order_p);
		} catch (Exception e) {
			String sMessage = "Error updating category. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ORDER_FIELD, null);
	}
	@RequestMapping(value = { "/order/" }, method = { RequestMethod.POST })
	public ModelAndView createOrder(@RequestBody Order order_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createOrderId;
		try {
			createOrderId = (long) orderService_i.createOrder ( order_p );
			order_p.setId( createOrderId );
		} catch (Exception e) {
			String sMessage = "Error creating new category. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("order", request_p.getContextPath() + "/order/" + createOrderId);
		return new ModelAndView(jsonView_i, ORDER_FIELD, order_p );
	}
	@RequestMapping(value = "/order/", method = RequestMethod.GET)
	public ModelAndView getOrders() {
		return new ModelAndView(jsonView_i, ORDERS_FIELD, orderService_i.getOrders());
	}
	@RequestMapping ( value = "/order/{orderId}", method = RequestMethod.GET )
	public ModelAndView getOrder ( @PathVariable ( "orderId" ) String orderId ) {
		Long _id = (long) 0;
		try {
			_id = Long.parseLong ( orderId );
		} catch (Exception e) {
			String sMessage = "Error converting ID into numeric value";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		return new ModelAndView ( jsonView_i, ORDER_FIELD, orderService_i.getOrder ( _id ) );
	}
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE)
	public ModelAndView removeOrder(@PathVariable("orderId") String orderId_p,
								   HttpServletResponse httpResponse_p) {

		try {
			Long id = Long.parseLong(orderId_p);
			orderService_i.delete ( id );
		} catch (Exception e) {
			String sMessage = "Error invoking getFunds. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ORDER_FIELD, null);
	}	
	public void setJsonView(View view) {
		jsonView_i = view;
	}
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
}
