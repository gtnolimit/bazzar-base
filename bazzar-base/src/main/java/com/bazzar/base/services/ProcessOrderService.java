package com.bazzar.base.services;

import com.bazzar.base.domain.order.Order;

public interface ProcessOrderService {

	public Order processOrderComplete ( Long orderId );
}
