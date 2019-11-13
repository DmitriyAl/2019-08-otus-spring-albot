package otus.spring.albot.lesson14.service;

import otus.spring.albot.lesson14.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
}