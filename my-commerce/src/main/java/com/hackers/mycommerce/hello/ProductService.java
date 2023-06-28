package com.hackers.mycommerce.hello;

import com.hackers.mycommerce.hello.config.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final PlatformTransactionManager transactionManager;

    public ProductDto getProduct(String name) {
        Optional<Product> product = productRepository.findByName(name);
        return ProductDto.from(product.get());
    }

    public void updateProductPrice1(Long productId, double newPrice) {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        try {
            Optional<Product> product = productRepository.findById(productId);
            product.get().setPrice(newPrice);
            productRepository.save(product.get());

            transactionManager.commit(transactionStatus);
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            throw e;
        }
    }

    @Transactional
    public void updateProductPrice2(Long productId, double newPrice) {
        Optional<Product> product = productRepository.findById(productId);
        product.get().setPrice(newPrice);
        productRepository.save(product.get());
    }

    public ProductDto saveProduct(String name, double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productRepository.save(product);

        return ProductDto.from(product);
    }
}
