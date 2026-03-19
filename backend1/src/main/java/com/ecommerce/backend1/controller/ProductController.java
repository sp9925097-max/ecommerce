package com.ecommerce.backend1.controller;

import com.ecommerce.backend1.dto.ApiResponse;
import com.ecommerce.backend1.dto.ProductDTO;
import com.ecommerce.backend1.entity.Product;
import com.ecommerce.backend1.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    // ✅ Get all (pagination)
    @GetMapping("/page")
    public Page<ProductDTO> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){

        Pageable pageable = PageRequest.of(page, size);
        return productService.getProducts(pageable);
    }

    @PostMapping("/add")
    public ApiResponse<Product> addProduct(@RequestBody Product product){
        Product savedProduct = productService.addProduct(product);
        return new ApiResponse<>("Product added successfully",savedProduct);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }

    // ✅ Search
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword){
        return productService.searchProducts(keyword);
    }
}