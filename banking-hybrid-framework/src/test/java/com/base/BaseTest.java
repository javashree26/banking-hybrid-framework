/**
 * 
 */
package com.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.factory.DriverFactory;
import com.utility.Constants;

/**
 * @author dhanashree For UI test setup and teardown
 */
public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.initDriver();
		driver.manage().window().maximize();
		driver.get(Constants.BASE_URL);
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
