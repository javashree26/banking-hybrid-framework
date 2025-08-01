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
 * @author dhanashree
 * 
 *         BaseTest.java
 * 
 *         This base class handles WebDriver setup and teardown. It reads
 *         browser config, initialises the driver and provides setup hooks for
 *         test classes.
 */
public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.initDriver(Constants.BROWSER);
		driver.get(Constants.BASE_URL);
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
