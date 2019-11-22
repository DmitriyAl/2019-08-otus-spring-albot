package otus.spring.albot.lesson20.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.spring.albot.lesson20.entity.Product;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
