package com.deadsec.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deadsec.ideal.model.db.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	//Fetch quantity in stock by productPrice_id
	@Query(value = "SELECT s.quantity FROM stock s where s.product_price_id = :productPrice_id",
	nativeQuery = true)
	public int getStocksForProduct(@Param("productPrice_id") int productPrice_id); 
	
}
