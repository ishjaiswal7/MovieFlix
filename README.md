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

## 🏗 Tech Stack

  Layer           Technology
  --------------- -----------------------
  Backend         Spring Boot
  Security        Spring Security + JWT
  Database        MySQL
  ORM             Hibernate / JPA
  Build Tool      Maven
  File Handling   Multipart File Upload
  JSON Mapping    Jackson

------------------------------------------------------------------------

## 🔑 Authentication APIs

  Method   Endpoint                Description
  -------- ----------------------- ---------------------------
  POST     /api/v1/auth/register   Register new user
  POST     /api/v1/auth/login      Login user
  POST     /api/v1/auth/refresh    Generate new access token

### Login Response

{ "accessToken": "JWT_TOKEN", "refreshToken": "REFRESH_TOKEN" }

Use access token in headers:

Authorization: Bearer `<accessToken>`{=html}

------------------------------------------------------------------------

## 🎬 Movie APIs

Base URL: /api/v1/movie

  Method   Endpoint             Role Required   Description
  -------- -------------------- --------------- -----------------------
  POST     /add-movie           ADMIN           Add movie with poster
  GET      /{movieId}           Authenticated   Get movie by ID
  GET      /all                 Authenticated   Get all movies
  PUT      /update/{movieId}    ADMIN           Update movie
  DELETE   /delete/{movieId}    ADMIN           Delete movie
  GET      /allMoviesPage       Authenticated   Pagination
  GET      /allMoviesPageSort   Authenticated   Pagination + Sorting

------------------------------------------------------------------------

## 📤 Add Movie Request (Multipart)

Content-Type: multipart/form-data

  Key        Type
  ---------- -------------
  file       Image File
  movieDto   JSON string

Example:

{ "title": "Avengers Endgame", "director": "Russo Brothers", "studio":
"Marvel Studios", "movieCast": \["RDJ", "Chris Evans"\], "releaseYear":
2019 }

------------------------------------------------------------------------

## 🖼 File APIs

  Method   Endpoint           Description
  -------- ------------------ ---------------
  POST     /file/upload       Upload poster
  GET      /file/{fileName}   View poster

------------------------------------------------------------------------

## 🔒 Security Rules

  Role    Permissions
  ------- ----------------------------
  USER    View movies
  ADMIN   Add, update, delete movies

------------------------------------------------------------------------

## ▶️ Running the Project

mvn spring-boot:run

App runs on:

http://localhost:8080

------------------------------------------------------------------------

## 👨‍💻 Author

Ish\
Full-stack developer passionate about Spring Boot & scalable backend
systems 🚀
