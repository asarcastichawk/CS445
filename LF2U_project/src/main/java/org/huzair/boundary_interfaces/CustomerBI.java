package org.huzair.boundary_interfaces;
import org.huzair.entities.Customer;
import org.huzair.entities.Order;
import org.huzair.report.OrderReport;

import java.util.ArrayList;


public interface CustomerBI {
	public String createAccount(Customer c);
	public void updateAccount(String cid,Customer c);
	public Customer viewAccount(String cid);
	public String createOrder(String cid, Order o);
	public ArrayList<Order> viewAllOrders(String cid);
	public Order viewById(String oid);
	public OrderReport viewOrderReport(String oid);
	public void cancelOrder(String cid, String oid, String status);
	public ArrayList<Order> viewAllOrders();
	public ArrayList<Customer> viewAllCustomers();
	void setNull();
}
