package com.example.eComerceApp.repository;

import com.example.eComerceApp.model.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository {
   private  Map<Long, Product> products = new HashMap<>();

   public Map<Long, Product> getProducts() {
      return products;
   }

   public void setProducts(Map<Long, Product> products) {
      this.products = products;
   }
}
