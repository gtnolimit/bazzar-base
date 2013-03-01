package com.bazzar.base.services.impl;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.ItemDao;
import com.bazzar.base.dao.OrderDao;
import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.lookup.OrderStatusLookup;
import com.bazzar.base.domain.order.Order;
import com.bazzar.base.domain.order.OrderDetail;
import com.bazzar.base.services.ProcessOrderService;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderService {
	
	@Autowired 
	OrderDao orderDao;
	@Autowired
	ItemDao itemDao;
	
	public Order processOrderCreated ( Long orderId ){
		// TODO create orderProcess
		return null;
	}
	public Order processOrderPaid ( Long orderId ){
		// TODO create orderProcess
		return null;
	}
	public Order processOrderPacked ( Long orderId ){
		// TODO create orderProcess
		return null;
	}
	public Order processOrderShipped ( Long orderId ){
		// TODO create orderProcess
		return null;
	}
 	public Order processOrderComplete ( Long orderId ){
		
		Order order = orderDao.getOrder ( orderId );
		//order.setInvoiceNumber ( invoiceNumImpl.getInvoiceNumber () );
		//order = ( calcOrderImpl.calculateOrder ( order ) );
		Set <OrderDetail> orderDetails = order.getDetail ();
		Iterator <OrderDetail> orderDetailIterator = orderDetails.iterator ();
		while ( orderDetailIterator.hasNext () ){
			OrderDetail orderDetail = (OrderDetail) orderDetailIterator.next ();
			Long itemId = orderDetail.getItemId();
			int qtyOrder = orderDetail.getQty();
			Item item = itemDao.getItem ( itemId );
			int qtyItem = item.getQuantity();
			if ( qtyOrder > qtyItem ){
				// TODO create onhold process
			}else{
				item.setQuantity ( qtyItem - qtyOrder );
				itemDao.editItem ( item );
			}
		}
		order.setOrderStatus ( OrderStatusLookup.PR );
		// TODO create shipping request
		orderDao.editOrder ( order );
		createInvoicePDF ( order );
		emailInvoice ( order );
		return order;
	}

	private void createInvoicePDF ( Order order ){
		// TODO create invoicePDF
	}
	private void emailInvoice ( Order order ){
		// TODO create emailInvoice
	}
}
