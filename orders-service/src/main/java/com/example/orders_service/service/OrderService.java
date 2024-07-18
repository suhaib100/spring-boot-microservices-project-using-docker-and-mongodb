package com.example.orders_service.service;

import com.example.orders_service.config.ProductClient;
import com.example.orders_service.model.Order;
import com.example.orders_service.model.Product;
import com.example.orders_service.repository.OrderRepository;
//import com.example.products_service.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);


    private final OrderRepository orderRepository;
    private final ProductClient productClient;




//
//    public OrderResponse getOrderWithProducts(String orderId) {
//        // Fetch the order by orderId from the repository
//        Order order = orderRepository.findById(orderId).orElseThrow();
//
//        // Fetch products from products-service
//        List<Product> products = order.getProductIds().stream()
//                .map(productClient::getProductById)
//                .collect(Collectors.toList());
//
//        return new OrderResponse(order, products);
//    }





    public OrderService(ProductClient productClient, OrderRepository orderRepository, ProductClient productClient1) {
        this.orderRepository = orderRepository;
        this.productClient = productClient1;
    }


    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }



    public Mono<Order> getOrderWithProducts(String orderId) {
        return orderRepository.findById(orderId)
                .flatMap(order -> fetchProducts(order.getProductIds())
                        .collectList()
                        .map(products -> {
                            Order orderWithProductsDTO = new Order();
                            orderWithProductsDTO.setId(order.getId());
                            orderWithProductsDTO.setCustomerName(order.getCustomerName());
                            orderWithProductsDTO.setProductName(order.getProductName());
                            orderWithProductsDTO.setProductIds(order.getProductIds());
                            orderWithProductsDTO.setProducts(products);
                            return orderWithProductsDTO;
                        }));
    }

    private Flux<Product> fetchProducts(List<String> productIds) {
        // Implement logic to fetch products from MongoDB based on productIds
        // Example:
        return Flux.fromIterable(productIds)
                .flatMap(productId -> orderRepository.findById(productId))
                .switchIfEmpty(Flux.empty()); // Handle empty case if needed
    }

}
