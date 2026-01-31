# 🎬 MovieFlix --- Spring Boot Movie Management API

A secure movie management REST API built using Spring Boot, Spring
Security (JWT), JPA/Hibernate, and MySQL.\
The system supports authentication, role-based authorization, movie CRUD
operations, pagination, sorting, and poster image uploads.

------------------------------------------------------------------------

## 🚀 Features

### 🔐 Authentication & Security

-   JWT-based authentication
-   Access token + Refresh token mechanism
-   Role-based authorization (USER, ADMIN)
-   Stateless session management
-   Password encryption using BCrypt

### 🎥 Movie Management

-   Add, update, delete movies
-   Upload and serve movie poster images
-   Get movie by ID
-   Get all movies
-   Pagination support
-   Sorting support

### 🖼 File Handling

-   Poster image upload
-   Static file serving endpoint

------------------------------------------------------------------------

## 🚀 Tech Stack

|  Layer        |  Technology|
|  -------------- |-----------------------------|
|  Backend     |   Spring Boot|
|  Security      | Spring Security + JWT|
|  Database      | MySQL |
|  ORM           | Spring Data JPA (Hibernate) |
|  Build Tool    | Maven |
|  File Storage  | Local File System |
|  API Format    | REST (JSON + Multipart) |
<br>


## 🔐 Authentication Flow

1.  User registers → account created
2.  User logs in → receives:
    -   Access Token (JWT)
    -   Refresh Token
3.  When access token expires → use refresh token to get new one
<br>


## 🧾Controllers & Endpoints

| Method | Endpoint | Description | Layer | Technology |
|--------|----------|-------------|-------|------------|
| POST | /api/v1/auth/register | Register a new user | Controller | Spring Boot REST |
| POST | /api/v1/auth/login | User login | Controller | Spring Boot REST, JWT |
| POST | /api/v1/auth/refresh | Refresh JWT token | Controller | Spring Boot REST, JWT |
| POST | /api/v1/movie/add-movie | Add new movie (Admin only) | Controller | Spring Boot REST, MultipartFile |
| GET | /api/v1/movie/{movieId} | Get movie by ID | Controller | Spring Boot REST |
| GET | /api/v1/movie/all | Get all movies | Controller | Spring Boot REST |
| PUT | /api/v1/movie/update/{movieId} | Update movie details | Controller | Spring Boot REST, MultipartFile |
| DELETE | /api/v1/movie/delete/{movieId} | Delete a movie | Controller | Spring Boot REST |
| GET | /api/v1/movie/allMoviesPage | Get movies with pagination | Controller | Spring Boot REST, Pageable |
| GET | /api/v1/movie/allMoviesPageSort | Get movies with pagination & sorting | Controller | Spring Boot REST, Pageable, Sort |
| POST | /file/upload | Upload a movie poster | Controller | Spring Boot REST, MultipartFile |
| GET | /file/{fileName} | Serve movie poster | Controller | Spring Boot REST |

<br>

## Exception Handling
- `EmptyFileException` – thrown when an uploaded file is empty.
- Runtime exceptions for invalid or expired refresh tokens.

## Usage
1. Clone the repository.
2. Configure database settings in `application.properties`.
3. Run the application using `mvn spring-boot:run`.
4. Use Postman or similar tools to test the REST endpoints.

<br>

## 🛡 Security Notes

-   Access token is short-lived
-   Refresh token stored in DB
-   Only ADMIN can add/update/delete movies
-   File uploads validated for empty files


<br>

## 📌 Future Improvements

-   Cloud file storage (AWS S3)
-   Redis for token blacklist
-   Swagger API docs
-   Docker deployment
