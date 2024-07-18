package com.example.orders_service.config;

import com.example.orders_service.model.Product;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Value;


public class ProductClientImpl implements ProductClient{

    private final WebClient webClient;

    public ProductClientImpl(@Value("${products.api.url}") String productsApiUrl) {
        this.webClient = WebClient.builder().baseUrl(productsApiUrl).build();
    }


    @Override
    public Mono<Product> getProductById(String id) {
        return webClient.get().uri("/api/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class);
    }
}
