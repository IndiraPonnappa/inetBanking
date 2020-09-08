package com.inetbanking.testCases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest()throws IOException {
		
	
		logger.info("Navigated to the url");

		LoginPage lp= new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered user name");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickLoginBtn();
		logger.info("Clicked on submit button");
	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){

			Assert.assertTrue(true);
			logger.info("Login successfull");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login  failed");
		}

	}


}
