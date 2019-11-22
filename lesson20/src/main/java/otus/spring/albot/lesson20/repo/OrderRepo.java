package otus.spring.albot.lesson20.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.spring.albot.lesson20.entity.Order;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    void deleteByIdIn(List<Long> orderIds);
}
