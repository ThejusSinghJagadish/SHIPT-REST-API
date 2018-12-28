package com.shipt.assignment.shiptapi.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	private Date orderdate;
	
	@NotNull
	private int weeknum;
	
	@NotNull
	private String day;
	
	@NotNull
	private String month;
	
	@NotNull
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "orders_products",
			joinColumns = { @JoinColumn(name = "orders_id") },
			inverseJoinColumns = { @JoinColumn(name = "orderdetails_id") }
			)
    private Set<OrderDetails> orderDetails = new HashSet<>();

	public Order(){}

	public Order(Long id, @NotNull Date orderdate, @NotNull int weeknum, @NotNull String day, @NotNull String month,
			@NotNull String status, Set<OrderDetails> orderDetails) {
		this.id = id;
		this.orderdate = orderdate;
		this.weeknum = weeknum;
		this.day = day;
		this.month = month;
		this.status = status;
		this.orderDetails = orderDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getWeeknum() {
		return weeknum;
	}

	public void setWeeknum(int weeknum) {
		this.weeknum = weeknum;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<OrderDetails> getOrders() {
		return orderDetails;
	}

	public void setOrders(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}
