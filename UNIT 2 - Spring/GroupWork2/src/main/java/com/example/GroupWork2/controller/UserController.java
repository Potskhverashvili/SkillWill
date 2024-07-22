package com.example.GroupWork2.controller;

import com.example.GroupWork2.model.Product;
import com.example.GroupWork2.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    UserService userService;

    // Injects the UserController dependency
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // --------------------------------- Display All Product ---------------------------------
    @GetMapping("/display-all-product")
    public Map<String, Product> displayAllProduct(@RequestParam String userType) {
        return userService.displayAllProduct(userType);
    }

    // ----------------------------------- Cart Requests ---------------------------------------
    @PostMapping("add-to-cart")
    public Product adToCart(@RequestParam String userType, @RequestParam String productName, @RequestParam int productQuantity) {
        return userService.addToCart(userType, productName, productQuantity);
    }

    @GetMapping("/get-shoppingCart")
    public Map<String, Product> getAllCartItem(@RequestParam String userType) {
        return userService.getSoppingCart(userType);
    }

    @DeleteMapping("/delete-item")
    public void deleteItem(@RequestParam String userType, @RequestParam String productName) {
        userService.deleteItem(userType, productName);
    }

    // ------------------------------------ Order Requests ---------------------------------------
    @PostMapping ("/add-to-order")
    public Product addToOrder(@RequestParam String userType, @RequestParam String productName, @RequestParam int quantity) {
        return userService.addToOrder(userType, productName, quantity);
    }
    @PostMapping("/add-shoppingCard-to-order")
    public Map<String, Product> addShoppingCartToOrder(@RequestParam String userType){
        return userService.addShoppingCartToOrder(userType);
    }

    @GetMapping("/check-balance")
    public double checkBalance(@RequestParam String userType){
       return userService.checkBalance(userType);
    }

    @GetMapping("/get-ordered-items")
    public Map<String , Product > getOrderedItems(@RequestParam String userType){
        return userService.getOrderedItems(userType);
    }
}
