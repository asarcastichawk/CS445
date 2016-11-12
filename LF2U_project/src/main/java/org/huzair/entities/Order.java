package org.huzair.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
	static AtomicInteger atomicInteger = new AtomicInteger();
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	

	private int oid;
	private int fid;
	private int cid;
	private ArrayList<OrderDetail> detail = new ArrayList<OrderDetail>();
	private String delivery_note;
	private String status;
	private String order_date;
	private String planned_delivery_date;
	private String actual_delivery_date;
	double products_total;
	double order_total;
	public Order(int fid, ArrayList<OrderDetail> detail, String delivery_note)
	{
		this.oid = atomicInteger.incrementAndGet();
		this.setFid(fid);
		this.detail = detail;
		this.setDelivery_note(delivery_note);
		this.setStatus("open");
		
		Date today = Calendar.getInstance().getTime();
		this.setOrder_date(dateFormat.format(today));
		Calendar.getInstance().add(Calendar.DAY_OF_MONTH, 1);
		Date tom = Calendar.getInstance().getTime();
		this.setPlanned_delivery_date(dateFormat.format(tom));
		
	}
	public ArrayList<OrderDetail> getAllDetails()
	{
		return detail;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getOid() {
		return oid;
	}
	
	public boolean matchesId(int oid) {
	    return(oid == this.oid);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActualDate() {
		return actual_delivery_date;
	}
	public void setActualDate(String actual_delivery_date) {
		this.actual_delivery_date = actual_delivery_date;
	}
	public String getDelivery_note() {
		return delivery_note;
	}
	public void setDelivery_note(String delivery_note) {
		this.delivery_note = delivery_note;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getPlanned_delivery_date() {
		return planned_delivery_date;
	}
	public void setPlanned_delivery_date(String planned_delivery_date) {
		this.planned_delivery_date = planned_delivery_date;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public boolean validate() {
		boolean isValid = false;
		if(detail!=null && fid > 0);
			isValid = true;
		Iterator<OrderDetail> o = detail.listIterator();
        while(o.hasNext()) {
            OrderDetail odetail = o.next();
            if(!odetail.validate()){
            	return false;
            }	
	}
        return isValid;
}
}