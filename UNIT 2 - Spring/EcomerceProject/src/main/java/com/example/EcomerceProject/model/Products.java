package com.example.EcomerceProject.model;

import com.example.EcomerceProject.view.ProductView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
//Model class for product
//annotation  for custom use of fields in classes
public class Products {
    @JsonView(ProductView.Summary.class)
    private  int id;
    @JsonView(ProductView.Summary.class)
    private String productName;
    @JsonView(ProductView.Summary.class)
    private double price;
    @JsonView(ProductView.Summary.class)
    private int quantity;
    @JsonView(ProductView.Detail.class)
    private double totalPrice;
// constructor
    public Products(int id, String productName, double price,  int quantity) {
        this.id = id;
        this.productName=productName;
        this.price=price;
        this.quantity=quantity;
    }

// getter and setter

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


}
