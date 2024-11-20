package com.example.producer.web.controller;

import com.example.producer.model.Order;
import com.example.producer.service.messaging.producer.Producer;
import com.example.producer.service.messaging.service.OrderParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final Producer producer;
    private final OrderParser orderParser; // Добавляем парсер как зависимость

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Order> sendOrders(@RequestBody List<Order> orders) {
        log.info("Received orders JSON: {}", orders);

        orders.forEach(order -> {
            try {
                // Преобразуем каждый объект Order в JSON для логирования
                String jsonOrder = orderParser.convertOrderToJson(order);
                log.info("Parsed order from JSON: {}", jsonOrder);

                // Отправляем заказ в Kafka
                producer.sendOrderEvent(order);
            } catch (Exception e) {
                log.error("Failed to parse or send order: {}", order, e);
            }
        });

        return orders;
    }
}
