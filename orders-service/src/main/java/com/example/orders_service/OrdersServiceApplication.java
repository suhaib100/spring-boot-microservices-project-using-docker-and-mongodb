package com.example.orders_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Collections;

@SpringBootApplication

//@EnableDiscoveryClient
@EnableFeignClients

public class OrdersServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(OrdersServiceApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
		app.run(args);	}

}
