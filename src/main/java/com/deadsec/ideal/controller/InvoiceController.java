package com.deadsec.ideal.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deadsec.ideal.model.data.InvoiceJSON;
import com.deadsec.ideal.service.InvoiceService;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping("/")
	public ResponseEntity<List<InvoiceJSON>> getInvoiceList(@RequestParam("startDate") Optional<String> startDate, @RequestParam("endDate") Optional<String> endDate) {
		
		List<InvoiceJSON> invoices = invoiceService.getInvoices();
		
		if(startDate.isPresent() && endDate.isPresent()) {
			try {
				Date begin = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(startDate.get());
				Date end = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(endDate.get());
				invoices = invoiceService.getInvocesByDate(begin, end);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			invoices = invoiceService.getInvoices();
		}
		
		if(invoices == null || invoices.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(invoices);
		}
	}
}
