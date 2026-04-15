USE sales;
create table Customers(customer_id INT PRIMARY KEY,name VARCHAR(255),city VARCHAR(255));
create table Products(product_id INT PRIMARY KEY,name VARCHAR(255), category VARCHAR(255), price FLOAT);
create table Orders(order_id INT PRIMARY KEY,customer_id INT NOT NULL,order_date DATETIME NOT NULL ,FOREIGN KEY(customer_id) REFERENCES Customers(customer_id));
create table Order_Items(order_id INT,product_id INT,quantity INT, FOREIGN KEY(order_id) REFERENCES Orders(order_id),FOREIGN KEY(product_id) REFERENCES Products(product_id));
