package com.example.orders_service.repository;
import com.example.orders_service.model.Order;
import com.example.orders_service.model.OrderResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepository extends MongoRepository<Order, String> {
}
