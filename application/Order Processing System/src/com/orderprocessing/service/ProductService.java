package com.orderprocessing.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.orderprocessing.entity.Product;

public interface ProductService {
	int addProductsFromFile(Set<Product> products) throws SQLException;
	
	List<Product> fetchAllProducts() throws SQLException;
}
