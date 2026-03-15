package com.ecommerce.backend1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Double price;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
