package com.cgi.orderservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cgi.orderservice.domain.OrderDetail;
import com.cgi.orderservice.domain.OrderSummary;
import com.cgi.orderservice.domain.OrderSummaryList;
import com.cgi.orderservice.repository.OrderServiceRepository;
import com.cgi.orderservice.utils.OrderType;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Autowired
	private OrderService orderService;

	@Test
	public void getAllLiveOrder() throws Exception {
		OrderDetail orderDetail = new OrderDetail("user1", Double.valueOf(3.5), new BigDecimal(300),
				OrderType.SELL.name());
		orderServiceRepository.save(orderDetail);

		OrderSummaryList orderDetailList = orderService.findAllLiveOrders();
		OrderSummary orderDetailTest = orderDetailList.getBuy().get(0);

		assertEquals(orderDetail.getPrice(), orderDetailTest.getPrice());
		assertEquals(orderDetail.getQuantity(), orderDetailTest.getQuantity());
	}

	@Test
	public void testCreateOrder() throws Exception {
		OrderDetail orderDetail = new OrderDetail("user1", Double.valueOf(3.5), new BigDecimal(300),
				OrderType.SELL.name());
		orderServiceRepository.save(orderDetail);

		OrderDetail order = orderService.save(orderDetail);
		assertEquals(orderDetail.getUserId(), order.getUserId());
		assertEquals(orderDetail.getOrderType(), order.getOrderType());
		assertEquals(orderDetail.getPrice(), order.getPrice());
		assertEquals(orderDetail.getQuantity(), order.getQuantity());

	}

	@Test
	public void testCancelOrder() throws Exception {
		OrderDetail orderDetail = new OrderDetail("user1", Double.valueOf(3.5), new BigDecimal(300),
				OrderType.CANCEL.name());

		String orderId = "user1";
		OrderDetail order = orderServiceRepository.save(orderDetail);
		assertEquals(orderDetail.getUserId(), order.getUserId());
		assertEquals(orderDetail.getOrderType(), order.getOrderType());
		assertEquals(orderDetail.getPrice(), order.getPrice());
		assertEquals(orderDetail.getQuantity(), order.getQuantity());

	}

}
