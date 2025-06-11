# 📝 MFPSB – My First Project Spring Boot

A RESTful API built with **Spring Boot** that allows managing phrases, authors, and categories. The project follows a clean, modular architecture in Java, using layered design with controllers, services, repositories, DTOs, and entities.

---

## 📑 Table of Contents

- [Features](#-features)
- [Architecture](#-architecture)
- [Technologies Used](#-technologies-used)
- [How to Run](#-how-to-run)
- [Available Endpoints](#-available-endpoints)
- [Project Structure](#-project-structure)
- [Error Handling](#-error-handling)
- [Future Enhancements](#-future-enhancements)
- [Acknowledgments](#-acknowledgments)
- [Team](#-team)

---

## 🎯 Features

- Motivational phrase management
- CRUD operations for authors, phrases, and categories
- Custom exception handling
- DTO-level input validation
- Layered architecture using Spring Boot
- Structured and controlled API responses
- Ready to be connected to frontend or Postman tests

---

## 🏗️ Architecture

The project follows a layered architecture:

```bash
MFPSB/
├── controller/    # REST Controllers
├── service/       # Business Logic
├── repository/    # JPA Data Access
├── dto/           # Data Transfer Objects
├── entity/        # JPA Entities
├── exceptions/    # Custom Exceptions & Global Handler
```

---

## 🛠️ Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Lombok
- MySQL (based on config)

---

## 🚀 How to Run

### Requirements

- JDK 21
- Maven installed
- IDE (IntelliJ, VSCode, Eclipse)

### Steps

1. Clone or unzip the project
2. Configure `application.properties` inside `src/main/resources` (if needed)
3. Run from IDE or terminal:

```bash
mvn spring-boot:run
```

4. API will be available at:

```
http://localhost:8080
```

---

## 📬 Available Endpoints

> Note: Endpoints are grouped by resource type.

### 🔤 Phrases (`/phrases`)

- `GET /phrases` – Get all phrases
- `GET /phrases/{id}` – Get a phrase by ID
- `POST /phrases` – Create new phrase
- `PUT /phrases/{id}` – Update phrase
- `DELETE /phrases/{id}` – Delete phrase

### 👤 Authors (`/authors`)

- `GET /authors` – List authors
- `POST /authors` – Create author

### 🏷️ Categories (`/categories`)

- `GET /categories` – List categories
- `POST /categories` – Create category

---

## 📁 Project Structure

```bash
src/
├── main/
│   ├── java/com/MyFirstProjectSpringBoot/MFPSB/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── exceptions/
│   │   └── MfpsbApplication.java
│   └── resources/
│       └── application.properties
```

---

## 🚨 Error Handling

Includes centralized error management via `GlobalExceptionHandler` and custom exceptions like:

- `EmptyListException`
- `AuthorIsExistingException`
- `CategoryIsExistingException`
- `PhraseAlreadyExistException`
- `NoIdPhraseFoundException`

---

## 📈 Future Enhancements

- [ ] Swagger/OpenAPI documentation
- [ ] Authentication & Authorization (JWT)
- [ ] Connect to external DB (MySQL/PostgreSQL)
- [ ] Pagination in list endpoints
- [ ] Unit & integration testing

---

## 🙏 Acknowledgments

- Spring Boot Team
- Factoria F5
- Open Source Community

---

Thanks for using MFPSB! 🚀