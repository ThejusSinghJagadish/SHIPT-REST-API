package com.shipt.assignment.shiptapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.shipt.assignment.shiptapi.model.Order;

import java.util.*;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>  {
	

	@Query(value = "select YEAR(orderdate) AS year, MONTH(orderdate) AS month , products.name AS productName, sum(quantity) AS quantity from orders, orderdetails, orders_products,products where orderdate BETWEEN ?1 AND ?2 and orders.id = orders_products.orders_id and orders_products.orderdetails_id = orderdetails.id and orderdetails.product_id = products.id group by YEAR(orderdate), MONTH(orderdate), products.name;", nativeQuery = true)
	public List<OrderRangeMonth> getOrdersBetweenRangeIntrMonth(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	@Query(value = "select YEAR(orderdate) AS year, Week(orderdate) AS week , products.name AS productName, sum(quantity) AS quantity from orders, orderdetails, orders_products,products where orderdate BETWEEN ?1 AND ?2 and orders.id = orders_products.orders_id and orders_products.orderdetails_id = orderdetails.id and orderdetails.product_id = products.id group by YEAR(orderdate), WEEK(orderdate), products.name;", nativeQuery = true)
	public List<OrderRangeWeek> getOrdersBetweenRangeIntrWeek(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	@Query(value = "select YEAR(orderdate) AS year, MONTH(orderdate) AS month, Day(orderdate) AS day , products.name AS productName, sum(quantity) AS quantity from orders, orderdetails, orders_products,products where orderdate BETWEEN ?1 AND ?2 and orders.id = orders_products.orders_id and orders_products.orderdetails_id = orderdetails.id and orderdetails.product_id = products.id group by YEAR(orderdate), MONTH(orderdate), DAY(orderdate), products.name;", nativeQuery = true)
	public List<OrderRangeDay> getOrdersBetweenRangeIntrDay(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
}
