package com.deadsec.ideal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deadsec.ideal.model.data.Product;
import com.deadsec.ideal.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/code/{code}")
	public ResponseEntity<Product> getProductByCode(@PathVariable("code") String code) {
		
		Product product = productService.getProductByCode(code);
		
		if(product == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(product);
		}
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Product>> getProductsByName(@PathVariable("name") String name) {
		
		List<Product> products = productService.getProductsByName(name);
		
		if(products == null || products.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(products);
		}
	}
	
	@GetMapping("/details/{code}")
	public ResponseEntity<Product> getProductDetails(@PathVariable("code") String code) {
		Product product = productService.getProductDetailsByCode(code);
		
		if(product == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(product);
		}
	}
	
	@GetMapping("/details/name/{name}")
	public ResponseEntity<List<Product>> getProductDetailsByName(@PathVariable("name") String name) {
		List<Product> products = productService.getProductDetailsByName(name);
		
		if(products == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(products);
		}
	}
	
	@PostMapping("/details")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		boolean result = productService.createProduct(product);
		
		if(result) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.badRequest().build();
		}
		
	}
}
