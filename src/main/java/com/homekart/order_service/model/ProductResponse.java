package com.homekart.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String productId;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;

}
