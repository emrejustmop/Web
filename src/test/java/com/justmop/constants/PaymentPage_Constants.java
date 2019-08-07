package com.justmop.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.justmop.base.BasePage;

public class PaymentPage_Constants extends BasePage{

	public PaymentPage_Constants(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By TOTAL_AMOUNT = By.id("summary-total");
	public By APPLY_BUTTON = By.id("voucher-code-button");
	public By VOUCHER_TEXTBOX = By.id("vouncher-code-input");
	public By CASH_CHECKBOX = By.cssSelector(".item.cash");
	public By COMPLETE_BUTTON = By.cssSelector(".btn.btn-success.btn-block.slider-next-button.completeButton");
	public By PAYMENT_PANEL = By.cssSelector(".panel.wizard.active");
	

}
