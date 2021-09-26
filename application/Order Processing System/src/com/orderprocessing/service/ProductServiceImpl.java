package com.orderprocessing.service;

import java.sql.SQLException;
import java.util.Set;

import com.orderprocessing.dao.ProductDao;
import com.orderprocessing.dao.ProductDaoImpl;
import com.orderprocessing.entity.Product;

public class ProductServiceImpl implements ProductService{
	private ProductDao productDao;
	
	// Default constructor
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}
	
	@Override
	public int addProductsFromFile(Set<Product> products) throws SQLException {
		return productDao.addProducts(products);
	}

}
