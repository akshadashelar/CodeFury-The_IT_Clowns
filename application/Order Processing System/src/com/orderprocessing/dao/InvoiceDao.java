package com.orderprocessing.dao;

import java.util.Date;
import java.sql.SQLException;

import com.orderprocessing.entity.Invoice;
import com.orderprocessing.exception.InvoiceNotFoundException;
import com.orderprocessing.util.GSTType;
import com.orderprocessing.util.InvoiceStatus;

public interface InvoiceDao {
	Invoice fetchInvoiceByOrderId(int orderId) throws SQLException, InvoiceNotFoundException;
	void addInvoice(Date invoiceDate, int order_id, int customer_id, GSTType gst_type, float total_value, InvoiceStatus status) throws SQLException;
}
