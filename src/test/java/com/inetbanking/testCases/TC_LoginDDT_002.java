package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String usn,String pd) throws InterruptedException{
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(usn);
		logger.info("Username entered");
		lp.setPassword(pd);
		logger.info("Password entered");
		lp.clickLoginBtn();
		logger.info("Login button clicked");
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true){
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			logger.info("Loggedout successfully");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
			
		}

	}
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e){
		return false;
		}
	}

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		int colCount=XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][]=new String[rowNum][colCount];

		for(int i=1;i<=rowNum;i++){

			for(int j=0;j<colCount;j++){
				
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);

			}
		}
		return logindata;


	}

}
