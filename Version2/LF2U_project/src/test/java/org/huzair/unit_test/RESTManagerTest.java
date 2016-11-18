package org.huzair.unit_test;
import static org.junit.Assert.*;
import javax.ws.rs.core.Response;
import org.huzair.entities.ProductCatalog;
import org.huzair.rest.RESTManager;
import static com.jayway.restassured.RestAssured.given;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.google.gson.Gson;

public class RESTManagerTest{

	static RESTManager rf = new RESTManager();
	static Gson gson = new Gson();
	static ProductCatalog pc;
	
	@Before
	public void setUp()  {
		pc = new ProductCatalog("Potatoes");
	}

	@After
	public void tearDown(){
	}
	@Test
	public void viewCatalogDirect(){
		Response r = rf.viewCatalog();
		assertEquals(200,r.getStatus());
	}

	@Test
	public void addProduct(){
		Response r = rf.addProduct(gson.toJson(pc));
		assertEquals(201,r.getStatus());
	}
	@Test
	public void updateProduct(){
		rf.addProduct(gson.toJson(pc));
		ProductCatalog pc2 = new ProductCatalog("Potatoes(RED)");
		Response r = rf.updateCatalog("1",(gson.toJson(pc2)));
		assertEquals(200,r.getStatus());
	}
	@Test
	public void updateProductNonExistingGcpid(){
		ProductCatalog pc2 = new ProductCatalog("Potatoes(RED)");
		Response r = rf.updateCatalog("100",(gson.toJson(pc2)));
		assertEquals(404,r.getStatus());
	}
	@Test
	public void viewManagers(){
		Response r = rf.viewManagers();
		assertEquals(200,r.getStatus());
	}
	@Test
	public void viewManagersByIDNonExisting(){
		Response r = rf.viewManagerById("50");
		assertEquals(404,r.getStatus());
	}
	
/*	@Test
    public void RESTmanagersAccountsTest() {
		given().
        expect().
        statusCode(200).
        when().
        get("/lf2u/managers/accounts/0");
	}
	@Test
    public void RESTmanagerAccountsTest() {
		given().
        expect().
        statusCode(200).
        when().
        get("/lf2u/managers/accounts");
	}
	@Test
    public void RESTmanagersReportsTest() {
		given().
        expect().
        statusCode(200).
        when().
        get("/lf2u/managers/reports");
	}
	@Test
    public void RESTviewCatalog() {
		given().
        expect().
        statusCode(200).
        when().
        get("/lf2u/managers/catalog");
	}P*/
}