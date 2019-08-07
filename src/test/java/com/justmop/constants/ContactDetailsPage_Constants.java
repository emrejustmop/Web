package com.justmop.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.justmop.base.BasePage;

public class ContactDetailsPage_Constants extends BasePage{

	public ContactDetailsPage_Constants(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By DIGIT_FIRST = By.id("phone-login-digits-first");
	public By DIGIT_SECOND = By.id("phone-login-digits-second");
	public By DIGIT_THIRD = By.id("phone-login-digits-third");
	public By DIGIT_FOURTH = By.id("phone-login-digits-fourth");
    public By NUMBER_FIELD = By.id("create_account_phone");
    public By AREA = By.className("area-container");
    public By AREA_DESC = By.className("description");
    public By ADDRESS = By.className("address-container");
    public By ADDRESS_DESC = By.className("description");
    public By PHONE = By.className("phone-container");
    public By PHONE_DESC = By.className("description");
    public By ADD_ADDRESS_BUTTON = By.cssSelector(".circle-plus.addNewAddressButton");
    public By BOOKING_SUMMARY = By.id("summary-payment-area");
    public By NEXT_BUTTON = By.cssSelector(".btn.btn-success.btn-block.slider-next-button");
    public By EDIT_BUTTON = By.cssSelector("body > div.wrapper > div:nth-child(3) > div > div.checkout-form > div.form-area > div.wizard-form > div.panel.wizard.active > div.panel-body > div.logged-in-form.active > div.checkout-form-register > div.addresses-container > div.address-item.active > div.buttons-container > div.description > div > span.edit-address");
    public By ADDRESS_FIELD = By.id("logged_account_address");
    public By SAVE_BUTTON = By.cssSelector(".btn.btn-success.save");
    public By CITY = By.cssSelector(".city");
    public By REGION = By.cssSelector(".region.region-item");
    
    

}
