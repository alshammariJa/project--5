package com.example.projectweek5.Repositry;

import com.example.projectweek5.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositry extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);
}
