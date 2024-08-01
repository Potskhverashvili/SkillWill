package com.example.eComerceApp.service;

import com.example.eComerceApp.model.Product;
import com.example.eComerceApp.model.UserType;
import com.example.eComerceApp.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(UserType userType, Long id, Product product) throws Exception {
        if (userType != UserType.ADMIN){
            throw new Exception("This operation is allowed only by admin");
        }
    }

}
