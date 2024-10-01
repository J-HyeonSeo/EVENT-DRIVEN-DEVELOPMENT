package com.example.event.payment.service;

import com.example.event.payment.event.PaymentEvent;
import com.example.event.payment.persist.Payment;
import com.example.event.payment.repository.PaymentRepository;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService (
        PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 5000))
    @ApplicationModuleListener //@Async + @Transactional(Requires_NEW) + @EventListener
    public void doPayment(PaymentEvent request) {
        paymentRepository.save(new Payment(request.orderId(), request.price()));
    }

    @Recover
    public void recoverPayment() {
        System.out.println("DB에 뭔가가 문제가 있어요, 확인해줘요 빨리...");
    }

}
