package oop;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 상품 생성
        Product product1 = new Product("치킨", 10000, 10);
        Product product2 = new Product("만두", 20000, 5);
        Product product3 = new Product("곱창", 30000, 8);

        // 고객 생성
        Customer customer1 = new Customer("강자바", "제주도", "010-1234-567");
        Customer customer2 = new Customer("김스프링", "서울", "010-9876-543");

        // 주문 생성
        List<Product> order1Products = new ArrayList<>();
        order1Products.add(product1);
        order1Products.add(product2);
        Order order1 = new Order("00001", customer1, order1Products);

        List<Product> order2Products = new ArrayList<>();
        order2Products.add(product2);
        order2Products.add(product3);
        Order order2 = new Order("00002", customer2, order2Products);

        // 주문 클라이언트 생성
        OrderClient orderClient = new OrderClient();

        // 주문 요청
        orderClient.placeOrder(order1);
        orderClient.placeOrder(order2);

        System.out.println("==========================");

        // 할인 정책 생성
        DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
        DiscountPolicy fixDiscountPolicy = new FixDiscountPolicy();

        // 주문에 할인 적용
        orderClient.applyDiscountWithAddress(customer1, rateDiscountPolicy, "제주도");
        orderClient.applyDiscountWithAddress(customer2, fixDiscountPolicy, "제주도");

        // 주문 상품 출력
        for (Order order : orderClient.getOrders()) {
            System.out.println("주문 번호: " + order.getOrderNumber());
            System.out.println("고객 이름: " + order.getCustomer().getName());
            System.out.println("주문 상태: " + order.getStatus());
            System.out.println("상품 목록:");
            for (Product product : order.getProducts()) {
                System.out.println("- 상품명: " + product.getName() + ", 가격: " + product.getPrice() + "원");
            }
            System.out.println("--------------------------");
        }

        System.out.println();

        // 주문 처리
        for (Order order : orderClient.getOrders()) {
            orderClient.processOrder(order.getOrderNumber());
        }

        System.out.println("==========================");

        for (Order order : orderClient.getOrders()) {
            System.out.println("주문 번호: " + order.getOrderNumber());
            System.out.println("고객 이름: " + order.getCustomer().getName());
            System.out.println("주문 상태: " + order.getStatus());
            System.out.println("--------------------------");
        }
    }
}
