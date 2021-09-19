package com.orderprocessing.entity;

public class Customer {
	private int customerId;
	private String customerName;
	private int customerGSTNumber;
	private String customerAddress;
	private String customerCity;
	private String customerEmail;
	private String customerPhone;
	private String customerPincode;
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getCustomerGSTNumber() {
		return customerGSTNumber;
	}
	
	public void setCustomerGSTNumber(int customerGSTNumber) {
		this.customerGSTNumber = customerGSTNumber;
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerCity() {
		return customerCity;
	}
	
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public String getCustomerPincode() {
		return customerPincode;
	}
	
	public void setCustomerPincode(String customerPincode) {
		this.customerPincode = customerPincode;
	}
	
}
