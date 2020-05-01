package com.deadsec.ideal.model.db;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productprice")
public class ProductPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int product_id;
	private int packing_id;
	private int company_id;
	private float price;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Timestamp deleted_at;
	
	public ProductPrice() {
		
	}

	public ProductPrice(int product_id, int packing_id, int company_id, float price) {
		super();
		this.product_id = product_id;
		this.packing_id = packing_id;
		this.company_id = company_id;
		this.price = price;
	}

	public ProductPrice(int id, int product_id, int packing_id, int company_id, float price) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.packing_id = packing_id;
		this.company_id = company_id;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getPacking_id() {
		return packing_id;
	}

	public void setPacking_id(int packing_id) {
		this.packing_id = packing_id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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