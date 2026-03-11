package com.ecommerce.backend1.service;

import com.ecommerce.backend1.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product updateProduct(Long id,Product product);
    void deleteProduct(Long id);
}
