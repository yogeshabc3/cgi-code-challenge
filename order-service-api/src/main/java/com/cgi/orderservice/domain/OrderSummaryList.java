package com.cgi.orderservice.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class OrderSummaryList {
	
	private List<OrderSummary> buy = new ArrayList<OrderSummary>();
	
	private List<OrderSummary> sell = new ArrayList<OrderSummary>();

}
