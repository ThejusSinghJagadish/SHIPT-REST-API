package com.shipt.assignment.shiptapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shipt.assignment.shiptapi.repository.CategoryRepository;
import com.shipt.assignment.shiptapi.exception.ResourceNotFoundException;
import com.shipt.assignment.shiptapi.model.*;

import java.util.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/category-api")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepo;
	
//	Get All Category
	@GetMapping("/categories")
	public List<Category> getAllCategories(){
		List<Category> catList = categoryRepo.findAll();
		return catList;
	}
	
	//Create a new Category
	@PostMapping("/category")
	public Category createCategory(@Valid @RequestBody Category category){
		return categoryRepo.save(category);
	}
	
	//Get a single category
	@GetMapping("/category/{id}")
	public Category getCategoryById(@PathVariable(value = "id") Long categoryId){
		return categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Cartegory", "id", categoryId));
	}
	
	//update a category
	@PutMapping("/category/{id}")
	public Category updateCategory(@PathVariable(value = "id") Long categoryId, @Valid @RequestBody Category category){
		
		Category cat = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		
		cat.setName(category.getName());
		
		Category updatedCategory = categoryRepo.save(cat);
		
		return updatedCategory;
	}
	
	//delete a category
	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long categoryId){
		
		Category cat = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		
		categoryRepo.delete(cat);
		
		return ResponseEntity.ok().build();
	}
}
