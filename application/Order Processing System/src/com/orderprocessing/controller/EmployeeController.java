package com.orderprocessing.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orderprocessing.entity.Employee;
import com.orderprocessing.exception.EmployeeNotFoundException;
import com.orderprocessing.service.EmployeeService;
import com.orderprocessing.service.EmployeeServiceImpl;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService employeeService = new EmployeeServiceImpl();
		Employee employee;
		
		int eid = Integer.parseInt(request.getParameter("ename"));
		String pass = request.getParameter("epswd");
		
		try {
			employee = employeeService.loginEmployee(eid, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(EmployeeNotFoundException e) {
			RequestDispatcher rd = request.getRequestDispatcher("employeelogin.html");
			rd.forward(request, response);
		}
		// TODO: forward employee obj to jsp page
	}

}
