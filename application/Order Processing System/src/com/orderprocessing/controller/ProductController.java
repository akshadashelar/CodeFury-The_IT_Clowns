package com.orderprocessing.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orderprocessing.dao.ProductDao;
import com.orderprocessing.dao.ProductDaoImpl;
import com.orderprocessing.entity.Customer;
import com.orderprocessing.entity.Employee;
import com.orderprocessing.entity.Product;
import com.orderprocessing.service.ProductService;
import com.orderprocessing.service.ProductServiceImpl;

@WebServlet("/ProductController")
@MultipartConfig
public class ProductController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		ProductService productService = new ProductServiceImpl();
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		
		Customer customer = null;
		Employee employee = null;
		// Check session
		HttpSession session = request.getSession();
		String user_type = (String) session.getAttribute("user_type");
		if(user_type == null) {
			rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}
		else if (user_type.equals("customer")) {
			customer = (Customer) session.getAttribute("user");
			if(customer == null) {
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
			}
		}
		else if (user_type.equals("employee")) {
			employee = (Employee) session.getAttribute("user");
			if(employee == null) {
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
			}
		}
		
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		RequestDispatcher rd = null;
		Customer customer = null;
		Employee employee = null;
		// Check session
		HttpSession session = request.getSession();
		String user_type = (String) session.getAttribute("user_type");
		if(user_type == null) {
			rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}
		else if (user_type.equals("customer")) {
			customer = (Customer) session.getAttribute("user");
			if(customer == null) {
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
			}
		}
		else if (user_type.equals("employee")) {
			employee = (Employee) session.getAttribute("user");
			if(employee == null) {
				rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
			}
		}
		
		if(operation.equals("importproduct")) {
			System.out.println(operation);
			ProductService productService = new ProductServiceImpl();
			Part filePart = request.getPart("products");
			String filePath = this.getServletContext().getRealPath("json_file")+"/products.json";
			filePart.write(filePath);
			
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			StringBuilder stringBuilder = new StringBuilder();
			String line = null;
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			// delete the last new line separator
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			reader.close();
			// String of JSON objects
			String products = stringBuilder.toString();
			// Convert JSON string to Set of Products
			Gson gson = new Gson();
			Type mapType = new TypeToken<HashSet<Product>>(){}.getType();
			Set<Product> prodmap = gson.fromJson(products, mapType);
			// cnt is total number of rows inserted or updated in product table 
			int cnt = 0;
			try {
				cnt = productService.addProductsFromFile(prodmap);
				request.setAttribute("successCount", cnt);
				rd = request.getRequestDispatcher("importproducts.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// TODO: 
			// Set cnt in request
			// Forward request to next page
		}
	}

}
