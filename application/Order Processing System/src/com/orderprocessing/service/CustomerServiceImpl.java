package com.orderprocessing.service;

import java.sql.SQLException;

import com.orderprocessing.dao.CustomerDao;
import com.orderprocessing.dao.CustomerDaoImpl;
import com.orderprocessing.entity.Customer;
import com.orderprocessing.exception.CustomerNotFoundException;

public class CustomerServiceImpl implements CustomerService{
	// Customer Dao object
	private CustomerDao customerDao;
	
	// Default constructor
	public CustomerServiceImpl() {
		customerDao = new CustomerDaoImpl();
	}

	@Override
	public Customer loginCustomer(String name_or_id, String password) throws SQLException, CustomerNotFoundException {
		try{
			// Check if id
			int cust_id = Integer.parseInt(name_or_id);
			return customerDao.loginUsingId(cust_id, password);
		} catch(NumberFormatException e) {
			// If name
			return customerDao.loginUsingName(name_or_id, password);
		}
	}
	
}
