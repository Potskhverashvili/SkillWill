package com.example.Assignment._3.model;

public class PersonShortModel {

    private String name;
    private String lastName;

    public PersonShortModel(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
    }

    // ------------------- Setters and Getters --------------------
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonShortModel{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
