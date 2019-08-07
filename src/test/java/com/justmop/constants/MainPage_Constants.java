package com.justmop.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.justmop.base.BasePage;

public class MainPage_Constants extends BasePage{

	public MainPage_Constants(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By LOGIN_BUTTON = By.id("login-button");
	public By BOOK_NOW_BUTTON = By.id("funnel-button");
	public By DIGIT_FIRST = By.id("topbar-phone-login-digits-first");
	public By DIGIT_SECOND = By.id("topbar-phone-login-digits-second");
	public By DIGIT_THIRD = By.id("topbar-phone-login-digits-third");
	public By DIGIT_FOURTH = By.id("topbar-phone-login-digits-fourth");

}
