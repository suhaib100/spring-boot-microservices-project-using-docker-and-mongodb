package com.example.products_service.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String price;
}
