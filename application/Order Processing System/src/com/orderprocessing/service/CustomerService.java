package com.orderprocessing.service;

import java.sql.SQLException;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.exception.CustomerNotFoundException;

public interface CustomerService {
	Customer loginCustomer(String name_or_id, String password) throws SQLException, CustomerNotFoundException;
}
