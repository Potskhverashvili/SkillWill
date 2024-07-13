package com.example.Assignments16.controller;

import com.example.Assignments16.model.Car;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    private static final List<Car> cars = new ArrayList<>();

    @GetMapping("/hello{name}")
    public String sayHello(@PathVariable String name) {
        return "hello " + name;
    }

    @PostMapping("/create-car")
    public Car createCar(@RequestBody Car car){
        cars.add(car);
        return car;
    }

}
