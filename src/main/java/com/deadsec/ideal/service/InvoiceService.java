package com.deadsec.ideal.service;

import java.util.List;

import com.deadsec.ideal.model.data.InvoiceJSON;

public interface InvoiceService {

	List<InvoiceJSON> getInvoices();
}
