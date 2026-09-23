package com.menuGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menuGo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}