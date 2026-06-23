package com.homekart.order_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.homekart.order_service.event.OrderCreatedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "order-created";

    public void publish(OrderCreatedEvent event) {
        
        kafkaTemplate.send(
                TOPIC,
                event.getOrderId(),
                event);

        log.info("Order event published {}", event);
    }

}
