package com.cgi.orderservice.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "OrderDetail")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "userId", unique = true)
	private String userId;

	@Column(name = "quantity")
	private Double quantity;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "orderType")
	private String orderType;

	public OrderDetail(String userId, Double quantity, BigDecimal price, String orderType) {
		this.userId = userId;
		this.quantity = quantity;
		this.price = price;
		this.orderType = orderType;
	}

}
