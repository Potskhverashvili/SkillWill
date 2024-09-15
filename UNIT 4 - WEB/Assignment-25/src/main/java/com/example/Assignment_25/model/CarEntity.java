package com.example.Assignment_25.model;

import jakarta.persistence.*;

@Entity
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name")
    String brandName;

    @Column(name = "model_name")
    String modelName;

    @Column(name = "release_year")
    Integer releaseYear;

    @Column(name = "price")
    Double price;

    @ManyToOne
    @JoinColumn(name = "car_id")
    BuyEntity buyEntity;

/*
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;
*/

    // ------------------------- Constructors --------------------------------------
    public CarEntity() {
    }

    public CarEntity(String brandName, Long id, String modelName, Integer releaseYear,Double price /*UserEntity userEntity*/) {
        this.brandName = brandName;
        this.id = id;
        this.modelName = modelName;
        this.releaseYear = releaseYear;
        this.price = price;
        //this.userEntity = userEntity;
    }

    // --------------------- Setters and Getters --------------------------
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



  /*  public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }*/
}
