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
 */
public class DriverFactory {

	// to store webdriver per thread without cross-thread interference during
	// parallel
	// tests
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver initDriver() {
		// does not require to hardcode local drive path, as it auto-downloads correct
		// version of the said browser
		WebDriverManager.chromedriver().setup();
		tlDriver.set(new ChromeDriver());
		return getDriver();
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quitDriver() {
		getDriver().quit();
		tlDriver.remove();
	}
}
