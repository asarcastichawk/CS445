package org.huzair.report;

import java.util.ArrayList;
import java.util.Iterator;

import org.huzair.boundary_interfaces.CustomerBI;
import org.huzair.entities.Order;
import org.huzair.use_cases.CustomerManager;

public class FarmerReport {

	String frid;
	String name;
	ArrayList<FarmerReportByOId> orders;
	
	public FarmerReport(String frid, String fid){
		orders = new ArrayList<FarmerReportByOId>();
		CustomerBI Cbi = new CustomerManager();
		 ArrayList<Order> allorders = Cbi.viewAllOrders();
			Iterator<Order> oiterator = allorders.listIterator();
	        while(oiterator.hasNext()) {
	            Order order = oiterator.next();
	            if(order.getFid()==fid){
	            	FarmerReportByOId FRT = new FarmerReportByOId(order.getOid());
	            	if(FRT!=null)
	            		orders.add(FRT);
	            }   
	       }
	}
}
