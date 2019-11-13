package otus.spring.albot.lesson14.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import otus.spring.albot.lesson14.entity.Order;
import otus.spring.albot.lesson14.repo.OrderRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepo orderRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }
}