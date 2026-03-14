package com.ecommerce.backend1.repository;

import com.ecommerce.backend1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}