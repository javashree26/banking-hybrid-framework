package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.BaseTest;
import com.api.endpoints.RequestFactory;
import com.api.utils.ApiConstants;

import io.restassured.response.Response;

/**
 * @author Dhanashree
 * GET call to get list of all users
 * Assertions: response status code and email validated
 **/

public class GetUsersTest extends BaseTest {

	@Test(enabled = false)
	public void getUserList() {

		// hitting the GET endpoint
		Response response = RequestFactory.getRequestSpec().when().get(ApiConstants.GET_URL).then().extract()
				.response();

		// printing response
		System.out.println("Response body:\n" + response.getBody().asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK");
		Assert.assertTrue(response.getBody().asString().contains("email"), "Response should contain email field");

	}
}
