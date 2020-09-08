package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	ReadConfig rc= new ReadConfig();
	public String baseURL=rc.getApplicationURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br){
		
		logger=Logger.getLogger("inetbanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")){
		System.setProperty("webdriver.chrome.driver",rc.getChromePath());
		driver=new ChromeDriver();
		
		}
		else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",rc.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
	
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
