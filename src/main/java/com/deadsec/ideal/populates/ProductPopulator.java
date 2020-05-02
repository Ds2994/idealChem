package com.deadsec.ideal.populates;

import java.util.ArrayList;
import java.util.List;

import com.deadsec.ideal.model.data.Product;
import com.deadsec.ideal.model.db.ProductDb;

public class ProductPopulator {

	public static Product populateProductFromDB(ProductDb data) {
		Product p = new Product();
		if(data != null) {
			p.setCode(data.getCode());
			p.setProductName(data.getProduct_name());
			p.setDescription(data.getDescription());
			p.setCasNumber(data.getCas_number());
			return p;
		} else {
			return null;
		}
	}
	
	public static List<Product> populateProductListFromDB(List<ProductDb> data) {
		List<Product> productList = new ArrayList<Product>();
		
		for(ProductDb entry : data) {
			if(entry != null) {
				productList.add(populateProductFromDB(entry));
			}
		}		
		return productList;
	}
}
