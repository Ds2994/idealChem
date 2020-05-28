package com.deadsec.ideal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deadsec.ideal.model.data.InvoiceJSON;
import com.deadsec.ideal.repository.InvoiceRepository;
import com.deadsec.ideal.service.InvoiceService;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping("/")
	public ResponseEntity<List<InvoiceJSON>> getInvoiceList() {
		
		List<InvoiceJSON> invoices = invoiceService.getInvoices();
		
		if(invoices == null && invoices.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(invoices);
		}
	}
}
