package com.example.Lecture16.service;

import com.example.Lecture16.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private static final List<Car> cars = new ArrayList<>();


    public Car createCar(Car car) {
        cars.add(car);
        return car;
    }

    public Car updateCar(int index, Car car) {
        if (index < cars.size() && index > -1) {
            Car oldCar = cars.get(index);
            oldCar.setBrandName(car.getBrandName());
            oldCar.setModelName(car.getModelName());
            oldCar.setReleaseYear(car.getReleaseYear());
        }
        return car;
    }

    public Car getCar(Integer carIndex){
        return cars.get(carIndex);
    }


    public List<Car> getCars(){
        return cars;
    }

    public void deleteCar(int carIndex){
        if(carIndex < cars.size() && carIndex > -1){
            cars.remove(carIndex);
        }
    }
}
