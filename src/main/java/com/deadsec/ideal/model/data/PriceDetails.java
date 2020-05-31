package com.deadsec.ideal.model.data;

import java.io.Serializable;

public class PriceDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private float price;
	private String size;
	private int quantity;
	
	public PriceDetails() {
		
	}

	public PriceDetails(int id, String size, float price, int quantity) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
