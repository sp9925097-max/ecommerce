package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.entity.Category;
import com.ecommerce.backend1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }
    @GetMapping
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
