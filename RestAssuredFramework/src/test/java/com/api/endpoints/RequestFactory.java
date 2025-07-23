/**
 * 
 */
package com.api.endpoints;

import static io.restassured.RestAssured.given;

import com.api.utils.ApiConstants;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * @author dhanashree
 *
 */
public class RequestFactory  {

	public static RequestSpecification getRequestSpec() {
		
		return 	given()
				.contentType(ContentType.JSON)
				.header("x-api-key", ApiConstants.API_KEY);
		
	}
}
