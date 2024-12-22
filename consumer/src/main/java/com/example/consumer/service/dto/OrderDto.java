package com.example.consumer.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String productName;
    private String barCode;
    private int quantity;
    private BigDecimal price;
    private String orderCategory;  // Добавлено поле для категории заказа
    private boolean vip;           // Добавлено поле для VIP статуса
    private String vipLevel;       // Добавлено поле для уровня VIP

}
