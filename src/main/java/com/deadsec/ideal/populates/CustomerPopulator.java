package com.deadsec.ideal.populates;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.deadsec.ideal.model.data.CustomerJSON;
import com.deadsec.ideal.model.db.Customer;

public class CustomerPopulator {

	public static List<CustomerJSON> populateCustomerJSONListfromDB(List<Customer> data) {
		List<CustomerJSON> customers = new ArrayList<CustomerJSON>();
		
		for(Customer c : data) {
			CustomerJSON json = new CustomerJSON(c.getId(), c.getName(), c.getInstitute());
			customers.add(json);
		}
		
		return customers;
	}

	public static Customer populateDBFromCustomerJSON(CustomerJSON customer) {
		Customer c = null;
		if(customer != null) {
			c = new Customer(customer.getName(), customer.getInstitute(), new Timestamp((new Date()).getTime()));
			c.setVersion(new Timestamp((new Date()).getTime()));
			return c;
		}
		return null;
	}

	public static CustomerJSON populateCustomerJSONFromDB(Customer data) {
		if(data != null) {
			return new CustomerJSON(data.getId(), data.getName(), data.getInstitute());
		}	
		return null;
	}
}
