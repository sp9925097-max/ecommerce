package com.ecommerce.backend1.repository;

import com.ecommerce.backend1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {


    List<Product> findByNameContainingIgnoreCase(String keyword);
}
