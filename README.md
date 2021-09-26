# CodeFury-The_IT_Clowns

## Project Topic - Order Processing System

## How to run

1) Clone project using git
2) Import project into Eclipse
3) Make sure runtime is selected as Tomcat 9
4) Make sure jar files have been added to build path. Following external jars used: gson-2.8.8.jar, jstl-1.2.jar, mysql-connector-java-8.0.26.jar, standard-1.1.2.jar
5) create database named "order_processing_system" in sql client.
6) Populate database using sql dump file: order_processing_system_dump_3.sql
7) To run the project right click on project and select run as -> run on server

Login credentials for employee:
username = 1
password = akshada

Login credentials for customer:
username = 1
password = oshee@123

## Possible errors while execution

1) Compilation error on common java commands: In this case the jre system library will have to be removed and added again

## Functionalities missing

1) Add new products: This functionality was working on one laptop and wasn't working on others.
2) View Invoice in Employee Order Management page
3) Side navigation bar session validation
