package com.example.producer.service.messaging.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.producer.dto.*;

@Service
public class KafkaMessagingService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topic.vip-order}")
    private String vipTopic;

    @Value("${topic.regular-order}")
    private String regularTopic;

    @Value("${topic.warehouse-order}")
    private String warehouseTopic;

    @Value("${topic.manager-order}")
    private String managerTopic;

    @Value("${topic.accounting-order}")
    private String accountingTopic;

    public KafkaMessagingService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToVip(VipOrderDto vipOrder) {
        kafkaTemplate.send(vipTopic, vipOrder);
    }

    public void sendToRegular(RegularOrderDto regularOrder) {
        kafkaTemplate.send(regularTopic, regularOrder);
    }

    public void sendToWarehouse(WarehouseOrderDto warehouseOrder) {
        kafkaTemplate.send(warehouseTopic, warehouseOrder);
    }

    public void sendToManager(ManageOrderDto managerOrder) {
        kafkaTemplate.send(managerTopic, managerOrder);
    }

    public void sendToAccounting(AccountingOrderDto accountingOrder) {
        kafkaTemplate.send(accountingTopic, accountingOrder);
    }
}
