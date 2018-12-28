package com.shipt.assignment.shiptapi.repository;

import org.springframework.stereotype.Repository;
import com.shipt.assignment.shiptapi.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}
