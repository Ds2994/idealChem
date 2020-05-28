package com.deadsec.ideal.model.data;

import java.sql.Date;

public class InvoiceJSON {

	private int id;
	private String reference;
	private String name;
	private Date createDate;
	private float amount;
	private String state;
	
	public InvoiceJSON() {
	}

	public InvoiceJSON(int id, String reference, String name, Date createDate, float amount, String state) {
		super();
		this.id = id;
		this.reference = reference;
		this.name = name;
		this.createDate = createDate;
		this.amount = amount;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
