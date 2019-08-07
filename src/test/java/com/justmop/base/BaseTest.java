package com.justmop.base;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
	protected WebDriver driver;
	public static String baseUrl = "https://preprod.justmop.com/";
	
	@Before
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		System.setProperty("webdriver.chrome.driver", "properties/driver/chromedriver");
		driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

//	@After
//	public void tearDown() throws Exception {
//		driver.quit();
//	}

}
