package com.example.orders_service.controller;

import com.example.orders_service.model.Order;
import com.example.orders_service.model.OrderResponse;
import com.example.orders_service.model.Product;
import com.example.orders_service.repository.OrderRepository;
import com.example.orders_service.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    //    @Autowired
    private final OrderRepository orderRepository;


//    @Autowired
    private final OrderService orderService;

    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }


    @GetMapping()
    public List<Order> getAllOrders() {
        return  orderRepository.findAll();
    }

    @PostMapping()
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderRepository.deleteById(id);
    }






    @GetMapping("/fetchProducts/{orderId}")
    public ResponseEntity<Mono<Order>> fetchProductsForOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.getOrderWithProducts(orderId));
    }

}
