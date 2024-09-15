package com.example.Assignment_25.service;

import com.example.Assignment_25.dto.buyDto.BuyRequest;
import com.example.Assignment_25.dto.buyDto.BuyResponse;
import com.example.Assignment_25.dto.carDto.CarRequest;
import com.example.Assignment_25.dto.carDto.CarResponse;
import com.example.Assignment_25.mappers.BuyMapper;
import com.example.Assignment_25.mappers.CarMapper;
import com.example.Assignment_25.model.BuyEntity;
import com.example.Assignment_25.model.CarEntity;
import com.example.Assignment_25.repository.BuyRepository;
import com.example.Assignment_25.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuyService {

    private final BuyRepository buyRepository;
    private final CarService carService;
    private final UserService userService;

    public BuyService(BuyRepository buyRepository, CarService carService, UserService userService) {
        this.buyRepository = buyRepository;
        this.carService = carService;
        this.userService = userService;
    }

    public BuyResponse buy (Long userId, Long carId, BuyRequest buyRequest){
        BuyEntity buyEntity = BuyMapper.mapRequestToEntity(buyRequest);
        buyEntity.setUserEntity(userService.findById(userId));

        // Assuming carService.findById returns a CarEntity
        CarEntity carEntity = carService.findById(carId);
        buyEntity.setCarEntities(List.of(carEntity)); // Assuming a one-to-many relationship

        buyRepository.save(buyEntity);

        return BuyMapper.mapEntityToResponse(buyEntity);
    }


    public List<BuyResponse> findAllBuy() {
        return buyRepository.findAll().stream()
                .map(BuyMapper::mapEntityToResponse)
                .collect(Collectors.toList());
    }
}
