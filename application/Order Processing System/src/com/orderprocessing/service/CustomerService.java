package com.orderprocessing.service;

import java.sql.SQLException;
import java.util.List;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.entity.Order;
import com.orderprocessing.exception.CustomerNotFoundException;

public interface CustomerService {
	Customer loginCustomer(String name_or_id, String password) throws SQLException, CustomerNotFoundException;

	List<Order> fetchQuotesByCustomerId(int custId) throws SQLException;

	List<Order> fetchOrdersByCustomerId(int custId) throws SQLException;
}
