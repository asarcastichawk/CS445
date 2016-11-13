package org.huzair.report;

import java.util.ArrayList;

import org.huzair.entities.FarmInfo;
import org.huzair.entities.Farmer;
import org.huzair.entities.Order;
import org.huzair.entities.OrderDetail;
import org.huzair.use_cases.FarmerManager;

public class OrderReport {
	private int oid;
	private String order_date;
	private String planned_delivery_date;
	private String actual_delivery_date = "";
	private String status;
	private FarmInfo farm_info;
	ArrayList<OrderDetail> order_detail;
	private String delivery_note;
	private double products_total;
	private double delivery_charge;
	private double order_total;
	
	public OrderReport(Order o){
		this.oid = o.getOid();
		this.order_date = o.getOrder_date();
		this.planned_delivery_date = o.getPlanned_delivery_date();
		this.actual_delivery_date = o.getActualDate();
		this.status = o.getStatus();
		FarmerManager fmanager = new FarmerManager();
		Farmer farm = fmanager.getFarmerById(o.getFid());
		farm_info = farm.getFarmInfo();
		this.order_detail = new ArrayList<OrderDetail>(o.getAllDetails());
		this.delivery_note = o.getDelivery_note();
		this.delivery_charge = farm.getDeliveryCharge();
		this.products_total = o.getProductsTotal();
		this.order_total = products_total + delivery_charge;
	}
	
}
