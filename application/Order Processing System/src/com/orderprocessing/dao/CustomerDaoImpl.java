package com.orderprocessing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.entity.Order;
import com.orderprocessing.exception.CustomerNotFoundException;
import com.orderprocessing.util.OrderStatus;

public class CustomerDaoImpl implements CustomerDao{
	private static Connection conn;
	private static PreparedStatement loginId, loginName, selectOrdersByCustId, selectQuotesByCustId;
	
	static {
		conn = DBUtil.getConnection();
		try {
			loginId = conn.prepareStatement("SELECT * FROM tbl_customer WHERE customer_id=? AND password=?");
			loginName = conn.prepareStatement("SELECT * FROM tbl_customer WHERE name=? AND password=?");
			selectOrdersByCustId = conn.prepareStatement("SELECT * FROM tbl_order where customer_id=? AND status IN (?,?)");
			selectQuotesByCustId = conn.prepareStatement("SELECT * FROM tbl_order where customer_id=? AND status=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Check customer id and password, return customer object
	@Override
	public Customer loginUsingId(int id, String password) throws SQLException, CustomerNotFoundException {
		loginId.setInt(1, id);
		loginId.setString(2, password);
		ResultSet rs = loginId.executeQuery();
		if(rs.next())
			return new Customer(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
		throw new CustomerNotFoundException("Customer not found or Invalid credentials");
	}
	
	// Check customer name and password, return customer object
	@Override
	public Customer loginUsingName(String name, String password) throws SQLException, CustomerNotFoundException {
		loginName.setString(1, name);
		loginName.setString(2, password);
		ResultSet rs = loginName.executeQuery();
		if(rs.next())
			return new Customer(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
		throw new CustomerNotFoundException("Customer not found  or Invalid credentials");
	}
	
	@Override
	public List<Order> getOrdersWithoutProductListByCustomerId(int id) throws SQLException{
		List<Order> orderList = new ArrayList<>();
		selectOrdersByCustId.setInt(1, id);
		selectOrdersByCustId.setString(2, OrderStatus.Approved.toString());
		selectOrdersByCustId.setString(3, OrderStatus.Completed.toString());
		ResultSet rs = selectOrdersByCustId.executeQuery();
		while(rs.next())
			orderList.add(new Order(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getString(7), OrderStatus.valueOf(rs.getString(8))));
		return orderList;
	}
	
	@Override
	public List<Order> getQuotesWithoutProductListByCustomerId(int id) throws SQLException{
		List<Order> orderList = new ArrayList<>();
		selectQuotesByCustId.setInt(1, id);
		selectQuotesByCustId.setString(2, OrderStatus.Pending.toString());
		ResultSet rs = selectQuotesByCustId.executeQuery();
		while(rs.next())
			orderList.add(new Order(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getString(7), OrderStatus.valueOf(rs.getString(8))));
		return orderList;
	}
	
}
