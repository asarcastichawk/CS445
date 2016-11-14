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

	static FarmerBI FT_Fbi = new FarmerManager();
	static ManagerBI Mbi = new LF2UManager();
	static ProductCatalog pcatalog;
	static ProductCatalog pcatalog2;
	static ArrayList<String> FT_zip_set1;
	static ArrayList<String> FT_zip_set2;
	static Farmer FT_farmer1;
	static Farmer FT_farmer2;
	static FarmInfo FT_f_info;
	static PersonalInfo FT_p_info; 
	static StoreProduct FT_storeProduct1;
	static StoreProduct FT_storeProduct2;
	final double DELTA = 1e-15;
	
	@BeforeClass
    public static void setUp() {
		
		FT_f_info = new FarmInfo("Alpaca", "1305 West Lake", "708-100-5400", "farm.com");
		FT_p_info = new PersonalInfo("Huzair", "huzair@gmail.com", "708-369-9357");
		FT_zip_set1 = new ArrayList<String>(Arrays.asList("60504", "60446"));
		FT_farmer1 = new Farmer(FT_p_info,FT_f_info,FT_zip_set1);
		FT_zip_set2 = new ArrayList<String>(Arrays.asList("60564", "60356"));
		FT_farmer2 = new Farmer(FT_p_info,FT_f_info,FT_zip_set2);
		FT_storeProduct1 = new StoreProduct("gcpid1", "" , "10-24-2016", "12-31-2016", 15, "lb", "");
		FT_storeProduct2 = new StoreProduct("gcpid2", "" , "10-24-2016", "12-31-2016", 15, "lb", "");
		pcatalog = new ProductCatalog("Potatoes");
		pcatalog2 = new ProductCatalog("Tomatoes");
		Mbi.addProduct(pcatalog);
		Mbi.addProduct(pcatalog2);
		FT_Fbi.createAccount(FT_farmer1);
		FT_Fbi.createAccount(FT_farmer2);
		
	}
	@AfterClass
	public static void tearDown(){
	}

	@Test
	public void testCreateAccountAndVerify() {
		ArrayList<Farmer> farmers = FT_Fbi.viewFarmers("60446");
		int no_farmers = farmers.size();
		assertEquals(no_farmers,1);
	}
	
	@Test
	public void testUpdateAccountAndVerify() {
		FT_zip_set2.add("60504");
		Farmer farmer2new = new Farmer(FT_p_info,FT_f_info,FT_zip_set2);
		FT_Fbi.updateAccount(2,farmer2new);
		ArrayList<Farmer> farmers = FT_Fbi.viewFarmers("60504");
		int no_farmers = farmers.size();
		assertEquals(no_farmers,2);
	}
	
	@Test
	public void testUpdateNonExistingAccount() {
		Farmer farm = FT_Fbi.viewAccount(3);
		assertEquals(farm,null);
	}
	
	@Test
	public void testDeliveryChargeBeforeInitilization(){
		double delivery_charge = FT_Fbi.ViewDelivery(1);
		assertEquals(delivery_charge,0,DELTA);
	}
	
	@Test
	public void testUpdateDelivery(){
		FT_Fbi.UpdateDelivery(1,5.00);
		double delivery_charge = FT_Fbi.ViewDelivery(1);
		assertEquals(delivery_charge,5.00,DELTA);
	}
	
	@Test
	public void testAddProductAndVerifyUsingViewProducts(){
		FT_Fbi.addProduct(1, FT_storeProduct1);
		FT_Fbi.addProduct(1, FT_storeProduct2);
		ArrayList<StoreProduct> allproducts1 = new ArrayList<StoreProduct>();
		allproducts1 = FT_Fbi.viewStore(1);
		int no_products = allproducts1.size();
		assertEquals(no_products,2);
	}
	
	@Test
	public void viewNotNullFarmer(){
		Farmer newFarmer = FT_Fbi.viewAccount(1);
		assertEquals(newFarmer,FT_farmer1);
	}
	@Test
	public void viewNullStore(){
		ArrayList<StoreProduct> allproducts = new ArrayList<StoreProduct>();
		allproducts = FT_Fbi.viewStore(2);
		assertEquals(allproducts.size(),0);
	}
	@Test
	public void modifyExistingProduct(){
		StoreProduct spupdate = new StoreProduct("123", "" , "10-24-2016", "12-31-2016", 15, "kg", "");
		FT_Fbi.modifyProduct(1, "fspid1", spupdate);
		StoreProduct spnew = FT_Fbi.viewProduct(1, "fspid1");
		String spNewUnit = spnew.getProductUnit();
		String spUpdateUnit = spupdate.getProductUnit();
		assertEquals(spNewUnit,spUpdateUnit);
	}
	@Test
	public void modifyNullProduct(){
		StoreProduct spupdate = new StoreProduct("123", "" , "10-24-2016", "12-31-2016", 15, "kg", "");
		FT_Fbi.modifyProduct(5, "fspid1", spupdate);
		StoreProduct spnew = FT_Fbi.viewProduct(1, "fspid1");
		String spNewUnit = spnew.getProductUnit();
		String spUpdateUnit = spupdate.getProductUnit();
		assertNotSame(spNewUnit,spUpdateUnit);
	}
	@Test
	public void viewEmptyStore(){
		ArrayList<StoreProduct> allProducts2 = new ArrayList<StoreProduct>();
		allProducts2 = FT_Fbi.viewStore(2);
		assertEquals(allProducts2.size(),0);
	}
	@Test
	public void testViewAllFarmersShouldBeF1AndF2(){
		ArrayList<Farmer> allFarmers = new ArrayList<Farmer>();
		allFarmers.add(FT_farmer1);
		allFarmers.add(FT_farmer2);
		ArrayList<Farmer> getAllFarmers = FT_Fbi.getAllFarmers();
		assertEquals(getAllFarmers,allFarmers);
	}
	
	//Ask about this test
	@Test
	public void viewAllReports(){
		FarmerReportType frid = new FarmerReportType();
		ArrayList<FarmerReportType> farmerReports = frid.getAllTypes();
		ArrayList<FarmerReportType> farmerReportsManager = FT_Fbi.allReportTypes();
		assertEquals(farmerReports.size(),farmerReportsManager.size());
	}
	


}
