package com.example.event.payment.repository;

import com.example.event.payment.persist.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
