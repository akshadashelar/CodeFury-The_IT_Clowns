package com.orderprocessing.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.orderprocessing.entity.Product;
import com.orderprocessing.service.ProductService1;
import com.orderprocessing.service.ProductServiceImpl1;

@WebServlet("/ProductController1")
public class ProductController1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		ProductService1 productService = new ProductServiceImpl1();
		PrintWriter out = resp.getWriter();
		if(operation.equals("getCustProducts")) {
			try {
				List<Product> products = productService.fetchAllProducts();
				Gson gson = new Gson();
				String jsonText = gson.toJson(products);
				out.println(jsonText);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
