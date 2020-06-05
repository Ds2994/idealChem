package com.deadsec.ideal.service.impl;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deadsec.ideal.model.data.InvoiceJSON;
import com.deadsec.ideal.model.db.Invoice;
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

	@Override
	public InvoiceJSON createInvoice(InvoiceJSON invoice) {
		
		if(invoice != null) {
			try {
				String reference = calculateNewReference(invoiceRepository.getLatestInvoiceReference());
				
				Invoice invoiceDbModel = new Invoice(reference, invoice.getCustomerId(), invoice.getAmount(),
						invoice.getState(), new Timestamp((new Date()).getTime()),
						new java.sql.Date(invoice.getCreateDate().getTime()));
				
				invoiceDbModel.setVersion(new Timestamp((new Date()).getTime()));
				
				invoiceDbModel = invoiceRepository.save(invoiceDbModel);
				
				return new InvoiceJSON(invoiceDbModel.getId(), invoiceDbModel.getReference(), invoice.getName(),
						invoiceDbModel.getCreate_date(), invoiceDbModel.getAmount(), invoiceDbModel.getState());
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	private String calculateNewReference(String latestInvoiceReference) {
		System.out.println("Old Reference - " + latestInvoiceReference);
		String [] splitData = latestInvoiceReference.split("-");
		System.out.println(splitData[0]);
		int trailer = Integer.parseInt(splitData[1]);
		
		if(trailer < 9999) {
			trailer++;
			String s = "" + trailer;
			while(s.length()<4) {
				s = "0" + s;
			}
			return splitData[0] + "-" + s;
		}
		return null;
	}
}
