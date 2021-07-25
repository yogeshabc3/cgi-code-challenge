package com.cgi.orderservice.utils;

import com.cgi.orderservice.domain.OrderDetail;

public class OrderTypeValidation {
	
    public static boolean validateOrderCancelled(OrderDetail orderDetail) {
        return  (OrderType.CANCEL.name() == orderDetail.getOrderType());
    }

}
