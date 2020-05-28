package com.deadsec.ideal.model.db;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String reference;
	private int customer_id;
	private float amount;
	private String state;
	private Date create_date;
	private Timestamp starttimestamp;
	private Timestamp version;
	private Timestamp endtimestamp = java.sql.Timestamp.valueOf("9999-12-31 23:59:59");
	
	public Invoice() {
	}

	public Invoice(String reference, int customer_id, float amount, String state, Timestamp starttimestamp, Date create_date) {
		super();
		this.reference = reference;
		this.customer_id = customer_id;
		this.amount = amount;
		this.create_date = create_date;
		this.state = state;
		this.starttimestamp = starttimestamp;
	}

	public Invoice(int id, String reference, int customer_id, float amount, String state, Date create_date, Timestamp starttimestamp) {
		super();
		this.id = id;
		this.reference = reference;
		this.customer_id = customer_id;
		this.amount = amount;
		this.create_date = create_date;
		this.state = state;
		this.starttimestamp = starttimestamp;
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

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public Timestamp getStarttimestamp() {
		return starttimestamp;
	}

	public void setStarttimestamp(Timestamp starttimestamp) {
		this.starttimestamp = starttimestamp;
	}

	public Timestamp getVersion() {
		return version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}

	public Timestamp getEndtimestamp() {
		return endtimestamp;
	}

	public void setEndtimestamp(Timestamp endtimestamp) {
		this.endtimestamp = endtimestamp;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
