package com.deadsec.ideal.populates;

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
}
