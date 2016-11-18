package org.huzair.entities;
import java.util.ArrayList;
import java.util.Iterator;

public class Order {
	
	private String oid;
	private String fid;
	private String cid;
	private ArrayList<OrderDetail> order_detail = new ArrayList<OrderDetail>();
	private String delivery_note;
	private String status;
	private String order_date;
	private String planned_delivery_date;
	private String actual_delivery_date;
	private double products_total;

	public Order(String fid, ArrayList<OrderDetail> order_detail, String delivery_note)
	{
		this.fid = fid;
		this.order_detail = new ArrayList<OrderDetail>(order_detail);
		this.delivery_note = delivery_note;	
		this.products_total = getProductsTotal();
	}
	
	public Order(Order another) {
	    this.fid = another.getFid();
	    this.order_detail = new ArrayList<OrderDetail>(another.getAllDetails());
	    this.delivery_note = another.getDelivery_note();
	    this.status = another.getStatus();
	    this.order_date = another.getOrder_date();
	    this.planned_delivery_date = another.getPlanned_delivery_date();
	  }
	
	public void setOid(String oid){
		this.oid = oid;
	}
	public ArrayList<OrderDetail> getAllDetails()
	{
		return order_detail;
	}
	public void setAllDetails(ArrayList<OrderDetail> order_detail)
	{
		this.order_detail = order_detail;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getOid() {
		return oid;
	}
	public boolean matchesId(String oid) {
	    return(this.oid.equalsIgnoreCase(oid));
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
	public void setProductTotal(double products_total){
		this.products_total = products_total;
	}
	public double getProductTotal(){
		return products_total;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
		int store = Integer.parseInt(order_date) + 1;
		this.planned_delivery_date = Integer.toString(store);
	}
	public String getPlanned_delivery_date() {
		return planned_delivery_date;
	}
	public void setPlanned_delivery_date(String planned_delivery_date) {
		this.planned_delivery_date = planned_delivery_date;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	
	public double getProductsTotal(){
		if(this.order_detail!=null){	
			Iterator<OrderDetail> o = order_detail.listIterator();
			while(o.hasNext()) {
				OrderDetail odetail = o.next();
				products_total += odetail.getLineItemTotal();	
			}
		}
		return products_total;
	}
	
	public boolean validate() {
		boolean isValid = this.fid!=null;
		if(this.order_detail!=null){	
			Iterator<OrderDetail> o = order_detail.listIterator();
			while(o.hasNext()) {
				OrderDetail odetail = o.next();
				if(!odetail.validate())
					return false;
			}
        }
		return isValid;
	}
	
	public boolean statusValidate() {
		String status = this.status;
		return status.equalsIgnoreCase("Cancelled");
			
	}

	public boolean match(String keyword){
		Iterator<OrderDetail> o = order_detail.listIterator();
        while(o.hasNext()) {
            OrderDetail odetail = o.next();
            if(odetail.match(keyword))
            	return true;}
        String all = this.toString();
        return all.matches(".*\\b" + keyword + "\\b.*");
	}
	
	public String toString(){
		return	 (oid+" "+cid+" "+fid+" "+delivery_note+" "+status+" "
				 +order_date+" "+planned_delivery_date+" "+actual_delivery_date
				 +" "+products_total).toLowerCase();
	}
}