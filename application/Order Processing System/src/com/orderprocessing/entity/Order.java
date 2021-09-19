package com.orderprocessing.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.orderprocessing.util.OrderStatus;

public class Order {
	private int orderId;
	private Calendar orderDate;
	private int customerId;
	private String customerShippingAddress;
	private List<Product> products;
	private float orderValue;
	private float shippingCost;
	private String shippingAgency;
	private OrderStatus status;
	
	public Order() {
		super();
		this.products = new ArrayList<Product>();;
	}

	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public Calendar getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerShippingAddress() {
		return customerShippingAddress;
	}
	
	public void setCustomerShippingAddress(String customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public float getOrderValue() {
		return orderValue;
	}
	
	public void setOrderValue(float orderValue) {
		this.orderValue = orderValue;
	}
	
	public float getShippingCost() {
		return shippingCost;
	}
	
	public void setShippingCost(float shippingCost) {
		this.shippingCost = shippingCost;
	}
	
	public String getShippingAgency() {
		return shippingAgency;
	}
	
	public void setShippingAgency(String shippingAgency) {
		this.shippingAgency = shippingAgency;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
}
