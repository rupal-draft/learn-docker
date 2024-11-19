package com.docker.ecommerce.product_service.repository;

import com.docker.ecommerce.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByTitle(String name);
}
