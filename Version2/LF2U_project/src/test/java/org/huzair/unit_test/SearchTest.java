package org.huzair.unit_test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.huzair.boundary_interfaces.CustomerBI;
import org.huzair.boundary_interfaces.FarmerBI;
import org.huzair.entities.Customer;
import org.huzair.entities.FarmInfo;
import org.huzair.entities.Farmer;
import org.huzair.entities.Order;
import org.huzair.entities.OrderDetail;
import org.huzair.entities.PersonalInfo;
import org.huzair.entities.Search;
import org.huzair.entities.StoreProduct;
import org.huzair.use_cases.CustomerManager;
import org.huzair.use_cases.FarmerManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SearchTest {

	Search search;
	static FarmerBI FBi = new FarmerManager();
	static CustomerBI CBi = new CustomerManager();
	static Farmer f1;
	static Farmer f2;
	static FarmInfo f_info;
	static FarmInfo f_info2;
	static PersonalInfo p_info; 
	static ArrayList<String> zip_set1;
	static StoreProduct sp1;
	static StoreProduct sp2;
	static Customer c1;
	static Customer c2;
	static Order o1;
	static ArrayList<OrderDetail> od;
	
	@Before
	public void setUp() {
	setUpFarmer();
	setUpOrder();
	}
	
	@After
	public void tearDown() {
	}
	
	@Ignore
	public static void setUpFarmer(){
		f_info = new FarmInfo("Alpaca", "1305 West", "708-100-5400", "farm.com");
		f_info2 = new FarmInfo("Bark", "1305 West", "708-100-5400", "farm.com");
		p_info = new PersonalInfo("Huzair", "huzair@gmail.com", "708-369-9357");
		zip_set1 = new ArrayList<String>(Arrays.asList("60504", "60446"));
		f1 = new Farmer(p_info,f_info,zip_set1);
		f2 = new Farmer(p_info,f_info2,zip_set1);
		sp1 = new StoreProduct("123", "" , "10-24-2016", "12-31-2016", 15.0, "lb", "");
		sp2 = new StoreProduct("125", "" , "10-24-2016", "12-31-2016", 15.0, "lb", "");
	}
	
	@Ignore
	public static void setUpOrder(){
		c1 = new Customer("John Doe", "2200 S Grace St", "60148", "630-915-4124", "johndoe@anonymous.com");
		c2 = new Customer("Abraham Lincoln", "2200 S Grace St", "60148", "630-915-4124", "johndoe@anonymous.com");
		OrderDetail od1 = new OrderDetail("1",2);
		OrderDetail od2 = new OrderDetail("2",5);
		od = new ArrayList<OrderDetail>();
		od.add(od1);
		od.add(od2);
		o1 = new Order("1",od,"note");
	}
	
	@Test
	public void testUnacceptableTopic() {
		String topic = "Delivery";
		String keyword = "75";
		search = new Search(topic,keyword);
		ArrayList<?> list  = search.determineTopic();
		assertEquals(null,list);
	}
	
	@Test
	public void searchForFarmWithSpecificKeyword() {
		FBi.createAccount(f1);
		FBi.createAccount(f2);
		String topic = "farm";
		String keyword = "Bark";
		search = new Search(topic,keyword);
		ArrayList<?> list  = search.determineTopic();
		assertTrue(list.contains(f2));
	}
	@Test
	public void searchForFarmWithKeywordAsEmpty() {
		FBi.createAccount(f1);
		FBi.createAccount(f2);
		String topic = "farm";
		String keyword = "";
		search = new Search(topic,keyword);
		ArrayList<?> list  = search.determineTopic();
		assertTrue(list.contains(f2)&&list.contains(f1));
	}
	@Test
	public void searchForFarmWithKeywordAsNotFound() {
		FBi.createAccount(f1);
		FBi.createAccount(f2);
		String topic = "farm";
		String keyword = "Pearl";
		search = new Search(topic,keyword);
		ArrayList<?> list  = search.determineTopic();
		assertEquals(0,list.size());
	}
	@Test
	public void searchForCustomerWithSpecificKeyword() {
		CBi.createAccount(c1);
		CBi.createAccount(c2);
		String topic = "customer";
		String keyword = "Lincoln";
		search = new Search(topic,keyword);
		ArrayList<?> list  = search.determineTopic();
		assertTrue(list.contains(c2));
	}
	@Test
	public void searchForCustomerWithKeywordAsEmpty() {
		CBi.createAccount(c1);
		CBi.createAccount(c2);
		String topic = "customer";
		String keyword = "";
		search = new Search(topic,keyword);
		ArrayList<?> list  = search.determineTopic();
		assertTrue(list.contains(c2)&&list.contains(c1));
	} 
	@Test
	public void searchForCustomerWithKeywordAsNotFound() {
		CBi.createAccount(c1);
		CBi.createAccount(c2);
		String topic = "Customer";
		String keyword = "Obama";
		search = new Search(topic,keyword);
		ArrayList<?> list  = search.determineTopic();
		assertEquals(0,list.size());
	}
	
	@Test
	public void searchForOrderWithSpecificKeyword() {
		String cid = CBi.createAccount(c1);
		CBi.createOrder(cid, o1);
		//OrderReport ord = new OrderReport(o1);
		String topic = "Order";
		String keyword = Integer.toString(1);
		search = new Search(topic,keyword);
		ArrayList<?> list  = search.determineTopic();
		//assertTrue(list.size()>=1);
	}
	

}
