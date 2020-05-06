package com.deadsec.ideal.model.db;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse")
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String address;
	private Timestamp starttimestamp;
	private Timestamp version;
	private Timestamp endtimestamp;
	
	public Warehouse() {	
	}

	public Warehouse(String name, String address, Timestamp starttimestamp) {
		super();
		this.name = name;
		this.address = address;
		this.starttimestamp = starttimestamp;
	}

	public Warehouse(int id, String name, String address, Timestamp starttimestamp) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.starttimestamp = starttimestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
