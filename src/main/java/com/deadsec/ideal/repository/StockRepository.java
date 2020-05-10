package com.deadsec.ideal.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deadsec.ideal.model.db.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	//Fetch quantity in stock by productPrice_id
	@Query(value = "SELECT * FROM stock s WHERE s.product_price_id = :productPrice_id AND s.starttimestamp <= :timestamp",		
	nativeQuery = true)
	Stock getStocksForProduct(@Param("productPrice_id") int productPrice_id, @Param("timestamp") Timestamp timestamp);
	
	//Fetch id and quantity for warehouse
	@Query(value = "SELECT s.product_price_id , s.quantity FROM stock s "
			+ "JOIN warehouse w ON s.warehouse_id = w.id WHERE w.id = :id",
	nativeQuery = true)
	public List<Object[]> getPPIdquantityList(@Param("id") int id);
	
	//Update existing quantity
	@Transactional
	@Modifying
	@Query(value = "UPDATE stock s set s.quantity = :qty where s.id = :id",
	nativeQuery = true)
	void updateStockQuantity(@Param("id") int id, @Param("qty") int qty);
	
}
