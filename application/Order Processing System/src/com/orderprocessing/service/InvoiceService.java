package com.orderprocessing.service;

import java.sql.SQLException;

import com.orderprocessing.entity.Invoice;
import com.orderprocessing.entity.Order;
import com.orderprocessing.exception.InvoiceNotFoundException;
import com.orderprocessing.exception.NoSuchOrderIdException;

public interface InvoiceService {
	
		Invoice fetchInvoiceByOrderIdService(int orderId) throws SQLException, InvoiceNotFoundException;
		//Invoice generateInvoiceService(Order o1)throws NoSuchOrderIdException;

		//Order generateOrderService(Order o1)throws NoSuchOrderIdException;

	}