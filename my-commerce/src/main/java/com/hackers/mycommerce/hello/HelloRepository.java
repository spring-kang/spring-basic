package com.hackers.mycommerce.hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HelloRepository extends JpaRepository<HelloStudent, Long> {
    Optional<HelloStudent> findByName(String name);
}
