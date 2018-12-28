package com.shipt.assignment.shiptapi.repository;

import org.springframework.stereotype.Repository;
import com.shipt.assignment.shiptapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
