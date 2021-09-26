package com.orderprocessing.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orderprocessing.dao.ProductDao;
import com.orderprocessing.dao.ProductDaoImpl;
import com.orderprocessing.entity.Product;
import com.orderprocessing.service.ProductService;
import com.orderprocessing.service.ProductServiceImpl;

@WebServlet("/ProductController")
@MultipartConfig
public class ProductController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO: 
		// Set cnt in request
		// Forward request to next page
	}

}
