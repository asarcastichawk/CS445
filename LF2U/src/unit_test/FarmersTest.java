package unit_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import use_cases.FarmerManager;
import boundary_interfaces.FarmerBI;
import entity.FarmInfo;
import entity.Farmer;
import entity.PersonalInfo;
import entity.StoreProduct;

public class FarmersTest {

	
	static FarmerBI bi = new FarmerManager();
	static ArrayList<String> zip_set1;
	static ArrayList<String> zip_set2;
	static Farmer f1;
	static Farmer f2;
	static FarmInfo f_info;
	static PersonalInfo p_info; 
	static StoreProduct sp1;
	static StoreProduct sp2;
	final double DELTA = 1e-15;
	
	@BeforeClass
    public static void setUp() {
		
		f_info = new FarmInfo("Alpaca", "1305 West Lake", "708-100-5400", "farm.com");
		p_info = new PersonalInfo("Huzair", "huzair@gmail.com", "708-369-9357");
		zip_set1 = new ArrayList<String>(Arrays.asList("60504", "60446"));
		f1 = new Farmer(p_info,f_info,zip_set1);
		zip_set2 = new ArrayList<String>(Arrays.asList("60564", "60356"));
		f2 = new Farmer(p_info,f_info,zip_set2);
		
		sp1 = new StoreProduct("123", "" , "10-24-2016", "12-31-2016", 15, "lb", "");
		sp2 = new StoreProduct("125", "" , "10-24-2016", "12-31-2016", 15, "lb", "");
		bi.createAccount(f1);
		bi.createAccount(f2);
		
	
	}
	@AfterClass
	public static void tearDown(){
		
	}

	@Test
	public void testCreateAccountAndVerify() {
		
		ArrayList<Farmer> farmers = bi.viewFarmers("60446");
		int no_farmers = farmers.size();
		assertEquals(no_farmers,1);
	}
	
	@Test
	public void testUpdateAccountAndVerify() {
		zip_set2.add("60504");
		f2 = new Farmer(p_info,f_info,zip_set2);
		bi.updateAccount(2,f2);
		ArrayList<Farmer> farmers = bi.viewFarmers("60504");
		int no_farmers = farmers.size();
		assertEquals(no_farmers,2);
	}
	
	@Test
	public void testUpdateNonExistingAccount() {
		Farmer farm = bi.viewAccount(3);
		assertEquals(farm,null);
	}
	
	@Test
	public void testDeliveryChargeBeforeInitilization(){
		double delivery_charge = bi.ViewDelivery(1);
		assertEquals(delivery_charge,0,DELTA);
	}
	
	@Test
	public void testUpdateDelivery(){
		bi.UpdateDelivery(1,5.00);
		double delivery_charge = bi.ViewDelivery(1);
		assertEquals(delivery_charge,5.00,DELTA);
	}
	
	@Test
	public void testAddProductAndVerifyUsingViewProducts(){
		bi.AddProduct(1, sp1);
		bi.AddProduct(1, sp2);
		ArrayList<StoreProduct> allproducts = new ArrayList<StoreProduct>();
		allproducts = bi.viewStore(1);
		int no_products = allproducts.size();
		assertEquals(no_products,2);
	}
	


}
