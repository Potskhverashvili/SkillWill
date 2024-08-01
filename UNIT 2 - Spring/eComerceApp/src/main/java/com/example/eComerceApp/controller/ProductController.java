package com.example.eComerceApp.controller;

import com.example.eComerceApp.model.Product;
import com.example.eComerceApp.model.UserType;
import com.example.eComerceApp.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestParam UserType userType, @RequestParam Long id, @RequestBody Product product) throws Exception {
        productService.addProduct(userType,id,product);
        return product;
    }


}
