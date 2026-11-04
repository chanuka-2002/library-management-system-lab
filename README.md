# Library Management System – REST API

## Lab Sheet 02: Building a REST API with Spring Boot

## 📌 Project Overview

This project implements a RESTful API for managing books in a library system using **Spring Boot, Spring Data JPA, and Microsoft SQL Server**.

The application supports CRUD (Create, Read, Update, Delete) operations and follows a layered architecture to separate the responsibilities of controllers, services, and repositories.

It also includes request validation and interactive API documentation using **Swagger UI / SpringDoc OpenAPI**.

### Application Architecture

```text
       Client (Postman / Swagger UI)
                    |
                    v
          +-------------------+
          |  BookController  |
          |  REST Endpoints  |
          +-------------------+
                    |
                    v
          +-------------------+
          |    BookService    |
          |  Business Logic   |
          +-------------------+
                    |
                    v
          +-------------------+
          |  BookRepository   |
          |  Data Access      |
          +-------------------+
                    |
                    v
          +-------------------+
          | Microsoft SQL     |
          | Server Database   |
          |    library_db     |
          +-------------------+
```

---

## 🛠️ Tech Stack & Dependencies

- **Language:** Java 21
- **Framework:** Spring Boot
- **Build Tool:** Maven
- **Data Persistence:** Spring Data JPA
- **ORM:** Hibernate
- **Database:** Microsoft SQL Server
- **Database Management:** SQL Server Management Studio (SSMS)
- **Validation:** Jakarta Bean Validation
- **API Documentation:** SpringDoc OpenAPI / Swagger UI
- **API Testing:** Postman

---

## 📂 Project Structure

```text
library-management-api/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── lk/uom/fit/library_management_api/
│       │       ├── controller/
│       │       │   └── BookController.java
│       │       ├── model/
│       │       │   └── Book.java
│       │       ├── repository/
│       │       │   └── BookRepository.java
│       │       ├── service/
│       │       │   └── BookService.java
│       │       └── LibraryManagementApiApplication.java
│       │
│       └── resources/
│           └── application.properties
│
├── mvnw
├── mvnw.cmd
└── pom.xml
```

---

## ⚙️ Configuration & Setup

### 1. Database Setup

Create a database named `library_db` in Microsoft SQL Server.

You can use SQL Server Management Studio (SSMS) to create and manage the database.

### 2. Application Properties

Configure your SQL Server connection in:

`src/main/resources/application.properties`

Example configuration:

```properties
spring.application.name=library-management-api

server.port=8080

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=library_db;encrypt=true;trustServerCertificate=true
spring.datasource.username=library_app
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
```

**Note:** Replace `YOUR_PASSWORD` with your own SQL Server login password. Do not commit actual database credentials to GitHub.

---

## 🚀 Running the Application

Make sure SQL Server is running before starting the application.

Navigate to the `library-management-api` directory and execute:

**Windows (PowerShell):**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux / macOS:**

```bash
./mvnw spring-boot:run
```

Or use Maven directly:

```bash
mvn spring-boot:run
```

The application starts on:

`http://localhost:8080`

---

## 📖 API Documentation – Swagger UI

Interactive API documentation is available through Swagger UI when the application is running.

- **Swagger UI:** http://localhost:8080/swagger-ui/index.html
- **OpenAPI JSON:** http://localhost:8080/v3/api-docs

Swagger UI allows users to explore the available endpoints, view request and response formats, and execute API requests.

---

## 📡 REST API Endpoints

| Method | Endpoint | Description | Success Status |
|---|---|---|---|
| `GET` | `/api/books` | Retrieve all books | `200 OK` |
| `GET` | `/api/books/{id}` | Retrieve a book by ID | `200 OK` |
| `POST` | `/api/books` | Create a new book | `201 Created` |
| `PUT` | `/api/books/{id}` | Update an existing book | `200 OK` |
| `DELETE` | `/api/books/{id}` | Delete a book by ID | `204 No Content` |

### Example Request Body

Used for creating and updating books:

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "price": 4500.00
}
```

---

## 🧪 API Testing with Postman

The REST API endpoints can be tested using Postman.

The following operations are covered:

1. Create a book – `POST`
2. Retrieve all books – `GET`
3. Retrieve a specific book – `GET`
4. Update a book – `PUT`
5. Delete a book – `DELETE`
6. Verify a deleted book – `GET`
7. Test request validation – `POST`

The API uses HTTP status codes to indicate the result of each operation.

---

## 🌿 Git Branching

The project uses Git for version control and source code management.

- **main:** Stable branch containing the completed lab implementation.
- **dev:** Development branch for integrating changes.
- **fix:** Branch for bug fixes and corrections.

---

*Developed as a practical exercise in building RESTful APIs with Spring Boot.*
