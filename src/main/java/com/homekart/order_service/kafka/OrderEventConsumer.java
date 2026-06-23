package com.homekart.order_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.homekart.order_service.event.OrderCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderEventConsumer {

    @KafkaListener(topics = "order-created", groupId = "notification-group")
    public void consume(OrderCreatedEvent event) {

        log.info("Received event {}", event);
    }

}
