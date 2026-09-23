package com.menuGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menuGo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}