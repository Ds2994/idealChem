package com.deadsec.ideal.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadsec.ideal.model.data.StockJSON;
import com.deadsec.ideal.model.db.Stock;
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
				Stock stock = stockRepository.getStocksForProduct(id, new Timestamp((new Date()).getTime()));
				jsonResponse = StockPopulator.populateStockJSONFromDb(code, productName, packingSize, stock.getQuantity());
			}
		} catch(Exception ex) {
			return null;
		}
		return jsonResponse;
	}

	@Override
	public List<StockJSON> getStockForWarehouse(int id) {
		List<StockJSON> stockList = new ArrayList<StockJSON>();
		try {
			List<Object[]> dbData = stockRepository.getPPIdquantityList(id);
			if(null != dbData && !dbData.isEmpty()){
				for(Object[] entry : dbData) {
					String size = productPriceRepository.findPackSizeByPPId((int) entry[0]);
					String name = productPriceRepository.findProductNameById((int) entry[0]);
					String code = productPriceRepository.findCodeById((int) entry[0]);
					StockJSON stock = new StockJSON(code, name, size,(int) entry[1]);
					stockList.add(stock);
				}
			}
		} catch(Exception ex) {
			return null;
		}
		return stockList;
	}

}
