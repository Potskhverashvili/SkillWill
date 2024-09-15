package com.example.Assignment_25.dto.buyDto;

import jakarta.validation.constraints.NotNull;

public class BuyRequest {

    @NotNull(message = "amount can not be null")
    Integer amount;

    public @NotNull(message = "amount can not be null") Integer getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "amount can not be null") Integer amount) {
        this.amount = amount;
    }
}
