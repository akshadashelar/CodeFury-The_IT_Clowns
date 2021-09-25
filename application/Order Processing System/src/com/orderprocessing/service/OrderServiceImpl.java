package com.orderprocessing.service;

import java.sql.SQLException;
import java.util.List;

import com.orderprocessing.dao.CustomerDao;
import com.orderprocessing.dao.CustomerDaoImpl;
import com.orderprocessing.dao.OrderDao;
import com.orderprocessing.dao.OrderDaoImpl;
import com.orderprocessing.entity.Order;

public class OrderServiceImpl implements OrderService{
	// Order Dao object
	private OrderDao orderDao;
	
	// Default constructor
	public OrderServiceImpl() {
		orderDao = new OrderDaoImpl();
	}
	@Override
	public List<Order> fetchAllOrders() throws SQLException {
		return orderDao.getAllOrdersWithoutProductList();
	}

	@Override
	public List<Order> fetchOrdersByCustomerId(int customerId) throws SQLException {
		return orderDao.getOrdersWithoutProductListByCustomerId(customerId);
	}

	@Override
	public List<Order> fetchQuotesByCustomerId(int customerId) throws SQLException {
		return orderDao.getQuotesWithoutProductListByCustomerId(customerId);
	}

}