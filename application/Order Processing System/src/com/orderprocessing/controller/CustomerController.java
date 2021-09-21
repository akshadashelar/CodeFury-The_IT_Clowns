package com.orderprocessing.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.exception.CustomerNotFoundException;
import com.orderprocessing.service.CustomerService;
import com.orderprocessing.service.CustomerServiceImpl;

@WebServlet("/CustomerContoller")
public class CustomerController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService customerService = new CustomerServiceImpl();
		Customer customer;
		String cname = request.getParameter("cname");
		String pass = request.getParameter("cpswd");
		try {
			customer = customerService.loginCustomer(cname, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(CustomerNotFoundException e) {
			RequestDispatcher rd = request.getRequestDispatcher("customerlogin.html");
			rd.forward(request, response);
		}
		// TODO: forward customer obj to jsp page
	}

}
