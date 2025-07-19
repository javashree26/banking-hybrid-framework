package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.utils.ApiConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleGetTest {

	@Test
	public void getUserList() {
		// setting up base URL
		RestAssured.baseURI = ApiConstants.baseURI;

		// hitting the GET endpoint
		Response response = RestAssured.given().when().get("/api/users?page=2").then().extract().response();

		// printing response
		System.out.println("Response body:\n" + response.getBody().asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK");
		Assert.assertTrue(response.getBody().asString().contains("email"), "Response should contain email field");

	}
}
