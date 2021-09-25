package com.orderprocessing.entity;

public class Product {
	private int productId;
	private String productName;
	private float productPrice;
	private int productCategory;
	
	// Default Constructor
	public Product() {
		this.productId = -1;
		this.productName = null;
		this.productPrice = -1;
		this.productCategory = -1;
	}
	
	// Parameterized constructor
	public Product(int productId, String productName, float productPrice, int productCategory) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
	}

	/// Setter and Getter methods
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
	
	@Override
	public int hashCode() {
		return this.getProductId();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (this.getProductId() != other.getProductId()) {
            return false;
        }
        return true;
	}
	
}
