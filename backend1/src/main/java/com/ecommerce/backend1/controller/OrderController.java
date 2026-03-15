package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.entity.Order;
import com.ecommerce.backend1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public Order publicOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}

