package com.hackers.mycommerce.product.service;

import com.hackers.mycommerce.product.dto.ProductRequest;
import com.hackers.mycommerce.product.dto.ProductResponse;
import com.hackers.mycommerce.product.model.Product;
import com.hackers.mycommerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDesc(request.getDesc());
        product.setStock(request.getStock());
        product.setCategory(request.getCategory());

        productRepository.save(product);

        return ProductResponse.from(product);
    }

    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDesc(request.getDesc());
        product.setStock(request.getStock());
        product.setCategory(request.getCategory());

        return ProductResponse.from(product);

    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        return ProductResponse.from(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductResponse::from).toList();
    }

}
