package com.cgi.orderservice.service;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.cgi.orderservice.domain.OrderDetail;
import com.cgi.orderservice.domain.OrderSummaryList;

public interface OrderService {
	
	 OrderSummaryList findAllLiveOrders();
	 
	 OrderDetail save(OrderDetail detail);
	 
	 Optional<OrderDetail> findByOrderId(@Param("orderId") String orderID);

}
