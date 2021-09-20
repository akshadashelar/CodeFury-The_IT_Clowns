package com.orderprocessing.dao;

import java.sql.SQLException;

import com.orderprocessing.entity.Customer;

public interface CustomerDao {
	Customer loginUsingId(int id, String password) throws SQLException;
	Customer loginUsingName(String name, String password) throws SQLException;
}
