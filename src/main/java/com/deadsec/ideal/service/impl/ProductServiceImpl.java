package com.deadsec.ideal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadsec.ideal.model.data.PriceDetails;
import com.deadsec.ideal.model.data.Product;
import com.deadsec.ideal.model.db.ProductDb;
import com.deadsec.ideal.model.db.Stock;
import com.deadsec.ideal.populates.ProductPopulator;
import com.deadsec.ideal.repository.PackingRepository;
import com.deadsec.ideal.repository.ProductPriceRepository;
import com.deadsec.ideal.repository.ProductRepository;
import com.deadsec.ideal.repository.StockRepository;
import com.deadsec.ideal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	private ProductPriceRepository productPriceRepository;
	private PackingRepository packingRepository;
	private StockRepository stockRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ProductPriceRepository productPriceRepository, 
			PackingRepository packingRepository, StockRepository stockRepository) {
		this.productRepository = productRepository;
		this.productPriceRepository = productPriceRepository;
		this.packingRepository = packingRepository;
		this.stockRepository = stockRepository;
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
	
	public List<Product> getProductDetailsByName(String name) {
		List<Product> products = new ArrayList<Product>();
		try {
			List<ProductDb> productList = productRepository.findProductsByName(name, new Timestamp((new Date()).getTime()));
			
			for(ProductDb product: productList){
				Product p = new Product(product.getCode(), product.getProduct_name(), product.getDescription(), product.getCas_number());
				List<Object[]> companyNameList = productPriceRepository.getCompanyNameByProductId(product.getId());
				
				for(Object[] company: companyNameList) {
					p.setComapanyName((String) company[1]);
					List<Object[]> priceList = productPriceRepository.getPricePackListByProductCompany(product.getId(), (int) company[0]);
					
					List<PriceDetails> detailsList = new ArrayList<PriceDetails>();
					for(Object[] data : priceList){
						Stock stock = stockRepository.getStocksForProduct((Integer) data[0], new Timestamp((new Date()).getTime()));
						if(null != stock) {
							PriceDetails details = new PriceDetails((Integer) data[0], (String) data[2], (float) data[1], stock.getQuantity());
							detailsList.add(details);
						}else {
							PriceDetails details = new PriceDetails((Integer) data[0], (String) data[2], (float) data[1], 0);
							detailsList.add(details);
						}
						
					}
					//Add details list to Product Object
					p.setPriceDetails(detailsList);
					//Add Product List for each Company
					products.add(p);
				}
			}
		}catch(Exception e) {
			return null;
		}
		return products;
	}

	@Override
	public Product getProductDetailsByCode(String code) {

		List<Integer> quantity = new ArrayList<Integer>();
		
		ProductDb product = productRepository.findProductByCode(code, new Timestamp((new Date()).getTime()));
		List<Object[]> priceList = productPriceRepository.getPricePackListByProduct(code, "SRL");
		for(Object[] data : priceList) {
			Stock stock = stockRepository.getStocksForProduct((Integer) data[0], new Timestamp((new Date()).getTime()));
			if(null != stock) {
				quantity.add(stock.getQuantity());
			} else {
				quantity.add(0);
			}
		}
		Product p = ProductPopulator.populateProductDetails(product, priceList, quantity);
		
		return p;
	}

	@Override
	public boolean createProduct(Product product) {

		try {
			//Save Product Table Data
			ProductDb productData = productRepository.save(ProductPopulator.populateDbFromProduct(product));
			int product_id = productData.getId();
			//Save Each Price details against Packing Size
			List<PriceDetails> priceList = product.getPriceDetails();
			for(PriceDetails  entry : priceList) {
				int packing_id = packingRepository.findPackingIdBySize(entry.getSize());
				productPriceRepository.save(ProductPopulator.populateDbFromPrice(product_id, packing_id, 1,
						entry.getPrice()));
			}
			return true;
		} catch(Exception e) {
			return false;
		}		
	}
}
