package org.huzair.use_cases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.huzair.boundary_interfaces.CustomerBI;
import org.huzair.entities.Customer;
import org.huzair.entities.Farmer;
import org.huzair.entities.Order;
import org.huzair.entities.Store;
import org.huzair.entities.StoreProduct;
import org.huzair.report.OrderReport;


public class CustomerManager implements CustomerBI{

	private static AtomicInteger atomicInteger = new AtomicInteger();
	private static AtomicInteger orderAtomicInteger = new AtomicInteger();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Order> orders = new ArrayList<Order>();
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	private String cancel = "cancelled";
	
	//Creates an account for the customer and returns the customer id
	@Override
	public int createAccount(Customer c) {
		Customer cust = c;
		cust.setCid(atomicInteger.incrementAndGet());
		customers.add(cust);
		int cid_as_int = cust.getCid();
		return cid_as_int;
	}
	
	//updates the customer account if found by customer id
	@Override
	public void updateAccount(int cid, Customer c) {
		Customer cust = getCustomerById(cid);
		if(cust!=null){
		cust.setCustomer(c);
		}
	}
	
	//Searches customer by id
	public Customer getCustomerById(int cid){
		Iterator<Customer> c = customers.listIterator();
        while(c.hasNext()) {
            Customer customer = c.next();
            if(customer.matchesId(cid))
            	return customer;
        }
		return null;
	}

	//Returns customer account by id
	@Override
	public Customer viewAccount(int cid) {
		Customer customer = getCustomerById(cid);
		if(customer!= null)
			return customer;
		return null;
		
	}

	//Creates an order if the customer id is found and returns the order id
	@Override
	public int createOrder(int cid, Order o) {
		if(getCustomerById(cid)==null)
			return 0;
		Order order = new Order(o);
		order.setCid(cid);
		order.setOid(orderAtomicInteger.incrementAndGet());
		order.setStatus("open");
		Date today = Calendar.getInstance().getTime();
		order.setOrder_date(dateFormat.format(today));
		Calendar.getInstance().add(Calendar.DAY_OF_MONTH, 1);
		Date tom = Calendar.getInstance().getTime();
		order.setPlanned_delivery_date(dateFormat.format(tom));
		orders.add(order);
		int oid_as_int = order.getOid();
		return oid_as_int;
		
	}
	
	//Returns all orders by customer id
	@Override
	public ArrayList<Order> viewAllOrders(int cid) {
		ArrayList<Order> allorders = new ArrayList<Order>();
		Customer cust = getCustomerById(cid);
		if(cust==null)
			return null;
		Iterator<Order> o = orders.listIterator();
        while(o.hasNext()) {
            Order order = o.next();
            int order_cid = order.getCid();
            if(order_cid == cid)
            	allorders.add(order);
        }
		return allorders;
	}
	//Searches order by order id
	@Override
	public Order viewById(int oid) {
		Iterator<Order> o = orders.listIterator();
        while(o.hasNext()) {
            Order order = o.next();
            if(order.matchesId(oid))
            	return order;
        }
		return null;
	}
	//Cancels order using order and customer id if instruction is "cancelled"
	@Override
	public void cancelOrder(int cid, int oid, String status) {
		if(status.equalsIgnoreCase(cancel)){
			ArrayList<Order> all_orders = viewAllOrders(cid);
			Order order = viewById(oid);
			if(all_orders.contains(order))
				order.setStatus(cancel);
	        }
		}

	@Override
	public OrderReport viewOrderReport(int oid) {
		Order o = viewById(oid);
		OrderReport oreport = new OrderReport(o);
		return oreport;
	}
}


