package com.orderprocessing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orderprocessing.entity.Product;

public class ProductDaoImpl implements ProductDao{
	private static Connection conn;
	private static PreparedStatement selectAllProducts;
	
	static {
		conn = DBUtil.getConnection();
		try {
			selectAllProducts = conn.prepareStatement("SELECT * FROM tbl_product");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Product> fetchAllProducts() throws SQLException {
		List<Product> productList = new ArrayList<>();
		ResultSet rs = selectAllProducts.executeQuery();
		while(rs.next())
			productList.add(new Product(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4)));
		return productList;
	}

}
