package com.ecommerce.backend1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private User user;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Product product;

    private int quantity;
}
