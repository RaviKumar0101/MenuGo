package com.menuGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menuGo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
