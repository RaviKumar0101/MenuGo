package com.menuGo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(name = "restaurant_id", nullable = false)
	 private Long restaurantId;

	 @Column(name = "name", nullable = false)
	 private String name;

	 @Column(name = "description")
	 private String description;

	 @Column(name = "status", nullable = false)
	 private String status;

	 @Column(name = "created_at", nullable = false)
	 private LocalDateTime createdAt;

	 @Column(name = "updated_at")
	 private LocalDateTime updatedAt;

	 
	 public Long getId() {
		return id;
	}

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public Long getRestaurantId() {
		 return restaurantId;
	 }

	 public void setRestaurantId(Long restaurantId) {
		 this.restaurantId = restaurantId;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getDescription() {
		 return description;
	 }

	 public void setDescription(String description) {
		 this.description = description;
	 }

	 public String getStatus() {
		 return status;
	 }

	 public void setStatus(String status) {
		 this.status = status;
	 }

	 public LocalDateTime getCreatedAt() {
		 return createdAt;
	 }

	 public void setCreatedAt(LocalDateTime createdAt) {
		 this.createdAt = createdAt;
	 }

	 public LocalDateTime getUpdatedAt() {
		 return updatedAt;
	 }

	 public void setUpdatedAt(LocalDateTime updatedAt) {
		 this.updatedAt = updatedAt;
	 }

	 
	 
	 @PrePersist
	 protected void onCreate() {
		 createdAt = LocalDateTime.now();
	     updatedAt = LocalDateTime.now();
	 }

	 @PreUpdate
	 protected void onUpdate() {
	     updatedAt = LocalDateTime.now();
	 }
}
