package com.example.event.payment.persist;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "payment")
public record Payment(@Id Long paymentId, Long orderId, long price) {
    public Payment(Long orderId, long price) {
        this(null, orderId, price);
    }
}
