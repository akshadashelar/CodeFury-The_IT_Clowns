package com.orderprocessing.entity;

public class Product {
	private int productId;
	private String productName;
	private float productPrice;
	private int productCategory;
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public float getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	
}
