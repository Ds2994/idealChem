package com.deadsec.ideal.model.data;

public class CustomerJSON {

	private int id;
	private String name;
	private String institute;
	
	public CustomerJSON() {	
	}

	public CustomerJSON(int id, String name, String institute) {
		super();
		this.id = id;
		this.name = name;
		this.institute = institute;
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
}
