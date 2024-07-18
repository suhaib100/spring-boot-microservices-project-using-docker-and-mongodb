package com.example.api_gateway.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RouteConfig {
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, WebClient.Builder webClientBuilder) {
//        return builder.routes()
//                .route("orders-service", r -> r.path("/api/orders/**")
//                        .filters(f -> f.rewritePath("/api/orders/(?<segment>.*)", "/${segment}"))
//                        .uri("http://192.168.1.37:8081"))
//                .route("products-service", r -> r.path("/api/products/**")
//                        .filters(f -> f.rewritePath("/api/products/(?<segment>.*)", "/${segment}"))
//                        .uri("http://192.168.1.37:8082"))
//                .build();
//    }


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("orders-service", r -> r.path("/api/orders/**")
                        .filters(f -> f.rewritePath("/api/orders/(?<segment>.*)", "/${segment}"))
                        .uri("lb://orders-service"))
                .route("products-service", r -> r.path("/api/products/**")
                        .filters(f -> f.rewritePath("/api/products/(?<segment>.*)", "/${segment}"))
                        .uri("lb://products-service"))
                .build();
    }



    }
