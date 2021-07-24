package com.cgi.orderservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.cgi.orderservice.domain.OrderDetail;

public class OrderServiceTest {
	
	@Test
	void getAllLiveOrder(){
	    OrderDetail orderDetail = new OrderDetail("user1", Double.valueOf(3.5), new BigDecimal(300), "BUY");
	    orderServiceRepository.save(orderDetail);
	    OrderService orderService = new OrderService(orderServiceRepository);

	    List<OrderDetail> orderDetailList = orderService.findAll();
	    OrderDetail orderDetailTest = orderDetailList.get(0);

	    assertEquals(orderDetail.getUserId(), orderDetailTest.getUserId());
	    assertEquals(orderDetail.getOrderType(), orderDetailTest.getOrderType());
	    assertEquals(orderDetail.getPrice(), orderDetailTest.getPrice());
	    assertEquals(orderDetail.getQuantity(), orderDetailTest.getQuantity());
	}

}
