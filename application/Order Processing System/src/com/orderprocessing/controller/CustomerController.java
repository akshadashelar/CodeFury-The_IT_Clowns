package com.orderprocessing.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.exception.CustomerNotFoundException;
import com.orderprocessing.service.CustomerService;
import com.orderprocessing.service.CustomerServiceImpl;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService customerService = new CustomerServiceImpl();
		Customer customer;
		String cname = request.getParameter("cname");
		String pass = request.getParameter("cpswd");
		
		RequestDispatcher rd = null;
		try {
			customer = customerService.loginCustomer(cname, pass);
			System.out.println("Login Successful");
			
			HttpSession session = request.getSession();
			session.setAttribute("user", customer);
			
			//rd = request.getRequestDispatcher("customerordermanagement.html");
			request.setAttribute("operation", "custorder");
			rd = request.getRequestDispatcher("OrderController");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(CustomerNotFoundException e) {
			rd = request.getRequestDispatcher("customerlogin.html");
			rd.forward(request, response);
		}
		// TODO: forward customer obj to jsp page
	}

}
