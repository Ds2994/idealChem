package com.deadsec.ideal.service.impl;

import java.util.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadsec.ideal.model.data.Product;
import com.deadsec.ideal.model.db.ProductDb;
import com.deadsec.ideal.populates.ProductPopulator;
import com.deadsec.ideal.repository.ProductRepository;
import com.deadsec.ideal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product getProductByCode(String code) {
		
		ProductDb dbData = productRepository.findProductByCode(code, new Timestamp((new Date()).getTime()));
		Product product = ProductPopulator.populateProductFromDB(dbData);
		
		return product;
	}
	
	
}
