package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.entity.Review;
import com.ecommerce.backend1.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("add")
    public Review addReview(@RequestBody Review review){
        return reviewRepository.save(review);
    }
    @GetMapping("/product/{productId}")
    public List<Review> getReviews(@PathVariable Long productId){
        return reviewRepository.findByProductId(productId);
    }
}
