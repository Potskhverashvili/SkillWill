package com.example.Assignment16.model;

import org.springframework.stereotype.Component;

@Component
public class Contacts {

    String name;
    String phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
