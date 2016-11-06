package unit_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import use_cases.CustomerManager;
import use_cases.FarmerManager;
import boundary_interfaces.CustomerBI;
import boundary_interfaces.FarmerBI;
import entity.Customer;
import entity.FarmInfo;
import entity.Farmer;
import entity.Order;
import entity.OrderDetail;
import entity.PersonalInfo;
import entity.StoreProduct;

public class CustomerTest {

	static CustomerBI bi = new CustomerManager();
	static Customer c1;
	static Order o1;
	static OrderDetail od1;
	static OrderDetail od2;
	static StoreProduct sp1;
	static StoreProduct sp2;
	static ArrayList<OrderDetail> odlist;
	static String acc_no;
	final double DELTA = 1e-15;
	
	@BeforeClass
    public static void setUp() {
		c1 = new Customer("John Doe", "2200 S Grace St", "60148", "630-915-4124", "johndoe@anonymous.com");
		//sp1 = new StoreProduct(1, acc_no, acc_no, acc_no, 0, acc_no, acc_no)
		acc_no = bi.createAccount(c1);
	}
	@AfterClass
	public static void tearDown(){
		
	}
	
	@Test
	public void testCreateAccountAndVerify() {
		assertEquals(acc_no,"1");
	}
	@Test
	public void testUpdateAccountAndVerify() {
		Customer c1new = new Customer("John Doe", "2200 S Grace St", "60500", "630-915-4124", "johndoe@anonymous.com");
		int cid = c1.getCid();
		bi.updateAccount(cid, c1new);
		assertEquals(c1.getZip(),"60500");
	}
	@Test
	public void testNonExistingCidUpdate() {
		Customer c1new = new Customer("John Doe", "2200 S Grace St", "60500", "630-915-4124", "johndoe@anonymous.com");
		bi.updateAccount(10, c1new);
		assertEquals(c1.getZip(),"60148");
	}
	@Test
	public void testNullAcount() {
		Customer c = bi.viewAccount(2);
		assertEquals(c,null);
	}
	@Test
	public void testCreateOrder() {
		//bi.createOrder(1, o)
		//assertEquals(c,null);
	}
	
	

}
