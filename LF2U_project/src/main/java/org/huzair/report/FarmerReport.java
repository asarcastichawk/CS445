package org.huzair.report;

import java.util.ArrayList;

import org.huzair.entities.Customer;
import org.huzair.entities.Order;
import org.huzair.entities.OrderDetail;

public class FarmerReport {

	private int frid;
	private String name;
	
	public FarmerReport(int fid, int frid,Order o){
		FarmerReportType frt = new FarmerReportType();
		this.name = frt.getName(frid);
		Order orders = o;
		//Customer ordered_by = c;
		//String delivery_address = ordered_by.getStreet();
		
		
	}


	}
	

