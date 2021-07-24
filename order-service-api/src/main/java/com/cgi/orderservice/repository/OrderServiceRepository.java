package com.cgi.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.orderservice.domain.OrderDetail;

public interface OrderServiceRepository extends JpaRepository<OrderDetail, Long>{

}
