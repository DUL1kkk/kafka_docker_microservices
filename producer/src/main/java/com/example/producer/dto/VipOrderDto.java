package com.example.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VipOrderDto {
    private String productName;
    private String barCode;
    private int quantity;
    private BigDecimal price;
    private boolean vip;
    private String vipLevel; // дополнительноe полe для уровня VIP
}
