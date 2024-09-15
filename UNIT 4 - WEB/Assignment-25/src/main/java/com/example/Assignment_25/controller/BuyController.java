package com.example.Assignment_25.controller;

import com.example.Assignment_25.dto.buyDto.BuyRequest;
import com.example.Assignment_25.dto.buyDto.BuyResponse;
import com.example.Assignment_25.service.BuyService;
import jakarta.validation.Valid;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @PostMapping("/make-purchase")
    public BuyResponse createBuy(@RequestBody @Valid BuyRequest buyRequest, Long userId, Long carId) {
        return buyService.buy(userId, carId, buyRequest);
    }

    @GetMapping("/find-purchase")
    public List<BuyResponse> findAllBuy() {
        return buyService.findAllBuy();
    }
}
