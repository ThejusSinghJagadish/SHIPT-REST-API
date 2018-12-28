package com.shipt.assignment.shiptapi.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVWriter;
import com.shipt.assignment.shiptapi.model.Customer;
import com.shipt.assignment.shiptapi.model.Order;
import com.shipt.assignment.shiptapi.model.OrderDetails;
import com.shipt.assignment.shiptapi.repository.OrderRangeDay;
import com.shipt.assignment.shiptapi.repository.OrderRangeMonth;
import com.shipt.assignment.shiptapi.repository.OrderRangeWeek;

public class SaveToFile {
	private final String filePath = "/Users/thejussinghj/Desktop/shipt-api/src/main/resources/output";
	
	public void save(List<String[]> list, String[] header, String filename){
		File file = new File(filePath + "/" + filename);
		try { 
	        FileWriter outputfile = new FileWriter(file); 
	        CSVWriter writer = new CSVWriter(outputfile, ',', 
	                                         CSVWriter.NO_QUOTE_CHARACTER, 
	                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
	                                         CSVWriter.DEFAULT_LINE_END); 
	        writer.writeNext(header); 
	        writer.writeAll(list); 
	  
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
	}
	
	public void saveCustomerOrder(Customer customerOrder){
//		File file = new File(filePath + "/customerOrder.csv");
//		List<String[]> formattedOutput = format(customerOrder);
//		String[] header = { "Email", "First Name", "Last Name", "Order Date", "Order Status", "Product Name", "Product Quantity", "Product Price/Unit" }; 
//        
//		try { 
//	        // create FileWriter object with file as parameter 
//	        FileWriter outputfile = new FileWriter(file); 
//	  
//	        // create CSVWriter with '|' as separator 
//	        CSVWriter writer = new CSVWriter(outputfile, ',', 
//	                                         CSVWriter.NO_QUOTE_CHARACTER, 
//	                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
//	                                         CSVWriter.DEFAULT_LINE_END); 
//	        writer.writeNext(header); 
//	        writer.writeAll(formattedOutput); 
//	  
//	        // closing writer connection 
//	        writer.close(); 
//	    } 
//	    catch (IOException e) { 
//	        // TODO Auto-generated catch block 
//	        e.printStackTrace(); 
//	    } 
		String[] header = { "Email", "First Name", "Last Name", "Order Date", "Order Status", "Product Name", "Product Quantity", "Product Price/Unit" };
		List<String[]> formattedResult = new ArrayList<>();
		StringBuilder customerInfo = new StringBuilder();
		customerInfo.append(customerOrder.getEmail()).append("%20");
		customerInfo.append(customerOrder.getFname()).append("%20");
		customerInfo.append(customerOrder.getLname()).append("%20");
		if(customerOrder.getOrders().size() == 0){
			formattedResult.add(customerInfo.toString().trim().split("%20"));
			save(formattedResult, header, "customerOrder.csv");
			return;
		}
		for(Order order: customerOrder.getOrders()){
			StringBuilder orderInfo = new StringBuilder(customerInfo.toString());
			orderInfo.append(String.valueOf(order.getOrderdate()).substring(0, 10)).append("%20");
			orderInfo.append(order.getStatus()).append("%20");
			for(OrderDetails orderDetails: order.getOrders()){
				StringBuilder productInfo = new StringBuilder(orderInfo.toString());
				productInfo.append(orderDetails.getProduct().getName()).append("%20");
				productInfo.append(String.valueOf(orderDetails.getQuantity())).append("%20");
				productInfo.append("$ "+String.valueOf(orderDetails.getProduct().getPrice()));
				formattedResult.add(productInfo.toString().trim().split("%20"));
			}
		}
		save(formattedResult, header, "customerOrder.csv");
	}
	
	public void productSoldPerMonth(List<OrderRangeMonth> productQty){
		String[] header = { "Year", "Month", "Product Name", "Quantity"};
		List<String[]> formattedResult = new ArrayList<>();
		String[] row;
		for(OrderRangeMonth order: productQty){
			row = new String[4];
			row[0] = String.valueOf(order.getYear());
			row[1] = String.valueOf(order.getMonth());
			row[2] = order.getProductName();
			row[3] = String.valueOf(order.getQuantity());
			formattedResult.add(row);
		}
		save(formattedResult, header, "orderQty.csv");
	}
	
	public void productSoldPerWeek(List<OrderRangeWeek> productQty){
		String[] header = { "Year", "Week", "Product Name", "Quantity"};
		List<String[]> formattedResult = new ArrayList<>();
		String[] row;
		for(OrderRangeWeek order: productQty){
			row = new String[4];
			row[0] = String.valueOf(order.getYear());
			row[1] = String.valueOf(order.getWeek());
			row[2] = order.getProductName();
			row[3] = String.valueOf(order.getQuantity());
			formattedResult.add(row);
		}
		save(formattedResult, header, "orderQty.csv");
	}
	
	public void productSoldPerDay(List<OrderRangeDay> productQty){
		String[] header = { "Year", "Month","Day", "Product Name", "Quantity"};
		List<String[]> formattedResult = new ArrayList<>();
		String[] row;
		for(OrderRangeDay order: productQty){
			row = new String[5];
			row[0] = String.valueOf(order.getYear());
			row[1] = String.valueOf(order.getMonth());
			row[2] = String.valueOf(order.getDay());
			row[3] = order.getProductName();
			row[4] = String.valueOf(order.getQuantity());
			formattedResult.add(row);
		}
		save(formattedResult, header, "orderQty.csv");
	}
	
	public List<String[]> format(Customer customerOrder){
		List<String[]> formattedResult = new ArrayList<>();
		StringBuilder customerInfo = new StringBuilder();
		customerInfo.append(customerOrder.getEmail()).append("%20");
		customerInfo.append(customerOrder.getFname()).append("%20");
		customerInfo.append(customerOrder.getLname()).append("%20");
		if(customerOrder.getOrders().size() == 0){
			formattedResult.add(customerInfo.toString().trim().split("%20"));
			return formattedResult;
		}
		for(Order order: customerOrder.getOrders()){
			StringBuilder orderInfo = new StringBuilder(customerInfo.toString());
			orderInfo.append(String.valueOf(order.getOrderdate()).substring(0, 10)).append("%20");
			orderInfo.append(order.getStatus()).append("%20");
			for(OrderDetails orderDetails: order.getOrders()){
				StringBuilder productInfo = new StringBuilder(orderInfo.toString());
				productInfo.append(orderDetails.getProduct().getName()).append("%20");
				productInfo.append(String.valueOf(orderDetails.getQuantity())).append("%20");
				productInfo.append("$ "+String.valueOf(orderDetails.getProduct().getPrice()));
				formattedResult.add(productInfo.toString().trim().split("%20"));
			}
		}
		return formattedResult;
	}
}
