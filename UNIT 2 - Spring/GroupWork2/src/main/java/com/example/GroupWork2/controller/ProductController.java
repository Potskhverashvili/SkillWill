package com.example.GroupWork2.controller;

import com.example.GroupWork2.model.Product;
import com.example.GroupWork2.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Requests to create a product
    @PostMapping("/add-product")
    public Product addProduct(@RequestParam String userType, @RequestBody Product product) throws Exception {
        return productService.addProduct(userType, product);
    }

    // Request to update product
    @PutMapping("/update-product")
    public Product updateProduct(@RequestParam String userType, @RequestParam("productName") String productName, @RequestBody Product product) {
        return productService.updateProduct(userType, productName, product);
    }

    // Request get all product
    @GetMapping("/get-all-product")
    public Map<String, Product> getAllProduct(@RequestParam String userType) {
        return productService.getAllProduct(userType);
    }

    // Request to delete product
    @DeleteMapping("/delete-product")
    public void deleteProduct(@RequestParam String userType, @RequestParam String productName) {
        productService.deleteProduct(userType, productName);
    }
}
