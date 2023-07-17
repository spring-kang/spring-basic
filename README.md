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

## Controller
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
## Service
### UserService - 사용자 생성, 수정, 검색 및 삭제와 같은 사용자 관련 작업을 처리합니다.
- joinUser(UserRequest userRequest): 사용자 회원가입을 처리하고, 사용자 정보를 저장합니다.
- login(LoginRequest request): 사용자 로그인을 처리하고, 인증 토큰을 생성하여 반환합니다.
- updateUser(long id, UserRequest userRequest): ID에 해당하는 사용자 정보를 업데이트합니다.
- getUser(long id): ID에 해당하는 사용자 정보를 조회합니다.
- removeUser(long id): ID에 해당하는 사용자 정보를 삭제합니다.
### OrderService - 주문 생성, 취소 및 검색과 같은 주문 관련 작업을 처리합니다.
- createOrder(OrderRequest request): 새로운 주문을 생성하고, 주문 정보를 저장합니다.
- cancelOrder(Long orderId): 주문을 취소합니다.
- getOrderDetails(Long orderId): 주문 세부 정보를 조회합니다.
### ProductService - 상품 생성, 수정 및 검색과 같은 상품 관련 작업을 처리합니다.
- createProduct(ProductRequest request): 새로운 상품을 생성하고, 상품 정보를 저장합니다.
- updateProduct(Long id, ProductRequest request): ID에 해당하는 상품 정보를 업데이트합니다.
- getProductById(Long id): ID에 해당하는 상품 정보를 조회합니다.
- getAllProducts(): 모든 상품 정보를 조회합니다.
## Securitry 
- 로그인 관련 Config, Filter, 토큰 Proider 기능을 제공합니다.
- SecurityConfig
- JwtAuthenticationFilter
- JwtProvider
## Policy
- 유저 나이 타입에 따른 할인 정책을 제공합니다.
- 할인정책에 대한 인터페이스와 구현체
- 할인정책에 대한 Config 파일
## 시작하기
- 저장소 복제하기: git clone https://github.com/spring-kang/spring-basic.git
- 프로젝트 디렉토리로 이동하기: cd mycommerce-app
- 프로젝트 빌드하기: ./gradlew build
- 애플리케이션 실행하기: ./gradlew bootRun
- 애플리케이션 접속하기: http://localhost:8080

## 문의사항 및 연락
- 프로젝트 관련하여 문의 사항이 있는 경우, 아래 메일을 통해 연락 부탁드립니다.
- spring7ang@gmail.com
