/**
 * 
 */
package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author dhanashree
 *
 *         DriverFactory.java
 * 
 *         This class manages WebDriver instance creation using ThreadLocal for
 *         thread safety. It supports parallel execution and dynamic browser
 *         setup via WebDriverManager.
 *
 */
public class DriverFactory {

	// to store webdriver per thread without cross-thread interference during
	// parallel
	// tests
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver initDriver(String browser) {
		// does not require to hardcode local drive path, as it auto-downloads correct
		// version of the said browser
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else {
			System.out.println(browser + "Browser not supported");
		}

		getDriver().manage().window().maximize();
		return getDriver();
	}

	// returns threadsafe webdriver instance
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	// quits and cleans up driver
	public static void quitDriver() {
		getDriver().quit();
		tlDriver.remove();
	}
}
