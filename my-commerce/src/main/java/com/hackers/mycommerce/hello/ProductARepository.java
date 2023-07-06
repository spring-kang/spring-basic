package com.hackers.mycommerce.hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductARepository extends JpaRepository<AProduct, Long> {
    Optional<AProduct> findByName(String name);
}
