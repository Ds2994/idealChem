package com.deadsec.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deadsec.ideal.model.db.Packing;

@Repository
public interface PackingRepository extends JpaRepository<Packing, Integer>{

}
