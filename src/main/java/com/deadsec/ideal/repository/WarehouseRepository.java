package com.deadsec.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deadsec.ideal.model.db.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{

}
