package com.example.event.order.persist;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "order")
public record Order(@Id Long orderId, String itemName, long price) {
    public Order(String itemName, long price) {
        this(null, itemName, price);
    }
}
