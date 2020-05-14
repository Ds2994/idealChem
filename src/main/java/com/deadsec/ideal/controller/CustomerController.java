package com.deadsec.ideal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deadsec.ideal.model.data.CustomerJSON;
import com.deadsec.ideal.model.data.StockJSON;
import com.deadsec.ideal.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<CustomerJSON>> getCustomersbyName(@PathVariable("name") String name) {
		List<CustomerJSON> response = new ArrayList<CustomerJSON>();
		
		response = customerService.getCustomersByName(name);
		
		if(response == null || response.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<CustomerJSON> createCustomer(@RequestBody CustomerJSON customer) {
		CustomerJSON response = null;
		
		response = customerService.saveCustomer(customer);
		
		if(response == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(response);
		}
	}
}
