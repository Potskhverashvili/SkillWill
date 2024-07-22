package com.example.GroupWork2.model;

import org.springframework.stereotype.Component;

@Component
public class User {
    String name;
    double budget = 1000; // Default balance

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
