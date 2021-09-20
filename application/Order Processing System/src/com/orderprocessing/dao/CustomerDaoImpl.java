package com.orderprocessing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.orderprocessing.entity.Customer;

public class CustomerDaoImpl implements CustomerDao{
	private static Connection conn;
	private static PreparedStatement loginId, loginName;
	static {
		conn = DBUtil.getConnection();
		try {
			loginId = conn.prepareStatement("SELECT * FROM Customer WHERE id=? AND password=?");
			loginName = conn.prepareStatement("SELECT * FROM Customer WHERE name=? AND password=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Check customer id and password, return customer object
	@Override
	public Customer loginUsingId(int id, String password) throws SQLException {
		loginId.setInt(1, id);
		loginId.setString(1, password);
		ResultSet rs = loginId.executeQuery();
		if(rs.next())
			return new Customer(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
		return null;
	}
	// Check customer name and password, return customer object
	@Override
	public Customer loginUsingName(String name, String password) throws SQLException {
		loginId.setString(1, name);
		loginId.setString(1, password);
		ResultSet rs = loginId.executeQuery();
		if(rs.next())
			return new Customer(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
		return null;
	}
	
}
