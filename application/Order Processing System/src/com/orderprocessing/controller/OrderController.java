package com.orderprocessing.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.entity.Invoice;
import com.orderprocessing.entity.Order;
import com.orderprocessing.entity.Product;
import com.orderprocessing.exception.OrderNotFoundException;
import com.orderprocessing.service.OrderService;
import com.orderprocessing.service.OrderServiceImpl;

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
		OrderService orderService = new OrderServiceImpl();
		
		if(operation.equals("emporder")) {
			
			System.out.println("In Order Controller; operation = emporder");
			try {
				List<Order> allOrders = orderService.fetchAllOrders();
				
				request.setAttribute("allOrders", allOrders);
				rd = request.getRequestDispatcher("employeeOrderManagement.jsp");
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
			try {
				List<Order> customerOrders = orderService.fetchOrdersByCustomerId(customerId);
				List<Order> customerQuotes = orderService.fetchQuotesByCustomerId(customerId);
				
				request.setAttribute("customerOrders", customerOrders);
				request.setAttribute("customerQuotes", customerQuotes);
				rd = request.getRequestDispatcher("customerordermanagement.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(operation.equals("custInvoice")) {
			Invoice invoice = (Invoice) request.getAttribute("invoice");
			int id = invoice.getOrderId();
			try {
				Order order = orderService.getOrderById(id);
				Map<Product,Integer> products = orderService.getProducts(id);
				request.setAttribute("order", order);
				request.setAttribute("products", products);
				rd = request.getRequestDispatcher("invoiceNew.html");
				rd.forward(request, response);
			} catch (SQLException | OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(operation.equals("approveOrder")) {
			int id = Integer.parseInt(request.getParameter("orderId"));
			try {
				orderService.approveOrder(id);
				Order order = orderService.getOrderById(id);
				Customer currentCustomer = (Customer) session.getAttribute("user");
				request.setAttribute("order", order);
				request.setAttribute("customer", currentCustomer);
				rd = request.getRequestDispatcher("InvoiceController");
				rd.forward(request, response);
			} catch (SQLException | OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
