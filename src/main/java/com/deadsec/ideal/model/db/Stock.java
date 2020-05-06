package com.deadsec.ideal.model.db;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int product_price_id;
	private int warehouse_id;
	private int quantity;
	private Timestamp starttimestamp;
	private Timestamp version;
	private Timestamp endtimestamp;
	
	public Stock() {
	}

	public Stock(int product_price_id, int warehouse_id, int quantity, Timestamp starttimestamp) {
		super();
		this.product_price_id = product_price_id;
		this.warehouse_id = warehouse_id;
		this.quantity = quantity;
		this.starttimestamp = starttimestamp;
	}

	public Stock(int id, int productPrice_id, int warehouse_id, int quantity, Timestamp starttimestamp) {
		super();
		this.id = id;
		this.product_price_id = productPrice_id;
		this.warehouse_id = warehouse_id;
		this.quantity = quantity;
		this.starttimestamp = starttimestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductPrice_id() {
		return product_price_id;
	}

	public void setProductPrice_id(int productPrice_id) {
		this.product_price_id = productPrice_id;
	}

	public int getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
}
