package org.huzair.unit_test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.huzair.use_cases.FarmerManager;
import org.huzair.use_cases.LF2UManager;
import org.huzair.boundary_interfaces.FarmerBI;
import org.huzair.boundary_interfaces.ManagerBI;
import org.huzair.entities.FarmInfo;
import org.huzair.entities.Farmer;
import org.huzair.entities.PersonalInfo;
import org.huzair.entities.ProductCatalog;
import org.huzair.entities.StoreProduct;
import org.huzair.report.FarmerReportType;

public class FarmersTest {

	static FarmerBI farmerManager = new FarmerManager();
	static ManagerBI lf2uManager = new LF2UManager();
	static ProductCatalog pcatalog;
	static ProductCatalog pcatalog2;
	static ArrayList<String> FT_zip_set1;
	static ArrayList<String> FT_zip_set2;
	static Farmer farmer1;
	static Farmer farmer2;
	static FarmInfo FT_f_info;
	static PersonalInfo FT_p_info; 
	static StoreProduct storeProduct1;
	static StoreProduct storeProduct2;
	final double DELTA = 1e-15;
	
	@BeforeClass
    public static void setUp() {
		
		FT_f_info = new FarmInfo("Alpaca", "1305 West Lake", "708-100-5400", "farm.com");
		FT_p_info = new PersonalInfo("Huzair", "huzair@gmail.com", "708-369-9357");
		FT_zip_set1 = new ArrayList<String>(Arrays.asList("60504", "60446"));
		farmer1 = new Farmer(FT_p_info,FT_f_info,FT_zip_set1);
		FT_zip_set2 = new ArrayList<String>(Arrays.asList("60564", "60000"));
		farmer2 = new Farmer(FT_p_info,FT_f_info,FT_zip_set2);
		storeProduct1 = new StoreProduct("1", "" , "10-24-2016", "12-31-2016", 15, "lb", "");
		storeProduct2 = new StoreProduct("2", "" , "10-24-2016", "12-31-2016", 15, "lb", "");
		pcatalog = new ProductCatalog("Potatoes");
		pcatalog2 = new ProductCatalog("Tomatoes");
		lf2uManager.addProduct(pcatalog);
		lf2uManager.addProduct(pcatalog2);
		farmerManager.createAccount(farmer1);
		farmerManager.createAccount(farmer2);
		
	}
	@AfterClass
	public static void tearDown(){
		farmerManager.setNull();
		lf2uManager.setNull();
	}

	@Test
	public void testCreateAccountAndVerify() {
		ArrayList<Farmer> farmers = farmerManager.getAllFarmers();
		int no_farmers = farmers.size();
		assertTrue(no_farmers!=0);
	}
	
	@Test
	public void testUpdateAccountAndVerify() {
		FT_zip_set2.add("60904");
		Farmer farmer2new = new Farmer(FT_p_info,FT_f_info,FT_zip_set2);
		farmerManager.updateAccount("2",farmer2new);
		Farmer F = farmerManager.viewAccount("2");
		ArrayList<String> zipcodes = F.getDeliversTo();
		assertTrue(zipcodes.contains("60904"));
	}
	
	@Test
	public void testUpdateNonExistingAccount() {
		Farmer farm = farmerManager.viewAccount("100");
		assertEquals(farm,null);
	}
	
	@Test
	public void testDeliveryChargeBeforeInitilization(){
		double delivery_charge = farmerManager.ViewDelivery("1");
		assertEquals(delivery_charge,0,DELTA);
	}
	
	@Test
	public void testUpdateDelivery(){
		farmerManager.UpdateDelivery("1",5.00);
		double delivery_charge = farmerManager.ViewDelivery("1");
		assertEquals(delivery_charge,5.00,DELTA);
	}
	
	@Test
	public void testAddProductAndVerifyUsingViewProducts(){
		farmerManager.addProduct("1", storeProduct1);
		ArrayList<StoreProduct> allproducts1 = new ArrayList<StoreProduct>();
		allproducts1 = farmerManager.viewStore("1");
		assertTrue(allproducts1.contains(storeProduct1));
	}
	
	@Test
	public void viewNotNullFarmer(){
		Farmer newFarmer = farmerManager.viewAccount(farmer1.getFid());
		assertEquals(newFarmer.getFid(),farmer1.getFid());
	}
	@Test
	public void viewNullStore(){
		ArrayList<StoreProduct> allproducts = new ArrayList<StoreProduct>();
		allproducts = farmerManager.viewStore("2");
		assertEquals(allproducts.size(),0);
	}
	@Test
	public void modifyExistingProduct(){
		StoreProduct spupdate = new StoreProduct("123", "" , "10-24-2016", "12-31-2016", 15, "kg", "");
		farmerManager.modifyProduct("1", "1", spupdate);
		StoreProduct spnew = farmerManager.viewProduct("1", "1");
		String spNewUnit = spnew.getProductUnit();
		String spUpdateUnit = spupdate.getProductUnit();
		assertEquals(spNewUnit,spUpdateUnit);
	}
	@Test
	public void modifyNullProduct(){
		StoreProduct spupdate = new StoreProduct("1", "" , "10-24-2016", "12-31-2016", 15, "kg", "");
		farmerManager.modifyProduct("1", "100", spupdate);
		StoreProduct spnew = farmerManager.viewProduct("1", "1");
		String spNewUnit = spnew.getProductUnit();
		String spUpdateUnit = spupdate.getProductUnit();
		assertTrue(spNewUnit!=spUpdateUnit);
	}
	@Test
	public void viewEmptyStore(){
		ArrayList<StoreProduct> allProducts2 = new ArrayList<StoreProduct>();
		allProducts2 = farmerManager.viewStore("2");
		assertEquals(allProducts2.size(),0);
	}
	@Test
	public void testViewAllFarmersShouldBeF1AndF2(){
		ArrayList<Farmer> allFarmers = new ArrayList<Farmer>();
		allFarmers.add(farmer1);
		allFarmers.add(farmer2);
		ArrayList<Farmer> getAllFarmers = farmerManager.getAllFarmers();
		assertTrue(getAllFarmers.containsAll(allFarmers));
	}
	
	@Test
	public void viewAllReports(){
		FarmerReportType frid = new FarmerReportType();
		ArrayList<FarmerReportType> farmerReports = frid.getAllTypes();
		ArrayList<FarmerReportType> farmerReportsManager = farmerManager.allReportTypes();
		assertEquals(farmerReports.size(),farmerReportsManager.size());
	}
	@Test
	public void getFarmerZip(){
		Farmer farm = new Farmer(FT_p_info,FT_f_info,FT_zip_set1);
		Farmer newfarm = farmerManager.getFarmerZip(farm, "60504");
		assertEquals(newfarm.getFid(),farm.getFid());
	}
	@Test
	public void getFarmersInNoZip(){
		ArrayList<Farmer> farmers = farmerManager.viewFarmers("101010");
		assertEquals(0,farmers.size());
	}

}
