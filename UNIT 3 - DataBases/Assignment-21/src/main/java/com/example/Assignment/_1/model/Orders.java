package com.example.Assignment._1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders {

    @Id
    private Long orderId;

    private String orderName;

    private Double orderPrice;

    private int orderQuantity;
}
