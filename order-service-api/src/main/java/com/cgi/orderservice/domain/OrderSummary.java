package com.cgi.orderservice.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderSummary {
	
	private Double quantity;
	
	private BigDecimal price;

	public OrderSummary(Double quantity, BigDecimal price) {
		this.quantity = quantity;
		this.price = price;
	}

}
