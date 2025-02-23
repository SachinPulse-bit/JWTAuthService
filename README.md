# 🛡️ JWT Authentication in Spring Boot

This project implements a **secure REST API with JWT authentication** in a **Spring Boot application**, using **Spring Security and MySQL**.

## ✨ Features
- User Registration & Login using JWT
- Secure API endpoints with role-based access
- JWT Token generation & validation
- Authentication with Spring Security
- MySQL Database Integration
- Role-based authorization (`USER`, `ADMIN`)

## 🚀 Technologies Used
- **Spring Boot** - Backend framework
- **Spring Security** - Authentication & Authorization
- **JWT (JSON Web Token)** - Token-based authentication
- **JPA (Hibernate)** - ORM for database operations
- **MySQL** - Relational Database
- **Maven** - Dependency Management

---

## 🏗️ Project Structure
```
com.pulse
 ├── controller
 │   ├── AuthController.java
 │   ├── UserController.java
 │
 ├── service 
 │   ├── AuthService.java  
 │   ├── UserService.java  
 │   ├── CustomUserDetailsService.java  
 │
 ├── security
 │   ├── JwtUtil.java
 │   ├── JwtFilter.java
 │   ├── SecurityConfig.java
 │
 ├── model
 │   ├── User.java
 │
 ├── dto  
 │   ├── AuthRequest.java
 │   ├── RegisterRequest.java
 │   ├── CustomUserDetails.java
 │
 ├── repository
 │   ├── UserRepository.java
 │
 ├── DemoProjectApplication.java
```

---

## 📌 API Endpoints

### 🔐 Authentication
| Method | Endpoint         | Description          |
|--------|-----------------|----------------------|
| `POST` | `/auth/register` | Register new user   |
| `POST` | `/auth/login`    | User login (JWT)    |
| `GET`  | `/auth/ping`     | Test API connection |

### 👤 User Management (Requires Authentication)
| Method   | Endpoint           | Role         | Description             |
|----------|-------------------|-------------|-------------------------|
| `GET`    | `/api/users/getAll` | `ADMIN`     | Fetch all users         |
| `GET`    | `/api/users/{id}`   | `USER` / `ADMIN` | Fetch user by ID |
| `PUT`    | `/api/users/{id}`   | `USER` / `ADMIN` | Update user details |
| `DELETE` | `/api/users/{id}`   | `ADMIN`     | Delete user by ID      |
| `PATCH`  | `/api/users/{id}/role` | `ADMIN` | Change user role       |

---

## ⚡ Running the Application
### 📌 **1. Configure MySQL Database**
Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jwt_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 📌 **2. Build & Run**
#### Using Maven:
```sh
mvn clean install
mvn spring-boot:run
```

#### Using Docker (Optional):
```sh
docker build -t jwt-auth-service .
docker run -p 8080:8080 jwt-auth-service
```

### 📌 **3. Test with Postman**
- Register a user using `/auth/register`
- Login using `/auth/login` to get a JWT token
- Use the token in the `Authorization` header (Bearer Token) to access secure endpoints.

---

## 🛠️ Future Enhancements
- Implement **refresh tokens** for better security
- Integrate with **MongoDB** instead of MySQL (optional)
- Add **OAuth2 authentication** (Google, GitHub)

---

## 🎯 Contribution
Feel free to fork and contribute! Submit a pull request with improvements. 😊

---

## 📜 License
This project is licensed under the **MIT License**.
```

