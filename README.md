These are all Projects Built in Java. They all are connected with a database in Oracle MYSQL using JDBC and perform some tasks.

Here we are perofrming CRUD Operations on various data like text file, binary file, random access file and atlast Databases.

## **Assignment 1:**
Develop a GUI application to manage product file. For each product following information is kept:
Product id (integer and unique)
Product name
Product price (double and positive)
User should be able to perform the following operations:
Add new product, only if all the valid information is provided
Modify existing product using product id

## **#Assignment 2:**
Create a customer management application. This application uses a binary file for storing customer information and includes data validation and exception handling.
With the customer management user should be able to perform the following operations:
Add new customer, only if all the valid information is provided
Find and modify existing customer using customer id
Display list of all customers
For each customer following information is kept:
Customer id (integer and unique)
Name, Phone, Email, and Postal Code

## **#Assignment 3:**
Using random access file, develop a GUI application to manage a product file. 
For each product, the following information is kept:
Product id (integer, unique, auto assigned)
Product name
Product price (double)
User should be able to perform the following operations:
Add new product
Modify existing product using product id
Delete product using product id

## **#Assignment 4:**
Write a Java GUI program that views, inserts, and updates staff information stored in a database, as shown in the following figure. The view button displays a record with a specified ID. The Staff table is created as follows:

create t
able Staff (  
  id char(9) not null,
  lastName varchar(15),
  firstName varchar(15),
  mi char(1),
  address varchar(20),
  city varchar(20),
  state char(2),
  telephone char(10),
  email varchar(40),
  primary key (id)
);

## **#Assignment 5:**
1. In ca.myjava.query package
• The two classes should do the same task - query the Country table in your Oracle
database and show the info of countries which have LifeExpectancy between two values.
• Use static SQL (Statement) or PreparedStatement to perform the query as described by
the class names.
2. In ca.myjava.unknown package
Code the AnySQL class which accepts user’s input of SQL command from the console
and execute the command using JDBC API. Show the query results or info of excuting
the SQL command on the console.
3. In ca.myjava.update package
• Use the three classes to run 3 SQL statements: insert, update and delete on the Country
table. Each class will run only one of the above SQL statements.
• The approach to run the SQL statement for each class is described by the class name.




