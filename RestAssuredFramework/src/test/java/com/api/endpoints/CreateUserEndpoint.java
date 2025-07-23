/**
 * 
 */
package com.api.endpoints;

import static io.restassured.RestAssured.given;
import com.api.payloads.UserPayload;
import com.api.utils.ApiConstants;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author dhanashree
 *
 */
public class CreateUserEndpoint {

	public static Response createUser(UserPayload payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.header("x-api-key", ApiConstants.API_KEY)
				.body(payload)
				.when()
				.post("/api/users")
				.then()
				.statusCode(201)
				.extract()
				.response();

		return response;
	}
}
