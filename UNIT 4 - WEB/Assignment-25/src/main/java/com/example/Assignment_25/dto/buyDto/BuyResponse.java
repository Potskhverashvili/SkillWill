package com.example.Assignment_25.dto.buyDto;

import jakarta.validation.constraints.NotNull;

public class BuyResponse {

    @NotNull(message = "Id can not be null")
    Long id;

    @NotNull(message = "amount can not be null")
    Integer amount;

    public @NotNull(message = "amount can not be null") Integer getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "amount can not be null") Integer amount) {
        this.amount = amount;
    }

    public @NotNull(message = "Id can not be null") Long getId() {
        return id;
    }

    public void setId(@NotNull(message = "Id can not be null") Long id) {
        this.id = id;
    }
}
