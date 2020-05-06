package com.deadsec.ideal.populates;

import com.deadsec.ideal.model.data.StockJSON;

public class StockPopulator {

	public static StockJSON populateStockJSONFromDb(String code, String name, String packSize, int quantity) {
		return new StockJSON(code, name, packSize, quantity);
	}
}
