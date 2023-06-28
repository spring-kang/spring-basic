package com.hackers.mycommerce.unit;

import com.hackers.mycommerce.hello.Product;
import com.hackers.mycommerce.hello.ProductDto;
import com.hackers.mycommerce.hello.ProductRepository;
import com.hackers.mycommerce.hello.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {
    @MockBean
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @Test
    public void getProductTest() {
        Product product = new Product();
        product.setName("book");
        product.setPrice(10000.0);
        when(productRepository.findByName("book")).thenReturn(Optional.of(product));

        ProductDto productDto = productService.getProduct("book");

        Assertions.assertEquals("book", productDto.getName());

        verify(productRepository).findByName("book");
    }

    @Test
    public void saveProductTest() {
        Product product = new Product();
        product.setName("book");
        product.setPrice(10000.0);
        when(productRepository.save(product)).thenReturn(product);

        ProductDto productDto = productService.saveProduct("book", 10000.0);

        Assertions.assertEquals("book", productDto.getName());

    }
}
