package com.ecommerce.backend1.service;

import com.ecommerce.backend1.dto.ProductDTO;
import com.ecommerce.backend1.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Page<ProductDTO> getProducts(Pageable pageable);

    List<Product> searchProducts(String keyword);
}