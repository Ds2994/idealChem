package com.deadsec.ideal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadsec.ideal.model.data.CustomerJSON;
import com.deadsec.ideal.model.db.Customer;
import com.deadsec.ideal.populates.CustomerPopulator;
import com.deadsec.ideal.repository.CustomerRepository;
import com.deadsec.ideal.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public List<CustomerJSON> getCustomersByName(String name) {
		List<Customer> customers = new ArrayList<Customer>();
		
		customers = customerRepository.getCustomersByName(name);
		
		if(!customers.isEmpty()) {
			return CustomerPopulator.populateCustomerJSONListfromDB(customers);
		}
		
		return null;
	}

}
