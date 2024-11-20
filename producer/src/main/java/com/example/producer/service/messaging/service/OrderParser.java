package com.example.producer.service.messaging.service;

import com.example.producer.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderParser {

    private final ObjectMapper objectMapper;

    public OrderParser() {
        this.objectMapper = new ObjectMapper();
    }

    // Метод для парсинга JSON в объект Order с валидацией
    public Order parseOrderFromJson(String json) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(json);

        // Валидация полей
        if (!jsonNode.has("productName") || !jsonNode.has("barCode") || !jsonNode.has("quantity")) {
            throw new IllegalArgumentException("JSON is missing required fields");
        }

        return objectMapper.treeToValue(jsonNode, Order.class);
    }

    // Метод для преобразования объекта Order в форматированный JSON
    public String convertOrderToJson(Order order) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(order);
    }
}
