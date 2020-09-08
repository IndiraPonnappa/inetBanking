package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException{

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username provided");
		lp.setPassword(password);
		logger.info("Password provided");
		lp.clickLoginBtn();
		logger.info("Login button clicked");

		Thread.sleep(5000);
		AddCustomerPage addcust=new AddCustomerPage(driver);

		
		addcust.clickAddCustomerLink();

		logger.info("providing customer details....");
		addcust.enterCustName("Stella");
		addcust.custGender("Female");
		addcust.enterDOB("01","01","1990");
		Thread.sleep(2000);
		addcust.enterAddr("INDIA");
		addcust.enterCity("Bangalore");
		addcust.enterState("KA");
		addcust.enterPincode("5000074");
		addcust.enterTeleNo("987890091");
		String email=randomString()+"@gmail.com";
		addcust.enterEmail(email);
		addcust.enterPassword("abcdef");
		addcust.clickSubBtn();

		Thread.sleep(3000);

		logger.info("validation started....");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true){
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}


	}




}
