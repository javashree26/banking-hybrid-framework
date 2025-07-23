/**
 * 
 */
package com.api.utils;

import org.testng.annotations.DataProvider;

/**
 * @author dhanashree
 *
 */
public class UserDataProvider {

	@DataProvider(name = "userData")
	public static Object[][] getUserData() {

		return new Object[][] {
			{"Rohit Sharma","cricketer"},
			{"Sanjyot Keer","chef"}
		};
	}

}
