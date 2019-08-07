package com.justmop.page;

import static org.junit.Assert.assertTrue;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.justmop.constants.ContactDetailsPage_Constants;

public class ContactDetailsPage extends ContactDetailsPage_Constants{

	public ContactDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String number = "501234567";
	String first = "4";
	String sec = "0";
	String third ="4";
	String fourth = "0";
	
	Random r = new java.util.Random();
	Actions action = new Actions(driver);
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	private void setNumber(String value) {
		getElementBy(NUMBER_FIELD).sendKeys(value);
	}
	
	private void setDigitFirst(String first, String sec, String third, String fourth) {
		setObjectById(DIGIT_FIRST, first);
		setObjectById(DIGIT_SECOND, sec);
		setObjectById(DIGIT_THIRD, third);
		setObjectById(DIGIT_FOURTH, fourth);
	}
	public ContactDetailsPage getMyAddress() {
		setNumber(number);
		setDigitFirst(first, sec, third, fourth);
		return this;
	}
	public PaymentPage checkMyAddres() throws InterruptedException {
		if (getElementBy(By.cssSelector(".address-item.active")).isEnabled()) {
			waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, By.className("description"));
			assertTrue("Area boş geldi",
					getElementBy(AREA).findElement(AREA_DESC).isDisplayed());
					assertTrue("Address boş geldi",driver.findElements(ADDRESS).get(1).findElement(ADDRESS_DESC).isDisplayed());
					sleep(1);
					assertTrue("Phone boş geldi",driver.findElements(PHONE).get(1).findElement(PHONE_DESC).isDisplayed());
					assertTrue("Adres ekleme butonu görülmedi", getElementBy(ADD_ADDRESS_BUTTON).isEnabled());
					assertTrue("Booking summary görülmedi", isElementPresent(BOOKING_SUMMARY));
					sleep(2);
					scrollToElement(NEXT_BUTTON);
					findElementsByCss(NEXT_BUTTON).get(2).click();
		}
		else {
			assertTrue("Eklenen adres default gelmedi", getElementBy(By.cssSelector(".address-item active")).isEnabled());
		}
		return new PaymentPage(driver);
	}
	public ContactDetailsPage editMyAddress() throws InterruptedException {
		waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, By.cssSelector(".address-item.active"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(EDIT_BUTTON));
		javaScriptClicker(driver, editButton);
		clickObjectByClassName("city-cancel-button");
		randomSelectCity();
		randomSelectRegion();
		driver.findElement(ADDRESS_FIELD).sendKeys(randomString(50));
		clickObjectBy(SAVE_BUTTON);
		return this;
	}
	private void randomSelectCity() throws InterruptedException {
        List<WebElement> city = driver.findElements(CITY);    
        WebElement randomElement = city.get(r.nextInt(city.size()));
        sleep(4);
        randomElement.click();
	}
	private void randomSelectRegion() throws InterruptedException {
		Random r = new java.util.Random();
        List<WebElement> region = driver.findElements(REGION);    
        WebElement randomElement = region.get(r.nextInt(region.size()));
        sleep(2);
        randomElement.click();
	}
	public ContactDetailsPage addNewAddress() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_ADDRESS_BUTTON));
		clickObjectBy(ADD_ADDRESS_BUTTON);
		randomSelectCity();
		randomSelectRegion();
		driver.findElement(ADDRESS_FIELD).sendKeys(randomString(50));
		clickObjectBy(SAVE_BUTTON);
		return this;
	}
	
	
	
	

}
