package com.shipt.assignment.shiptapi.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipt.assignment.shiptapi.model.Order;
import com.shipt.assignment.shiptapi.repository.OrderRangeDay;
import com.shipt.assignment.shiptapi.repository.OrderRangeMonth;
import com.shipt.assignment.shiptapi.repository.OrderRangeWeek;
import com.shipt.assignment.shiptapi.repository.OrderRepository;
import com.shipt.assignment.shiptapi.utils.SaveToFile;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderRepository orderRepo;
	
	
	@GetMapping("/orders")
	public List<Order> getAllCategories(){
		return orderRepo.findAll();
	}
	
	@GetMapping("/order-range/{startDate}/{endDate}/Month")
	public List<OrderRangeMonth> getOrderQtyByMonth(@PathVariable(value = "startDate") String startDate, @PathVariable(value = "endDate") String endDate){
		SaveToFile saveToFile = new SaveToFile();
		List<OrderRangeMonth> list = orderRepo.getOrdersBetweenRangeIntrMonth(startDate, endDate);
		saveToFile.productSoldPerMonth(list);
		return list;
	}
	
	@GetMapping("/order-range/{startDate}/{endDate}/Week")
	public List<OrderRangeWeek> getOrderQtyByWeek(@PathVariable(value = "startDate") String startDate, @PathVariable(value = "endDate") String endDate){
		SaveToFile saveToFile = new SaveToFile();
		List<OrderRangeWeek> list = orderRepo.getOrdersBetweenRangeIntrWeek(startDate, endDate);
		saveToFile.productSoldPerWeek(list);
		return list;
	}
	
	@GetMapping("/order-range/{startDate}/{endDate}/Day")
	public List<OrderRangeDay> getOrderQtyByDay(@PathVariable(value = "startDate") String startDate, @PathVariable(value = "endDate") String endDate){
		SaveToFile saveToFile = new SaveToFile();
		List<OrderRangeDay> list = orderRepo.getOrdersBetweenRangeIntrDay(startDate, endDate);
		saveToFile.productSoldPerDay(list);
		return list;
	}
	
}
