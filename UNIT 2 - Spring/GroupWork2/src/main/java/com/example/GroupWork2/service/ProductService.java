package com.example.GroupWork2.service;

import com.example.GroupWork2.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    // This static Map serves as an in-memory storage for product information
    static Map<String, Product> products = new HashMap<>();

    // Method to add a new product
    public Product addProduct(String userType, Product product) {

        // Check if the user has the "admin" role (case-insensitive comparison)
        if (!userType.equalsIgnoreCase("admin")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only admins can add products.");
        }

        // Check if a product with the same name already exists in the products map
        if (products.containsKey(product.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with this name already exists.");
        }

        // Add the new product to the products map, using the product name as the key
        products.put(product.getName(), product);

        // Retrieve and return the newly added product from the map (for confirmation).
        return products.get(product.getName());
    }

    // Update product
    public Product updateProduct(String userType, String productName, Product product) {

        // Check if the user has the "admin" role (case-insensitive comparison)
        if (!userType.equalsIgnoreCase("admin")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only admins can add products.");
        }

        // Check if a product exists in the products map
        if (!products.containsKey(productName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with this name doesn't exists.");
        }

        // Remove the existing product entry from the 'products' map
        products.remove(productName);

        // Add the updated product entry with its new values to the 'products' map
        products.put(product.getName(), product);

        // Return the updated product if it was successfully updated, otherwise return null
        return products.get(product.getName());
    }

    // Method to retrieve all products from the in-memory storage.
    public Map<String, Product> getAllProduct(String userType) {

        if (!userType.equalsIgnoreCase("admin")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only admins can add products.");
        }
        return products;
    }

    // Method to delete a specific product
    public void deleteProduct(String userType, String productName) {
        // Check if the user attempting to delete has the "admin" role.
        if (!userType.equalsIgnoreCase("admin")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only admins can add products.");
        }

        // Check if a product with the given name exists in the 'products' map.
        if (!products.containsKey(productName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with this name doesn't exists.");
        }

        // If the user is an admin and the product exists:
        // Remove the product with the specified name from the 'products' map.
        products.remove(productName);
    }
}
