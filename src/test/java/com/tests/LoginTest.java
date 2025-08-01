/**
 * 
 */
package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;

/**
 * @author dhanashree
 * 
 *         LoginTest.java
 * 
 *         Test class that validates the login functionality using the LoginPage
 *         object. Includes execution and assertions.
 *
 */
public class LoginTest extends BaseTest {

	@Test
	public void verifyLoginPageTitle() {
		LoginPage page = new LoginPage(driver);
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, "ParaBank | Welcome | Online Banking", "Title mismatch");
	}

}
