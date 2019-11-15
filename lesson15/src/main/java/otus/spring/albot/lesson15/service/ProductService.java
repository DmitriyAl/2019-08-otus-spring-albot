package otus.spring.albot.lesson15.service;

import otus.spring.albot.lesson15.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);
}