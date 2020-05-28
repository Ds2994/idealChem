package com.deadsec.ideal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deadsec.ideal.model.db.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

	//Fetch latest 10 invoices always
	@Query(value = "SELECT inv.id, inv.reference, cust.name, inv.create_date, inv.amount, inv.state " 
					+"FROM ideal.invoice inv "
					+"JOIN ideal.customer cust "
					+"ON inv.customer_id = cust.id "
					+"ORDER BY create_date DESC LIMIT 10 ",
	nativeQuery = true)
	public List<Object[]> getLatestInvoices();
}
