package com.hackers.mycommerce.hello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloProductRepository extends JpaRepository<HelloProduct, Long> {
}
