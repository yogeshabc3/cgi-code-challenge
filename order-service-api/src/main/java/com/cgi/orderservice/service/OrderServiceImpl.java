package com.cgi.orderservice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.orderservice.domain.OrderDetail;
import com.cgi.orderservice.domain.OrderSummary;
import com.cgi.orderservice.domain.OrderSummaryList;
import com.cgi.orderservice.repository.OrderServiceRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Override
	public OrderSummaryList findAllLiveOrders() {
		
		OrderSummaryList orderSummaryList = new OrderSummaryList();
        List<OrderSummary> orderSummaryBuyList = new ArrayList<OrderSummary>();
        List<OrderSummary> orderSummarySellList = new ArrayList<OrderSummary>();
        Optional<List<OrderDetail>> orderDetailList = orderServiceRepository.findLiveOrders();
        
        Map<String,List<OrderSummary>> orderSummaryGroupList =
        		orderDetailList
        		.get()
        		.stream()
        		.collect(
        				Collectors.groupingBy(o -> o.getOrderType(),
        	            Collectors.mapping(o -> new OrderSummary(o.getQuantity(),o.getPrice()),
        	            Collectors.toList())));
        
		orderSummaryGroupList.forEach((key, value) -> {
			Map<BigDecimal, Double> orderSummaryMap = value.stream().collect(
					Collectors.groupingBy(OrderSummary::getPrice, Collectors.summingDouble(OrderSummary::getQuantity)));
			if (key.equals("BUY")) {
				    orderSummaryMap.forEach((k, v) -> {
					OrderSummary orderBuy = new OrderSummary(v, k);
					orderSummaryBuyList.add(orderBuy);
				});
			} else if (key.equals("SELL")) {
				    orderSummaryMap.forEach((k, v) -> {
					OrderSummary orderSell = new OrderSummary(v, k);
					orderSummarySellList.add(orderSell);
				});
			    }
               }
            );
	
         Collections.sort(orderSummarySellList, Comparator.comparing(OrderSummary::getPrice));
         Collections.sort(orderSummaryBuyList, Comparator.comparing(OrderSummary::getPrice).reversed());
        
		return orderSummaryList;
	}

	@Override
	public OrderDetail save(OrderDetail detail) {
		 return orderServiceRepository.save(detail);
	}

	@Override
	public Optional<OrderDetail> findByOrderId(String orderId) {
		return orderServiceRepository.findByOrderId(orderId);
	}

}
