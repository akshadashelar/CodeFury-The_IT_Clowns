package com.orderprocessing.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.orderprocessing.entity.Product;

public interface ProductDao {
	List<Product> fetchAllProducts() throws SQLException;
	int addProducts(Set<Product> products) throws SQLException;
}
