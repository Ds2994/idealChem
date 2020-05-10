package com.deadsec.ideal.model.data;

import java.io.Serializable;

public class PriceDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String size;
	private float price;
	private int quantity;
	
	public PriceDetails() {
		
	}

	public PriceDetails(String size, float price, int quantity) {
		super();
		this.size = size;
		this.price = price;
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
