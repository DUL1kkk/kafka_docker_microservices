package org.example.kafka_practice3.entity;

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

}