package org.huzair.entities;
import java.util.ArrayList;
import java.util.Iterator;
import org.huzair.report.OrderReport;
import org.huzair.use_cases.CustomerManager;
import org.huzair.use_cases.FarmerManager;

public class Search {
	
	private String topic;
	private String keyword;
	private String[] acceptable_topic= {"farm","order","customer"};
	
	public Search(String topic,String keyword){
		this.topic = topic;
		this.keyword = keyword;
		keyword = keyword.toLowerCase();
	}
	
	public <T> ArrayList<T> determineTopic() {
		if(topic.equalsIgnoreCase(acceptable_topic[0]))
			return (ArrayList<T>) searchFarm();
		else if(topic.equalsIgnoreCase(acceptable_topic[1]))
			return (ArrayList<T>) searchOrder();
		else if(topic.equalsIgnoreCase(acceptable_topic[2]))
			return (ArrayList<T>) searchCustomer();
		return null;	
	}

	private ArrayList<Customer> searchCustomer() {
		CustomerManager cm = new CustomerManager();
		ArrayList<Customer> found = new ArrayList<Customer>();
		ArrayList<Customer> customer = cm.viewAllCustomers();
		Iterator<Customer> c = customer.listIterator();
        while(c.hasNext()) {
            Customer cust = c.next();
            if(cust.match(keyword))
            	found.add(cust);
        }
		return found;
	}	
	private ArrayList<OrderReport> searchOrder() {
		CustomerManager cm = new CustomerManager();
		ArrayList<OrderReport> found = new ArrayList<OrderReport>();
		ArrayList<Order> orders = cm.viewAllOrders();
		Iterator<Order> o = orders.listIterator();
        while(o.hasNext()) {
        	Order order = o.next();
            OrderReport oreport = new OrderReport(order);
            if(order.match(keyword))
            	found.add(oreport);
        }
		return found;		
	}
	public ArrayList<Farmer> searchFarm(){
		FarmerManager fm = new FarmerManager();
		ArrayList<Farmer> found = new ArrayList<Farmer>();
		ArrayList<Farmer> farmers = fm.getAllFarmers();
		Iterator<Farmer> f = farmers.listIterator();
        while(f.hasNext()) {
            Farmer farm = f.next();
            if(farm.match(keyword))
            	found.add(farm);
        }
		return found;
	}
}
