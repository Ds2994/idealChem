package com.deadsec.ideal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deadsec.ideal.model.db.Product;
import com.deadsec.ideal.repository.ProductRepository;

@RestController
public class DemoController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/product")
    public List<Product> index(){
        return productRepository.findAll();
    }
	
}
