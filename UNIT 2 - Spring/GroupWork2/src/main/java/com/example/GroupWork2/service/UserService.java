package com.example.GroupWork2.service;

import com.example.GroupWork2.model.Product;
import com.example.GroupWork2.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

import static com.example.GroupWork2.service.ProductService.products;

@Service
public class UserService {

    // Variable to keep track of the total price of items in the shopping cart.
    double sumOfCartItemsPrice;

    // Object representing a user.
    User user;

    // budget control functionality is dependent on the user's budget.
    public UserService(User user) {
        this.user = user;
    }

    // In-memory storage (HashMap) to represent the user's shopping cart.
    Map<String, Product> cartProducts = new HashMap<>();

    // In-memory storage (HashMap) to represent the user's placed orders
    Map<String, Product> orderProducts = new HashMap<>();

    // --------------------------------------------- Cart Management ------------------------------------------
    // Method Add Product to Cart
    public Product addToCart(String userType, String productName, int quantity) {

        // Check if the user has the "admin" role (case-insensitive comparison)
        if (!userType.equalsIgnoreCase("user")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only user can add products.");
        }
        // Check if a product exists in the products map
        if (!products.containsKey(productName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with this name doesn't exists.");
        }

        // Retrieve the product from products map
        Product existingProduct = products.get(productName);

        // Check if there is enough stock
        if (quantity > existingProduct.getStock()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient stock for product:");
        }

        //This object for specific quantity of the product being added to the cart.
        Product cartProduct = new Product();

        // Calculate the remaining stock of the original product after the desired quantity is removed.
        int newStock = existingProduct.getStock() - quantity;

        // Update the stock of the existing product to reflect the new available quantity.
        existingProduct.setStock(newStock);

        // Calculate the total cost of this specific item being added
        sumOfCartItemsPrice = sumOfCartItemsPrice + (quantity * existingProduct.getPrice());

        // Set the details of the cartProduct (name, price, and quantity added)
        cartProduct.setName(existingProduct.getName());
        cartProduct.setPrice(existingProduct.getPrice());
        cartProduct.setStock(quantity);

        // Add the cartProduct to the shopping cart (cartProducts map)
        cartProducts.put(cartProduct.getName(), cartProduct);

        // Return the cartProduct (representing the item added to the cart)
        return cartProduct;
    }

    // Get All Product From Cart
    public Map<String, Product> getSoppingCart(String userType) {
        if (!userType.equalsIgnoreCase("user")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only user can get Sopping Cart");
        }
        if (cartProducts.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Empty Cart");
        }
        return cartProducts;
    }

    // Delete Product From Cart
    public void deleteItem(String userType, String productName) {

        if (!userType.equalsIgnoreCase("user")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Ony user can delete item");
        }

        // Check if a product exists in the products map
        if (!products.containsKey(productName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with this name doesn't exists.");
        }

        cartProducts.remove(productName);
    }

    // --------------------------------------- Order Management -----------------------------------------
    // Method to transfer items from the shopping cart to an order.
    public Map<String, Product> addShoppingCartToOrder(String userType) {

        // Check if the user trying to place the order has the "user" role.
        if (!userType.equalsIgnoreCase("user")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only user can add Shopping cart to order");
        }

        // Check if the user's budget is sufficient to cover the total price of the items in the cart.
        if (user.getBudget() < sumOfCartItemsPrice) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is not enough money on the balance");
        }

        //Transfer the contents of the shopping cart (cartProducts) to the order (orderProducts).
        orderProducts = cartProducts;
        cartProducts.clear();

        // Update the user's budget by subtracting the total price of the order.
        user.setBudget(user.getBudget() - sumOfCartItemsPrice);

        // Return the orderProducts map, which now contains the purchased items.
        return orderProducts;
    }

    // Method to add a specific item directly to an order.
    public Product addToOrder(String userType, String productName, int quantity) {

        // Check if the user trying to add to the order is a "user"
        if (!userType.equalsIgnoreCase("user")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only user can add to order");
        }
        // Check if the product with the given name exists in the products map.
        if (!products.containsKey(productName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with this name doesn't exists.");
        }

        // Retrieve the product from the products map (assuming this map represents the available products).
        Product existingProduct = products.get(productName);

        // Check if there is enough stock
        if (quantity > existingProduct.getStock()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient stock for product:");
        }

        // Calculate the total cost of this item
        double totalCost = quantity * existingProduct.getPrice();

        // Check if the user's budget is sufficient to cover the total price of the items in the cart.
        if (user.getBudget() < totalCost) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is not enough money on the balance");
        }

        // This object for specific quantity of the product being added to the order
        Product orderProduct = new Product();

        // Set the details of the orderProduct
        orderProduct.setName(existingProduct.getName());
        orderProduct.setPrice(existingProduct.getPrice());
        orderProduct.setStock(quantity);

        // Add the orderProduct to the orderProducts map.
        orderProducts.put(orderProduct.getName(), orderProduct);

        // Calculate the new stock level after removing the ordered quantity.
        int newStock = existingProduct.getStock() - quantity;

        // Update the product's stock in the products map with the newStock.
        existingProduct.setStock(newStock);

        // Calculate the user's remaining budget after deducting the item's cost.
        double balance = user.getBudget() - totalCost;

        // Update the user's budget with the new balance.
        user.setBudget(balance);

        // Returns the previous value associated with the key (product name), or null if there wasn't one.
        return orderProducts.get(productName);
    }

    // display all ordered items
    public Map<String, Product> getOrderedItems(String userType) {
        if (!userType.equalsIgnoreCase("user")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only user get Ordered Items");
        }
        return orderProducts;
    }

    // -------------------------------- Helper Functions -----------------------------
    // check user balance
    public double checkBalance(String userType) {
        if (!userType.equalsIgnoreCase("user")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only user can check balance");
        }
        return user.getBudget();
    }

    // Display all existing product
    public Map<String, Product> displayAllProduct(String userType) {
        if (!userType.equalsIgnoreCase("user")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only user can get all item");
        }
        return products;
    }
}

