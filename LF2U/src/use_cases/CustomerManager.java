package use_cases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import entity.Customer;
import entity.Order;
import boundary_interfaces.CustomerBI;

public class CustomerManager implements CustomerBI{

	private static AtomicInteger atomicInteger = new AtomicInteger();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Order> orders = new ArrayList<Order>();
	private String cancel = "cancelled";
	
	//Creates an account for the customer and returns the customer id
	@Override
	public String createAccount(Customer c) {
		Customer cust = c;
		cust.setCid(atomicInteger.incrementAndGet());
		customers.add(cust);
		int cid_as_int = cust.getCid();
		String cid_as_str = Integer.toString(cid_as_int);
		return cid_as_str;
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
	public String createOrder(int cid, Order o) {
		Customer customer = getCustomerById(cid);
		if(customer!=null){
			Order order = o;
			order.setCid(cid);
			orders.add(order);
			int oid_as_int = order.getOid();
			String oid_as_str = Integer.toString(oid_as_int);
			return oid_as_str;
		}
		return null;
	}
	
	//Returns all orders by customer id
	@Override
	public ArrayList<Order> viewAllOrders(int cid) {
		ArrayList<Order> order_by_cid = new ArrayList<Order>();
		Iterator<Order> o = orders.listIterator();
        while(o.hasNext()) {
            Order order = o.next();
            int order_cid = order.getCid();
            if(order_cid == cid)
            	order_by_cid.add(order);
        }
		return order_by_cid;
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
}


