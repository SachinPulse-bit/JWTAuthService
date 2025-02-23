# JWT Authentication Service

## 📌 Overview
This is a **Spring Boot JWT Authentication Service** that provides secure authentication and authorization using **Spring Security, JWT, and MySQL**. It supports user registration, login, and role-based access control.

## ✨ Features
- **User Registration & Login**
- **JWT Token Generation & Validation**
- **Role-Based Access Control (Admin, User)**
- **Secure API Endpoints with JWT**
- **Spring Security Integration**
- **MySQL Database for User Storage**

## 🛠️ Tech Stack
- **Backend:** Spring Boot, Spring Security, JWT
- **Database:** MySQL (via Spring Data JPA)
- **Authentication:** JWT (JSON Web Token)
- **Tooling:** Maven, Postman

## ⚙️ Project Structure
```
com.jwtauthservice
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

## 🚀 Installation & Setup

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/SachinPulse-bit/JWTAuthService.git
cd JWTAuthService
```

### 2️⃣ Configure MySQL Database
Update `application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jwt_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Build and Run the Project
```sh
mvn clean install
mvn spring-boot:run
```

## 🔥 API Endpoints
### 🟢 Authentication APIs
| Method | Endpoint       | Description           |
|--------|--------------|----------------------|
| POST   | `/auth/register` | Register a new user |
| POST   | `/auth/login`    | Authenticate user & get JWT |

### 🔐 Protected APIs
| Method | Endpoint        | Access |
|--------|---------------|--------|
| GET    | `/api/users/getAll` | ADMIN |
| GET    | `/api/users/{id}` | ADMIN/User (Self) |
| PUT    | `/api/users/{id}` | ADMIN/User (Self) |
| DELETE | `/api/users/{id}` | ADMIN |
| PATCH  | `/api/users/{id}/role` | ADMIN |

## 🧪 Testing with Postman
1. **Register User**
   ```json
   POST /auth/register
   {
       "username": "testuser",
       "password": "password123",
       "role": "USER"
   }
   ```
2. **Login & Get JWT Token**
   ```json
   POST /auth/login
   {
       "username": "testuser",
       "password": "password123"
   }
   ```
   Response:
   ```json
   {
       "token": "eyJhbGciOiJIUzI1NiIsIn..."
   }
   ```
3. **Use JWT for Secured Endpoints**
   - Add `Authorization: Bearer <JWT_TOKEN>` in **Headers**.

## 🎯 Contributing
Contributions are welcome! Feel free to fork the repo, create a feature branch, and submit a PR.

## 📜 License
This project is licensed under the MIT License.

