package com.cgi.orderservice.service;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cgi.orderservice.domain.OrderDetail;
import com.cgi.orderservice.repository.OrderServiceRepository;
import com.cgi.orderservice.utils.OrderType;

@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void getAllLiveOrder() throws Exception  {
	    OrderDetail orderDetail = new OrderDetail("user1", Double.valueOf(3.5), new BigDecimal(300), OrderType.SELL.name());
	    orderServiceRepository.save(orderDetail);

	    List<OrderDetail> orderDetailList = orderService.findAll();
	    OrderDetail orderDetailTest = orderDetailList.get(0);

	    assertEquals(orderDetail.getUserId(), orderDetailTest.getUserId());
	    assertEquals(orderDetail.getOrderType(), orderDetailTest.getOrderType());
	    assertEquals(orderDetail.getPrice(), orderDetailTest.getPrice());
	    assertEquals(orderDetail.getQuantity(), orderDetailTest.getQuantity());
	}
	
	@Test
	public void testName() throws Exception {
		
	}

}
