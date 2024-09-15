package com.example.Assignment_25.dto.carDto;

import com.example.Assignment_25.model.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarResponse {

    @NotNull(message = "Id can not be null")
    private Long id;

    @NotNull(message = "brandName can not be blank")
    private String brandName;

    @NotBlank(message = "modelNme can not be blank")
    private String modelName;

    @NotNull(message = "releaseYear can not be null")
    private Integer releaseYear;

    @NotNull(message = "price can not be null")
    private Double price;


    // -------------------- Constructors ----------------------------
    public CarResponse() {
    }

    public CarResponse(String brandName, Long id, String modelName, Integer releaseYear, Double price) {
        this.brandName = brandName;
        this.id = id;
        this.modelName = modelName;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    // -------------------- Setters and Getters -------------------

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
