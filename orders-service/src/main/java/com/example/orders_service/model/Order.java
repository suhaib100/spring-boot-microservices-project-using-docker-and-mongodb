package com.example.orders_service.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@Data
public class Order {
    @Id
    private String id;
    private String customerName;
    private String productName;
    private List<String> productIds;

    @Transient
    private List<Product> products;



}
