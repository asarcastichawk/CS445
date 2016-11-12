package org.huzair.boundary_interfaces;
import org.huzair.entities.Customer;
import org.huzair.entities.Order;

import java.util.ArrayList;


public interface CustomerBI {
	int createAccount(Customer c);
	void updateAccount(int cid,Customer c);
	Customer viewAccount(int cid);
	int createOrder(int cid, Order o);
	ArrayList<Order> viewAllOrders(int cid);
	Order viewById(int oid);
	void cancelOrder(int cid, int oid, String status);
	
}
