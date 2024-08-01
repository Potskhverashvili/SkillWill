package com.example.Lecture16;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Car Service",
				version = "1.0.0",
				description = "Assignment 16",
				contact = @Contact(
						name = "Gia Potskhverashvili",
						email = "gia.focxverashvili@gmail.com"
				)
		)
)
public class Lecture16Application {

	public static void main(String[] args) {
		SpringApplication.run(Lecture16Application.class, args);
	}

}
