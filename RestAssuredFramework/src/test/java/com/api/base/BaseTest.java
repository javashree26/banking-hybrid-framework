/**
 * 
 */
package com.api.base;

import org.testng.annotations.BeforeClass;

import com.api.utils.ApiConstants;

import io.restassured.RestAssured;

/**
 * @author dhanashree
 *
 */
public class BaseTest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = ApiConstants.BASE_URI;
	}
}
