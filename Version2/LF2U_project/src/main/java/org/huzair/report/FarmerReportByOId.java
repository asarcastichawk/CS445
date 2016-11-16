package org.huzair.report;

import java.util.ArrayList;
import java.util.Iterator;

import org.huzair.boundary_interfaces.CustomerBI;
import org.huzair.boundary_interfaces.FarmerBI;
import org.huzair.entities.Customer;
import org.huzair.entities.Farmer;
import org.huzair.entities.Order;
import org.huzair.entities.OrderDetail;
import org.huzair.use_cases.CustomerManager;
import org.huzair.use_cases.FarmerManager;

public class FarmerReportByOId {

	private String oid;
	private double products_total;
	private double delivery_charge;
	private double order_total;
	private String status;
	private String order_date;
	private String planned_delivery_date;
	private String actual_delivery_date;
	private Customer ordered_by;
	private String delivery_address;
	private String note;
	private ArrayList<OrderDetail> order_detail;

	public FarmerReportByOId(String oid){
		this.oid = oid;
		CustomerBI CM = new CustomerManager();
		FarmerBI FM = new FarmerManager();
		Order order = CM.viewById(oid);
		this.products_total = order.getProductsTotal();
		Farmer farm = FM.viewAccount(order.getFid());
		this.delivery_charge = farm.getDeliveryCharge();
		this.status = order.getStatus();
		this.order_date = order.getActualDate();
		this.planned_delivery_date = order.getPlanned_delivery_date();
		ordered_by = CM.viewAccount(order.getCid());
		ordered_by.setCid(null);
		this.delivery_address = ordered_by.getStreet();
		ordered_by.setStreet(null);
		this.note = order.getDelivery_note();
		this.order_detail = order.getAllDetails();
		
		//int fid = viewFarmersByOid(oid);
		
	}
	/*public int viewFarmerByOid(int oid){
		 CustomerBI Cbi = new CustomerManager();
		 ArrayList<Order> allorders = Cbi.viewAllOrders();
			Iterator<Order> oiterator = allorders.listIterator();
	        while(oiterator.hasNext()) {
	            Order order = oiterator.next();
	            if(order.matchesId(oid))
	            	return order.getFid();
	        }
     }*/
}
