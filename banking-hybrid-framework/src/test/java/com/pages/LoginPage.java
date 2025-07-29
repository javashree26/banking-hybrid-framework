/**
 * 
 */
package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseTest;
import com.factory.DriverFactory;

/**
 * @author dhanashree
 *
 */
public class LoginPage extends BaseTest {

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage() {
		this.driver = DriverFactory.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	// locators
	private By usernameInput = By.xpath("//input[@name= 'username']");
	private By passwordInput = By.xpath("//input[@name= 'password']");
	private By submitButton = By.xpath("//input[@value= 'Log In']");
}
