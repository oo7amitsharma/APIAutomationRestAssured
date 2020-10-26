package com.adidas.APIAutomation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdatePetStatus extends Base{
	

	@BeforeClass
	@Description("Test Description: Get all the required information to call PUT request")
	@Step("Step 1: Get pet id, pet name and pet status")
	public void putData() throws IOException {

		map.put("id", utilities.getId());
		category.put("id", "0");
		category.put("name", utilities.getPetName());
		map.put("category", category);
		photoUrls.add("string");
		map.put("photoUrls", photoUrls);
		tag.put("id", "0");
		tag.put("name", "string");
		tags.add(tag);
		map.put("tags", tags);
		map.put("status", "sold");
		
		
		RestAssured.baseURI = utilities.getUrl();
		RestAssured.basePath ="";
		
	}
	@Test(priority = 1)
	@Description("Test Description: Call PUT request to update the pet status")
	@Step("Step 2: This request change the status of pet from 'available' to 'sold'")
	public void testData() {
		
		given()
			.contentType("application/json")
			.accept("application/json")
	
		.when()
			.body(map).log().all()
			.put(baseURI)
	
		.then()
			.statusCode(200);
		
		Response putResponse = 
				given()
					.contentType("application/json")
					.accept("application/json")
				.when()
					.body(map).log().all()
					.put(baseURI);
		getID = putResponse.getBody().path("id");
		getPetName  = putResponse.getBody().path("category.name");
		getStatus  = putResponse.getBody().path("status");
		
		System.out.println("getID "+getID);
		System.out.println("getPetName"+getPetName);
		System.out.println("getStatus"+getStatus);
	}
	@Test(priority = 2)
	@Description("Test Description: Call GET request to check whether pet status status updated or not")
	@Step("Step 2: Verify pet status 'sold' and status code '200'")
	public void validatePutRequest() throws IOException {

		
		given()
			.contentType("application/json")
			.accept("application/json")
			.baseUri(baseURI)

		.when()
			.get(baseURI+"/"+utilities.getId())

		.then()
			.assertThat()
			.statusCode(200)
			.body("category.name", equalTo(utilities.getPetName()));
		
	}

}
