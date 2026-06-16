package com.homekart.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Order {

    private String orderId;
    private String productId;
    private Integer quantity;
    private String status;
    private String createdAt;

    @DynamoDbPartitionKey
    public String getOrderId() {
        return orderId;
    }

}
