package com.deadsec.ideal.service;

import java.util.List;

import com.deadsec.ideal.model.data.CustomerJSON;

public interface CustomerService {

	List<CustomerJSON> getCustomersByName(String name);
	CustomerJSON saveCustomer(CustomerJSON customer);
}
