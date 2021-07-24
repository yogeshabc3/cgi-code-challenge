package com.cgi.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.orderservice.domain.OrderDetail;
import com.cgi.orderservice.repository.OrderServiceRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Override
	public Optional<List<OrderDetail>> findAllLiveOrders() {
		return orderServiceRepository.findLiveOrders();
	}

	@Override
	public OrderDetail save(OrderDetail detail) {
		 return orderServiceRepository.save(detail);
	}

	@Override
	public Optional<OrderDetail> findByOrderId(String orderId) {
		return orderServiceRepository.findByOrderId(orderId);
	}

}
