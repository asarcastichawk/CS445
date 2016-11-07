package reports;

import use_cases.CustomerManager;
import use_cases.FarmerManager;
import entity.Customer;
import entity.FarmInfo;
import entity.Farmer;
import entity.Order;
import entity.OrderDetail;

public class CompleteOrderReport {
	private int oid;
	private String order_date;
	private String planned_delivery_date;
	private String actual_delivery_date;
	private String status;
	private Customer customer_info;
	private FarmInfo farm_info;
	private OrderDetail order_detail;
	private String delivery_note;
	private double products_total;
	private double delivery_charge;
	private double order_total;
	private CustomerManager cm;
	private FarmerManager fm;
	
	public CompleteOrderReport(Order o){
		this.oid = o.getOid();
		//this.order_date = o.getOrderDate();
		//this.planned_delivery_date = o.getPlannedDeliveryDate();
		this.actual_delivery_date = o.getActualDate();
		this.status = o.getStatus();
		this.delivery_note = o.getDelivery_note();
		//this.products_total = o.productsTotal();
		//this.delivery_charge = o.deliveryCharge();
		//this.order_total = o.orderTotal();
		int cid = o.getCid();
		customer_info = cm.getCustomerById(cid);
		
}
}