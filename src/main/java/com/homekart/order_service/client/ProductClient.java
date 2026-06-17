package com.homekart.order_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.homekart.order_service.model.ProductResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductClient {

    private final WebClient webClient;

    public ProductResponse getProduct(String productId) {

        return webClient.get()
                .uri("http://localhost:8080/product/" + productId)
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .block();
    }

}
