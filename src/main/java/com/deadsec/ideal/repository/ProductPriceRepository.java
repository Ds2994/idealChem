package com.deadsec.ideal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deadsec.ideal.model.db.ProductPrice;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer>{

	@Query(value = "SELECT pp.price, pk.packing_size FROM productprice pp "
			+ "JOIN product p ON p.id = pp.product_id "
			+ "JOIN packing pk ON pk.id = pp.packing_id "
			+ "JOIN company c ON c.id = pp.company_id "
			+ "WHERE p.code = :code AND c.company_name = :cName ",
	nativeQuery = true)
	public List<Object[]> getPricePackListByProduct(@Param("code") String code, @Param("cName") String cName);
	
	//Fetch productPrice_id by code, size and company
	@Query(value = "SELECT pp.id FROM productprice pp "
			+ "JOIN product p ON p.id = pp.product_id "
			+ "JOIN packing pk ON pk.id = pp.packing_id "
			+ "JOIN company c ON c.id = pp.company_id "
			+ "WHERE p.code = :code AND pk.packing_size = :size AND c.company_name = :cName ",
	nativeQuery = true)
	public int getProductPriceIdByProduct(@Param("code") String code, @Param("size") String size, @Param("cName") String cName);
}
