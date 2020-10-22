package com.adidas.APIAutomation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeletePet extends Base{
	
	@Test(priority = 1)
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
	public void validateDeletedPet() throws IOException {
		
		given()
		 .when()
		 	.get(baseURI+"/"+utilities.getId())
		 .then()
		 	.statusCode(404)
		 	.assertThat().body("message", equalTo("Pet not found"));
		
	}
	
	

}
