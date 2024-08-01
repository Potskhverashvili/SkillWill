package com.example.eComerceApp.repository;

import com.example.eComerceApp.model.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartRepository {
    Map<Long, Product> cartProducts = new HashMap<>();
}
