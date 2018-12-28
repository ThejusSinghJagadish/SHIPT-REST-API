package com.shipt.assignment.shiptapi.model;

import javax.persistence.*;


public class OrderRange {
	
	private int product_count;
	private String product_name;
	
	public OrderRange(){}
	
	public OrderRange(int product_count, String product_name) {
		this.product_count = product_count;
		this.product_name = product_name;
	}

	public int getProduct_count() {
		return product_count;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
}
