package com.orderprocessing.dao;

import java.sql.SQLException;

import com.orderprocessing.entity.Invoice;
import com.orderprocessing.exception.InvoiceNotFoundException;

public interface InvoiceDao {
	Invoice fetchInvoiceByOrderId(int orderId) throws SQLException, InvoiceNotFoundException;
}
