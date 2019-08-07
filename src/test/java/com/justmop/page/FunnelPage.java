package com.justmop.page;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.justmop.constants.FunnelPage_Constants;

public class FunnelPage extends FunnelPage_Constants{

	public FunnelPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
	Actions action = new Actions(driver);
	private void checkAppointmentType() {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ONE_OFF));
		String oneOff = getElementBy(ONE_OFF).getText();
		oneOff.equals("ONE-OFF");
	}
	private void selectDuration() {
		waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, DURATION_OPTION);
		WebElement durationSelectbox = driver.findElements(DURATION_OPTION).get(0);
		javaScriptClicker(driver, durationSelectbox);
		List<WebElement> duration = driver.findElements(DURATION_LIST);
		waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, DURATION_LIST);
		for (int i = 0; i < duration.size(); i++) {
			System.out.println(duration.get(i).getText());
		}
		duration.get(0).click();
	}
	private void checkCleaner() {
		WebElement cleaner = getElementBy(CLEANER_OPTION);
		cleaner.equals(1);
	}
	private void materials() {
		String material = getElementBy(MATERIAL_NO_BUTTON).getText();
		material.equals("No");
	}
	private void instructions(String ins) {
		setObjectBy(INSTRUCTIONS, ins);
	}
	
	public FunnelPage checkChooseYourCleanOptions() {
		checkAppointmentType();
		selectDuration();
		checkCleaner();
		materials();
		instructions("test");
		return this;
		
	}
	public DateAndTimePage clickNextButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(NEXT_BUTTON));
		WebElement clickNext = driver.findElements(NEXT_BUTTON).get(0);
		javaScriptClicker(driver, clickNext);
		return new DateAndTimePage(driver);
	}

}
