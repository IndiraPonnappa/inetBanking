package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	 public LoginPage (WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement Usernametxt;
	
	@FindBy(name="password")
	WebElement Passwordtxt;
	
	@FindBy(name="btnLogin")
	WebElement LoginBtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	
	public void setUsername(String Uname){
		Usernametxt.sendKeys(Uname);
	
	}
	
	public void setPassword(String pwd){
		Passwordtxt.sendKeys(pwd);
	
	}
	public void clickLoginBtn(){
		LoginBtn.click();
	
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	

}
