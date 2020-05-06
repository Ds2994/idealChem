package com.deadsec.ideal.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deadsec.ideal.model.db.ProductDb;

@Repository
public interface ProductRepository extends JpaRepository<ProductDb, Integer>{

	//Fetching Product by Code
	@Query(value = "SELECT * FROM product p WHERE p.code = :code AND p.created_at <= :timestamp",
	nativeQuery = true)
	ProductDb findProductByCode(@Param("code") String code, @Param("timestamp") Timestamp timestamp);
	
	//Fetching Product Name by Code
	@Query(value = "SELECT p.product_name FROM product p WHERE p.code = :code",
	nativeQuery = true)
	String findNameByCode(@Param("code") String code);
	
	//Fetching List of Products by Name
	@Query(value = "SELECT * FROM product p WHERE p.product_name LIKE %:name% AND p.created_at <= :timestamp",
	nativeQuery = true)
	List<ProductDb> findProductsByName(@Param("name") String name, @Param("timestamp") Timestamp timestamp);
}
