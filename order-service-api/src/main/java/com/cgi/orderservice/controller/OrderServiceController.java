package com.cgi.orderservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.orderservice.domain.OrderDetail;
import com.cgi.orderservice.domain.OrderSummaryList;
import com.cgi.orderservice.exception.RecordNotFoundException;
import com.cgi.orderservice.service.OrderService;
import com.cgi.orderservice.utils.OrderType;

@RestController
@RequestMapping("/api")
public class OrderServiceController {

	@Autowired
	private OrderService service;

	@PostMapping("/orders")
	public ResponseEntity<OrderDetail> createOrder(@RequestBody OrderDetail orderData) {
		OrderDetail _result = service.save(new OrderDetail(orderData.getUserId(), orderData.getQuantity(),
				orderData.getPrice(), orderData.getOrderType()));
		return new ResponseEntity<>(_result, HttpStatus.CREATED);
	}

	@PutMapping("/orders/cancel/{orderId}")
	public ResponseEntity<OrderDetail> cancelOrder(@PathVariable String orderId) {
		Optional<OrderDetail> orderDetail = service.findByOrderId(orderId);
		if (orderDetail.isPresent()) {
			OrderDetail detail = orderDetail.get();
			detail.setOrderType(OrderType.CANCEL.name());
			return new ResponseEntity<>(service.save(detail), HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("Order Details not found " + orderId);
		}
	}

	@GetMapping("/orders/summary")
	public ResponseEntity<OrderSummaryList> getAllLiveOrders() {
		OrderSummaryList orderSummaryList = service.findAllLiveOrders();
        if (orderSummaryList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<>(orderSummaryList, HttpStatus.OK);
	}

}
