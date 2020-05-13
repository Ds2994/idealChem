package com.deadsec.ideal.populates;

import java.util.ArrayList;
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
}
