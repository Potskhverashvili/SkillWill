package com.example.Assignments12.config;

import com.example.Assignments12.models.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Indicates this class defines bean configurations
@Configuration
public class AppConfig {
    // Creates a Car bean managed by Spring
    @Bean
    public Car createCar() {
        return new Car();
    }
}
