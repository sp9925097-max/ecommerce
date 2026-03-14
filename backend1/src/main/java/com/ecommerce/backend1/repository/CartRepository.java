package com.ecommerce.backend1.repository;

import com.ecommerce.backend1.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart , Long> {
}
