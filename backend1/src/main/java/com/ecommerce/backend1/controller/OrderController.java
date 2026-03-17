package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.entity.Cart;
import com.ecommerce.backend1.entity.Order;
import com.ecommerce.backend1.repository.CartRepository;
import com.ecommerce.backend1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/place/{userId}")
    public Order placeOrder(@PathVariable Long userId){
        List<Cart> cartItems = cartRepository.findByUserId(userId);

        double total = cartItems.stream()
                .mapToDouble(c -> c.getProduct().getPrice())
                .sum();
        Order order = new Order();
        order.setUser(cartItems.get(0).getUser());
        order.setTotalAmount(total);
        order.setStatus("PLACED");

        cartRepository.deleteAll(cartItems);

        return orderRepository.save(order);
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrders(@PathVariable Long userId){
        return orderRepository.findByUserId(userId);
    }
}

