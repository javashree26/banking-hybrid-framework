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
import com.api.utils.UserDataProvider;

import io.restassured.response.Response;

/**
 * @author dhanashree
 * Using data provider to create new data for POST
 *Assertions: response status, name, job, userId and created timestamp validated
 */
public class PostUserTest extends BaseTest {

	@Test(dataProvider = "userData", dataProviderClass = UserDataProvider.class, enabled = false)
	public void testCreateUser(String name, String job) {

		// Prepare payload using POJO
		UserPayload payload = new UserPayload(name, job);

		// Send POST request and capture response
		Response response = RequestFactory.getRequestSpec().body(payload).when().post(ApiConstants.POST_URL).then()
				.statusCode(201).extract().response();

		// Log full response (optional but useful during debug)
		System.out.println("Response:\n" + response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 201, "Status code should be 201");

		String responseName = response.jsonPath().getString("name");
		String responseJob = response.jsonPath().getString("job");
		String userId = response.jsonPath().getString("id");
		String createdAt = response.jsonPath().getString("createdAt");

		Assert.assertEquals(responseName, name, "Name should match the request");
		Assert.assertEquals(responseJob, job, "Job should match the request");
		Assert.assertNotNull(userId, "User ID should be generated");
		Assert.assertTrue(createdAt.matches("\\d{4}-\\d{2}-\\d{2}T.*Z"), "createdAt should be in ISO format");
	}

}
