package com.shipt.assignment.shiptapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipt.assignment.shiptapi.exception.ResourceNotFoundException;
import com.shipt.assignment.shiptapi.model.Category;
import com.shipt.assignment.shiptapi.model.Customer;
import com.shipt.assignment.shiptapi.repository.CustomerRepository;
import com.shipt.assignment.shiptapi.utils.SaveToFile;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepo;
	
	
//	Get Customer
	@GetMapping("/customers")
	public List<Customer> getAllCategories(){
		List<Customer> catList = customerRepo.findAll();
		return catList;
	}
	
	//Get a single category
	@GetMapping("/customerOrders/{email}")
	public Customer getCategoryById(@PathVariable(value = "email") String email){
		SaveToFile saveToFile = new SaveToFile();
		Customer custOrder = customerRepo.findById(email)
				.orElseThrow(() -> new ResourceNotFoundException("Cartegory", "email", email));
		saveToFile.saveCustomerOrder(custOrder);
		return custOrder;
	}
}
