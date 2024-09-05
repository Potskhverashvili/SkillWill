package com.example.Assignment._2.service;

import com.example.Assignment._2.model.Customer;
import com.example.Assignment._2.model.Order;
import com.example.Assignment._2.repository.CustomerRepository;
import com.example.Assignment._2.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MainService {

    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    public MainService(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }


    @PostConstruct
    public void insert(){
        Customer customer = new Customer();
        customer.setFirstName("Jane");
        customer.setLastName("Davis");
        customer.setEmail("Jane@gmail.com");
        customer.setAddress("address");
        customerRepository.save(customer);

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.parse("2007-12-03"));
    }
}
