package com.example.Assignment_25.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BuyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    Integer amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @OneToMany(mappedBy = "buyEntity")
    private List<CarEntity> carEntities;

    // ---------------------- Constructors ----------------------------
    public BuyEntity() {
    }

    public BuyEntity(Integer amount, List<CarEntity> carEntities, Long id, UserEntity userEntity) {
        this.amount = amount;
        this.carEntities = carEntities;
        this.id = id;
        this.userEntity = userEntity;
    }

    // --------------------- Setters and Getters ----------------------
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<CarEntity> getCarEntities() {
        return carEntities;
    }

    public void setCarEntities(List<CarEntity> carEntities) {
        this.carEntities = carEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
