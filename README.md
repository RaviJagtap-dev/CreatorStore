# 🛒 CreatorStore Backend

A secure E-commerce Backend API built using Java, Spring Boot, Spring Security, Hibernate, JPA, and PostgreSQL.

The application provides REST APIs for user authentication, product management, order processing, and inventory management while following clean layered architecture principles.

## 🚀 Features

### 🔐 Authentication & Security

* User Registration
* User Login
* Spring Security Integration
* BCrypt Password Encryption

### 📦 Product Management

* Create Product
* Get All Products
* Get Product By ID
* Update Product
* Delete Product

### 🛍️ Order Management

* Create Orders
* View Orders
* Order Processing

### 📊 Inventory Management

* Stock Quantity Tracking
* Product Availability Handling

### ⚙️ Additional Features

* Input Validation
* Exception Handling
* RESTful APIs
* Swagger Documentation
* Layered Architecture
* JPA & Hibernate ORM

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Lombok
* Swagger/OpenAPI

## 📂 Project Structure

```text
src
└── main
    └── java
        └── com.example.creatorstore
            ├── config
            │   ├── SecurityBeans.java
            │   └── SecurityConfig.java
            ├── controllers
            │   ├── AuthController.java
            │   ├── ProductController.java
            │   └── OrderController.java
            ├── dto
            │   ├── RegisterRequest.java
            │   ├── LoginRequest.java
            │   ├── AuthResponse.java
            │   ├── OrderRequest.java
            │   └── OrderItemRequest.java
            ├── entities
            │   ├── User.java
            │   ├── Product.java
            │   ├── Order.java
            │   └── OrderItem.java
            ├── repositories
            │   ├── UserRepository.java
            │   ├── ProductRepository.java
            │   ├── OrderRepository.java
            │   └── OrderItemsRepository.java
            └── services
                ├── AuthService.java
                ├── ProductService.java
                └── OrderService.java
```

## 📖 API Documentation

Access Swagger UI after running the application:

```text
http://localhost:8080/swagger-ui.html
```

## 🔮 Future Enhancements

* JWT Authentication
* Role-Based Authorization (ADMIN/USER)
* React Frontend
* Docker Support
* Cloud Deployment (Render/AWS)
* Payment Gateway Integration

## 👨‍💻 Author

Ravi Jagtap

Java Backend Developer | Spring Boot Enthusiast
