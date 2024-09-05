package com.example.Assignment._1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Products {

    @Id
    private Long productId;

    private String productName;

    private int productQuantity;
}
