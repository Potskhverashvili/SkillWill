package com.example.EcomerceProject.controler;

import com.example.EcomerceProject.model.Products;
import com.example.EcomerceProject.service.ChartService;
import com.example.EcomerceProject.service.ProductService;
import com.example.EcomerceProject.view.ProductView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {
//injecting classes for dependency
private final ProductService productService;
private final ChartService chartService;
public ProductController(ProductService productService, ChartService chartService){

    this.productService = productService;
    this.chartService=chartService;
}

//requests for admin
    @PostMapping("/add/{userRole}")
    @JsonView(ProductView.Summary.class)
    public Products addProducts(@PathVariable("userRole") String userRole, @RequestBody Products products) {
        if ("admin".equalsIgnoreCase(userRole)) {
            return productService.addProducts(products.getId(), products);
        } else {
            throw new IllegalArgumentException("Only admin users can add products.");
        }
    }
    @PutMapping("/updateProduct/{userRole}/{id}")
    @JsonView(ProductView.Summary.class)
    public Products updateProduct(@PathVariable("userRole") String userRole, @PathVariable("id") Integer id, @RequestBody Products productToUpdate) throws IllegalAccessException {
        if ("admin".equalsIgnoreCase(userRole) && id != null) {
            return productService.updateProduct(id, productToUpdate);
        } else {
            throw new IllegalAccessException("Access denied");
        }
    }

    @GetMapping("/updated-stock/")

    public Map<Integer, Products> getAllProductsWithUpdatedStock() {
        // Retrieve the updated stock with the adjusted quantities
        return chartService.getLeftStock();
    }
   





    @GetMapping("/getProducts/")
    @JsonView(ProductView.Summary.class)
    public Map<Integer,Products> getProductsList(){
    return productService.getProductsInStock();

    }

    @GetMapping("/getProduct/{id}")
    @JsonView(ProductView.Summary.class)
    public Products getProductById(@PathVariable("id") Integer id) {
        Products product = productService.getProductById(id);
        if (product != null) {
            return product;
        } else {
            throw new NoSuchElementException("Product not found with ID: " + id);
        }
    }



    @DeleteMapping("/deleteProduct/ {productId}")

    public void deleteProduct(@PathVariable("productId") Integer id){
    productService.deleteProduct(id);
        System.out.println(" product removed successfully");
    }




}



