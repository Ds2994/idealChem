package com.deadsec.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deadsec.ideal.model.db.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{

}
