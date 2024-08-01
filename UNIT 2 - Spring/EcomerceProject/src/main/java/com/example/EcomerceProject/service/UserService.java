package com.example.EcomerceProject.service;

import com.example.EcomerceProject.model.Products;
import com.example.EcomerceProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
    private User user;
    private final ChartService chartService;

    @Autowired
    public UserService(ChartService chartService) {
        this.user = new User(); // Initialize the User object
        this.user.setBudget(1000.00);
        this.chartService = chartService; // Inject ChartService through the constructor
    }

    public double getUserBudget() {
        return user.getBudget();
    }

    public void setUserBudget(double budget) {
        user.setBudget(budget);
    }

    public String checkout() {
        double orderTotal = chartService.calculateOrderTotal();
        double userBudget = getUserBudget();

        if (orderTotal <= userBudget) {
            double amountOnAccount= userBudget - orderTotal;
            setUserBudget(amountOnAccount);
            chartService.deleteAllProductsFromChart(); // Clear the chart after successful checkout
            return "Order was successful, amount on the account is:"+ amountOnAccount;
        } else {
            return "Not valid amount";
        }
    }
    public String checkoutProductById(int Id) {
        Products product = chartService.getProductFromChart(Id);
        if (product == null) {
            return "Product not found in chart";
        }

        double productTotalPrice = chartService.totalPriceCount(product);
        double userBudget = getUserBudget();

        if (productTotalPrice <= userBudget) {
            double amountOnAccount = userBudget - productTotalPrice;
            setUserBudget(amountOnAccount);
            chartService.deleteProductById(Id); // Remove the product from the chart after successful checkout
            return "Order was successful, amount on the account is: " + amountOnAccount;
        } else {
            return "Not valid amount";
        }
    }

}
