package com.justmop.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.justmop.constants.PaymentCompletePage_Constants;

public class PaymentCompletePage extends PaymentCompletePage_Constants{

	public PaymentCompletePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public PaymentCompletePage checkPaymentComplete()  {
		waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, ACTIVE_PANEL);
		Assert.assertTrue("Payment complete ekranı gelmedi", 
				driver.findElement(ACTIVE_PANEL).isDisplayed());
		Assert.assertTrue("Promosyon code gelmedi", 
				getElementBy(PROMO_CODE).isDisplayed());
		return this;
	}

}
