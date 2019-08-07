package com.justmop.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.justmop.base.BasePage;

public class DateAndTime_Constants extends BasePage{

	public DateAndTime_Constants(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By ACTIVE_DATE = By.cssSelector(".day.clickable.active");
	public By NUMBER = By.className("number");
	public By SUMMARY_DATE = By.id("summary-date");
	public By AVAILABLE_TIMES = By.id("available-times-new");
	public By ACTIVE_TIME = By.cssSelector(".btn.hours.active");
	public By SUMMARY_TIME = By.id("summary-time");
	public By NEXT_BUTTON = By.cssSelector(".btn.btn-success.btn-block.slider-next-button");

}
