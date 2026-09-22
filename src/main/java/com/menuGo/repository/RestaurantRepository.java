package com.menuGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menuGo.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

}
