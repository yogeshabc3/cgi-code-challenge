package com.cgi.orderservice.service;

import java.util.List;

import com.cgi.orderservice.domain.OrderDetail;

public interface OrderService {
	
	 List<OrderDetail> findAll();
	 
	 OrderDetail save(OrderDetail detail);

}
