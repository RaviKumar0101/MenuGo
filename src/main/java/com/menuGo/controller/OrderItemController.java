package com.menuGo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menuGo.entity.OrderItem;
import com.menuGo.service.OrderItemService;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public OrderItem saveOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.saveOrderItem(orderItem);
    }

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }

    @PutMapping("/{id}")
    public OrderItem updateOrderItem(
            @PathVariable Long id,
            @RequestBody OrderItem orderItem) {

        return orderItemService.updateOrderItem(id, orderItem);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderItem(@PathVariable Long id) {

        orderItemService.deleteOrderItem(id);

        return "Order item deleted successfully";
    }
}