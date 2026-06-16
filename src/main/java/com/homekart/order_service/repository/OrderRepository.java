package com.homekart.order_service.repository;

import org.springframework.stereotype.Repository;

import com.homekart.order_service.model.Order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
@Slf4j
@RequiredArgsConstructor
public class OrderRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    private static final String TABLE_NAME = "orders";

    private DynamoDbTable<Order> getTable() {
        return dynamoDbEnhancedClient.table(TABLE_NAME, TableSchema.fromBean(Order.class));
    }

    public String saveOrder(Order order) {

        log.info("Saving order to the DynamoDB with Id: {}", order.getOrderId());

        getTable().putItem(order);
        return "Order created with orderId: " + order.getOrderId();

    }

    public Order getOrder(String orderId) {

        log.info("Fetching order from DynamoDB with ID: {}", orderId);

        return getTable().getItem(
                Key.builder()
                        .partitionValue(orderId)
                        .build());
    }

}
