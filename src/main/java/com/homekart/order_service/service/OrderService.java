package com.homekart.order_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homekart.order_service.client.ProductClient;
import com.homekart.order_service.exception.OrderNotFoundException;
import com.homekart.order_service.model.Order;
import com.homekart.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    public String createOrder(Order order) {

        log.info("Creating order with productId: {}",
                order.getProductId());

        order.setOrderId(UUID.randomUUID().toString());

        productClient.getProduct(order.getProductId());

        String response = orderRepository.saveOrder(order);

        notificationService.publishOrderCreated(order);

        return response;
    }

    public Order getOrder(String orderId) {
        log.info("Fetching order with OrderId: {}", orderId);

        Order order = orderRepository.getOrder(orderId);

        if (order == null) {
            throw new OrderNotFoundException(
                    "Order not found with Id: " + orderId);
        }

        return order;

    }

}
