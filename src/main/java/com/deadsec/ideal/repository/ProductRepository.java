package com.deadsec.ideal.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deadsec.ideal.model.db.ProductDb;

@Repository
public interface ProductRepository extends JpaRepository<ProductDb, Integer>{

	@Query(value = "SELECT * FROM product p WHERE p.code = :code AND p.created_at <= :timestamp",
	nativeQuery = true)
	ProductDb findProductByCode(@Param("code") String code, @Param("timestamp") Timestamp timestamp);
}
