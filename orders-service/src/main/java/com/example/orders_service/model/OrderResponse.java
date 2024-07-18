package com.example.orders_service.model;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class OrderResponse {


    private Order  order;
    private List<Product> products;

    public OrderResponse(Order order, List<Product> products) {
    }

    public OrderResponse() {

    }
}
