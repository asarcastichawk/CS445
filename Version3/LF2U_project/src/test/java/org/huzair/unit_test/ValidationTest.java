package org.huzair.unit_test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.huzair.entities.Customer;
import org.huzair.entities.FarmInfo;
import org.huzair.entities.Farmer;
import org.huzair.entities.Order;
import org.huzair.entities.OrderDetail;
import org.huzair.entities.PersonalInfo;
import org.huzair.entities.ProductCatalog;
import org.huzair.entities.StoreProduct;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ValidationTest{
	private static ProductCatalog CT_productCatalog1;
	static Customer CT_customer1;
	static Order CT_order1;
	static String CT_cid;
	static String CT_oid;
	static StoreProduct CT_storeProduct1;
	static StoreProduct CT_storeProduct2;
	private static Farmer CT_farmer1;
	private static FarmInfo CT_f_info;
	private static PersonalInfo CT_p_info; 
	static ArrayList<String> CT_zip_set1;
	static ArrayList<OrderDetail> CT_odlist;
	final double DELTA = 1e-15;
	
	@BeforeClass
    public static void setUp() {
		setUpFarmer();
	}
	@Ignore
	public static void setUpFarmer(){
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void farmerValidation() {
		CT_f_info = new FarmInfo("Alpaca", "1305 West Lake", "708-100-5400", "farm.com");
		CT_p_info = new PersonalInfo(null, "huzair@gmail.com", "708-369-9357");
		CT_zip_set1 = new ArrayList<String>(Arrays.asList("60504", "60446"));
		CT_farmer1 = new Farmer(CT_p_info,CT_f_info,CT_zip_set1);
		Boolean validatefarmer = CT_farmer1.validate();
		assertTrue(!validatefarmer);
	}
	@Test
	public void productValidation() {
		CT_productCatalog1 = new ProductCatalog("Potatoes");
		CT_storeProduct1 = new StoreProduct(null, "" , "10-24-2016", "12-31-2016", 15.0, "lb", "");
		Boolean validateproduct= CT_storeProduct1.validate();
		assertTrue(!validateproduct);
	}
	@Test
	public void customerValidation() {
		CT_customer1 = new Customer(null, "2200 S Grace St", "60504", "630-915-4124", "johndoe@anonymous.com");
		Boolean validateproduct= CT_customer1.validate();
		assertTrue(!validateproduct);
	}
	@Test
	public void orderValidation() {
		OrderDetail od1 = new OrderDetail("1",2);
		OrderDetail od2 = new OrderDetail("2",5);
		ArrayList<OrderDetail> od = new ArrayList<OrderDetail>();
		od.add(od1);
		od.add(od2);
		CT_order1 = new Order(null,od,"note");
		Boolean validateproduct= CT_order1.validate();
		assertTrue(!validateproduct);
	}
	@Test
	public void orderDetailValidation() {
		OrderDetail od1 = new OrderDetail(null,2);
		OrderDetail od2 = new OrderDetail("2",5);
		ArrayList<OrderDetail> od = new ArrayList<OrderDetail>();
		od.add(od1);
		od.add(od2);
		CT_order1 = new Order("1",od,"note");
		Boolean validateproduct= CT_order1 .validate();
		assertTrue(!validateproduct);
	}
}