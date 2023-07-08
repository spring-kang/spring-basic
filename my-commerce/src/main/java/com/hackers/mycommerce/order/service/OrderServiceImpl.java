package com.hackers.mycommerce.order.service;


import com.hackers.mycommerce.order.dto.OrderRequest;
import com.hackers.mycommerce.order.dto.OrderResponse;
import com.hackers.mycommerce.order.model.Order;
import com.hackers.mycommerce.order.model.OrderItem;
import com.hackers.mycommerce.order.repository.OrderRepository;
import com.hackers.mycommerce.policy.DiscountPolicy;
import com.hackers.mycommerce.product.model.Product;
import com.hackers.mycommerce.product.repository.ProductRepository;
import com.hackers.mycommerce.user.model.User;
import com.hackers.mycommerce.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final DiscountPolicy discountPolicy;
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Long createOrder(OrderRequest request) {
        Optional<User> user = userRepository.findById(request.getUserId());
        if(!user.isPresent()) {
            throw new RuntimeException();
        }

        Optional<Product> product = productRepository.findById(request.getProductId());
        if(!product.isPresent()) {
            throw new RuntimeException();
        }

        long discountPrice = product.get().getPrice()- discountPolicy.discount(user.get() ,product.get().getPrice());

        OrderItem orderItem = OrderItem.createOrderItem(product.get(), discountPrice, request.getCount());
        Order order = Order.from(user.get(), orderItem);

        orderRepository.save(order);
        return order.getId();

    }

    @Override
    @Transactional
    public Long cancelOrder(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(!order.isPresent()) {
            throw new RuntimeException();
        }

        order.get().cancel();

        return orderId;
    }

    @Override
    public OrderResponse getOrderDetails(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        return OrderResponse.from(order);
    }
}