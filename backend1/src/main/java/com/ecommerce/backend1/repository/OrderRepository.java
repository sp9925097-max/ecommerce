package com.ecommerce.backend1.repository;


import com.ecommerce.backend1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

List<Order> findByUserId(Long userId);

    List<Order> findByUserEmail(String email);
}
