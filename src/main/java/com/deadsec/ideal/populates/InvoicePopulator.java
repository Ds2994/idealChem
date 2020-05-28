package com.deadsec.ideal.populates;

import java.sql.Date;

import com.deadsec.ideal.model.data.InvoiceJSON;

public class InvoicePopulator {

	public static InvoiceJSON populateInvoiceJSONfromData(Object[] entry) {
		
		if(entry != null) {
			return (new InvoiceJSON((int) entry[0] , 
					(String) entry[1], (String) entry[2], 
					(Date) entry[3], (float) entry[4], 
					(String) entry[5]));
		}
		return null;
	}

}
