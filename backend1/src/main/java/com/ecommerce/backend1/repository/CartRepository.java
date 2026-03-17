package com.ecommerce.backend1.repository;

import com.ecommerce.backend1.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart , Long> {
    List<Cart> findByUserId(Long userId);
}
