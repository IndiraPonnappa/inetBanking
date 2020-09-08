package com.inetbanking.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement AddCustomerLnk;

	@FindBy(name="name")
	WebElement CustName;

	@FindBy(name="rad1")
	WebElement radGender;

	@FindBy(id="dob")
	WebElement txtdob;

	@FindBy(name="addr")
	WebElement txtAddr;

	@FindBy(name="city")
	WebElement txtCity;

	@FindBy(name="state")
	WebElement txtState;

	@FindBy(name="pinno")
	WebElement txtPin;

	@FindBy(name="telephoneno")
	WebElement txtTelno;

	@FindBy(name="emailid")
	WebElement txtEmail;

	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(name="sub")
	WebElement btnSubmit;

	public void clickAddCustomerLink(){
		
		AddCustomerLnk.click();
	}

	public void enterCustName(String cname){
		CustName.sendKeys(cname);
	}

	public void custGender(String gender){
		radGender.click();
	}

	public void enterDOB(String dd,String mm,String yyyy){
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yyyy);
	}

	public void enterAddr(String addr){
		txtAddr.sendKeys(addr);
	}

	public void enterCity(String city){
		txtCity.sendKeys(city);
	}
	public void enterState(String state){
		txtState.sendKeys(state);
	}
	public void enterPincode(String pin){
		txtPin.sendKeys(String.valueOf(pin));
	}
	public void enterTeleNo(String telNo){
		txtTelno.sendKeys(telNo);
	}
	public void enterEmail(String email){
		txtEmail.sendKeys(email);
	}
	public void enterPassword(String Cpwd){
		txtPassword.sendKeys(Cpwd);
	}
	public void clickSubBtn(){
		btnSubmit.click();
	}
	
	
	



}
