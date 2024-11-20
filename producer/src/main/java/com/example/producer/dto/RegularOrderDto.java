package com.example.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegularOrderDto {
    private String productName;
    private String barCode;
    private int quantity;
    private BigDecimal price;

    private String orderCategory; // пример дополнительного поля для категории обычного заказа
}