package com.example.EcomerceProject.controler;
import com.example.EcomerceProject.model.Products;
import com.example.EcomerceProject.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ChartController {

    private final ChartService chartService;

    @Autowired
    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }
    @PostMapping("/addToChart/")
    public Products addProducts(@RequestParam("userRole") String userRole,@RequestBody Products Products) {
        if ("user".equalsIgnoreCase(userRole)) {
            return chartService.addToChart(Products.getId(), new Products(Products.getId(), Products.getProductName(), Products.getPrice(), Products.getQuantity()));
        } else {
            throw new IllegalArgumentException("Only users can add products.");
        }
    }

    @PutMapping("/updateProductInChart/{id}")
    public Products updateProduct(@PathVariable("id")  Integer id, @RequestParam("userRole") String userRole, @RequestBody Products updatedProduct) {
        return chartService.updateProductById(id, updatedProduct);
    }


    @GetMapping("/get-chartList")
    public Map<Integer,Products> getChartList(@RequestParam("userRole")String userRole){
        return chartService.getChartList();

    }

    @GetMapping("/get-chartProduct/{id}")
    public Products getProductFromChart(@PathVariable("id")int id, @RequestParam("useRole") String usrRole ) {
        return chartService.getProductFromChart(id);
    }

    @DeleteMapping("/deleteProductFromChart/{id}")
    public boolean deleteProduct(@PathVariable("id") Integer id,@RequestParam("userRole") String userRole) {
        return chartService.deleteProductById(id);
    }
    @DeleteMapping("/deleteChart/")
    public void deleteAllProducts(@RequestParam("userRole") String userRole) {
        chartService.deleteAllProducts();
    }



}







