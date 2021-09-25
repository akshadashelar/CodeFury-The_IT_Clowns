package com.orderprocessing.service;

import java.sql.SQLException;

import com.orderprocessing.dao.InvoiceDao;
import com.orderprocessing.dao.InvoiceDaoImpl;
import com.orderprocessing.entity.Invoice;
import com.orderprocessing.entity.Order;
import com.orderprocessing.exception.InvoiceNotFoundException;
import com.orderprocessing.exception.NoSuchOrderIdException;

	public class InvoiceServiceImpl implements InvoiceService{
		
		@Override
		public Invoice fetchInvoiceByOrderIdService(int orderId) throws  SQLException, InvoiceNotFoundException {
			InvoiceDao id1=new InvoiceDaoImpl();
			return id1.fetchInvoiceByOrderId(orderId);
			 
		}

//		public Invoice generateInvoiceService(Order o1) throws NoSuchOrderIdException {
//			// TODO Auto-generated method stub
//			InvoiceDao id1=new InvoiceDaoImpl();
//			return id1.generateInvoiceDao(o1);
//		}
//
//		public Order generateOrderService(Order o1) throws NoSuchOrderIdException {
//			// TODO Auto-generated method stub
//			InvoiceDao id1=new InvoiceDaoImpl();
//			return id1.generateOrderDao(o1);	}

	}