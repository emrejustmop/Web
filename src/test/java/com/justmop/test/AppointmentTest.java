package com.justmop.test;

import org.junit.Test;

import com.justmop.base.BaseTest;
import com.justmop.page.ContactDetailsPage;
import com.justmop.page.DateAndTimePage;
import com.justmop.page.MainPage;

public class AppointmentTest extends BaseTest{
	
	
	
	/*
	 * Case 1.0
	 *  One-Off
	 *  2 Hour
	 *  1 Cleaner
	 *  Without Material
	 *  Instruction = test
	 *  Date&Time = Earliest Slot
	 *  Repeat (Log in on the funnel
	 *  Continue by editing an existing address
	 *  Cash+ Voucher
	 *  
	 */
	
	@Test
	  public void BookingCreateWithRepeatUserEditingAddress() throws InterruptedException {
		  new MainPage(driver)
		  .closeAppPopup()
		  .getFunnelPage()
		  .checkChooseYourCleanOptions()
		  .clickNextButton()
		  .checkTime();
		  new DateAndTimePage(driver)
		  .clickNextButton()
		  .getMyAddress()
		  .editMyAddress()
		  .checkMyAddres()
		  .completePayment()
		  .checkPaymentComplete();

		  
	  }
	/*
	 * Case 1.1
	 *  One-Off
	 *  2 Hour
	 *  1 Cleaner
	 *  Without Material
	 *  Instruction = test
	 *  Date&Time = Earliest Slot
	 *  Repeat (Log in on the funnel
	 *  Continue with an existing address
	 *  Cash+ Voucher
	 */

	@Test
	public void BookingCreateWithRepeatUser() throws InterruptedException {
		new MainPage(driver)
		.getFunnelPage()
		.checkChooseYourCleanOptions()
		.clickNextButton()
		.checkTime();
		new DateAndTimePage(driver)
		.selectRandomTime()
		.clickNextButton()
		.getMyAddress()
		.checkMyAddres()
		.completePayment()
		.checkPaymentComplete();
	}
	/*
	 * Case 1.2
	 * One-Off
	 * 2 Hour
	 * 1 Cleaner
	 * Without Material
	 * Instruction = test
	 * Date&Time Earliest Slot
	 * Repeat (Log in on the funnel)
	 * Continue with new address
	 * Cash+Voucher
	 */
	@Test
	public void BookingCreateWithNewAddress() throws InterruptedException {
		new MainPage(driver)
		.getFunnelPage()
		.checkChooseYourCleanOptions()
		.clickNextButton()
		.checkTime();
		new DateAndTimePage(driver)
		.clickNextButton()
		.getMyAddress()
		.addNewAddress()
		.checkMyAddres()
		.completePayment()
		.checkPaymentComplete();
		
	}
	/*
	 * Case 1.3
	 * One-Off
	 * 2 Hour
	 * 1 Cleaner
	 * Without Material
	 * Instruction = test
	 * Date&Time Earliest Slot
	 * Repeat (Log in on the main page)
	 * Continue with an existing address
	 * Cash+Voucher
	 */
	@Test
	public void BookingCreateLoginHeader() throws InterruptedException {
		new MainPage(driver)
		.login()
		.getFunnelPage()
		.checkChooseYourCleanOptions()
		.clickNextButton()
		.checkTime();
		new DateAndTimePage(driver)
		.selectRandomTime()
		.clickNextButton()
		.checkMyAddres()
		.completePayment()
		.checkPaymentComplete();
	}
}

  
