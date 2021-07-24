package com.cgi.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cgi.orderservice.domain.OrderDetail;
import com.cgi.orderservice.repository.OrderServiceRepository;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return orderServiceRepository.findAll();
	}

	@Override
	public OrderDetail save(OrderDetail detail) {
		// TODO Auto-generated method stub
		return null;
	}

}
