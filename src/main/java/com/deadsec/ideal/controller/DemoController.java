package com.deadsec.ideal.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deadsec.ideal.model.data.Test;
import com.deadsec.ideal.model.db.Packing;
import com.deadsec.ideal.model.data.Product;
import com.deadsec.ideal.repository.PackingRepository;
import com.deadsec.ideal.repository.ProductRepository;

@RestController
public class DemoController {

	@Autowired
	private PackingRepository packingRepository;
	
	@GetMapping("/product")
    public ResponseEntity<Product> product(){
        Product p = new Product("1234", "Ethyl Alcohol", "", "[1234-56-7]");
        return ResponseEntity.ok(p);
    }
	
	@GetMapping("/test")
	public ResponseEntity<Test> read() {
		Test t = new Test("Deb", 26);
		return ResponseEntity.ok(t);
	}
	
	@PostMapping("/")
	public ResponseEntity<Test> create(@RequestBody Test student) {
		Test t2 = student;
		if (t2 == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(t2);
		}
	}
}
