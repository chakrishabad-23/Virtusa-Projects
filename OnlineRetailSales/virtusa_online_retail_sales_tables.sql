USE sales;
create table Customers(customer_id INT PRIMARY KEY,name VARCHAR(255),city VARCHAR(255));
create table Products(product_id INT PRIMARY KEY,name VARCHAR(255), category VARCHAR(255), price FLOAT);
create table Orders(order_id INT PRIMARY KEY,customer_id INT NOT NULL,order_date DATETIME NOT NULL ,FOREIGN KEY(customer_id) REFERENCES Customers(customer_id));
create table Order_Items(order_id INT,product_id INT,quantity INT, FOREIGN KEY(order_id) REFERENCES Orders(order_id),FOREIGN KEY(product_id) REFERENCES Products(product_id));
# Top Selling Products
SELECT
    p.product_id,
    p.name,
    SUM(oi.quantity) AS total_sold
FROM Products p
JOIN Order_Items oi
ON p.product_id = oi.product_id
GROUP BY p.product_id, p.name
ORDER BY total_sold DESC;

#Most valuable customers
SELECT
    c.customer_id,
    c.name,
    SUM(oi.quantity * p.price) AS total_spent
FROM Customers c
JOIN Orders o
ON c.customer_id = o.customer_id
JOIN Order_Items oi
ON o.order_id = oi.order_id
JOIN Products p
ON oi.product_id = p.product_id
GROUP BY c.customer_id, c.name
ORDER BY total_spent DESC;

# Monthly Revenue Calculation
SELECT
    YEAR(o.date) AS year,
    MONTH(o.date) AS month,
    SUM(oi.quantity * p.price) AS revenue
FROM Orders o
JOIN Order_Items oi
ON o.order_id = oi.order_id
JOIN Products p
ON oi.product_id = p.product_id
GROUP BY YEAR(o.date), MONTH(o.date)
ORDER BY year, month;

# Category wise Sales Analysis
SELECT
    p.category,
    SUM(oi.quantity) AS total_quantity,
    SUM(oi.quantity * p.price) AS total_revenue
FROM Products p
JOIN Order_Items oi
ON p.product_id = oi.product_id
GROUP BY p.category
ORDER BY total_revenue DESC;

#Detect Inactive Customers
SELECT
    c.customer_id,
    c.name
FROM Customers c
LEFT JOIN Orders o
ON c.customer_id = o.customer_id
WHERE o.order_id IS NULL;
