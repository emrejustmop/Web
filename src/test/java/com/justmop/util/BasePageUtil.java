package com.justmop.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageUtil {
	protected WebDriver driver;
	
	public BasePageUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public static final int DEFAULT_WAIT_4_ELEMENT = 15;
	
	public WebElement getElementBy(By by) {
		return driver.findElement(by);
	}
	public int sleep(int i) throws InterruptedException {
		Thread.sleep(i * 1000);
		return i;
	}
	
	public WebElement setObjectBy(By by, String value) {
		// WaitTool.waitForElement(driver, by, 5);
//		WaitTool.waitElementPresentAndDisplay(driver, by, 5);
		WebElement element = getElementBy(by);
		element.clear();
		element.sendKeys(value);
		return element;
	}
	public WebElement setObjectByName(String name, String value) {
		return setObjectBy(By.name(name), value);
	}

	public WebElement setObjectById(By by, String value) {
		return setObjectBy(by, value);
	}
	

	public WebElement setObjectByCssSelector(String cssSelector, String value) {
		return setObjectBy(By.cssSelector(cssSelector), value);
	}

	public WebElement setObjectByClassName(String className, String value) {
		return setObjectBy(By.className(className), value);
	}
	public WebElement clickObjectById(By by) {
		return clickObjectBy(by);
	}
	

	public WebElement clickObjectByCss(String css) {
		return clickObjectBy(By.cssSelector(css));
	}

	public WebElement clickObjectByClassName(String className) {
		return clickObjectBy(By.className(className));
	}

	public WebElement clickObjectByLinkText(String linkText) {
		return clickObjectBy(By.linkText(linkText));
	}

	public WebElement clickObjectByXpath(String xpath) {
		return clickObjectBy(By.xpath(xpath));
	}

	public WebElement clickObjectBy(By by) {
//		WaitTool.waitForElementClickable(driver, by, 10);
		WebElement element = driver.findElement(by);
		element.click();
		return element;
	}
	public void waitForElement(WebDriver driver, int seconds, By elementBy) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
	}
	
	
	
	public void scrollToElement(By by) throws InterruptedException {
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}
	public List<WebElement> findElementsByCss(By by) {
		return driver.findElements(by);
	}
	public void javaScriptClicker(WebDriver driver, WebElement element) {

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", element);
	}
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
