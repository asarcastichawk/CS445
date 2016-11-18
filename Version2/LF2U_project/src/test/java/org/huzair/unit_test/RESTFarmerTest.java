package org.huzair.unit_test;
import org.huzair.rest.RESTFarmer;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.File;

import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RESTFarmerTest{

	static RESTFarmer rf = new RESTFarmer();
	
	@Before
	public void setUp() {
		
	}

	@After
	public void tearDown()  {
	}
	/*@Test
    public void RESTNullFarmerAccount() {
		given().
        expect().
        statusCode(404).
        when().
        get("/lf2u/farmers/5");
	}
	@Test
    public void RESTNullStore() {
		given().
        expect().
        statusCode(404).
        when().
        get("/lf2u/farmers/products/500");
	}*/
}