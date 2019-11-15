package otus.spring.albot.lesson15.service;

import otus.spring.albot.lesson15.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
}