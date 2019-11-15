package otus.spring.albot.lesson15.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.spring.albot.lesson15.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
}