package org.huzair.use_cases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.huzair.boundary_interfaces.CustomerBI;
import org.huzair.boundary_interfaces.FarmerBI;
import org.huzair.entities.Customer;
import org.huzair.entities.Farmer;
import org.huzair.entities.Order;
import org.huzair.entities.OrderDetail;
import org.huzair.report.OrderReport;

public class CustomerManager implements CustomerBI{

	private static AtomicInteger atomicInteger = new AtomicInteger();
	private static AtomicInteger orderAtomicInteger = new AtomicInteger();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Order> orders = new ArrayList<Order>();
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	FarmerBI FBi = new FarmerManager();
	private String cancel = "cancelled";
	
	//Creates an account for the customer and returns the customer id
	@Override
	public String createAccount(Customer c) {
		Customer cust = c;
		cust.setCid(Integer.toString(atomicInteger.incrementAndGet()));
		customers.add(cust);
		String cid_as_str = cust.getCid();
		return cid_as_str;
	}
	
	//updates the customer account if found by customer id
	@Override
	public void updateAccount(String cid, Customer c) {
		Customer cust = getCustomerById(cid);
		if(cust!=null)
			cust.setCustomer(c);
		
	}
	
	//Searches customer by id
	public Customer getCustomerById(String cid){
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
	public Customer viewAccount(String cid) {
		Customer customer = getCustomerById(cid);
			return customer;
	}

	//Creates an order if the customer id is found and returns the order id
	@Override
	public String createOrder(String cid, Order o) {
		Customer c = getCustomerById(cid);
		if(c==null)
			return null;
		Farmer farm = FBi.viewAccount(o.getFid());
		if(farm==null)
			return "0";
		ArrayList<String> zipcodes = farm.getDeliversTo();
		if(!zipcodes.contains(c.getZip()))
			return "0";
		
		Order order = new Order(o);
		order.setCid(cid);
		order.setOid(Integer.toString(orderAtomicInteger.incrementAndGet()));
		order.setStatus("open");
		Calendar.getInstance().add(Calendar.DAY_OF_MONTH, 0);
		Date today = Calendar.getInstance().getTime();
		order.setOrder_date(dateFormat.format(today));
		double total = 0;
		Map<String,Double> hashmap = FBi.getHashmap();
		
		ArrayList<OrderDetail> details = order.getAllDetails();
		Iterator<OrderDetail> od = details.listIterator();
        while(od.hasNext()) {
            OrderDetail odetails = od.next();
            double price = 0;
            if(odetails!=null){
            	try{
            	price = hashmap.get(odetails.getFspid());
            	}
            	catch(Exception e){}
            	odetails.setPrice(price);
            }
        }
           /*A ArrayList<StoreProduct> sproducts = FBi.viewStore(order.getFid());
    		Iterator<StoreProduct> s = sproducts.listIterator();
            while(s.hasNext()) {
                StoreProduct product = s.next();
                if(odetails.getFspid()==product.getFspid()){
                	odetails.setPrice(product.getPrice());
                	total = total+odetails.getLineItemTotal();
                }
            }  */
        //}
        order.setProductTotal(total);
        order.setAllDetails(details);
		orders.add(order);
		String oid_as_str = order.getOid();
		return oid_as_str;
	}
	
	//Returns all orders by customer id
	@Override
	public ArrayList<Order> viewAllOrders(String cid) {
		ArrayList<Order> allorders = new ArrayList<Order>();
		Customer cust = getCustomerById(cid);
		if(cust==null)
			return null;
		Iterator<Order> o = orders.listIterator();
        while(o.hasNext()) {
            Order order = o.next();
            String order_cid = order.getCid();
            if(order_cid.equalsIgnoreCase(cid))
            	allorders.add(order);
        }
		return allorders;
	}
	
	//Searches order by order id
	@Override
	public Order viewById(String oid) {
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
	public void cancelOrder(String cid, String oid, String status) {
		if(status.equalsIgnoreCase(cancel)){
			ArrayList<Order> all_orders = viewAllOrders(cid);
			Order order = viewById(oid);
			if(order!=null&&all_orders.contains(order))
				order.setStatus(cancel);
	        }
		}
	
	//View order report
	@Override
	public OrderReport viewOrderReport(String oid) {
		Order o = viewById(oid);
		OrderReport oreport = new OrderReport(o);
		return oreport;
	}
	
	//View all orders
	public ArrayList<Order> viewAllOrders(){
		return orders;
	}
	
	//View all customers
	public ArrayList<Customer> viewAllCustomers(){
		return customers;
	}
	@Override
	public void setNull(){
		customers.clear();
		orders.clear();
		atomicInteger.set(0);
		orderAtomicInteger.set(0);
	}
	
}
