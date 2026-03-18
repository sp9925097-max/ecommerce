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

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category){

        return categoryRepository.save(category);
    }
    @GetMapping
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id,
                                   @RequestBody Category category){
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setName(category.getName());
        return categoryRepository.save(existing);
    }
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
        return "Category deleted";
    }
}
