package com.example.Assignment_25.dto.carDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarRequest {

    @NotNull(message = "brandName can not be blank")
    private String brandName;

    @NotBlank(message = "modelNme can not be blank")
    private String modelName;

    @NotNull(message = "releaseYear can not be null")
    private Integer releaseYear;

    @NotNull(message = "price can not be null")
    private Double price;

    // -------------------------- Constructors -------------------------------
    public CarRequest() {
    }

    public CarRequest(String brandName, String modelName, Integer releaseYear, Double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    // ------------------------- Setters and Getters -----------------------


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
