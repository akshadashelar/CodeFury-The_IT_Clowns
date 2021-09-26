package com.orderprocessing.service;

import java.sql.SQLException;
import java.util.List;

import com.orderprocessing.dao.ProductDao;
import com.orderprocessing.dao.ProductDaoImpl;
import com.orderprocessing.entity.Product;

public class ProductServiceImpl1 implements ProductService1{
	private ProductDao productDao;
	
	public ProductServiceImpl1() {
		this.productDao = new ProductDaoImpl();
	}
	
	@Override
	public List<Product> fetchAllProducts() throws SQLException {
		return productDao.fetchAllProducts();
	}
}
