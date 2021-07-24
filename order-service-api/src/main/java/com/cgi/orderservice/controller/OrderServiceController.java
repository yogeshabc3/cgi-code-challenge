package com.cgi.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.orderservice.domain.OrderDetail;

@RestController
@RequestMapping("/api")
public class OrderServiceController {
	
	
	@PostMapping("/orders")
	public ResponseEntity<OrderDetail> createOrder(@RequestBody OrderDetail orderData) {
		return new ResponseEntity<>(new OrderDetail(), HttpStatus.CREATED);		
	}

}
