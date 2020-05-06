package com.deadsec.ideal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deadsec.ideal.model.data.StockJSON;
import com.deadsec.ideal.service.StockService;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@GetMapping()
	public ResponseEntity<StockJSON> getStockByProduct(@RequestParam(name = "code") String code, 
			@RequestParam(name = "pack") String packSize) {
		StockJSON jsonResponse = new StockJSON();
		
		jsonResponse = stockService.getStockForProduct(code, packSize);
		
		if(jsonResponse == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(jsonResponse);
		}
		
	}
}
