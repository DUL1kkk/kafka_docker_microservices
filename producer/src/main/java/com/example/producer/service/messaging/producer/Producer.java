package com.example.producer.service.messaging.producer;

import com.example.producer.dto.*;
import com.example.producer.model.Order;
import com.example.producer.service.messaging.service.KafkaMessagingService;
import com.example.producer.service.messaging.service.OrderConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {
    @Autowired
    private final KafkaMessagingService kafkaMessagingService;
    private final OrderConverter orderConverter;

    public void sendOrderEvent(Order order) {
        // Преобразуем Order в DTO для отправки в разные топики
        WarehouseOrderDto warehouseOrder = orderConverter.toWarehouseOrderDto(order);

        // Отправляем в топик warehouse и записываем лог
        kafkaMessagingService.sendToWarehouse(warehouseOrder);
        log.info("Order sent to warehouse-topic: {}", warehouseOrder);

        // Отправка в другие топики (например, VIP или регулярные заказы)
        if (order.getVip()) {
            VipOrderDto vipOrder = orderConverter.toVipOrderDto(order);
            kafkaMessagingService.sendToVip(vipOrder);
            log.info("Order sent to vip-orders topic: {}", vipOrder);
        } else {
            RegularOrderDto regularOrder = orderConverter.toRegularOrderDto(order);
            kafkaMessagingService.sendToRegular(regularOrder);
            log.info("Order sent to regular-orders topic: {}", regularOrder);
        }

        // Отправка в другие топики, такие как manager и accounting
        ManageOrderDto managerOrder = orderConverter.toManageOrderDto(order);
        AccountingOrderDto accountingOrder = orderConverter.toAccountingOrderDto(order);
        DatabaseDto databaseOrder=orderConverter.toDatabaseDto(order);

        kafkaMessagingService.sendToDatabase(databaseOrder);
        log.info("Order sent to manager-topic: {}", databaseOrder);


        kafkaMessagingService.sendToAccounting(accountingOrder);
        log.info("Order sent to accounting-topic: {}", accountingOrder);
        kafkaMessagingService.sendToManager(managerOrder);
        log.info("Order sent to send-order-event-topic: {}", managerOrder);
    }
}

