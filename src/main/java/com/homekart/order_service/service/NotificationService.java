package com.homekart.order_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.homekart.order_service.model.Order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private final SnsClient snsClient;

    @Value("${aws.sns.topic-arn}")
    private String topicArn;

    public void publishOrderCreated(Order order) {

        String message = String.format(
                "Order created successfully%nOrderId: %s%nProduct Id: %s%nQuantity: %d%nStatus: %s",
                order.getOrderId(),
                order.getProductId(),
                order.getQuantity(),
                order.getStatus());

        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(topicArn)
                .subject("HomeKart order created")
                .message(message)
                .build();

        snsClient.publish(publishRequest);

        log.info("SNS notification published for orderId: {}", order.getOrderId());
    }

}
