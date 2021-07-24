package com.cgi.orderservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cgi.orderservice.domain.OrderDetail;

public interface OrderServiceRepository extends JpaRepository<OrderDetail, Long>{
	
    @Query("select o from OrderDetail o where o.orderType != 'CANCEL'")
    Optional<List<OrderDetail>> findLiveOrders();
    
    @Query("select o from OrderDetail o where o.userId = :orderId")
    Optional<OrderDetail> findByOrderId(@Param("orderId") String orderId);

}
