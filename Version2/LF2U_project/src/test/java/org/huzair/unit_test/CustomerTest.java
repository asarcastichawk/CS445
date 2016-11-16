package org.huzair.unit_test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.huzair.use_cases.CustomerManager;
import org.huzair.use_cases.FarmerManager;
import org.huzair.use_cases.LF2UManager;
import org.huzair.boundary_interfaces.CustomerBI;
import org.huzair.boundary_interfaces.FarmerBI;
import org.huzair.boundary_interfaces.ManagerBI;
import org.huzair.entities.Customer;
import org.huzair.entities.FarmInfo;
import org.huzair.entities.Farmer;
import org.huzair.entities.Order;
import org.huzair.entities.OrderDetail;
import org.huzair.entities.PersonalInfo;
import org.huzair.entities.ProductCatalog;
import org.huzair.entities.StoreProduct;

public class CustomerTest {

	static CustomerBI CT_Cbi = new CustomerManager();
	static FarmerBI CT_Fbi = new FarmerManager();
	static ManagerBI CT_Mbi = new LF2UManager();
	static ProductCatalog CT_productCatalog1;
	static ProductCatalog CT_productCatalog2;
	static Customer CT_customer1;
	static Order CT_order1;
	static String CT_cid;
	static String CT_oid;
	static StoreProduct CT_storeProduct1;
	static StoreProduct CT_storeProduct2;
	static Farmer CT_farmer1;
	static FarmInfo CT_f_info;
	static PersonalInfo CT_p_info; 
	static ArrayList<String> CT_zip_set1;
	static ArrayList<OrderDetail> CT_odlist;
	final double DELTA = 1e-15;
	
	@BeforeClass
    public static void setUp() {
		
		setUpFarmer();
		CT_customer1 = new Customer("John Doe", "2200 S Grace St", "60504", "630-915-4124", "johndoe@anonymous.com");
		OrderDetail od1 = new OrderDetail("1",2);
		OrderDetail od2 = new OrderDetail("2",5);
		ArrayList<OrderDetail> od = new ArrayList<OrderDetail>();
		od.add(od1);
		od.add(od2);
		CT_order1 = new Order("1",od,"note");
		CT_cid = CT_Cbi.createAccount(CT_customer1);
	}
	@Ignore
	public static void setUpFarmer(){
		CT_productCatalog1 = new ProductCatalog("Potatoes");
		CT_productCatalog2 = new ProductCatalog("Tomatoes");
		CT_f_info = new FarmInfo("Alpaca", "1305 West Lake", "708-100-5400", "farm.com");
		CT_p_info = new PersonalInfo("Huzair", "huzair@gmail.com", "708-369-9357");
		CT_zip_set1 = new ArrayList<String>(Arrays.asList("60504", "60446"));
		CT_farmer1 = new Farmer(CT_p_info,CT_f_info,CT_zip_set1);
		String id = CT_Fbi.createAccount(CT_farmer1);
		CT_Mbi.addProduct(CT_productCatalog1);
		CT_Mbi.addProduct(CT_productCatalog2);
		CT_storeProduct1 = new StoreProduct("1", "" , "10-24-2016", "12-31-2016", 15.0, "lb", "");
		CT_storeProduct2 = new StoreProduct("2", "" , "10-24-2016", "12-31-2016", 15.0, "lb", "");
		CT_Fbi.addProduct(id, CT_storeProduct1);
		CT_Fbi.addProduct(id, CT_storeProduct2);
	}
	
	@AfterClass
	public static void tearDown(){
		
	}
	
	@Test
	public void testCreateAccountAndVerify() {
		ArrayList<Customer> allCustomer = CT_Cbi.viewAllCustomers();
		assertEquals(1,allCustomer.size());
	}
	@Test
	public void testUpdateAccountAndVerify() {
		Customer CT_customer1new = new Customer("John Doe", "2200 S Grace St", "60446", "630-915-4124", "johndoe@anonymous.com");
		String CT_cid = CT_customer1.getCid();
		CT_Cbi.updateAccount(CT_cid, CT_customer1new);
		assertEquals("60446",CT_customer1.getZip());
	}
	@Test
	public void testNonExistingCidUpdate() {
		Customer CT_customer1new = new Customer("John Doe", "2200 S Grace St", "60446", "630-915-4124", "johndoe@anonymous.com");
		CT_Cbi.updateAccount("10", CT_customer1new);
		assertEquals("60504",CT_customer1.getZip());
	}
	@Test
	public void testNullAcount() {
		Customer c = CT_Cbi.viewAccount("2");
		assertEquals(null,c);
	}
	@Test
	public void viewCustomerById() {
		Customer c = CT_Cbi.viewAccount(CT_cid);
		assertTrue(CT_customer1.equals(c));
	}
	@Test
	public void testCreateOrder() {
		CT_oid = CT_Cbi.createOrder(CT_cid,CT_order1);
		ArrayList<Order> allOrders = CT_Cbi.viewAllOrders();
		assertEquals(1,allOrders.size());
	}
	@Test
	public void testCreateOrderWithNonExistingCustomer() {
		CT_Cbi.createOrder("5",CT_order1);
		ArrayList<Order> allOrders = CT_Cbi.viewAllOrders();
		assertEquals(0,allOrders.size());
	}
	@Test
	public void testViewOrderByOrderID() {
		Order o = CT_Cbi.viewById(CT_oid);
		assertEquals(CT_order1.getAllDetails(),o.getAllDetails());
	}
	@Test
	public void testOrderCancellationWrongCid() {
		String cancel = "cancelled";
		CT_Cbi.cancelOrder("5", CT_oid, cancel);
		assertEquals(null,CT_Cbi.viewById(CT_oid));
	}
	@Test
	public void testOrderCancellation() {
		String cancel = "cancelled";
		CT_Cbi.cancelOrder(CT_cid, CT_oid, cancel);
		Order o = CT_Cbi.viewById(CT_oid);
		assertEquals(cancel,o.getStatus());
	}
}
