package com.cgi.orderservice.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgi.orderservice.OrderServiceApplication;
import com.cgi.orderservice.domain.OrderDetail;
import com.cgi.orderservice.utils.OrderType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderServiceControllerIntegrationTest {
	
    @Autowired
    private TestRestTemplate restTemplate;


    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

	@Test
	public void testCreateOrder() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setUserId("user1");
		orderDetail.setQuantity(Double.valueOf(3.5));
		orderDetail.setPrice(new BigDecimal(303));
		orderDetail.setOrderType(OrderType.SELL.name());
		ResponseEntity<OrderDetail> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/orders/", orderDetail,
				OrderDetail.class);
		assertNotNull(postResponse);
		assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
		assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testCancelOrder()  {
	    HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setUserId("user25");
		orderDetail.setQuantity(Double.valueOf(3.5));
		orderDetail.setPrice(new BigDecimal(303));
		orderDetail.setOrderType(OrderType.SELL.name());
		
		String orderId = "user25";
		
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/orders/cancel/" + orderId,
                HttpMethod.PUT, entity, String.class);
        String cancelBody = response.getBody();
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(cancelBody);		
	}
	
	@Test
	public void testGetAllLiveOrders() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/orders/summary",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
	}

}
