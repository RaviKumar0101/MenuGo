package com.menuGo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuGo.entity.Order;
import com.menuGo.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order order) {

        Order existingOrder = orderRepository.findById(id).orElse(null);

        if (existingOrder == null) {
            return null;
        }

        existingOrder.setOrderNumber(order.getOrderNumber());
        existingOrder.setCustomerId(order.getCustomerId());
        existingOrder.setRestaurantId(order.getRestaurantId());
        existingOrder.setTableId(order.getTableId());
        existingOrder.setTotalAmount(order.getTotalAmount());
        existingOrder.setPaymentMethod(order.getPaymentMethod());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setSpecialInstructions(order.getSpecialInstructions());

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}