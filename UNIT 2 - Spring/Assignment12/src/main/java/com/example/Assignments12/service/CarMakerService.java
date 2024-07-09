package com.example.Assignments12.service;

import com.example.Assignments12.models.Car;
import org.springframework.stereotype.Service;

@Service
public class CarMakerService {
    // Final field ensures it can only be set once during construction
    private final Car car;

    // Constructor-based dependency injection of the Car
    public CarMakerService(Car car) {
        this.car = car;
    }

    // Assembles a Car object
    public Car assembleCar() {
        car.setBrand("BMW");
        car.setModel("M4");
        return car;
    }
}
