package com.deadsec.ideal.service.impl;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadsec.ideal.model.data.Product;
import com.deadsec.ideal.model.db.ProductDb;
import com.deadsec.ideal.populates.ProductPopulator;
import com.deadsec.ideal.repository.ProductPriceRepository;
import com.deadsec.ideal.repository.ProductRepository;
import com.deadsec.ideal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	private ProductPriceRepository productPriceRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ProductPriceRepository productPriceRepository) {
		this.productRepository = productRepository;
		this.productPriceRepository = productPriceRepository;
	}

	@Override
	public Product getProductByCode(String code) {
		
		ProductDb dbData = productRepository.findProductByCode(code, new Timestamp((new Date()).getTime()));
		Product product = ProductPopulator.populateProductFromDB(dbData);
		
		return product;
	}

	@Override
	public List<Product> getProductsByName(String name) {
		
		List<ProductDb> dbData = productRepository.findProductsByName(name, new Timestamp((new Date()).getTime()));
		List<Product> productList = ProductPopulator.populateProductListFromDB(dbData);
		
		return productList;
	}

	@Override
	public Product getProductDetailsByCode(String code) {
		
		ProductDb product = productRepository.findProductByCode(code, new Timestamp((new Date()).getTime()));
		List<Object[]> priceList = productPriceRepository.getPricePackListByProduct(code, "SRL");
		
		Product p = ProductPopulator.populateProductDetails(product, priceList);
		
		return p;
	}
}
