package com.example.EcomerceProject.service;
import com.example.EcomerceProject.model.Products;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
@Service
public class ChartService {

private final  ProductService productService;
    private final HashMap<Integer, Products>chartList = new HashMap<>();
    private  HashMap<Integer,Products>productsInStock;


    public ChartService( HashMap<Integer, Products> productsInStock, ProductService productService) {

        this.productsInStock = productsInStock;
        this.productService = productService;
    }




    public Products addToChart(Integer id, Products products) {
        System.out.println("Adding to chart - ID: " + id + ", Products: " + products);
        //calculate total price

    Products chartProduct = new Products(products.getId(), products.getProductName(), products.getPrice(), products.getQuantity());
        double totalPrice =chartProduct.getPrice()*chartProduct.getQuantity();
     chartProduct.setTotalPrice(totalPrice);
        chartList.put(products.getId(), chartProduct);


        return chartProduct;

    }

    public double totalPriceCount(Products chartProduct){
        return chartProduct.getPrice()*chartProduct.getQuantity();
    }

    public Products updateProductById(Integer id, Products updatedProduct) {
        if (chartList.containsKey(id)) {
            Products existingProduct = chartList.get(id);
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setTotalPrice(updatedProduct.getPrice() * updatedProduct.getQuantity());
            return existingProduct;
        } else {
            throw new NoSuchElementException("Product not found in the chart with ID: " + id);
        }
    }

    public HashMap<Integer, Products> getChartList() {
        return chartList;
    }

    public Products getProductFromChart(int Id) {
        return chartList.get(Id);
    }


    public boolean deleteProductFromChartById(Integer id) {
        if (chartList.containsKey(id)) {
            chartList.remove(id);
            return true;
        } else {
            throw new NoSuchElementException("Product not found in the chart with ID: " + id);
        }
    }
    public void deleteAllProductsFromChart() {
        chartList.clear();
    }



    //   method to calculate  total order amount
    public double calculateOrderTotal() {
        double orderTotal = 0.0;

        // Iterate over the chartList entries
        for (Products product : chartList.values()) {
            // Add the total price of each product to the order total
            orderTotal += product.getTotalPrice();
        }

        return orderTotal;
    }
    public HashMap<Integer, Products> calculateProductInStock(HashMap<Integer, Products> productInStock, HashMap<Integer, Products>chartList) {

        // Deduct quantities from chartList if product IDs match
        for (Map.Entry<Integer, Products> entry: productsInStock.entrySet()) {
            Integer key = entry.getKey();
                Products product2 = entry.getValue();
                Products product3 =chartList.get(key);
                if(product3 != null){
                    int newQuantity = product2.getQuantity()-product3.getQuantity();
                    product2.setPrice(product2.getPrice());
                    product2.setProductName(product2.getProductName());
                    product2.setId(product2.getId());
                    product2.setQuantity(newQuantity);

                }

            }
        return productInStock;
        }


    // Method to update product quantities based on the chartList
    public void updateStock() {
        // Deduct quantities from productInStock based on chartList
        productsInStock= calculateProductInStock(productsInStock, chartList);
    }



    // Method to get the remaining stock
    public HashMap<Integer, Products> getLeftStock() {
        // Optionally update stock before returning
        updateStock();
        return productsInStock;
    }











    private static double findPriceForProductId(HashMap<Integer, Products> productInStock, int Id) {
        for (HashMap.Entry<Integer, Products> entry : productInStock.entrySet()) {
            if (entry.getKey() == Id) {
                return entry.getValue().getPrice();
            }
        }
        return -1; // Product not found
    }
/*
    public double getProductPrice(int id) {
        // Check if the product exists in the map
        if (productsInStock.containsKey(id)) {
            // Retrieve the product from the map
            Products product = productsInStock.get(id);
            // Return the price of the product
           return   product.getPrice();

        } else {
            // Throw an exception if the product ID is not found
            throw new NoSuchElementException("Product not found with ID: " + id);
        }
    } */

    // Method to calculate total price for the given product ID and quantity
    public double calculateTotalPrice(Integer id, Integer quantity) {
        double productPrice=0.0;

         productPrice = findPriceForProductId(productsInStock,id);


        return productPrice * quantity;
    }

    public boolean deleteProductById(Integer id) {
        if (chartList.containsKey(id)) {
            chartList.remove(id);
            return true;
        } else {
            throw new NoSuchElementException("Product not found in the chart with ID: " + id);
        }
    }
    public void deleteAllProducts() {
        chartList.clear();
    }


    }
