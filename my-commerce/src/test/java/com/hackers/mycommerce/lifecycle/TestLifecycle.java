package com.hackers.mycommerce.lifecycle;

import org.junit.jupiter.api.*;

public class TestLifecycle {
    @BeforeAll
    static void beforeAll() {
        System.out.println("===== beforeAll method call =====");
        System.out.println();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("===== afterAll method call =====");
        System.out.println();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("===== beforeEach method call =====");
        System.out.println();
    }

    @AfterEach
    void afterEach() {
        System.out.println("===== afterEach method call =====");
        System.out.println();
    }

    @Test
    void test() {
        System.out.println("===== test method call =====");
        System.out.println();
    }

    @Test
    void test2() {
        System.out.println("===== test2 method call =====");
        System.out.println();
    }

    @Test
    void test3() {
        System.out.println("===== test3 method call =====");
        System.out.println();
    }
}
