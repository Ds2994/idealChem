package com.deadsec.ideal.service;

import java.util.List;

import com.deadsec.ideal.model.data.StockJSON;

public interface StockService {

	public StockJSON getStockForProduct(String code, String packingSize);
	
	public List<StockJSON> getStockForWarehouse(int id);
}
