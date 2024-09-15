package com.example.Assignment_25.repository;

import com.example.Assignment_25.model.BuyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends JpaRepository<BuyEntity, Long> {
}
