package com.ecommerce.backend1.repository;


import com.ecommerce.backend1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
