package com.menuGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menuGo.entity.RestaurantTable;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

}