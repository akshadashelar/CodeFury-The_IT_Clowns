package com.orderprocessing.service;

import java.sql.SQLException;
import java.util.Date;

import com.orderprocessing.entity.Invoice;
import com.orderprocessing.entity.Order;
import com.orderprocessing.exception.InvoiceNotFoundException;
import com.orderprocessing.util.GSTType;
import com.orderprocessing.util.InvoiceStatus;

public interface InvoiceService {
	
		Invoice fetchInvoiceByOrderIdService(int orderId) throws SQLException, InvoiceNotFoundException;
		//Invoice generateInvoiceService(Order o1)throws NoSuchOrderIdException;

		//Order generateOrderService(Order o1)throws NoSuchOrderIdException;
		void addInvoice(Date invoiceDate, int order_id, int customer_id, GSTType gst_type, float total_value, InvoiceStatus status) throws SQLException;

	}
