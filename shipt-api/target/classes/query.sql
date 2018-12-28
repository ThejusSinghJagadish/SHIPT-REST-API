--Write a SQL query to return the results as display below:
--Example
--
--customer_id	customer_first_name	category_id	category_name	number_purchased
--	1				John				1		Bouquets		15


--Solution 1:  Gets customer information, category information and number of products purchased per category by each customer.

SELECT customers.email, customers.fname AS first_name, customers.lname AS last_name, categories.id, categories.name AS category_name, SUM(orderdetails.quantity) AS quantity 
FROM customers, orders, customer_orders, orderdetails, orders_products, products, categories, category_products 
WHERE customers.email = customer_orders.email AND  customer_orders.orders_id = orders.id AND orders.id = orders_products.orders_id AND orders_products.orderdetails_id = orderdetails.id AND orderdetails.product_id = products.id AND categories.id = category_products.category_id AND category_products.product_id = products.id 
GROUP BY customers.email, categories.id;

--+--------------------------+--------------+-----------+----+----------------+----------+
--| email                    | first_name   | last_name | id | category_name  | quantity |
--+--------------------------+--------------+-----------+----+----------------+----------+
--| thejussingh.13@gmail.com | Thejus Singh | Jagadish  |  1 | Dairy Products |       13 |
--| thejussingh.13@gmail.com | Thejus Singh | Jagadish  |  2 | Vegetables     |       17 |
--+--------------------------+--------------+-----------+----+----------------+----------+


--Solution 2:  Gets customer information, product information and number of products purchased by each customer.

SELECT customers.email, customers.fname AS first_name, customers.lname AS last_name, products.id, products.name AS product_name, SUM(orderdetails.quantity) AS quantity 
FROM customers, orders, customer_orders, orderdetails, orders_products, products 
WHERE customers.email = customer_orders.email AND  customer_orders.orders_id = orders.id AND orders.id = orders_products.orders_id AND orders_products.orderdetails_id = orderdetails.id AND orderdetails.product_id = products.id 
GROUP BY customers.email, products.id; 

--+--------------------------+--------------+-----------+----+---------------+----------+
--| email                    | first_name   | last_name | id | product_name  | quantity |
--+--------------------------+--------------+-----------+----+---------------+----------+
--| thejussingh.13@gmail.com | Thejus Singh | Jagadish  |  3 | Whole Milk    |        3 |
--| thejussingh.13@gmail.com | Thejus Singh | Jagadish  |  1 | Carrot        |       13 |
--| thejussingh.13@gmail.com | Thejus Singh | Jagadish  |  4 | Organic Eggs  |       10 |
--| thejussingh.13@gmail.com | Thejus Singh | Jagadish  |  2 | Cherry Tomato |        4 |
--+--------------------------+--------------+-----------+----+---------------+----------+


--Solution 3:  Gets customer information, category information and number of products purchased for a particular  customer.


SELECT customers.email, customers.fname AS first_name, customers.lname AS last_name, categories.id, categories.name AS category_name, SUM(orderdetails.quantity) AS quantity 
FROM customers, orders, customer_orders, orderdetails, orders_products, products, categories, category_products 
WHERE customers.email = customer_orders.email AND  customer_orders.orders_id = orders.id AND orders.id = orders_products.orders_id AND orders_products.orderdetails_id = orderdetails.id AND orderdetails.product_id = products.id AND categories.id = category_products.category_id AND category_products.product_id = products.id
AND customers.email = "thejussingh.13@gmail.com"
GROUP BY customers.email, categories.id;

