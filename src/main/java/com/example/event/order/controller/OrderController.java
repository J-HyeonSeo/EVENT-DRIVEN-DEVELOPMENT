package com.example.event.order.controller;

import com.example.event.order.service.OrderService;
import com.example.event.order.vo.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    OrderController (
        OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    ResponseEntity<Long> doOrder(@RequestBody OrderRequest request) throws InterruptedException {
        return ResponseEntity.ok(orderService.doOrder(request.itemName(), request.price()));
    }

}
