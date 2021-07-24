package com.cgi.orderservice;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cgi.orderservice.domain.OrderDetail;
import com.cgi.orderservice.repository.OrderServiceRepository;

@SpringBootApplication
public class OrderServiceApplication {
	 
	@Autowired
	private OrderServiceRepository orderRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
    @PostConstruct
    private void initDb() {
 	   OrderDetail order1 = new OrderDetail("user1", Double.valueOf(3.5), new BigDecimal(306), "SELL");
	   orderRepository.save(order1);
	   OrderDetail order2 = new OrderDetail("user2", Double.valueOf(1.2), new BigDecimal(310), "SELL");
	   orderRepository.save(order2);
	   OrderDetail order3 = new OrderDetail("user3", Double.valueOf(1.5), new BigDecimal(307), "SELL");
	   orderRepository.save(order3);
	   OrderDetail order4 = new OrderDetail("user4", Double.valueOf(2.0), new BigDecimal(306), "SELL");
	   orderRepository.save(order4);
	   OrderDetail order5 = new OrderDetail("user5", Double.valueOf(2.0), new BigDecimal(306), "CANCEL");
	   orderRepository.save(order5);
    }

}
