package org.huzair.rest;

import java.util.ArrayList;
import java.util.Iterator;
import org.huzair.entities.Order;

public class GET_Order {
private String oid;
private String order_date;
private String planned_delivery_date;
private String actual_delivery_date;
private String status;
private String fid;

public GET_Order(Order o){
	this.oid = o.getOid();
	this.order_date = o.getOrder_date();
	this.planned_delivery_date = o.getPlanned_delivery_date();
	this.actual_delivery_date = o.getActualDate();
	this.status = o.getStatus();
	this.fid = o.getFid();
}

public static ArrayList<GET_Order> allGetOrders(ArrayList<Order> orders){
	ArrayList<GET_Order> getorders = new ArrayList<GET_Order>();
	Iterator<Order> o = orders.listIterator();
    while(o.hasNext()) {
        GET_Order thisorder = new GET_Order(o.next());
        getorders.add(thisorder);
        }
    	return getorders;
}
public static GET_Order getOrder(Order order){
	GET_Order thisorder = new GET_Order(order);
	return thisorder;
	
}
}
