package com.justmop.page;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.justmop.constants.PaymentPage_Constants;



public class PaymentPage extends PaymentPage_Constants{

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Actions action = new Actions(driver);
	int voucherDiscount = 10;
//	String totalAmount = getElementBy(TOTAL_AMOUNT).getText().substring(4, 7);
	
	public void setVoucherCode(String voucher) throws InterruptedException {
		sleep(2);
		WebElement applyButton= getElementBy(APPLY_BUTTON);
		setObjectById(VOUCHER_TEXTBOX, voucher);
	    sleep(2);
		action.click(applyButton).build().perform();
	}
	public PaymentPage selectCash() throws InterruptedException  {
		sleep(2);
		WebElement em = driver.findElement(CASH_CHECKBOX);
		sleep(1);
		action.click(em).build().perform();
		return this;
	}
	@SuppressWarnings("unlikely-arg-type")
	public PaymentCompletePage completePayment() throws InterruptedException {
		waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, PAYMENT_PANEL);
		String totalAmount = getElementBy(TOTAL_AMOUNT).getText().substring(4);
		int total = Integer.parseInt(totalAmount);
		int totalAmountCash = Integer.parseInt(totalAmount) +5 ;
		selectCash();
		Assert.assertTrue("Total amount yanlış", !((totalAmountCash - voucherDiscount) == total));
		setVoucherCode("testotomasyo");
		waitForElement(driver, DEFAULT_WAIT_4_ELEMENT, By.cssSelector(".alert-area-register.active"));
		String invalidVoucherPopup = driver.findElement(By.cssSelector(".alert-area-register.active")).getText();
		assertTrue("Invalid voucher uyarısı görülmedi", invalidVoucherPopup.contains("This voucher code is not valid"));
		setVoucherCode("testotomasyon");
		sleep(2);
		getElementBy(COMPLETE_BUTTON).click();
		return new PaymentCompletePage(driver);
	}

}
