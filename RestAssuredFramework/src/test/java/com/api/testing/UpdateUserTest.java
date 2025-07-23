/**
 * 
 */
package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.BaseTest;
import com.api.endpoints.RequestFactory;
import com.api.payloads.UserPayload;
import com.api.utils.ApiConstants;

import io.restassured.response.Response;

/**
 * @author dhanashree
 *
 */
public class UpdateUserTest extends BaseTest {
	String userID;

	@Test(priority = 1, groups = "putmethod")
	public void getUserId() {

		Response response = RequestFactory.getRequestSpec().when().get(ApiConstants.GET_URL);
//				.then().extract()
//				.response();

		// printing response
		System.out.println("Response body:\n" + response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK");
		userID = response.jsonPath().getString("data[0].id");
		System.out.println("Fetched User ID: " + userID);

	}

	@Test(priority = 2, enabled = true, dependsOnMethods = "getUserId", groups = "putmethod")
	public void updateUserId() {
		String updatedName = "Ananya";
		String updatedJob = "Tech Lead";

		UserPayload payload = new UserPayload(updatedName, updatedJob);

		Response response = RequestFactory.getRequestSpec().body(payload).when().put(ApiConstants.PUT_URL + userID);

		System.out.println("Response:\n" + response.asPrettyString());

		// Assertions
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
		Assert.assertEquals(response.jsonPath().getString("name"), updatedName);
		Assert.assertEquals(response.jsonPath().getString("job"), updatedJob);

	}
}
