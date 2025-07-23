/**
 * 
 */
package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.BaseTest;
import com.api.endpoints.CreateUserEndpoint;
import com.api.payloads.UserPayload;
import com.api.utils.UserDataProvider;

import io.restassured.response.Response;

/**
 * @author dhanashree
 *
 */
public class PostUserTest extends BaseTest {

	@Test(dataProvider = "userData", dataProviderClass = UserDataProvider.class)
	public void testCreateUser(String name, String job) {

		// Prepare payload using POJO
		UserPayload payload = new UserPayload(name, job);

		// Send POST request and capture response
		Response response = CreateUserEndpoint.createUser(payload);

		// Log full response (optional but useful during debug)
		System.out.println("Response:\n" + response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 201, "Status code should be 201");

		String responseName = response.jsonPath().getString("name");
		String responseJob = response.jsonPath().getString("job");
		String userId = response.jsonPath().getString("id");

		Assert.assertEquals(responseName, name, "Name should match the request");
		Assert.assertEquals(responseJob, job, "Job should match the request");
		Assert.assertNotNull(userId, "User ID should be generated");
	}

}
