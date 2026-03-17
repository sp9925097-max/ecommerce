package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.entity.Cart;
import com.ecommerce.backend1.entity.Product;
import com.ecommerce.backend1.entity.User;
import com.ecommerce.backend1.repository.CartRepository;
import com.ecommerce.backend1.repository.ProductRepository;
import com.ecommerce.backend1.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart){

        User user = userRepository.findById(cart.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(cart.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.setUser(user);
        cart.setProduct(product);

        return cartRepository.save(cart);
    }
    @GetMapping("/user/{userId}")
    public List<Cart>getCartByUser(@PathVariable Long userId){
        return cartRepository.findByUserId(userId);
    }
}