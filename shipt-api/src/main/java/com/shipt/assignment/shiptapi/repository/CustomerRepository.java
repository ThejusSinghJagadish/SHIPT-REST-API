package com.shipt.assignment.shiptapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shipt.assignment.shiptapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
