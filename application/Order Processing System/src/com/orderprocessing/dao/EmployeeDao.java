package com.orderprocessing.dao;

import java.sql.SQLException;

import com.orderprocessing.entity.Employee;
import com.orderprocessing.exception.EmployeeNotFoundException;

public interface EmployeeDao {
	Employee loginUsingId(int id, String password) throws SQLException, EmployeeNotFoundException;
}
