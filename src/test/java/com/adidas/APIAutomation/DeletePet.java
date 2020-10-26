package com.adidas.APIAutomation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.io.IOException;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

public class DeletePet extends Base{
	
	@Test(priority = 1)
	@Description("Test Description: Call DELETE request to delete the pet")
	@Step("Step 1: This request delete the newly added pet")
	public void deletePet() throws IOException {
		
		RestAssured.baseURI = utilities.getUrl();
		RestAssured.basePath ="";
		
		 given()
		 .when()
		 	.delete(baseURI+"/"+utilities.getId())
		 .then()
		 	.statusCode(200)
		 	.assertThat().body("message", equalTo(utilities.getId()));
			
	}
	@Test(priority = 2)
	@Description("Test Description: Call GET request to get the all pet details")
	@Step("Step 1: This request verify that newly added pet shold be deleted successfully")
	public void validateDeletedPet() throws IOException {
		
		given()
		 .when()
		 	.get(baseURI+"/"+utilities.getId())
		 .then()
		 	.statusCode(404)
		 	.assertThat().body("message", equalTo("Pet not found"));
		
	}
	
	

}
