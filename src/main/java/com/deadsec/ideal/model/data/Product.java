package com.deadsec.ideal.model.data;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String productName;
	private String description;
	private String casNumber;
	
	private List<PriceDetails> priceDetails;
	
	public Product() {
		
	}

	public Product(String code, String productName, String description, String casNumber) {
		super();
		this.code = code;
		this.productName = productName;
		this.description = description;
		this.casNumber = casNumber;
	}

	public Product(String code, String productName, String description, String casNumber, List<PriceDetails> details) {
		super();
		this.code = code;
		this.productName = productName;
		this.description = description;
		this.casNumber = casNumber;
		this.priceDetails = details;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCasNumber() {
		return casNumber;
	}

	public void setCasNumber(String casNumber) {
		this.casNumber = casNumber;
	}

	public List<PriceDetails> getPriceDetails() {
		return priceDetails;
	}

	public void setPriceDetails(List<PriceDetails> priceDetails) {
		this.priceDetails = priceDetails;
	}
}
