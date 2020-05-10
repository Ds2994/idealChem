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
