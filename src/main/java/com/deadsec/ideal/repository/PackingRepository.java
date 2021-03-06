package com.deadsec.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deadsec.ideal.model.db.Packing;

@Repository
public interface PackingRepository extends JpaRepository<Packing, Integer>{

	@Query(value = "SELECT pk.id FROM packing pk WHERE pk.packing_size = :size",
	nativeQuery = true)
	int findPackingIdBySize(@Param("size") String size);
}
