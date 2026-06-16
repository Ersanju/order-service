package com.homekart.order_service;

import java.time.Instant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.homekart.order_service.model.Order;
import com.homekart.order_service.repository.OrderRepository;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		System.out.println("Order service running...");
	}

	@Bean
	CommandLineRunner testOrder(OrderRepository repository) {
		return args -> {

			Order order = Order.builder()
					.orderId("ORD-1001")
					.productId("P1001")
					.quantity(2)
					.status("CREATED")
					.createdAt(Instant.now().toString())
					.build();

			System.out.println(
					repository.saveOrder(order));

			System.out.println(
					repository.getOrder("ORD-1001"));
		};
	}
}
