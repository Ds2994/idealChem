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
	
	private int productPrice_id;
	private int warehouse_id;
	private int quantity;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Timestamp deleted_at;
	
	public Stock() {
	}

	public Stock(int productPrice_id, int warehouse_id, int quantity, Timestamp created_at) {
		super();
		this.productPrice_id = productPrice_id;
		this.warehouse_id = warehouse_id;
		this.quantity = quantity;
		this.created_at = created_at;
	}

	public Stock(int id, int productPrice_id, int warehouse_id, int quantity, Timestamp created_at) {
		super();
		this.id = id;
		this.productPrice_id = productPrice_id;
		this.warehouse_id = warehouse_id;
		this.quantity = quantity;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductPrice_id() {
		return productPrice_id;
	}

	public void setProductPrice_id(int productPrice_id) {
		this.productPrice_id = productPrice_id;
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

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public Timestamp getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}
}
