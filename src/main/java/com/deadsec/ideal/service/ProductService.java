package com.deadsec.ideal.service;

import java.util.List;

import com.deadsec.ideal.model.data.Product;

public interface ProductService {

	public Product getProductByCode(String code);
	
	public List<Product> getProductsByName(String name);
	
	public Product getProductDetailsByCode(String code);
	
	public boolean createProduct(Product product);
}
