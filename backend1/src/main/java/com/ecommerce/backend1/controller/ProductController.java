package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.entity.Product;
import com.ecommerce.backend1.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET ALL PRODUCTS
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // ADD PRODUCT
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}