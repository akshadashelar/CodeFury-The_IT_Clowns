package com.orderprocessing.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InvoiceController")
public class InvoiceController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In Invoice Controller");
		String operation = req.getParameter("operation");
		
		if(operation.equals("custInvoice")) {
			int orderId = Integer.parseInt(req.getParameter("orderId"));
			System.out.println("Order Id: "+orderId);
			// TO-DO Fetch Invoice data from Service layer and send to invoice page
		}
	}
}
