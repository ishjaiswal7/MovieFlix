package com.movieflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesFlixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesFlixApplication.class, args);
	}

	/*
	* netstat -ano | findstr :8080
	* taskkill /PID <PID> /F
	 */
}
