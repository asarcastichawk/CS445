package boundary_interfaces;



import java.util.ArrayList;

import entity.Customer;
import entity.Order;

public interface CustomerBI {
	String createAccount(Customer c);
	void updateAccount(int cid,Customer c);
	Customer viewAccount(int cid);
	String createOrder(int cid, Order o);
	ArrayList<Order> viewAllOrders(int cid);
	Order viewById(int oid);
	void cancelOrder(int cid, int oid, String status);
	
}
