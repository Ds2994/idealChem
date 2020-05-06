package com.deadsec.ideal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadsec.ideal.model.data.StockJSON;
import com.deadsec.ideal.populates.StockPopulator;
import com.deadsec.ideal.repository.ProductPriceRepository;
import com.deadsec.ideal.repository.ProductRepository;
import com.deadsec.ideal.repository.StockRepository;
import com.deadsec.ideal.service.StockService;

@Service
public class StockServiceImpl implements StockService{

	private ProductPriceRepository productPriceRepository;
	private StockRepository stockRepository;
	private ProductRepository productRepository;
	
	@Autowired
	public StockServiceImpl(ProductPriceRepository productPriceRepository, StockRepository stockRepository, ProductRepository productRepository) {
		super();
		this.productPriceRepository = productPriceRepository;
		this.stockRepository = stockRepository;
		this.productRepository = productRepository;
	}

	@Override
	public StockJSON getStockForProduct(String code, String packingSize) {
		StockJSON jsonResponse = new StockJSON();
		try {
			int id = productPriceRepository.getProductPriceIdByProduct(code, packingSize, "SRL");
			String productName = productRepository.findNameByCode(code);
			if(0 != id) {
				int quantity = stockRepository.getStocksForProduct(id);
				jsonResponse = StockPopulator.populateStockJSONFromDb(code, productName, packingSize, quantity);
			}
		} catch(Exception ex) {
			return null;
		}
		return jsonResponse;
	}

}
