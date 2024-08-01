package com.example.Assignment17;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Contacts Book",
                version = "1.0.0",
                description = "Assignment17",
                contact = @Contact(
                        name = "Gia Potskhverashvili",
                        email = "gia.focxverashvili@gmail.com"
                )
        )
)
public class Assignment17Application {
    public static void main(String[] args) {
        SpringApplication.run(Assignment17Application.class, args);
    }
}
