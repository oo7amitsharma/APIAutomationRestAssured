package com.adidas.APIAutomation;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured .*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class AddNewPet extends Base{
	

	@BeforeClass
	@Description("Test Description: Collect the body data for post request")
	@Step("Step 1: Get pet name and pet status for body request")
	public void postData() throws IOException {
		RestAssured.baseURI = utilities.getUrl();
		RestAssured.basePath ="";
		
		map.put("id", "0");
		category.put("id", "0");
		category.put("name", utilities.getPetName());
		map.put("category", category);
		photoUrls.add("string");
		map.put("photoUrls", photoUrls);
		tag.put("id", "0");
		tag.put("name", "string");
		tags.add(tag);
		map.put("tags", tags);
		map.put("status", utilities.getStatus());

	}
	@Description("Call POST request to Add new pet")
	@Step("Step 2: Call POST request with body in we get in Step 1 and get the result, status code etc..")
	@Test(priority = 1)
	public void testData() throws IOException {
		
		given()
			.contentType("application/json")
			.accept("application/json")
		
		.when()
			.body(map).log().all()
			.post(baseURI)
		
		.then()
			.statusCode(200);
		
		Response postResponse = 
			given()
				.contentType("application/json")
				.accept("application/json")
			
			.when()
				.body(map).log().all()
				.post(baseURI);
		

		getID = postResponse.getBody().path("id");
		getPetName  = postResponse.getBody().path("category.name");
		getStatus  = postResponse.getBody().path("status");
		utilities.setData(getID.toString());
			
	}
	@Test(priority = 2)
	@Description("Validate new pet added sucessfully or not")
	@Step("Step 3: Call GET request with ID and get verify the response and status code etc..")
	public void validateAddedPet() throws IOException {
		
			given()
				.contentType("application/json")
				.accept("application/json")
				.baseUri(baseURI)

			.when()
				.get(baseURI+"/"+getID)

			.then()
			.assertThat()
				.statusCode(200)
			    .body("category.name", equalTo(utilities.getPetName()));
		

	}

}
