package com.justmop.page;



import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.justmop.constants.DateAndTime_Constants;


public class DateAndTimePage extends DateAndTime_Constants{
    
	public DateAndTimePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	      

	Date date = new Date(); 
    Random random = new Random();
    
	public DateAndTimePage selectRandomTime() {
		List<WebElement> availableTimes = driver.findElements(By.className("btn-wrapper"));
		availableTimes.get(new Random().nextInt(availableTimes.size())).click();
		return this;
	}
	public void checkTime() throws InterruptedException {
		
		if( getHour() >= 18) {	
			
		 Assert.assertTrue("Date false döndü",getMobDate()==getDate() +1);
//		 Assert.assertTrue("Saat aralığı 1 saatten fazla", getHour() - getMobHour() < 1);
		}
		else {
			
			Assert.assertTrue("Tarihler farklı",getMobDate()==getDate());		
			Assert.assertTrue("Saat aralığı 1 saatten fazla", getHour() - getMobHour() < 1);
			
		}
	}
	private Calendar getCalendar() {
		  // given date
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	private int getHour() throws InterruptedException {
		sleep(2);
	return	getCalendar().get(Calendar.HOUR_OF_DAY);
		
	}
	private int getDate() throws InterruptedException {
		sleep(2);
		System.out.println(Calendar.DAY_OF_MONTH);
		return getCalendar().get(Calendar.DAY_OF_MONTH);
	}
	private int getMobDate () {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ACTIVE_DATE));
//		waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, ACTIVE_DATE);
		String justMopDate= driver.findElement(ACTIVE_DATE).findElement(NUMBER).getText();
		System.out.println(justMopDate + "*");
		int date = Integer.parseInt(justMopDate);
		String summaryDate = getElementBy(SUMMARY_DATE).getText().substring(0, 2);
		System.out.println(summaryDate);
		int summaryDateParse = Integer.parseInt(summaryDate);
		Assert.assertTrue("Slot date ile booking summary farklı döndü", date==summaryDateParse);
		return date;
	}
	private int getMobHour() {
		String justmopTime= driver.findElement(AVAILABLE_TIMES)
				.findElement(ACTIVE_TIME).getText();
		int time= Integer.parseInt(justmopTime.substring(0, 2));
		String summaryTime = getElementBy(SUMMARY_TIME).getText().substring(0, 2);
		int summaryTimeParse = Integer.parseInt(summaryTime);
		Assert.assertTrue("Slot time ile booking summary farklı döndü", time==summaryTimeParse);
		return time;
	}
	public ContactDetailsPage clickNextButton() throws InterruptedException {
		sleep(2);
		driver.findElements(NEXT_BUTTON).get(0)
		.click();
		return new ContactDetailsPage(driver);
	}

}
