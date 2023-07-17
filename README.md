# MyCommerce 애플리케이션
MyCommerce는 사용자, 주문 및 상품 관리 기능을 제공하는 커머스 애플리케이션입니다.

## 사용된 기술
- Java 17
- Spring Boot 3.x.x
- Spring MVC
- Lombok
- Spring Data JPA
- Spring Security
- JUnit 5
- H2 Database

## 컨트롤러
### UserController
- /sign - 새로운 사용자를 생성하기 위한 POST 요청입니다.
- /api/users/{id} - ID에 해당하는 사용자를 수정하기 위한 PUT 요청입니다.
- /api/users/{id} - ID에 해당하는 사용자를 검색하기 위한 GET 요청입니다.
- /api/users/{id} - ID에 해당하는 사용자를 삭제하기 위한 DELETE 요청입니다.
- /login - 사용자 로그인을 위한 POST 요청입니다.
### OrderController
- /api/orders - 새로운 주문을 생성하기 위한 POST 요청입니다.
- /api/orders/{id}/cancel - ID에 해당하는 주문을 취소하기 위한 PUT 요청입니다.
- /api/orders/{id} - ID에 해당하는 주문의 세부 정보를 검색하기 위한 GET 요청입니다.
### ProductController
- /api/products - 새로운 상품을 생성하기 위한 POST 요청입니다.
- /api/products/{id} - ID에 해당하는 상품을 수정하기 위한 PUT 요청입니다.
- /api/products/{id} - ID에 해당하는 상품을 검색하기 위한 GET 요청입니다.
- /api/products - 모든 상품을 검색하기 위한 GET 요청입니다.
## 서비스
### UserService - 사용자 생성, 수정, 검색 및 삭제와 같은 사용자 관련 작업을 처리합니다.
### OrderService - 주문 생성, 취소 및 검색과 같은 주문 관련 작업을 처리합니다.
### ProductService - 상품 생성, 수정 및 검색과 같은 상품 관련 작업을 처리합니다.

## 시작하기
- 저장소 복제하기: git clone https://github.com/spring-kang/spring-basic.git
- 프로젝트 디렉토리로 이동하기: cd mycommerce-app
- 프로젝트 빌드하기: ./gradlew build
- 애플리케이션 실행하기: ./gradlew bootRun
- 애플리케이션 접속하기: http://localhost:8080

## 문의사항 및 연락
- 프로젝트 관련하여 문의 사항이 있는 경우, 아래 메일을 통해 연락 부탁드립니다.
- spring7ang@gmail.com
