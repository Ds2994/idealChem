package com.deadsec.ideal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deadsec.ideal.model.db.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	//Fetching all the customers by name
	@Query(value = "SELECT * FROM customer c WHERE c.name LIKE %:name%",
	nativeQuery = true)
	List<Customer> getCustomersByName(@Param("name") String name);
	
}
