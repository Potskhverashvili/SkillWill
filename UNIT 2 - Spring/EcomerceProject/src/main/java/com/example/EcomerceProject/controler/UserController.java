package com.example.EcomerceProject.controler;

import com.example.EcomerceProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/checkout/")
    public String checkout(@RequestParam("UserRole") String userRole) {
        return userService.checkout();
    }


    @PostMapping("/productCheckout/{id}")
    public String checkoutProduct(@PathVariable("id") int id) {
       return   userService.checkoutProductById(id);

    }
}
