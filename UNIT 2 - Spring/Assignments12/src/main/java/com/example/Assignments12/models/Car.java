package com.example.Assignments12.models;

// Class representing a car, which is used as a bean
public class Car {
    private String model;
    private String brand;

    // ----------------- Setters for brand and model ---------------
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }


    // Overrides the toString() method for custom output
    @Override
    public String toString() {
        return "Brand: " + brand + "\nModel: " + model;
    }
}
