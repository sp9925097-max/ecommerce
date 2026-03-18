package com.ecommerce.backend1.service;

import com.ecommerce.backend1.dto.ProductDTO;
import com.ecommerce.backend1.entity.Product;
import com.ecommerce.backend1.repository.ProductRepository;
import com.ecommerce.backend1.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow();

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductDTO> getProducts(Pageable pageable) {

        Page<Product> productPage = productRepository.findAll(pageable);

        return productPage.map(product ->
                modelMapper.map(product, ProductDTO.class));
    }

        @Override
        public List<Product> searchProducts(String keyword){
            return productRepository.findByNameContainingIgnoreCase(keyword);
        }
    }
