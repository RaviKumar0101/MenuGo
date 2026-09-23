package com.menuGo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuGo.entity.OrderItem;
import com.menuGo.repository.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {

        OrderItem existingOrderItem =
                orderItemRepository.findById(id).orElse(null);

        if (existingOrderItem == null) {
            return null;
        }

        existingOrderItem.setOrderId(orderItem.getOrderId());
        existingOrderItem.setMenuItemId(orderItem.getMenuItemId());
        existingOrderItem.setItemName(orderItem.getItemName());
        existingOrderItem.setUnitPrice(orderItem.getUnitPrice());
        existingOrderItem.setQuantity(orderItem.getQuantity());
        BigDecimal itemTotal =
                existingOrderItem.getUnitPrice()
                .multiply(BigDecimal.valueOf(orderItem.getQuantity()));

        existingOrderItem.setItemTotal(itemTotal);
        existingOrderItem.setSpecialInstructions(
                orderItem.getSpecialInstructions());

        return orderItemRepository.save(existingOrderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}