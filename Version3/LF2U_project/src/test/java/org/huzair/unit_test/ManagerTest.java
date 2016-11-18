package org.huzair.unit_test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.huzair.entities.Manager;
import org.huzair.entities.ProductCatalog;
import org.huzair.report.ManagerReportType;
import org.huzair.use_cases.LF2UManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManagerTest {

	static LF2UManager MT_Mbi = new LF2UManager();
	static String gcpid;
	static ProductCatalog pcatalog;
	final double DELTA = 1e-15;
	
	@BeforeClass
    public static void setUp() {
		pcatalog = new ProductCatalog("Potatoes");
		MT_Mbi.addProduct(pcatalog);	
	}
	@AfterClass
	public static void tearDown(){
		
	}

	@Test
	public void testSystemCreatedManager() {
		ArrayList<Manager> managers = MT_Mbi.viewAllManagers();
		assertEquals(1,managers.size());
	}
	@Test
	public void TestingAddingProductToCatalog() {
		ArrayList<ProductCatalog> parray = MT_Mbi.viewCatalog();
		assertTrue(parray.size()!=0);
	}
	@Test
	public void updateProductCatalog() {
		String update = "Potatoes(Red)";
		ProductCatalog p1 = new ProductCatalog(update);
		MT_Mbi.updateProduct("1", p1);
		ProductCatalog p2 = MT_Mbi.viewProductById("1");
		assertEquals(update,p2.getName());
	}
	@Test
	public void updateNullProductCatalog() {
		String update = "Potatoes(Blue)";
		ProductCatalog p1 = new ProductCatalog(update);
		MT_Mbi.updateProduct("4", p1);
		ProductCatalog p2 = MT_Mbi.viewProductById("1");
		String actual = p2.getName();
		assertFalse(actual.equalsIgnoreCase(update));
	}
	@Test
	public void viewTheSystemManager() {
		Manager manager = MT_Mbi.viewManagerById("0");
		assertEquals("Super User",manager.getName());
	}
	@Test
	public void viewNonExistingManager() {
		Manager manager = MT_Mbi.viewManagerById("5");
		assertEquals(null,manager);
	}
	@Test
	public void viewAllReportsForManager(){
		ManagerReportType frid = new ManagerReportType();
		ArrayList<ManagerReportType> ManagerReports = frid.getAllTypes();
		ArrayList<ManagerReportType> ManagerReportsManager = MT_Mbi.allReportTypes();
		assertEquals(ManagerReports.size(),ManagerReportsManager.size());
	}
	@Test
	public void viewProductById() {
		ProductCatalog p2 = MT_Mbi.viewProductById("1");
		ProductCatalog p3 = MT_Mbi.viewProductById("1");
		assertTrue(p2.equals(p3));
	}
}
