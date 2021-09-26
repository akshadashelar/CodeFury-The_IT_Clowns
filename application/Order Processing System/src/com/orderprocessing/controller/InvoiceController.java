package com.orderprocessing.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orderprocessing.entity.Invoice;
import com.orderprocessing.exception.InvoiceNotFoundException;
import com.orderprocessing.service.InvoiceService;
import com.orderprocessing.service.InvoiceServiceImpl;

@WebServlet("/InvoiceController")
public class InvoiceController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		RequestDispatcher rd = null;
		
		//1.request to invoice controller pass orderid 
		if(operation.equals("custInvoice")) {
			System.out.println("In Invoice Controller");
			InvoiceService invoiceService= new InvoiceServiceImpl();
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
	}
}
