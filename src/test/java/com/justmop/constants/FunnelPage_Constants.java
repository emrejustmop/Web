package com.justmop.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.justmop.base.BasePage;

public class FunnelPage_Constants extends BasePage{

	public FunnelPage_Constants(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By ONE_OFF = By.cssSelector(".btn.active");
	public By DURATION_OPTION = By.cssSelector(".selected");
	public By DURATION_LIST = By.cssSelector(".options li");
	public By CLEANER_OPTION = By.className("selected");
	public By MATERIAL_NO_BUTTON = By.cssSelector(".btn.active");
	public By INSTRUCTIONS = By.id("cleaning-instructions");
	public By NEXT_BUTTON = By.cssSelector(".btn.btn-success.slider-next-button");

}
