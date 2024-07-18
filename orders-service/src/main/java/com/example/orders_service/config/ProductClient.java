package com.example.orders_service.config;

import com.example.orders_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;


@FeignClient(name = "products-service", url = "http://localhost:8082")
public interface ProductClient {

    @GetMapping("/api/products/{id}")
//    Product getProductById(@PathVariable("id") String id);




    Mono<Product> getProductById(String id);

}
