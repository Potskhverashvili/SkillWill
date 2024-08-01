package com.example.EcomerceProject.service;

import com.example.EcomerceProject.model.Products;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
@Service
public class ProductService {
//Hash map declaration
    private final HashMap<Integer, Products> productsInStock = new HashMap<>();

    // methods for storing in request methods
    public Products addProducts(Integer id, Products products) {
        productsInStock.put(id, new Products(products.getId(), products.getProductName(), products.getPrice(), products.getQuantity()));
      return products;
    }

    public Map<Integer, Products> getProductsInStock() {

        return productsInStock;
    }

    public Products getProductById(Integer id) {
        return productsInStock.get(id);
    }

    public Products updateProduct(Integer id, Products productToUpdate) {
        if (productsInStock.containsKey(id)) {
            Products product = productsInStock.get(id);
            product.setProductName(productToUpdate.getProductName());
            product.setPrice(productToUpdate.getPrice());
            product.setQuantity(productToUpdate.getQuantity());
            return product;
        } else {
            throw new NoSuchElementException("Invalid Product ID: " + id);
        }
    }

    public void deleteProduct(Integer id){
    if (productsInStock.containsKey(id)){
        productsInStock.remove(id);
    }else throw new NoSuchElementException("Invalid Product ID: " + id);
    }

}