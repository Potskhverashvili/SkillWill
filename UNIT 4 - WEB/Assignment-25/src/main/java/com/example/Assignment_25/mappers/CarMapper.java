package com.example.Assignment_25.mappers;

import com.example.Assignment_25.dto.carDto.CarRequest;
import com.example.Assignment_25.dto.carDto.CarResponse;
import com.example.Assignment_25.model.CarEntity;

public class CarMapper {

    public static CarEntity mapRequestToEntity(CarRequest carRequest) {
        CarEntity carEntity = new CarEntity();
        carEntity.setBrandName(carRequest.getBrandName());
        carEntity.setModelName(carRequest.getModelName());
        carEntity.setReleaseYear(carRequest.getReleaseYear());
        carEntity.setPrice(carRequest.getPrice());
        return carEntity;
    }

    public static CarResponse mapEntityToResponse(CarEntity carEntity) {
        CarResponse carResponse = new CarResponse();
        carResponse.setId(carEntity.getId());
        carResponse.setBrandName(carEntity.getBrandName());
        carResponse.setModelName(carEntity.getModelName());
        carResponse.setReleaseYear(carEntity.getReleaseYear());
        carResponse.setPrice(carEntity.getPrice());
        return carResponse;
    }
}
