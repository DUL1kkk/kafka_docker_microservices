package com.example.producer.service.messaging.service;

import com.example.producer.dto.AccountingOrderDto;
import com.example.producer.dto.ManageOrderDto;
import com.example.producer.dto.WarehouseOrderDto;
import com.example.producer.dto.RegularOrderDto;
import com.example.producer.dto.VipOrderDto;
import com.example.producer.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static WarehouseOrderDto toWarehouseOrderDto(Order order) {
        return modelMapper.map(order, WarehouseOrderDto.class);
    }

    public static ManageOrderDto toManageOrderDto(Order order) {
        return modelMapper.map(order, ManageOrderDto.class);
    }

    public static AccountingOrderDto toAccountingOrderDto(Order order) {
        return modelMapper.map(order, AccountingOrderDto.class);
    }

    public RegularOrderDto toRegularOrderDto(Order order) {
        RegularOrderDto dto = modelMapper.map(order, RegularOrderDto.class);
        dto.setOrderCategory(order.getOrderCategory()); // Заполняем orderCategory
        return dto;
    }
    public VipOrderDto toVipOrderDto(Order order) {
        VipOrderDto dto = modelMapper.map(order, VipOrderDto.class);
        dto.setVipLevel(order.getVipLevel()); // Заполняем vipLevel
        return dto;
    }
}
