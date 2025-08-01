/**
 * 
 */
package com.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author dhanashree 
 * Webdriver wait utility class for centralised wait logic
 */
public class WaitUtils {

	private WebDriver driver;
	private WebDriverWait wait;

	public WaitUtils(WebDriver driver, Duration timeout) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, timeout);
	}

	public WebElement waitForElementVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public boolean waitForUrlContains(String partialUrl) {
		return wait.until(ExpectedConditions.urlContains(partialUrl));
	}

	public boolean waitForTextPresent(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
}
