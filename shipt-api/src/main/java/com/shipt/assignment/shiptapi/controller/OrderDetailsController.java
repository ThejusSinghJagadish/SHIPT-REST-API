package com.shipt.assignment.shiptapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipt.assignment.shiptapi.model.OrderDetails;
import com.shipt.assignment.shiptapi.repository.OrderDetailsRepository;

@RestController
@RequestMapping("/orderDetail-api")
public class OrderDetailsController {
	@Autowired
	OrderDetailsRepository orderDetailsrepository;
	
//	Get All Category
	@GetMapping("/orderDetails")
	public List<OrderDetails> getAllCategories(){
		List<OrderDetails> orderDetails = orderDetailsrepository.findAll();
		System.out.println(orderDetails.size());
		return orderDetailsrepository.findAll();
	}
}
