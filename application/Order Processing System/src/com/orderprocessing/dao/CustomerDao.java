package com.orderprocessing.dao;

import java.sql.SQLException;

import com.orderprocessing.entity.Customer;
import com.orderprocessing.exception.CustomerNotFoundException;

public interface CustomerDao {
	Customer loginUsingId(int id, String password) throws SQLException, CustomerNotFoundException;
	Customer loginUsingName(String name, String password) throws SQLException, CustomerNotFoundException;
}
