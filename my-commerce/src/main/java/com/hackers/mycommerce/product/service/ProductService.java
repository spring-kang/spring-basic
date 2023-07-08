package com.hackers.mycommerce.product.service;

import com.hackers.mycommerce.product.dto.ProductRequest;
import com.hackers.mycommerce.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    ProductResponse updateProduct(Long id, ProductRequest request);
    ProductResponse getProductById(Long id);
    List<ProductResponse> getAllProducts();
}
