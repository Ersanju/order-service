package com.homekart.order_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homekart.order_service.model.Order;
import com.homekart.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public String createOrder(@RequestBody Order order) {

        log.info("Recieved request to create object with productId: {}", order.getProductId());
        return orderService.createOrder(order);

    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {

        log.info("Recieved request to fetch order with Id: {}", orderId);
        return orderService.getOrder(orderId);
    }
}
