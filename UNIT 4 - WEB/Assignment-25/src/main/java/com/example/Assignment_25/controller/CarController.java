package com.example.Assignment_25.controller;

import com.example.Assignment_25.dto.carDto.CarRequest;
import com.example.Assignment_25.dto.carDto.CarResponse;
import com.example.Assignment_25.dto.userDto.UserRequest;
import com.example.Assignment_25.dto.userDto.UserResponse;
import com.example.Assignment_25.service.CarService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService ;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/create")
    public CarResponse create(@RequestBody @Valid CarRequest carRequest) {
        return carService.createCar(carRequest);
    }

    @GetMapping("/{carId}")
    public  CarResponse getCar(@PathVariable("carId") Long id){
        return carService.getCar(id);
    }
}
