    package com.example.producer.dto;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.math.BigDecimal;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public class AccountingOrderDto {
        private String productName;
        private BigDecimal price;
        private int quantity;


    }

