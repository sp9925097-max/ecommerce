package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.entity.Wishlist;
import com.ecommerce.backend1.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class WishlistController {
    @Autowired
    private WishlistRepository wishlistRepository;

    @PostMapping("/add")
    public Wishlist add(@RequestBody Wishlist wishlist){
        return wishlistRepository.save(wishlist);
    }
    @GetMapping("/user/{userId}")
    public List<Wishlist>getWishlist(@PathVariable Long userId){
        return wishlistRepository.findByUserId(userId);
    }
}
