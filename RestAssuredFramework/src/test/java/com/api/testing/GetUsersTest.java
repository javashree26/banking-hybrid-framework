package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUsersTest extends BaseTest {

	@Test(enabled = false)
	public void getUserList() {

		int statusCode;
		// hitting the GET endpoint
		Response response = RestAssured.given().when().get("/api/users?page=2").then().extract().response();

		// printing response
		System.out.println("Response body:\n" + response.getBody().asPrettyString());

		statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200, "Expected 200 OK");
		Assert.assertTrue(response.getBody().asString().contains("email"), "Response should contain email field");

	}
}
