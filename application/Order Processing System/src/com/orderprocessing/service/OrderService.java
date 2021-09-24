package com.orderprocessing.service;

import java.sql.SQLException;
import java.util.List;

import com.orderprocessing.entity.Order;

public interface OrderService {

	List<Order> fetchAllOrders() throws SQLException;

	List<Order> fetchOrdersByCustomerId(int customerId) throws SQLException;

	List<Order> fetchQuotesByCustomerId(int customerId) throws SQLException;

}
