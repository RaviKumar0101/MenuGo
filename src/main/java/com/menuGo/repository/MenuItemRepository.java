package com.menuGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menuGo.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
