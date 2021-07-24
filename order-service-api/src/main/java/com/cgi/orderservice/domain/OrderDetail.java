package com.cgi.orderservice.domain;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderDetail {
	
	private String userId;
	
	private Double quantity;
	
	private BigDecimal price;
	
	private String orderType;

	public OrderDetail(String userId, Double quantity, BigDecimal price, String orderType) {
		this.userId = userId;
		this.quantity = quantity;
		this.price = price;
		this.orderType = orderType;
	}	

}
