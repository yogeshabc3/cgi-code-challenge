package com.cgi.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.cgi.orderservice.domain.OrderDetail;

public interface OrderService {
	
	 Optional<List<OrderDetail>> findAllLiveOrders();
	 
	 OrderDetail save(OrderDetail detail);
	 
	 Optional<OrderDetail> findByOrderId(@Param("orderId") String orderID);

}
