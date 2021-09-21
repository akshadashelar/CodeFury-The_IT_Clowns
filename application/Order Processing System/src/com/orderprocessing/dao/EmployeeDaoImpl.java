package com.orderprocessing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orderprocessing.entity.Employee;
import com.orderprocessing.entity.Order;
import com.orderprocessing.exception.EmployeeNotFoundException;
import com.orderprocessing.util.OrderStatus;

public class EmployeeDaoImpl implements EmployeeDao{
	private static Connection conn;
	private static PreparedStatement loginId, selectOrdersWithoutProducts;
	static {
		conn = DBUtil.getConnection();
		try {
			loginId = conn.prepareStatement("SELECT * FROM tbl_employee WHERE employee_id=? AND password=?");
			selectOrdersWithoutProducts = conn.prepareStatement("SELECT * FROM tbl_order");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Employee login using id
	@Override
	public Employee loginUsingId(int id, String password) throws SQLException, EmployeeNotFoundException {
		loginId.setInt(1, id);
		loginId.setString(2, password);
		ResultSet rs = loginId.executeQuery();
		if(rs.next())
			return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
		throw new EmployeeNotFoundException("Employee not found or Invalid credentials");
	}
	
	// Get all orders without list of products
	@Override
	public List<Order> getAllOrdersWithoutProductList() throws SQLException {
		List<Order> orderList = new ArrayList<>();
		ResultSet rs = selectOrdersWithoutProducts.executeQuery();
		while(rs.next())
			orderList.add(new Order(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getString(7), OrderStatus.valueOf(rs.getString(8))));
		return orderList;
	}

}
