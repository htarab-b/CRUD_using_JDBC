# CRUD Operations using Java JDBC

## Description
This program has the basic CRUD Operations (Create, Read, Update, Delete) using Java JDBC API. JDBC is essential for Java programs to connect to a Database for storing and managing data. There are various Databases that can be connected using JDBC, but in this program MySQL Database is used.

## Prerequisites
In order to run this program, A MySQL server has to be running in your local with a Database that goes by a name of your choice. And in the MySQL Database, run the below command to create a Table in the Database.
```
CREATE DATABASE example
USE example

CREATE TABLE sample (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50),
  age int(11),
  PRIMARY KEY (ID)
)
```

## Execution
Run 'App.java' and the program will connect to the MySQL Database running in your local. An infinite loop will start to execute asking for your choice between 1 of the 4 CRUD Operations available. Data entered in the program will cause changes in the Database running in local.
