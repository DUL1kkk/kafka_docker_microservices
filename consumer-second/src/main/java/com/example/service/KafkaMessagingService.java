package com.example.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaMessagingService {


    private static final String kafkaConsumerGroupId = "order-2"; // Идентификатор группы консюмеров

    @Transactional
    @KafkaListener(topics = { "${topic.vip-order}", "${topic.regular-order}" },
            groupId = kafkaConsumerGroupId,
            properties = { "spring.json.value.default.type=com.example.service.OrderEvent" })
    public void printOrder(OrderEvent orderEvent) {
        log.info("The product: {} was ordered in quantity: {} and at a price: {}",
                orderEvent.getProductName(), orderEvent.getQuantity(), orderEvent.getPrice());
        log.info("To pay: {}", orderEvent.getPrice().multiply(BigDecimal.valueOf(orderEvent.getQuantity())));
    }
}
