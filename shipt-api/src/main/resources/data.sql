--Insert statements for all tables


INSERT INTO `categories` (`name`) VALUES ('Dairy Products');
INSERT INTO `categories` (`name`) VALUES ('Vegetables');
INSERT INTO `categories` (`name`) VALUES ('Fruits');

INSERT INTO `products` (`name`, `price`) VALUES ('Carrot', 2.99);
INSERT INTO `products` (`name`, `price`) VALUES ('Cherry Tomato', 3.99);
INSERT INTO `products` (`name`, `price`) VALUES ('Whole Milk', 5.99);
INSERT INTO `products` (`name`, `price`) VALUES ('Organic Eggs', 10.00);

INSERT INTO `category_products` (`category_id`, `product_id`) VALUES (2, 1);
INSERT INTO `category_products` (`category_id`, `product_id`) VALUES (2, 2);
INSERT INTO `category_products` (`category_id`, `product_id`) VALUES (1, 3);
INSERT INTO `category_products` (`category_id`, `product_id`) VALUES (1, 4);

INSERT INTO `customers` (`email`, `fname`, `lname`) VALUES ('thejussingh.13@gmail.com', 'Thejus Singh', 'Jagadish');
INSERT INTO `customers` (`email`, `fname`, `lname`) VALUES ('sapthami.shetty@gmail.com', 'Sapthami', 'Shetty');
INSERT INTO `customers` (`email`, `fname`, `lname`) VALUES ('vinaysagar@gmail.com', 'Vinay', 'Sagar');

INSERT INTO `orders` (`orderdate`, `day`, `month`, `weeknum`, `status`) VALUES('2019-01-01', 'Tuesday', 'January', 1, 'DELIVERED');
INSERT INTO `orders` (`orderdate`, `day`, `month`, `weeknum`, `status`) VALUES('2019-01-17', 'Thursday', 'January', 3, 'DELIVERED');
INSERT INTO `orders` (`orderdate`, `day`, `month`, `weeknum`, `status`) VALUES('2019-02-24', 'Sunday', 'February', 9, 'ON THE WAY');

INSERT INTO `customer_orders` (`email`, `orders_id`) VALUES ('thejussingh.13@gmail.com', 1);
INSERT INTO `customer_orders` (`email`, `orders_id`) VALUES ('thejussingh.13@gmail.com', 2);
INSERT INTO `customer_orders` (`email`, `orders_id`) VALUES ('thejussingh.13@gmail.com', 3);

INSERT INTO `orderdetails` (`quantity`, `product_id`) VALUES (3, 3);
INSERT INTO `orderdetails` (`quantity`, `product_id`) VALUES (10, 1);
INSERT INTO `orderdetails` (`quantity`, `product_id`) VALUES (5, 4);
INSERT INTO `orderdetails` (`quantity`, `product_id`) VALUES (3, 4);
INSERT INTO `orderdetails` (`quantity`, `product_id`) VALUES (2, 4);
INSERT INTO `orderdetails` (`quantity`, `product_id`) VALUES (4, 2);
INSERT INTO `orderdetails` (`quantity`, `product_id`) VALUES (3, 1);

INSERT INTO `orders_products` (`orders_id`, `orderdetails_id`) VALUES (1, 1);
INSERT INTO `orders_products` (`orders_id`, `orderdetails_id`) VALUES (1, 2);
INSERT INTO `orders_products` (`orders_id`, `orderdetails_id`) VALUES (1, 3);
INSERT INTO `orders_products` (`orders_id`, `orderdetails_id`) VALUES (2, 4);
INSERT INTO `orders_products` (`orders_id`, `orderdetails_id`) VALUES (3, 5);
INSERT INTO `orders_products` (`orders_id`, `orderdetails_id`) VALUES (3, 6);
INSERT INTO `orders_products` (`orders_id`, `orderdetails_id`) VALUES (3, 7);










