package com.homekart.order_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homekart.order_service.event.OrderCreatedEvent;
import com.homekart.order_service.kafka.OrderEventProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaTestController {

    private final OrderEventProducer producer;

    @GetMapping("/test")
    public String test() {
        OrderCreatedEvent event = OrderCreatedEvent.builder()
                .orderId("ORD-101")
                .productId("P1001")
                .quantity(2)
                .status("PENDING")
                .build();

        producer.publish(event);

        return "Event published";
    }
}
