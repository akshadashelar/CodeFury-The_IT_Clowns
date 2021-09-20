package com.orderprocessing.service;

import java.sql.SQLException;

import com.orderprocessing.entity.Employee;
import com.orderprocessing.exception.EmployeeNotFoundException;

public interface EmployeeService {
	Employee loginEmployee(int eid, String password) throws SQLException, EmployeeNotFoundException;
}
