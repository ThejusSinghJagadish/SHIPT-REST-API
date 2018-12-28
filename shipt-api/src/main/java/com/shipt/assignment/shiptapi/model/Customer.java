package com.shipt.assignment.shiptapi.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
    private String email;
	
	@NotNull
	private String fname;
	
	@NotNull
	private String lname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "customer_orders",
			joinColumns = { @JoinColumn(name = "email") },
			inverseJoinColumns = { @JoinColumn(name = "orders_id") }
			)
    private Set<Order> orders = new HashSet<>();

	public Customer(){}

	public Customer(String email, @NotNull String fname, @NotNull String lname, Set<Order> orders) {
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.orders = orders;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}