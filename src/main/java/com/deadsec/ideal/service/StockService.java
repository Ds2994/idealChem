package com.deadsec.ideal.service;

import com.deadsec.ideal.model.data.StockJSON;

public interface StockService {

	public StockJSON getStockForProduct(String code, String packingSize);
}
