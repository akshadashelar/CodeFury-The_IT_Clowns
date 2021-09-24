package com.orderprocessing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.orderprocessing.entity.Order;
import com.orderprocessing.util.OrderStatus;

public class OrderDaoImpl implements OrderDao{
	private static Connection conn;
	private static PreparedStatement selectOrdersWithoutProdList, selectOrdersWithoutProdListByCustId, 
		selectQuotesWithoutProdListByCustId, insertQuote;
	
	static {
		conn = DBUtil.getConnection();
		try {
			selectOrdersWithoutProdList = conn.prepareStatement("SELECT * FROM tbl_order");
			selectOrdersWithoutProdListByCustId = conn.prepareStatement("SELECT * FROM tbl_order where customer_id=? AND status IN (?,?)");
			selectQuotesWithoutProdListByCustId = conn.prepareStatement("SELECT * FROM tbl_order where customer_id=? AND status=?");
			insertQuote = conn.prepareStatement("INSERT INTO tbl_order(order_date,customer_id,customer_shipping_address,total_order_value,shipping_cost,status) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Get all orders without list of products
	@Override
	public List<Order> getAllOrdersWithoutProductList() throws SQLException {
		List<Order> orderList = new ArrayList<>();
		ResultSet rs = selectOrdersWithoutProdList.executeQuery();
		while(rs.next())
			orderList.add(new Order(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getString(7), OrderStatus.valueOf(rs.getString(8))));
		return orderList;
	}
	
	// Get Orders list for customer, product list is null
	@Override
	public List<Order> getOrdersWithoutProductListByCustomerId(int id) throws SQLException{
		List<Order> orderList = new ArrayList<>();
		selectOrdersWithoutProdListByCustId.setInt(1, id);
		selectOrdersWithoutProdListByCustId.setString(2, OrderStatus.Approved.toString());
		selectOrdersWithoutProdListByCustId.setString(3, OrderStatus.Completed.toString());
		ResultSet rs = selectOrdersWithoutProdListByCustId.executeQuery();
		while(rs.next())
			orderList.add(new Order(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getString(7), OrderStatus.valueOf(rs.getString(8))));
		return orderList;
	}
	
	// Get Quotes list for customer, product list is null
	@Override
	public List<Order> getQuotesWithoutProductListByCustomerId(int id) throws SQLException{
		List<Order> orderList = new ArrayList<>();
		selectQuotesWithoutProdListByCustId.setInt(1, id);
		selectQuotesWithoutProdListByCustId.setString(2, OrderStatus.Pending.toString());
		ResultSet rs = selectQuotesWithoutProdListByCustId.executeQuery();
		while(rs.next())
			orderList.add(new Order(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getString(7), OrderStatus.valueOf(rs.getString(8))));
		return orderList;
	}
	
	// Insert new quote in database and return order_id
	@Override
	public int addQuote(Date order_date, int customer_id, String customer_shipping_address, float total_order_value,
			float shipping_cost) throws SQLException {
		// Convert java.util.Date to java.sql.Date
		java.sql.Date sqlDate = new java.sql.Date(order_date.getTime());
		
		insertQuote.setDate(1, sqlDate);
		insertQuote.setInt(2, customer_id);
		insertQuote.setString(3, customer_shipping_address);
		insertQuote.setFloat(4, total_order_value);
		insertQuote.setFloat(5, shipping_cost);
		insertQuote.setString(6, OrderStatus.Pending.toString());
		
		insertQuote.executeUpdate();
		
		ResultSet rs = insertQuote.getGeneratedKeys();
		if(rs.next())
			return rs.getInt(1);
		return -1;
	}
}
