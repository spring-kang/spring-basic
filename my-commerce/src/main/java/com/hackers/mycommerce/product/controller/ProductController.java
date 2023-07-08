package com.hackers.mycommerce.product.controller;

import com.hackers.mycommerce.product.dto.ProductRequest;
import com.hackers.mycommerce.product.dto.ProductResponse;
import com.hackers.mycommerce.product.service.ProductService;
import com.hackers.mycommerce.product.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/api/products")
    public ResponseEntity<ProductResponse> postProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok().body(productService.createProduct(productRequest));
    }

    @PutMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> putProduct(@PathVariable("id") long id, @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok().body(productService.updateProduct(id, productRequest));
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }
}
