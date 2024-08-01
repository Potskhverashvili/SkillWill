package com.example.Lecture16.controller;

import com.example.Lecture16.model.Car;
import com.example.Lecture16.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final CarService carService;

    public MainController(CarService carService) {
        this.carService = carService;
    }


    @PostMapping("/create-car")
    public Car createCar(@RequestBody Car car) {

        return carService.createCar(car);
    }

    @PutMapping("update-car/{carIndex}")
    public Car updateCar(@PathVariable("carIndex") Integer index, @RequestBody Car car) {

        return carService.updateCar(index, car);
    }

    @GetMapping("/get-car/{carIndex}")
    public Car getCar(@PathVariable("carIndex") Integer carIndex) {
        return carService.getCar(carIndex);
    }

    @GetMapping("/get-car")
    public List<Car> getCar() {
        return carService.getCars();
    }

    @DeleteMapping("/delete-car/{carIndex}")
    public void deleteCar(@PathVariable("carIndex") Integer index) {
        carService.deleteCar(index);
    }
}

