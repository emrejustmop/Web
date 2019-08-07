package com.justmop.page;


import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.justmop.constants.MainPage_Constants;

public class MainPage extends MainPage_Constants{

	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String number = "501234567";
	String first = "4";
	String sec = "0";
	String third ="4";
	String fourth = "0";
	
	public MainPage closeAppPopup() {
		WebElement useCode = getElementBy(By.className("button"));
		WebElement downloadButton = getElementBy(By.className("button-yellow"));
		waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, By.className("button"));
		assertTrue("Use Code butonu aktif değil", useCode.isEnabled());
		assertTrue("Download button aktif değil", downloadButton.isEnabled());
		clickObjectByClassName("close-button");
		return this;
		
	}
	public FunnelPage getFunnelPage() {
		waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, BOOK_NOW_BUTTON);
		clickObjectById(BOOK_NOW_BUTTON);
		return new FunnelPage(driver);
	}
	public MainPage clickLoginButton() {
		clickObjectById(By.id("login-button"));
		
		return this;
	}
	public void setNumber(String no) {
		setObjectById(By.id("topbar-modal-check-mobilenumber"), no);
	}
	public void clickSendCode() {
		clickObjectById(By.id("topbar-phone-check-form-button"));
	}
	private void setDigitFirst(String first, String sec, String third, String fourth) {
		setObjectById(DIGIT_FIRST, first);
		setObjectById(DIGIT_SECOND, sec);
		setObjectById(DIGIT_THIRD, third);
		setObjectById(DIGIT_FOURTH, fourth);
	}
	public MainPage login() throws InterruptedException {
		clickLoginButton();
		setNumber(number);
		clickSendCode();
		setDigitFirst(first, sec, third, fourth);
		sleep(2);
		return this;
	}
	
	
	

}
