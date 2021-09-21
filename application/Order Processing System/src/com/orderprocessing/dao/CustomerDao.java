package com.orderprocessing.dao;

import java.sql.SQLException;
import java.util.List;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.entity.Order;
import com.orderprocessing.exception.CustomerNotFoundException;

public interface CustomerDao {
	Customer loginUsingId(int id, String password) throws SQLException, CustomerNotFoundException;
	Customer loginUsingName(String name, String password) throws SQLException, CustomerNotFoundException;
	List<Order> getOrdersWithoutProductListByCustomerId(int id) throws SQLException;
	List<Order> getQuotesWithoutProductListByCustomerId(int id) throws SQLException;
}
