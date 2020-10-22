package com.adidas.APIAutomation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured .*;
import static org.hamcrest.Matchers.*;


public class GetAvailablePets extends Base {
	
	
	@Test
	public void getStatus() throws IOException {
		
		RestAssured.baseURI = utilities.getUrl();
		RestAssured.basePath ="/findByStatus?status="+utilities.getStatus();
		
		 given()
		 .when()
		 	.get(baseURI+basePath)
		 .then()
		 .statusCode(200)
		 .assertThat().body("status", hasItem("available"));

	}

}
