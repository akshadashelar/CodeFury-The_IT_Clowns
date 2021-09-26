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
import com.orderprocessing.entity.Invoice;
import com.orderprocessing.exception.CustomerNotFoundException;
import com.orderprocessing.service.CustomerService;
import com.orderprocessing.service.CustomerServiceImpl;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		System.out.println(operation);
		RequestDispatcher rd = null;
		
		if(operation.equals("custlogin")) {
			CustomerService customerService = new CustomerServiceImpl();
			Customer customer;
			String cname = request.getParameter("cname");
			String pass = request.getParameter("cpswd");
			
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
				rd = request.getRequestDispatcher("customerlogin.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation.equals("custInvoice")) {
			CustomerService customerService = new CustomerServiceImpl();
			Customer customer;
			Invoice invoice = (Invoice)request.getAttribute("invoice");
			try {
				customer = customerService.getCustomerById(invoice.getCustomerId());
				request.setAttribute("operation", "custInvoice");
				request.setAttribute("customer", customer);
				rd = request.getRequestDispatcher("OrderController");
				rd.forward(request, response);
			} catch (SQLException | CustomerNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(operation.equals("approveOrder")) {
			request.setAttribute("operation", "approveOrder");
			rd = request.getRequestDispatcher("OrderController");
			rd.forward(request, response);
		}
	}

}
