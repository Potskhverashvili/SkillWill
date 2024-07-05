package com.example.Assignments12.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PrinterService {
    // Reference to the CarMakerService
    CarMakerService carMakerService;

    // Constructor-based dependency injection of the CarMakerService
    public PrinterService(CarMakerService carMakerService) {
        this.carMakerService = carMakerService;
    }

    // Method annotated with @PostConstruct to run after object creation
    @PostConstruct
    public void printService() {
        System.out.println(carMakerService.assembleCar());
    }
}
