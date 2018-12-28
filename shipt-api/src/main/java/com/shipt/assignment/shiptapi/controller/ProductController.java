package com.shipt.assignment.shiptapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shipt.assignment.shiptapi.repository.ProductRepository;
import com.shipt.assignment.shiptapi.exception.ResourceNotFoundException;
import com.shipt.assignment.shiptapi.model.*;

import java.util.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		List<Product> productlist = productRepo.findAll();
		return productlist;
	}
}
