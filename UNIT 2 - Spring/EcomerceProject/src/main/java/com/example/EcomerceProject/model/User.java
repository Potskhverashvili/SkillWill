package com.example.EcomerceProject.model;

public class User {
    private double budget;


    public User() {
        // Default constructor
    }


    public User(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }


}
