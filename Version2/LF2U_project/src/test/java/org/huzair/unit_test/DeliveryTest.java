package org.huzair.unit_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.huzair.boundary_interfaces.CustomerBI;
import org.huzair.boundary_interfaces.DeliveryBI;
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
import org.huzair.use_cases.CustomerManager;
import org.huzair.use_cases.DeliveryManager;
import org.huzair.use_cases.FarmerManager;
import org.huzair.use_cases.LF2UManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class DeliveryTest {

	static CustomerBI DT_Cbi = new CustomerManager();
	static FarmerBI DT_Fbi = new FarmerManager();
	static DeliveryBI DT_Dbi = new DeliveryManager();
	static ManagerBI DT_Mbi = new LF2UManager();
	static ProductCatalog CT_productCatalog1;
	static ProductCatalog CT_productCatalog2;
	static Customer DT_customer1;
	static Order DT_order1;
	static String DT_cid;
	static String DT_oid;
	static StoreProduct DT_storeProduct1;
	static StoreProduct DT_storeProduct2;
	static Farmer DT_farmer1;
	static FarmInfo DT_f_info;
	static PersonalInfo DT_p_info; 
	static ArrayList<String> DT_zip_set1;
	static ArrayList<OrderDetail> DT_odlist;
	final double DELTA = 1e-15;
	
	@BeforeClass
    public static void setUp() {
		
		setUpFarmer();
		setUpOrder();
		
	}
	@Ignore
	public static void setUpFarmer(){
		CT_productCatalog1 = new ProductCatalog("Potatoes");
		CT_productCatalog2 = new ProductCatalog("Tomatoes");
		DT_f_info = new FarmInfo("Alpaca", "1305 West Lake", "708-100-5400", "farm.com");
		DT_p_info = new PersonalInfo("Huzair", "huzair@gmail.com", "708-369-9357");
		DT_zip_set1 = new ArrayList<String>(Arrays.asList("60504", "60446"));
		DT_farmer1 = new Farmer(DT_p_info,DT_f_info,DT_zip_set1);
		DT_Fbi.createAccount(DT_farmer1);
		DT_Mbi.addProduct(CT_productCatalog1);
		DT_Mbi.addProduct(CT_productCatalog2);
		DT_storeProduct1 = new StoreProduct("1", "" , "10-24-2016", "12-31-2016", 15.0, "lb", "");
		DT_storeProduct2 = new StoreProduct("2", "" , "10-24-2016", "12-31-2016", 15.0, "lb", "");
		
	}
	@Ignore
	public static void setUpOrder(){
		DT_customer1 = new Customer("John Doe", "2200 S Grace St", "60504", "630-915-4124", "johndoe@anonymous.com");
		OrderDetail od1 = new OrderDetail("1",2);
		OrderDetail od2 = new OrderDetail("2",5);
		ArrayList<OrderDetail> od = new ArrayList<OrderDetail>();
		od.add(od1);
		od.add(od2);
		DT_order1 = new Order("1",od,"note");
	}
	@AfterClass
	public static void tearDown(){
		DT_Cbi.setNull();
		DT_Fbi.setNull(); 
		DT_Mbi.setNull();
	}
	
	@Test
	public void TestUpdateStatusExistingId() {
		DT_Fbi.addProduct("1", DT_storeProduct1);
		DT_Fbi.addProduct("1", DT_storeProduct2);
		DT_cid = DT_Cbi.createAccount(DT_customer1);
		DT_oid = DT_Cbi.createOrder(DT_cid,DT_order1);
		String status = "delivered";
		DT_Dbi.UpdateStatus(DT_oid, status);
		Order o = DT_Cbi.viewById(DT_oid);
		assertEquals(status,o.getStatus());
	}
	@Test
	public void TestUpdateStatusNonExistingId() {
		DT_Fbi.addProduct("1", DT_storeProduct1);
		DT_Fbi.addProduct("1", DT_storeProduct2);
		DT_cid = DT_Cbi.createAccount(DT_customer1);
		DT_oid = DT_Cbi.createOrder(DT_cid,DT_order1);
		String status = "delivered";
		DT_Dbi.UpdateStatus("5", status);
		Order o = DT_Cbi.viewById(DT_oid);
		assertEquals("open",o.getStatus());
	}

}
