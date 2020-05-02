package com.deadsec.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deadsec.ideal.model.db.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

	@Query(value = "SELECT c.id FROM company c WHERE c.company_name = :name",
	nativeQuery = true)
	int findCompanyIdByName(@Param("name") String name);
}
