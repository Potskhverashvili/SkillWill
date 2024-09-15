package com.example.Assignment_25.service;

import com.example.Assignment_25.dto.carDto.CarRequest;
import com.example.Assignment_25.dto.carDto.CarResponse;
import com.example.Assignment_25.dto.userDto.UserRequest;
import com.example.Assignment_25.dto.userDto.UserResponse;
import com.example.Assignment_25.mappers.CarMapper;
import com.example.Assignment_25.mappers.UserMapper;
import com.example.Assignment_25.model.CarEntity;
import com.example.Assignment_25.model.UserEntity;
import com.example.Assignment_25.repository.CarRepository;
import com.example.Assignment_25.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    // ----------------- Create Car -----------------
    public CarResponse createCar(CarRequest carRequest) {
        CarEntity carEntity = CarMapper.mapRequestToEntity(carRequest);
        carEntity.setBrandName(carRequest.getBrandName());
        carEntity.setModelName(carRequest.getModelName());
        carEntity.setReleaseYear(carRequest.getReleaseYear());
        carEntity.setPrice(carEntity.getPrice());
        CarEntity save = carRepository.save(carEntity);

        return CarMapper.mapEntityToResponse(save);
    }

    // ------------------ Find Car -------------------------
    public CarEntity findById(Long id) {
        Optional<CarEntity> byId = carRepository.findById(id);
        return byId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
    }

    public CarResponse getCar(Long id) {
        return CarMapper.mapEntityToResponse(findById(id));
    }
}
