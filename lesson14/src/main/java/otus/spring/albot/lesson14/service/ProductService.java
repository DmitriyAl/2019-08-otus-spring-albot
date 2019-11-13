package otus.spring.albot.lesson14.service;

import otus.spring.albot.lesson14.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);
}