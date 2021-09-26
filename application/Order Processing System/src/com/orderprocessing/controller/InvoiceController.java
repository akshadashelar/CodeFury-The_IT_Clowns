package com.orderprocessing.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.entity.Invoice;
import com.orderprocessing.entity.Order;
import com.orderprocessing.exception.InvoiceNotFoundException;
import com.orderprocessing.service.InvoiceService;
import com.orderprocessing.service.InvoiceServiceImpl;
import com.orderprocessing.util.GSTType;
import com.orderprocessing.util.InvoiceStatus;

@WebServlet("/InvoiceController")
public class InvoiceController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvoiceService invoiceService= new InvoiceServiceImpl();
		String operation = request.getParameter("operation");
		RequestDispatcher rd = null;
		
		//1.request to invoice controller pass orderid 
		if(operation.equals("custInvoice")) {
			System.out.println("In Invoice Controller");
			try {
				int orderId = Integer.parseInt(request.getParameter("orderId"));
				
				//2.fetch from invoice 
				Invoice invoice=new Invoice();
				invoice = invoiceService.fetchInvoiceByOrderIdService(orderId);
				
				//TODO
				//3.forward req to customer controller 
				//4. fetch customer details & forward to order controller(from customer controller request transfers to order controller)
				request.setAttribute("invoice", invoice);
				rd = request.getRequestDispatcher("CustomerController");
				rd.forward(request, response);
				
				//5. fetch order details & forward to invoice jsp
				/*request.setAttribute("custInvoice", invoice);
				rd = request.getRequestDispatcher("invoiceNew.html");
				rd.forward(request, response);*/
			}catch (SQLException | InvoiceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(operation.equals("approveOrder")) {
			// TO-DO Insert new record into invoice table
			Order order = (Order) request.getAttribute("order");
			Customer customer = (Customer) request.getAttribute("customer");
			Date currentDate = new Date();
			float total_value = order.getOrderValue() + order.getShippingCost();
			try {
				invoiceService.addInvoice(currentDate, order.getOrderId(), customer.getCustomerId(), GSTType.INTER_STATE, total_value, InvoiceStatus.Unpaid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("operation", "custorder");
			rd = request.getRequestDispatcher("OrderController");
			rd.forward(request, response);
		}
	}
}
