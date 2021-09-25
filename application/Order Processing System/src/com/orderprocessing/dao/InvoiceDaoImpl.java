package com.orderprocessing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.orderprocessing.entity.Invoice;
import com.orderprocessing.exception.InvoiceNotFoundException;
import com.orderprocessing.util.GSTType;
import com.orderprocessing.util.InvoiceStatus;

public class InvoiceDaoImpl implements InvoiceDao{
	private static Connection conn;
	private static PreparedStatement selectInvoiceByOrderId;
	
	static {
		conn = DBUtil.getConnection();
		try {
			selectInvoiceByOrderId = conn.prepareStatement("SELECT * FROM tbl_invoice WHERE order_id = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Invoice fetchInvoiceByOrderId(int orderId) throws SQLException, InvoiceNotFoundException {
		selectInvoiceByOrderId.setInt(1, orderId);
		ResultSet rs = selectInvoiceByOrderId.executeQuery();
		if(rs.next())
			return(new Invoice(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4),GSTType.valueOf(rs.getString(5)),rs.getFloat(6),InvoiceStatus.valueOf(rs.getString(7))));
		throw new InvoiceNotFoundException("Invoice for given order id not found");
	}
	
}
