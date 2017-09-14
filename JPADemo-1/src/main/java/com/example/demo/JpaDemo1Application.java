package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// scanBasePackages= {"com.example.demo", "com.example.controlador", "com.example.servicio", "com.example.dao", "com.example.modelo"}
@SpringBootApplication
@ComponentScan("com.example.*")
public class JpaDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemo1Application.class, args);
	}
}