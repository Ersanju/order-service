package com.homekart.order_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homekart.order_service.model.Order;
import com.homekart.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public String createOrder(Order order) {

        log.info("Creating order with productId: {}" + order.getProductId());
        order.setOrderId(UUID.randomUUID().toString());

        return orderRepository.saveOrder(order);
    }

    public Order getOrder(String orderId){
        log.info("Fetching order with OrderId: {}", orderId);

        return orderRepository.getOrder(orderId);
        
    }

}
