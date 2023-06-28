package com.hackers.mycommerce.hello;

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
public class HelloProductService {

    private final HelloProductRepository helloProductRepository;
    private final PlatformTransactionManager transactionManager;

    public void updateProductPriceV1(Long productId, double newPrice) {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        try {
            Optional<HelloProduct> product = helloProductRepository.findById(productId);
            product.get().setPrice(newPrice);
            helloProductRepository.save(product.get());

            transactionManager.commit(transactionStatus);
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            throw e;
        }
    }

    @Transactional
    public void updateProductPriceV2(Long productId, double newPrice) {
        Optional<HelloProduct> product = helloProductRepository.findById(productId);
        product.get().setPrice(newPrice);
        helloProductRepository.save(product.get());
    }
}
