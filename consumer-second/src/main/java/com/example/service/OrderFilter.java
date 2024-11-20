package com.example.service;

import com.jayway.jsonpath.JsonPath;

public class OrderFilter {

    /**
     * Проверяет, является ли заказ VIP на основе значения поля "price".
     *
     * @param orderJson JSON-сообщение заказа в формате строки
     * @return true, если цена больше 100000, иначе false
     */
    public static boolean isVipOrder(String orderJson) {
        try {
            double price = JsonPath.read(orderJson, "$.price");
            return price > 100000;
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            return false;
        }
    }
}
