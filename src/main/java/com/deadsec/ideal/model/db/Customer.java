package com.deadsec.ideal.model.db;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String institute;
	private Timestamp starttimestamp;
	private Timestamp version;
	private Timestamp endtimestamp = java.sql.Timestamp.valueOf("9999-12-31 23:59:59");
	
	public Customer() {
	}

	public Customer(String name, String institute, Timestamp starttimestamp) {
		super();
		this.name = name;
		this.institute = institute;
		this.starttimestamp = starttimestamp;
	}

	public Customer(int id, String name, String institute, Timestamp starttimestamp) {
		super();
		this.id = id;
		this.name = name;
		this.institute = institute;
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

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
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
