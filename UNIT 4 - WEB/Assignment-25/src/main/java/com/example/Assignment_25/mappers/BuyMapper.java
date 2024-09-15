package com.example.Assignment_25.mappers;

import com.example.Assignment_25.dto.buyDto.BuyRequest;
import com.example.Assignment_25.dto.buyDto.BuyResponse;
import com.example.Assignment_25.dto.carDto.CarRequest;
import com.example.Assignment_25.dto.carDto.CarResponse;
import com.example.Assignment_25.model.BuyEntity;
import com.example.Assignment_25.model.CarEntity;

public class BuyMapper {


    public static BuyEntity mapRequestToEntity(BuyRequest buyRequest) {
        BuyEntity buyEntity = new BuyEntity();
        buyEntity.setAmount(buyEntity.getAmount());
        return buyEntity;
    }

    public static BuyResponse mapEntityToResponse(BuyEntity buyEntity) {
        BuyResponse buyResponse = new BuyResponse();

        buyResponse.setAmount(buyResponse.getAmount());
        buyResponse.setId(buyEntity.getId());

        return buyResponse;
    }
}
