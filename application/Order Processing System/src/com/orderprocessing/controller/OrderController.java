package com.orderprocessing.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.entity.Order;
import com.orderprocessing.service.CustomerService;
import com.orderprocessing.service.CustomerServiceImpl;
import com.orderprocessing.service.EmployeeService;
import com.orderprocessing.service.EmployeeServiceImpl;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getAttribute("operation").toString();
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		
		if(operation.equals("emporder")) {
			
			System.out.println("In Order Controller; operation = emporder");
			EmployeeService employeeService = new EmployeeServiceImpl();
			try {
				List<Order> allOrders = employeeService.fetchAllOrders();
				
				rd = request.getRequestDispatcher("employeeordermanagement.html");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(operation.equals("custorder")) {
			
			System.out.println("In Order Controller; operation = custorder");
			Customer currentCustomer = (Customer) session.getAttribute("user");
			int customerId = currentCustomer.getCustomerId();
			CustomerService customerService = new CustomerServiceImpl();
			try {
				List<Order> customerOrders = customerService.fetchOrdersByCustomerId(customerId);
				List<Order> customerQuotes = customerService.fetchQuotesByCustomerId(customerId);
				
				rd = request.getRequestDispatcher("customerordermanagement.html");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
