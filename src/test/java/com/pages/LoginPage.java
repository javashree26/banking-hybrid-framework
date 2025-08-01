/**
 * 
 */
package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.factory.DriverFactory;

/**
 * @author dhanashree
 * 
 *         LoginPage.java
 * 
 *         Page Object Model (POM) class for the login functionality. Contains
 *         element locators and methods to perform login actions.
 *
 */
public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver2) {
		this.driver = DriverFactory.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	// locators
	private By usernameInput = By.xpath("//input[@name= 'username']");
	private By passwordInput = By.xpath("//input[@name= 'password']");
	private By submitButton = By.xpath("//input[@value= 'Log In']");

}
