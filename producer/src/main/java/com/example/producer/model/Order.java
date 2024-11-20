package com.example.producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String productName;
    private String barCode;
    private int quantity;
    private BigDecimal price;
    private boolean vip; // Поле для VIP статуса
    private String orderCategory; // Новое поле для категории заказа
    private String vipLevel; // Новое поле для уровня VIP

    public boolean getVip() {
        return vip;
    }
}
