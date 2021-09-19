package com.orderprocessing.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.orderprocessing.util.GSTType;
import com.orderprocessing.util.InvoiceStatus;

public class Invoice {
	private int invoiceId;
	private Calendar invoiceDate;
	private int orderId;
	private int customerId;
	private List<Product> products;
	private List<Float> gstPerProduct;
	private float totalGST;
	private GSTType typeOfGST;
	private float totalInvoiceValue;
	private InvoiceStatus status;
	
	public Invoice() {
		this.products = new ArrayList<Product>();
		this.gstPerProduct = new ArrayList<Float>();
	}

	public int getInvoiceId() {
		return invoiceId;
	}
	
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	public Calendar getInvoiceDate() {
		return invoiceDate;
	}
	
	public void setInvoiceDate(Calendar invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public List<Float> getGstPerProduct() {
		return gstPerProduct;
	}
	
	public void setGstPerProduct(List<Float> gstPerProduct) {
		this.gstPerProduct = gstPerProduct;
	}
	
	public float getTotalGST() {
		return totalGST;
	}
	
	public void setTotalGST(float totalGST) {
		this.totalGST = totalGST;
	}
	
	public GSTType getTypeOfGST() {
		return typeOfGST;
	}
	
	public void setTypeOfGST(GSTType typeOfGST) {
		this.typeOfGST = typeOfGST;
	}
	
	public float getTotalInvoiceValue() {
		return totalInvoiceValue;
	}
	
	public void setTotalInvoiceValue(float totalInvoiceValue) {
		this.totalInvoiceValue = totalInvoiceValue;
	}
	
	public InvoiceStatus getStatus() {
		return status;
	}
	
	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}
	
	
}
