package com.example.event.order.service;

import com.example.event.order.persist.Order;
import com.example.event.order.repository.OrderRepository;
import com.example.event.payment.event.PaymentEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;
    private final OrderRepository orderRepository;

    public OrderService(
        ApplicationEventPublisher eventPublisher,
        OrderRepository orderRepository
    ) {
        this.eventPublisher = eventPublisher;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Long doOrder(String itemName, long price) {
        Order order = orderRepository.save(new Order(itemName, price));
        eventPublisher.publishEvent(new PaymentEvent(order.orderId(), order.price()));
        return order.orderId();
    }

}
