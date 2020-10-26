package com.adidas.APIAutomation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

import static io.restassured.RestAssured .*;
import static org.hamcrest.Matchers.*;


public class GetAvailablePets extends Base {
	
	
	@Test(priority = 0, description="Get the all available pets")
	@Description("Test Description: Hit GET requst and get all pets with status 'avalable'")
	@Step("Call GET api with status findByStatus?status getStatus")
	public void getPetStatus() throws IOException {
		
		RestAssured.baseURI = utilities.getUrl();
		RestAssured.basePath ="/findByStatus?status="+utilities.getStatus();
		
		System.out.println(baseURI+basePath);
		
		 given()
		 .when()
		 	.get(baseURI+basePath)
		 .then()
		 .statusCode(200)
		 .assertThat().body("status", hasItem("available"));

	}

}
