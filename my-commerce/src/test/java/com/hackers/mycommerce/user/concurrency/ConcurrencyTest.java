package com.hackers.mycommerce.user.concurrency;

import com.hackers.mycommerce.order.dto.OrderRequest;
import com.hackers.mycommerce.order.service.OrderService;
import com.hackers.mycommerce.product.model.Product;
import com.hackers.mycommerce.product.repository.ProductRepository;
import com.hackers.mycommerce.user.model.User;
import com.hackers.mycommerce.user.model.UserRole;
import com.hackers.mycommerce.user.repository.UserRepository;
import com.hackers.mycommerce.user.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@SpringBootTest

public class ConcurrencyTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderService orderService;

    @BeforeEach
    public void setUp() {
        User user = new User();
        user.setId(1L);
        user.setEmail("abcd@gmail.com");
        user.setPhoneNumber("0101234567");

        Product product = new Product();
        product.setId(1L);
        product.setName("product");
        product.setDesc("product desc");
        product.setCategory("food");
        product.setPrice(15000);
        product.setStock(50);

        userRepository.save(user);
        productRepository.save(product);
    }

    @AfterEach
    public void clear() {
        productRepository.deleteAll();
    }

    @Test
    @Transactional
    public void testStockDecrease() {
        OrderRequest orderRequest = OrderRequest.builder()
                .userId(1L)
                .productId(1L)
                .count(1)
                .build();

        Long order = orderService.createOrder(orderRequest);

        Optional<Product> product = productRepository.findById(1L);

        Assertions.assertEquals(49, product.get().getStock());

    }

    @Test
    public void test50StockDecrease() throws InterruptedException {
        int threadCount = 50;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CyclicBarrier barrier = new CyclicBarrier(threadCount);
        List<Future<Long>> futures = new ArrayList<>();

        System.out.println("Starting concurrent tasks...");

        for (int i = 0; i < threadCount; i++) {
            futures.add(executorService.submit(() -> {
                try {
                    barrier.await(); // Wait for all threads to reach the barrier
                    OrderRequest orderRequest = OrderRequest.builder()
                            .userId(1L)
                            .productId(1L)
                            .count(1)
                            .build();

                    Long order = orderService.createOrder(orderRequest);
                    System.out.println(order);
                    return order;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }));
        }

        // Wait for all tasks to complete
        for (Future<Long> future : futures) {
            try {
                future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Get the final stock value
        Optional<Product> product = productRepository.findById(1L);
        long finalStock = product.get().getStock();

        System.out.println("Final stock: " + finalStock);
        Assertions.assertEquals(0, finalStock);
    }

}
