package com.example.Assignment._2.repository;

import com.example.Assignment._2.model.Customer;
import com.example.Assignment._2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    List<Customer> findCustomersByEmail(@Param("email") String email);


    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.customer = :customer")
    BigDecimal findTotalAmountByCustomer(@Param("customer") Customer customer);
}
