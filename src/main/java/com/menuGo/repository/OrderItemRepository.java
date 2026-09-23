package com.menuGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menuGo.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}