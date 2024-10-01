package com.example.event.order.repository;

import com.example.event.order.persist.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
