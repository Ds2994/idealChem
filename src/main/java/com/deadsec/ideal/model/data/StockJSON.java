package com.deadsec.ideal.model.data;

import java.io.Serializable;

public class StockJSON implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String productName;
	private String packingSize;
	private int quantity;
	
	public StockJSON() {
		
	}

	public StockJSON(String code, String productName, String packingSize, int quantity) {
		super();
		this.code = code;
		this.productName = productName;
		this.packingSize = packingSize;
		this.quantity = quantity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPackingSize() {
		return packingSize;
	}

	public void setPackingSize(String packingSize) {
		this.packingSize = packingSize;
	}

	public int getQuntity() {
		return quantity;
	}

	public void setQuntity(int quntity) {
		this.quantity = quantity;
	}
}
