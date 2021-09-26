package com.orderprocessing.service;

import java.sql.SQLException;
import java.util.List;

import com.orderprocessing.entity.Product;

public interface ProductService1 {

	List<Product> fetchAllProducts() throws SQLException;

}
