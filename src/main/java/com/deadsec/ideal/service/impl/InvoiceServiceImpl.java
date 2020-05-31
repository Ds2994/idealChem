package com.deadsec.ideal.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadsec.ideal.model.data.InvoiceJSON;
import com.deadsec.ideal.populates.InvoicePopulator;
import com.deadsec.ideal.repository.InvoiceRepository;
import com.deadsec.ideal.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	public List<InvoiceJSON> getInvoices() {
		List<InvoiceJSON> invoices = new ArrayList<InvoiceJSON>();
		try {
			List<Object[]> dbData = invoiceRepository.getLatestInvoices();
			
			if(dbData != null && !dbData.isEmpty()) {
				for(Object[] entry : dbData) {
					InvoiceJSON invoice = InvoicePopulator.populateInvoiceJSONfromData(entry);
					invoices.add(invoice);
				}
				return invoices;
			}
		}catch(Exception e) {
			return null;
		}		
		return null;
	}

	@Override
	public List<InvoiceJSON> getInvocesByDate(Date begin, Date end) {
		List<InvoiceJSON> invoices = new ArrayList<InvoiceJSON>();
		try {
			List<Object[]> dbData = invoiceRepository.getLatestInvoicesByDate(new java.sql.Date(begin.getTime()), new java.sql.Date(end.getTime()));
			
			if(dbData != null && !dbData.isEmpty()) {
				for(Object[] entry : dbData) {
					InvoiceJSON invoice = InvoicePopulator.populateInvoiceJSONfromData(entry);
					invoices.add(invoice);
				}
				return invoices;
			}
		}catch(Exception e) {
			return null;
		}		
		return null;
	}
}
