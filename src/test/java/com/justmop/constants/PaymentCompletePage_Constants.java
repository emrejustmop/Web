package com.justmop.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.justmop.base.BasePage;

public class PaymentCompletePage_Constants extends BasePage{

	public PaymentCompletePage_Constants(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By COMPLETE_PANEL = By.className("panel-body");
	public By ACTIVE_PANEL = By.cssSelector(".panel.wizard.success.active");
	public By PROMO_CODE = By.id("promo_code");

}
