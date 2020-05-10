package com.deadsec.ideal.populates;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.deadsec.ideal.model.data.PriceDetails;
import com.deadsec.ideal.model.data.Product;
import com.deadsec.ideal.model.db.ProductDb;
import com.deadsec.ideal.model.db.ProductPrice;
import com.deadsec.ideal.model.db.Stock;
import com.deadsec.ideal.repository.StockRepository;

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
	
	public static ProductDb populateDbFromProduct(Product product) {
		ProductDb data = new ProductDb();
		
		if(product != null) {
			data.setCode(product.getCode());
			data.setCas_number(product.getCasNumber());
			data.setProduct_name(product.getProductName());
			data.setDescription(product.getDescription());
			data.setCreated_at(new Timestamp((new Date()).getTime()));
			data.setUpdated_at(new Timestamp((new Date()).getTime()));
			return data;
		}
		return null;
	}
	
	public static ProductPrice populateDbFromPrice(int prod_id, int pack_id, int comp_id, float price) {
		ProductPrice pp = new ProductPrice();
		
		pp.setProduct_id(prod_id);
		pp.setPacking_id(pack_id);
		pp.setCompany_id(comp_id);
		pp.setPrice(price);
		pp.setCreated_at(new Timestamp((new Date()).getTime()));
		pp.setUpdated_at(new Timestamp((new Date()).getTime()));
		
		return pp;
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

	public static Product populateProductDetails(ProductDb product, List<Object[]> priceList, List<Integer> quantity) {
		List<PriceDetails> priceDetails = new ArrayList<PriceDetails>();
		Product p = null;
		if((priceList != null && !priceList.isEmpty()) 
				&& product != null) {
			int i=0;
			for(Object[] entry : priceList) {
				PriceDetails price = new PriceDetails();
				price.setQuantity(quantity.get(i));
				price.setSize((String) entry[2]);
				price.setPrice((float) entry[1]);
				priceDetails.add(price);
				i++;
			}
			p = new Product(product.getCode(), product.getProduct_name(),
					product.getDescription(), product.getCas_number(), priceDetails);
		}
		return p;
	}
}
